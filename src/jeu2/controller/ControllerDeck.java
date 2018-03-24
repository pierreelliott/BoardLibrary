package jeu2.controller;

import jeu2.model.Model;
import jeu2.model.ModelDeck;
import mainlib.controller.LController;
import mainlib.model.LModel;

import java.util.Observable;

public class ControllerDeck extends LController {

    private LModel mainModel;

    public ControllerDeck(LModel mainModel,  ModelDeck modelDeck) throws Exception {
        super(modelDeck);
        this.mainModel = mainModel;
        this.mainModel.addObserver(this);
    }


    @Override
    protected void cellMouseClicked(int row, int col) {
        ((ModelDeck) lModel).selectPiece(col, row);
        refresh();
    }

    @Override
    public void update(Observable o, Object arg) {
        ((ModelDeck) lModel).removePiece();
//        if(((Model) mainModel).getPlayerI())
        ((ModelDeck) lModel).disable();
        super.update(o, arg);
    }
}
