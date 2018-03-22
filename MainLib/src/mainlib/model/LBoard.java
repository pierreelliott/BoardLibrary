package mainlib.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The LBoard class managed pieces on the board.
 * In theory it reflects the grid instantiated on the GUI.
 * The class provides a full panel of piece management functions.
 *
 * @author  Tancrède SUARD 11505293
 * @author  Pierre-Elliott THIBOUD 11402690
 * @version 1.0
 * @since   2018-01-17
 *
 * @see LModel
 * @see LPiece
 * @see LPosition
 */
public class LBoard {

    /**
     * List of LPiece contained on the board.
     */
    private List<LPiece> pieces;
    /**
     * Width of the board.
     * Must be strict positive.
     */
    private int width;
    /**
     * Height of the board.
     * Must be strict positive.
     */
    private int height;

    /**
     * Constructor.
     * List of piece are empty by default.
     * @param width Width of the board. Must be strict positive.
     * @param height Height of the board. Must be strict positive.
     * @throws Exception If Width or Height are not strict positive.
     * @see #pieces
     */
    public LBoard(int width, int height) throws Exception {
        if(width <= 0 || height <= 0)
            throw new Exception("Board size must be positive.");
        this.width = width;
        this.height = height;
        this.pieces = new ArrayList<>();
    }

    /**
     * Height getter
     * @return Height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Width getter
     * @return Width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Create a two dimensional array of piece pointers.
     * Pointer is <em>null</em> when there is no piece on location.
     * Use width and height of the board as indices.
     * @return LPiece[][]
     * @see #getPiece(LPosition)
     */
    public LPiece[][] getMatrix() {
        LPiece[][] matrix = new LPiece[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                matrix[i][j] = getPiece(new LPosition(j, i)); // stocke un pointeur sur la pièce qui l'occupe ou null sinon
            }
        }

        return matrix;
    }

    /**
     * Reset the board clearing piece list.
     * @see #pieces
     */
    public void resetBoard() {
        pieces.clear();
    }

    /**
     * Get a piece on a location.
     * Can return <em>null</em>.
     * @param p LPosition Absolute location of the piece
     * @return LPiece or <em>null</em>
     */
    public LPiece getPiece(LPosition p) {
        for(LPiece piece : pieces) {
            if(piece.isOnPosition(p)) {
                return piece;
            }
        }
        return null;
    }

    /**
     * Erase a line
     * @param y int
     * @see #clearLine(LPosition, LPosition)
     */
    @Deprecated
    public void removeLine(int y) {
        List<LPosition> line = new ArrayList<>();
        for(int i = 0; i < width; i++) {
            line.add(new LPosition(i, y));
        }

        for(LPiece piece : pieces) {
            piece.removePositions(line);
        }
    }

    /**
     * Check if a Column is empty
     * @param x int Number of the column
     * @return <em>true</em> if the column is empty
     */
    public boolean isColumnEmpty(int x) {
        for(LPiece piece : pieces) {
            if(piece.isOnColumn(x)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if a row is empty
     * @param y int Numver of the row
     * @return <em>true</em> if the row is empty
     */
    public boolean isRowEmpty(int y) {
        for(LPiece piece : pieces) {
            if(piece.isOnLine(y)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if a specified position is on the board.
     * @param p LPosition
     * @return <em>true</em> if the position is on the board.
     */
    public boolean isOnBoard(LPosition p) {
        return (p.getPosY() < height && p.getPosY() >= 0 && p.getPosX() < width && p.getPosX() >= 0);
    }

    /**
     * Add a LPiece on the Board.<br>
     * Verify only is the piece is on the board.<br>
     * <b>Can overwrite other pieces.</b>
     * @param p LPiece to add on the board
     * @throws Exception If the piece is located out of the board.
     */
    public void addPiece(LPiece p) throws Exception {
        for(LPosition pos : p.getPositions()) {
            if(!isOnBoard(pos)) {
                throw new Exception("Out of the board");
            }
        }
        pieces.add(p);
    }

    /**
     * Remove a piece of the board.
     * @param p LPiece to remove.
     */
    public void removePiece(LPiece p) {
        pieces.remove(p);
    }

    /**
     * @see #isFullLine(LPosition, LPosition)
     */
    @Deprecated
    public boolean isColumnFull(int x) {
        int count = 0;
        for(LPiece piece : pieces) {
            if(piece.isOnColumn(x)) {
                count++;
            }
        }
        return (count == height);
    }

    /**
     * @see #isFullLine(LPosition, LPosition)
     */
    @Deprecated
    public boolean isLineFull(int y) {
        int count = 0;
        for(LPiece piece : pieces) {
            if(piece.isOnLine(y)) {
                count++;
            }
        }
        return (count == width);
    }

    /**
     * Check if a piece can be moved on a relative location (ie movement).
     * @param pos LPosition. Relative position.
     * @param p LPiece to move.
     * @return <em>true</em> if the piece can be moved.
     */
    public boolean canMove(LPosition pos, LPiece p) {
        LPiece hypo = new LPiece(p);
        hypo.move(pos);
        return !isCollision(p, hypo);
    }

    /**
     * Check if a piece can be rotated.
     * @param p LPiece to rotate.
     * @param trigo <em>true</em> to 90 degrees inverse-clockwise rotation.
     *              <em>false</em> to 90 degrees clockwise rotation.
     * @return <em>true</em> if the piece can be rotated.
     * @see LPiece#rotate(boolean)
     */
    public boolean canRotate(LPiece p, boolean trigo){
        LPiece hypo = new LPiece(p);
        hypo.rotate(trigo);
        return !isCollision(p, hypo);
    }

    /**
     * Check if a piece can be placed at a specific position.
     * @param pos Absolute LPosition where the piece should be placed.
     * @param p LPiece to place.
     * @return <em>true</em> if the piece can be moved.
     */
    public boolean canPlaceAt(LPosition pos, LPiece p) {
        LPiece hypo = new LPiece(p);
        hypo.placeAt(pos);
        return !isCollision(p, hypo);
    }

    /**
     * Check for a already placed piece, if there is a collision when moved.
     * @param lPiece LPiece Already placed piece.
     * @param hypoLPiece Same piece already moved by hypothetical movements.
     * @return <true>true</true> if there is a collision.
     */
    private boolean isCollision(LPiece lPiece, LPiece hypoLPiece){
        LPiece[][] matrix = getMatrix();
        for(LPosition position : lPiece.getPositions()){
            matrix[position.getPosY()][position.getPosX()] = null;
        }

        ArrayList<LPosition> hypoPos = hypoLPiece.getPositions();
        for(LPosition position : hypoPos){
            if(!isOnBoard(position)) {
//                System.out.println("STOP Is not on board " + position.toString());
                return true;
            }
            if(matrix[position.getPosY()][position.getPosX()] != null){
//                System.out.println("STOP matrix " + position.toString());
                return true;
            }
        }
        return false;
    }

    /**
     * Place a piece at center top of the board.
     * @param piece LPiece to place.
     * @return <true>true</true> if success
     */
    public boolean placeAtTopCenter(LPiece piece) {
        int pieceWidth = piece.getWidth();
        int leftOffset = (width - pieceWidth)/2;
        if(canMove(new LPosition(leftOffset, 0), piece)){
            piece.move(new LPosition(leftOffset, 0));
            return true;
        }
        return false;
    }

    /**
     * Check if a line is full from a start position.<br>
     * Every direction can be use for testing.<br>
     * <b>Check if all pieces on line are broken</b>
     * @param startPos LPosition to start checking.
     * @param direction LPosition Relative direction for testing.
     * @return <em>true</em> if the line is full.
     * @see LPiece#isBroken()
     */
    public boolean isFullLine(LPosition startPos, LPosition direction){
        if(!isOnBoard(startPos)){
            return false;
        }

        LPiece[][] matrix = getMatrix();
        LPosition testpos = new LPosition(startPos);
        do {
            if(matrix[testpos.getPosY()][testpos.getPosX()] != null){
                if(matrix[testpos.getPosY()][testpos.getPosX()].isBroken()){
                    testpos.translate(direction);
                } else return false;
            } else return false;
        } while(isOnBoard(testpos));
        return true;
    }

    /**
     * Explode a piece on only-one-position pieces.
     * All only-one-position pieces are broken by definition.
     * @param lPiece LPiece to explode
     * @see LPiece#isBroken()
     */
    public void explodeLPiece(LPiece lPiece) {
        LPiece previousLPiece = new LPiece(lPiece);
        ArrayList<LPosition> positions = previousLPiece.getPositions();
        pieces.remove(lPiece);
        ArrayList<LPosition> soloPos;
        for (LPosition pos : positions) {
            soloPos = new ArrayList<>();
            soloPos.add(new LPosition(pos));
            try {
                addPiece(
                        new LPiece(soloPos, pos, previousLPiece.getColor())
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Clear a line from a start position.<br>
     * Every direction can be use for clearing.<br>
     * @param startPos LPosition to start clearing.
     * @param direction LPosition Relative direction for clearing
     */
    public void clearLine(LPosition startPos, LPosition direction){
        if(!isOnBoard(startPos))
            return;

        LPiece[][] matrix = getMatrix();
        LPosition toCleanPos = new LPosition(startPos);
        do {
            if(matrix[toCleanPos.getPosY()][toCleanPos.getPosX()] != null)
                if(matrix[toCleanPos.getPosY()][toCleanPos.getPosX()].isBroken())
                    removePiece(matrix[toCleanPos.getPosY()][toCleanPos.getPosX()]);
            toCleanPos.translate(direction);
        } while(isOnBoard(toCleanPos));
    }

    /**
     * Move a bench of pieces in a direction.
     * Create pieces list thanks to a rectangle specified by two LPosition.
     * First position must have equal or lower coordinates.
     * @param firstCornerPosition LPosition First corner position
     * @param secondCornerPosition LPosition Second corner position
     * @param direction LPosition Relative direction for movement.
     * @see LPiece#move(LPosition)
     */
    public void movePieces(LPosition firstCornerPosition, LPosition secondCornerPosition, LPosition direction){
        if(firstCornerPosition.getPosX() > secondCornerPosition.getPosX() ||
                firstCornerPosition.getPosY() > secondCornerPosition.getPosY()){
            return;
        }

        if(!isOnBoard(firstCornerPosition) || !isOnBoard(secondCornerPosition)){
            return;
        }

        LPiece[][] matrix = getMatrix();
        for(int i = firstCornerPosition.getPosX(); i <= secondCornerPosition.getPosX(); i++){
            for(int j = firstCornerPosition.getPosY(); j <=  secondCornerPosition.getPosY(); j++){
                if(matrix[j][i] != null){
                    if(matrix[j][i].isBroken()){
                        matrix[j][i].move(direction);
                    }
                }
            }
        }
    }
}
