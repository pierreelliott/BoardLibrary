package jeu2.controller;

import javafx.scene.paint.Color;
import jeu2.model.Model;
import jeu2.model.ModelDeck;
import mainlib.controller.LController;
import mainlib.model.LModel;
import mainlib.model.LPiece;
import mainlib.model.LPosition;

import java.util.Observable;

public class ControllerDeck extends LController {

    private LModel mainModel;
    private LPosition selectedPos;

    public ControllerDeck(LModel mainModel, ModelDeck modelDeck) throws Exception {
        super(modelDeck);
        this.mainModel = mainModel;
    }

    protected void cellMouseClicked(int row, int col) {
        System.out.println("Cell clicked at " + row + "," + col + "\nIn deck " + ((ModelDeck)lModel).getColor().toString());
        LPosition pos = new LPosition(col, row);
        LPiece p = ((ModelDeck)lModel).getPiece(pos);
        if(p != null && !mainModel.hasCurrentPiece()) {
            mainModel.setCurrentPiece(((Model)mainModel).spawnPiece(new LPiece(p)));
            p.setColor(Color.GRAY);
            selectedPos = pos;
            mainModel.addObserver(this);
            // TODO Demander au model de le notifier si la pièce est définitivement posée
        }
        refresh();
    }

    public void update(Observable o, Object arg) {
        lModel.getBoard().removePiece(lModel.getBoard().getPiece(selectedPos));
        mainModel.resetCurrentPiece();
        refresh();
    }
}
