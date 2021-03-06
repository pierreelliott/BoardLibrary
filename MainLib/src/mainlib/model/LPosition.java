package mainlib.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to standardize two dimensional usages.
 * It provides translation and rotation.
 * This class is used every time there is a notion of direction, movement, location.
 * Constructors are easy to use for translate, simulate and use new position.
 *
 * @author  Tancrède SUARD 11505293
 * @author  Pierre-Elliott THIBOUD 11402690
 * @version 1.0
 * @since   2018-01-17
 */
public class LPosition implements Cloneable{

    /**
     * Position X
     */
    private int posX;

    /**
     * Position Y
     */
    private int posY;

    /**
     * Constructor
     * @param x Position X
     * @param y Position Y
     */
    public LPosition(int x, int y) {
        posX = x;
        posY = y;
    }

    /**
     * Clone constructor
     * @param lPosition LPosition
     */
    public LPosition(LPosition lPosition){
        super();
        posX = lPosition.posX;
        posY = lPosition.posY;
    }

    /**
     * Additive constructor.<br>
     *     Coordinates will be added together
     * @param pFirst LPosition
     * @param pSecond LPosition
     */
    public LPosition(LPosition pFirst, LPosition pSecond) {
        posX = pFirst.posX + pSecond.posX;
        posY = pFirst.posY + pSecond.posY;
    }

    /**
     * Add i to X position
     * @param i int
     */
    public void translateX(int i) {
        posX += i;
    }

    /**
     * Add i to Y position
     * @param i int
     */
    public void translateY(int i) {
        posY += i;
    }

    /**
     * Translate LPosition by p.<br>
     *     Add p's X and Y with X and Y.
     * @param p LPosition
     */
    public void translate(LPosition p) {
        posX += p.posX;
        posY += p.posY;
    }

    /**
     * Get the approximative direction (considering the LPosition as a vector)
     * @return <em>1</em> if the direction is only horizontal,
     *          <em>-1</em> if the direction is only vertical,
     *          <em>0</em> otherwise
     */
    public int direction() {
        if(posX != 0) {
            if(posY != 0) {
                return 0;
            }
            return 1;
        } else {
            if(posY != 0) {
                return -1;
            }
            return 0;
        }
    }

    /**
     * X getter
     * @return posX
     */
    public int getPosX() {
        return posX;
    }

    /**
     * X setter
     * @param posX X position
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Y getter
     * @return posY
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Y setter
     * @param posY Y position
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Rotate the position by 90 degrees inverse-clockwise
     */
    public void rotate90Trigo(){
        int tmp = posX;
        posX = -posY;
        posY = tmp;
    }

    /**
     * Rotate the position by 90 degress inverse-clockwise around a center position.
     * @param centerPos LPosition center position
     * @see #rotate90Trigo()
     */
    public void rotate90Trigo(LPosition centerPos){
        posX -= centerPos.posX;
        posY -= centerPos.posY;
        rotate90Trigo();
        posX += centerPos.posX;
        posY += centerPos.posY;
    }

    /**
     * Rotate the position by 90 degrees clockwise
     */
    public void rotate90AntiTrigo(){
        int tmp = posX;
        posX = posY;
        posY = -tmp;
    }

    /**
     * Rotate the position by 90 degress clockwise around a center position.
     * @param centerPos LPosition center position
     * @see #rotate90AntiTrigo()
     */
    public void rotate90AntiTrigo(LPosition centerPos){
        posX -= centerPos.posX;
        posY -= centerPos.posY;
        rotate90AntiTrigo();
        posX += centerPos.posX;
        posY += centerPos.posY;
    }

    /**
     * Multiply X by -1
     */
    public void flipX(){
        posX = -posX;
    }

    /**
     * Multiply Y by -1
     */
    public void flipY(){
        posY = -posY;
    }

    /**
     * Get Positions adjacent to the current one<br>
     *     Note : any positive number is handled as <em>1</em> (the same applies to <em>-1</em>)
     * @param withDiag <em>1</em> to get "direct adjacent" positions (without diagonal)
     *                 <em>0</em> to get all adjacent positions (diagonal and the others)
     *                 <em>-1</em> to get only diagonal adjacent positions
     * @return List of all adjacent positions
     */
    public List<LPosition> getAdjacentPositions(int withDiag) {
        List<LPosition> adjacents = new ArrayList<>();

        if(withDiag >= 0) {
            adjacents.add(new LPosition(posX-1,posY));
            adjacents.add(new LPosition(posX,posY-1));
            adjacents.add(new LPosition(posX,posY+1));
            adjacents.add(new LPosition(posX+1,posY));
        }

        if(withDiag <= 0) {
            adjacents.add(new LPosition(posX-1,posY-1));
            adjacents.add(new LPosition(posX-1,posY+1));
            adjacents.add(new LPosition(posX+1,posY-1));
            adjacents.add(new LPosition(posX+1,posY+1));
        }

        return adjacents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LPosition)) return false;

        LPosition lPosition = (LPosition) o;

        if (getPosX() != lPosition.getPosX()) return false;
        return getPosY() == lPosition.getPosY();
    }

    @Override
    public int hashCode() {
        int result = getPosX();
        result = 31 * result + getPosY();
        return result;
    }

    @Override
    public String toString() {
        return "[" + posX + ";" + posY + "]";
    }
}
