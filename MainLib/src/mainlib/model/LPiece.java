package mainlib.model;

import java.util.ArrayList;
import java.util.List;

public class LPiece {

    private List<LPosition> positions;
    private boolean broked; // Si la pièce est cassée, elle ne peut plus tourner

    public LPiece() {
        positions = new ArrayList<>();
    }

    public LPiece(List<LPosition> pos) {
        positions = pos;
    }

    public List<LPosition> getPositions() {
        return positions;
    }

    public void move(LPosition p) {
        for(LPosition pos : positions) {
            pos.translate(p);
        }
    }

    public boolean isEmpty() {
        return positions.isEmpty();
    }

    public void removePosition(LPosition p) {
        positions.remove(p);
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
        LPiece piece = new LPiece(positions);
        piece.move(p);
        return piece;
    }

    // TODO Est-ce qu'on a besoin d'une autre fonction pour différencier les cases collées et celles en diagonale ?
    public List<LPosition> getAdjacentPositions() {
        return null;
    }
}
