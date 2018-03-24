package jeu2.controller;

import jeu2.model.Model;
import jeu2.model.ModelDeck;
import mainlib.controller.LController;
import mainlib.model.LModel;
import mainlib.model.LPiece;
import mainlib.model.LPosition;

public class ControllerDeck extends LController {

    private LModel mainModel;

    public ControllerDeck(LModel mainModel, ModelDeck modelDeck) throws Exception {
        super(modelDeck);
        this.mainModel = mainModel;
    }

    protected void cellMouseClicked(int row, int col) {
        System.out.println("Cell clicked at " + row + "," + col + "\nIn deck " + ((ModelDeck)lModel).getColor().toString());
        LPosition pos = new LPosition(col, row);
        LPiece p = ((ModelDeck)lModel).getPiece(pos);
        if(p != null) {
            mainModel.setCurrentPiece(((Model)mainModel).spawnPiece(p));
            // TODO Demander au model de le notifier si la pièce est définitivement posée
        }
        refresh();
    }

}
