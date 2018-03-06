package jeu1.model;

import javafx.scene.paint.Color;
import mainlib.model.LBoard;
import mainlib.model.LModel;
import mainlib.model.LPiece;
import mainlib.model.LPosition;

import java.util.ArrayList;

public class Model extends LModel {

    public Model() throws Exception { //FIXME enlever les essaies
        LBoard board = new LBoard(5,6);
        setBoard(board);
        ArrayList<LPosition> aPos = new ArrayList<>();
        aPos.add(new LPosition(2,2));
        aPos.add(new LPosition(2,3));
        aPos.add(new LPosition(2,4));
        board.addPiece(new LPiece(aPos, new LPosition(aPos.get(0))));

        ArrayList<LPosition> aPos2 = new ArrayList<>();
        aPos2.add(new LPosition(1,0));
        aPos2.add(new LPosition(2,0));
        aPos2.add(new LPosition(3,0));
        board.addPiece(new LPiece(aPos2,  new LPosition(aPos2.get(0)), Color.BLUE));

    }
}
