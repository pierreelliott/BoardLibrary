package mainlib.model;

public class LPosition {

    private int posX;
    private int posY;

    public LPosition(int x, int y) {
        posX = x;
        posY = y;
    }

    public LPosition(LPosition posAdd){
        posX = posAdd.getPosX();
        posY = posAdd.getPosY();
    }

    public LPosition(LPosition pDepart, LPosition pDirection) {
        posX = pDepart.posX + pDirection.posX;
        posY = pDepart.posY + pDirection.posY;
    }

    public void translateX(int i) {
        posX += i;
    }

    public void translateY(int i) {
        posY += i;
    }

    public void translate(LPosition p) {
        posX += p.posX;
        posY += p.posY;
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
