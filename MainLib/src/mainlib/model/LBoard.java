package mainlib.model;

import java.util.ArrayList;
import java.util.List;

public class LBoard {

    private List<LPiece> pieces;
    private int width;
    private int height;

    public LBoard(int width, int height) throws Exception {
        if(width <= 0 || height <= 0)
            throw new Exception("Board size must be positive.");
        this.width = width;
        this.height = height;
        this.pieces = new ArrayList<>();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public LPiece[][] getMatrix() {
        LPiece[][] matrix = new LPiece[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                matrix[i][j] = getPiece(new LPosition(j, i)); // stocke un pointeur sur la pièce qui l'occupe ou null sinon
            }
        }

        return matrix;
    }

    public void resetBoard() {
        pieces.clear();
    }

    public LPiece getPiece(LPosition p) {
        for(LPiece piece : pieces) {
            if(piece.isOnPosition(p)) {
                return piece;
            }
        }
        return null;
    }

    public void removeLine(int y) {
        List<LPosition> line = new ArrayList<>();
        for(int i = 0; i < width; i++) {
            line.add(new LPosition(i, y));
        }

        for(LPiece piece : pieces) {
            piece.removePositions(line);
        }
    }

    public boolean isColumnEmpty(int x) {
        for(LPiece piece : pieces) {
            if(piece.isOnColumn(x)) {
                return false;
            }
        }
        return true;
    }

    public boolean isLineEmpty(int y) {
        for(LPiece piece : pieces) {
            if(piece.isOnLine(y)) {
                return false;
            }
        }
        return true;
    }

    public boolean isOnBoard(LPosition p) {
        return (p.getPosY() < height && p.getPosY() >= 0 && p.getPosX() < width && p.getPosX() >= 0);
    }

    public void addPiece(LPiece p) throws Exception {
        for(LPosition pos : p.getPositions()) {
            if(!isOnBoard(pos)) {
                throw new Exception("Out of the board");
            }
        }
        pieces.add(p);
    }

    public void removePiece(LPiece p) {
        pieces.remove(p);
    }

    public boolean isColumnFull(int x) {
        int count = 0;
        for(LPiece piece : pieces) {
            if(piece.isOnColumn(x)) {
                count++;
            }
        }
        return (count == height);
    }

    public boolean isLineFull(int y) {
        int count = 0;
        for(LPiece piece : pieces) {
            if(piece.isOnLine(y)) {
                count++;
            }
        }
        return (count == width);
    }

    public boolean canMove(LPosition pos, LPiece p) {
        LPiece hypo = new LPiece(p);
        hypo.move(pos);
        return !isCollision(p, hypo);
    }

    public boolean canRotate(LPiece p, boolean trigo){
        LPiece hypo = new LPiece(p);
        hypo.rotate(trigo);
        return !isCollision(p, hypo);
    }

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

    public boolean placeAtCenter(LPiece piece) {
        int pieceWidth = piece.getWidth();
        int leftOffset = (width - pieceWidth)/2;
        if(canMove(new LPosition(leftOffset, 0), piece)){
            piece.move(new LPosition(leftOffset, 0));
            return true;
        }
        return false;
    }

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
