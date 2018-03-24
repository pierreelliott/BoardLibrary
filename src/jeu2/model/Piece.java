package jeu2.model;

import javafx.scene.paint.Color;
import mainlib.model.LPiece;
import mainlib.model.LPosition;

import java.util.ArrayList;

public class Piece extends LPiece {

    private LPosition startPos;

    public Piece(ArrayList<LPosition> pos, LPosition base, Color color, LPosition startPos) {
        super(pos, base, color);
        this.startPos = startPos;
    }

    public void moveToStartPos(){
        move(startPos);
    }

}
