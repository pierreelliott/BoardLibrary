package mainlib.model;

public class LPosition {

    private int posX;
    private int posY;

    public LPosition(int x, int y) {
        posX = x;
        posY = y;
    }

    /**
     * Clone constructor
     * @param lPosition LPosition
     */
    public LPosition(LPosition lPosition){
        posX = lPosition.getPosX();
        posY = lPosition.getPosY();
    }

    public LPosition(LPosition pDepart, LPosition pDirection) {
        posX = pDepart.getPosX() + pDirection.getPosX();
        posY = pDepart.getPosY() + pDirection.getPosY();
    }

    public void translateX(int i) {
        posX += i;
    }

    public void translateY(int i) {
        posY += i;
    }

    public void translate(LPosition p) {
        posX += p.getPosX();
        posY += p.getPosY();
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void rotate90Trigo(){
        int tmp = posX;
        posX = -posY;
        posY = tmp;
    }

    public void rotate90Trigo(LPosition centerPos){
        posX -= centerPos.getPosX();
        posY -= centerPos.getPosY();
        rotate90Trigo();
        posX += centerPos.getPosX();
        posY += centerPos.getPosY();
    }

    public void rotate90AntiTrigo(){
        int tmp = posX;
        posX = posY;
        posY = -tmp;
    }

    public void rotate90AntiTrigo(LPosition centerPos){
        posX -= centerPos.getPosX();
        posY -= centerPos.getPosY();
        rotate90AntiTrigo();
        posX += centerPos.getPosX();
        posY += centerPos.getPosY();
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
