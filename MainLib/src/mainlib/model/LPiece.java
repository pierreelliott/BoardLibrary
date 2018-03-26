package mainlib.model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * The LPiece class provides a way to custom pieces on a board.
 * It manages list of positions and provides functions to edit them.
 * A base LPosition is defined in order to process rotation correctly.
 * There is also a color variable which can be used for GUI.
 *
 * @author  Tancrède SUARD 11505293
 * @author  Pierre-Elliott THIBOUD 11402690
 * @version 1.0
 * @since   2018-01-17
 */
public class LPiece {

    /**
     * LPositions to locate the piece on grid
     */
    private ArrayList<LPosition> positions;

    /**
     * Color used for rendering
     */
    private Color color;

    /**
     * LPosition for rotation
     */
    private LPosition base;

    /**
     * Constructor.<br>
     * Empty position.
     * Base located on [0,0]
     * @see #positions
     * @see #base
     * @see #LPiece(ArrayList, LPosition)
     */
    public LPiece() {
        this(new ArrayList<>(), new LPosition(0,0));
    }

    /**
     * Clone constructor LPiece
     * @param p Lpiece
     */
    public LPiece(LPiece p){
        positions = new ArrayList<>();
        for(LPosition pos : p.getPositions()){
            positions.add(new LPosition(pos));
        }
        base = new LPosition(p.getBase());
        color = new Color(
                p.getColor().getRed(),
                p.getColor().getGreen(),
                p.getColor().getBlue(),
                p.getColor().getOpacity()
        );
    }

    /**
     * Constructor.
     * Default color MAGENTA
     * @param pos Position list to locate the piece on grid.
     * @param base LPosition for rotation
     * @see #color
     * @see #LPiece(ArrayList, LPosition, Color)
     */
    public LPiece(ArrayList<LPosition> pos, LPosition base) {
        this(pos, base, Color.MAGENTA);
    }

    /**
     * Main constructor.
     * @param pos LPosition list to locate the piece on grid.
     * @param base LPosition for rotation
     * @param color Color for rendering
     */
    public LPiece(ArrayList<LPosition> pos, LPosition base, Color color) {
        this.positions = pos;
        this.color = color;
        this.base = base;
    }

    /**
     * LPositions list getter.
     * Can be empty
     * @return List of LPosition
     */
    public ArrayList<LPosition> getPositions() {
        return positions;
    }

    /**
     * Move the piece by translating it.
     * @param p Relative LPosition to translate.
     */
    public void move(LPosition p) {
        for(LPosition pos : positions) {
            pos.translate(p);
        }
        base.translate(p);
    }

    /**
     * Place the piece at a precise position (based on the position of <em>base</em>
     * @param p
     */
    public void placeAt(LPosition p) {
        LPosition vector = new LPosition(p.getPosX()-base.getPosX(), p.getPosY()-base.getPosY());
        this.move(vector);
    }

    /**
     * <em>true</em> if positions if empty.
     * @return <em>true</em> if positions if empty.
     */
    public boolean isEmpty() {
        return positions.isEmpty();
    }

    /**
     * Remove a position of the LPosition list
     * @param p LPosition
     */
    public void removePosition(LPosition p) {
        positions.remove(p);
    }

    /**
     * Check if the piece is located on a position (ie, if it contains this position).
     * @param p LPosition to check
     * @return <em>true</em> when the LPosition match the piece positions.
     */
    public boolean isOnPosition(LPosition p) {
        return positions.contains(p);
    }

    /**
     * Check if a piece is located on a row.
     * @param l int line
     * @return <em>true</em> when the piece is located on a line.
     */
    public boolean isOnLine(int l) {
        for(LPosition pos : positions) {
            if(pos.getPosY() == l) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if a piece is located on a column.
     * @param c int column
     * @return <em>true</em> when the piece is located on a column.
     */
    public boolean isOnColumn(int c) {
        for(LPosition pos : positions) {
            if(pos.getPosX() == c) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes a list of positions from piece's positions list
     * @param pos List of position.
     */
    public void removePositions(List<LPosition> pos) {
        positions.removeAll(pos);
    }

    /**
     * Rotate the piece.
     * @param trigo <em>true</em> to 90 degrees inverse-clockwise rotation.
     *              <em>false</em> to 90 degrees clockwise rotation.
     * @see LPosition#rotate90AntiTrigo(LPosition)
     * @see LPosition#rotate90Trigo(LPosition)
     * @see #base
     */
    public void rotate(boolean trigo){
        for(LPosition pos : positions) {
            if(trigo)
                pos.rotate90Trigo(base);
            else
                pos.rotate90AntiTrigo(base);
        }
    }

    /**
     * Flip the piece from X axe.
     */
    public void flipX(){
        flip(true);
    }

    /**
     * Flip the piece from Y axe.
     */
    public void flipY(){
        flip(false);
    }

    /**
     * Flip the piece from axe.
     * @param axeX <em>true</em> for X axe. Y axe otherwise.
     */
    public void flip(boolean axeX){
        if(axeX){
            int maxX = 0;
            int minX = Integer.MAX_VALUE;
            for(LPosition pos : positions) {
                if(pos.getPosX() > maxX)
                    maxX = pos.getPosX();
                if(pos.getPosX() < minX)
                    minX = pos.getPosX();
                pos.flipX();
            }
            for(LPosition pos : positions) {
                pos.translate(new LPosition(maxX + minX, 0));
            }
        } else {
            int maxY = 0;
            int minY = Integer.MAX_VALUE;
            for(LPosition pos : positions) {
                if(pos.getPosY() > maxY)
                    maxY = pos.getPosY();
                if(pos.getPosY() < minY)
                    minY = pos.getPosY();
                pos.flipY();
            }
            for(LPosition pos : positions) {
                pos.translate(new LPosition(0, maxY + minY));
            }
        }
    }

    /**
     * Color getter
     * @return Color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Color setter
     * @param color Color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Process the width piece.
     * Subtract max right position from max left position.
     * @return int
     */
    public int getWidth() {
        if(positions.isEmpty()) {
            return 0;
        }
        int min = 0;
        int max = 0;
        for(LPosition p : positions) {
            if(p.getPosX() > max)
                max = p.getPosX();
            if(p.getPosX() < min)
                min = p.getPosX();
        }
        return max - min + 1;
    }

    /**
     * Process the height piece.
     * Subtract max top position from max bottom position.
     * @return int
     */
    public int getHeight() {
        if(positions.isEmpty()) {
            return 0;
        }
        int min = 0;
        int max = 0;
        for(LPosition p : positions) {
            if(p.getPosY() > max)
                max = p.getPosY();
            if(p.getPosY() < min)
                min = p.getPosY();
        }
        return max - min + 1;
    }

    /**
     * Base position getter.
     * @return LPosition
     */
    public LPosition getBase(){
        return base;
    }

    /**
     * Check if position has only 1 position.
     * @return <em>true</em> if the piece has only 1 position.
     */
    public boolean isBroken(){
        return positions.size() == 1;
    }

    /**
     * Get adjacent positions to the current piece
     * @param withDiag <em>True</em> if adjacent positions contain diagonal ones, <em>False</em> otherwise.
     * @return List of LPositions (which might not be on the board)
     * @see LPosition#getAdjacentPositions(int)
     */
    public List<LPosition> getAdjacentPositions(int withDiag) {
        List<LPosition> correctPos = new ArrayList<>();
        for(LPosition p: positions) {
            List<LPosition> adjacents = p.getAdjacentPositions(withDiag);
            List<LPosition> pos = new ArrayList<>();
            for(LPosition adj: adjacents) {
                for(LPosition alreadyContained: positions) {
                    if(adj.equals(alreadyContained)) {
                        continue;
                    }
                }
                pos.add(adj);
            }
            correctPos.addAll(pos);
        }

        return correctPos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LPiece)) return false;

        LPiece lPiece = (LPiece) o;

        if (getColor() != lPiece.getColor()) return false;
        if (getBase() != lPiece.getBase()) return false;
        ArrayList<LPosition> lpositions = lPiece.getPositions();
        if(getPositions().size() != lpositions.size()) return false;
        for (LPosition lpos : lpositions) {
            if(!getPositions().contains(lpos)) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + getColor().hashCode();
        result = 37 * result + getBase().hashCode();
        for (LPosition lpos : getPositions()) {
            result = 37 * result + lpos.hashCode();
        }
        return result;
    }

}
