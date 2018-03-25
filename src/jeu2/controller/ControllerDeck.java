package jeu2.controller;

import jeu2.model.ModelDeck;
import mainlib.controller.LController;


public class ControllerDeck extends LController {


    public ControllerDeck(ModelDeck modelDeck) throws Exception {
        super(modelDeck);
        modelDeck.addObserver(this);
    }

    @Override
    protected void cellMouseClicked(int row, int col) {
        ((ModelDeck) lModel).selectPiece(col, row);
        refresh();
    }
}
