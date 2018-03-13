package mainlib.model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class LPiece {

    private List<LPosition> positions;
    private boolean broked; // Si la pièce est cassée, elle ne peut plus tourner
    private Color color;
    private LPosition base;

    public LPiece() {
        this(new ArrayList<>(), new LPosition(0,0));
    }

    public LPiece(List<LPosition> pos, LPosition base) {
        this(pos, base, Color.MAGENTA);
    }

    public LPiece(List<LPosition> pos, LPosition base, Color color) {
        this.positions = pos;
        this.color = color;
        this.base = base;
    }

    public List<LPosition> getPositions() {
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

    // TODO Ajouter le sens en paramètre ?
    public void rotate() {
        // Après discussion : mettre un point de rotation en attribut de la pièce que l'on utilisera ensuite
    }

    public LPiece hypoMove(LPosition p) {
        LPiece piece = new LPiece(positions, base); // FIXME le "base" n'est pas sur du tout !!!
        piece.move(p);
        return piece;
    }

    // TODO Est-ce qu'on a besoin d'une autre fonction pour différencier les cases collées et celles en diagonale ?
    public List<LPosition> getAdjacentPositions() {
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
        int w1 = -1, w2 = 0;
        for(LPosition p : positions) {
            if(p.getPosX() > w2) {
                w2 = p.getPosX();
            }
            if(w1 == -1) {
                w1 = p.getPosX();
            }
            if(w1 > p.getPosX()) {
                w1 = p.getPosX();
            }
        }
        return w2 - w1;
    }

    public int getHeight() {
        if(positions.isEmpty()) {
            return 0;
        }
        int w1 = -1, w2 = 0;
        for(LPosition p : positions) {
            if(p.getPosY() > w2) {
                w2 = p.getPosY();
            }
            if(w1 == -1) {
                w1 = p.getPosY();
            }
            if(w1 > p.getPosY()) {
                w1 = p.getPosY();
            }
        }
        return w2 - w1;
    }
}
