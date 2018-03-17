package mainlib.model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class LPiece {

    private ArrayList<LPosition> positions;
    private boolean broked; // Si la pièce est cassée, elle ne peut plus tourner
    private Color color;
    private LPosition base;

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

    public LPiece(ArrayList<LPosition> pos, LPosition base) {
        this(pos, base, Color.MAGENTA);
    }

    public LPiece(ArrayList<LPosition> pos, LPosition base, Color color) {
        this.positions = pos;
        this.color = color;
        this.base = base;
    }

    public ArrayList<LPosition> getPositions() {
        return positions;
    }

    public void move(LPosition p) {
        for(LPosition pos : positions) {
            pos.translate(p);
        }
        base.translate(p);
    }

    public boolean isEmpty() {
        return positions.isEmpty();
    }

    public void removePosition(LPosition p) {
        positions.remove(p);
    }

    public boolean breakPiece() {
        if(broked) {
            return false;
        } else {
            broked = true;
            return true;
        }
    }

    public boolean isOnPosition(LPosition p) {
        for(LPosition pos : positions) {
            if(pos.equals(p)) {
                return true;
            }
        }
        return false;
    }

    public boolean isOnLine(int l) {
        for(LPosition pos : positions) {
            if(pos.getPosY() == l) {
                return true;
            }
        }
        return false;
    }

    public boolean isOnColumn(int c) {
        for(LPosition pos : positions) {
            if(pos.getPosX() == c) {
                return true;
            }
        }
        return false;
    }

    public void removePositions(List<LPosition> pos) {
        positions.removeAll(pos);
    }

    public void rotate(boolean trigo){
        for(LPosition pos : positions) {
            if(trigo)
                pos.rotate90Trigo(base);
            else
                pos.rotate90AntiTrigo(base);
        }
    }

    // TODO Est-ce qu'on a besoin d'une autre fonction pour différencier les cases collées et celles en diagonale ?
    public ArrayList<LPosition> getAdjacentPositions() {
        return null;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

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

    public LPosition getBase(){
        return base;
    }
}
