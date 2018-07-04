package jeu3.model;

import javafx.scene.paint.Color;
import mainlib.model.LPiece;
import mainlib.model.LPosition;

import java.util.ArrayList;

public class Piece extends LPiece {

    /**
     * Direction of the piece
     * <em>True</em> horizontal, <em>False</em> vertical
     */
    private boolean direction;

    public Piece(ArrayList<LPosition> pos, LPosition base, Color color, boolean dir) {
        super(pos, base, color);
        this.direction = dir;
    }

    public void move(LPosition p) {
        if( !((direction && p.direction() == 1) || (!direction && p.direction() == -1)) ) {
            return;
        }
        super.move(p);
    }
}
