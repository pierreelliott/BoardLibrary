package jeu2.controller;

import jeu2.model.ModelDeck;
import mainlib.controller.LController;
import mainlib.model.LModel;

public class ControllerDeck extends LController {

    private LModel mainModel;

    public ControllerDeck(LModel mainModel, ModelDeck modelDeck) throws Exception {
        super(modelDeck);
        this.mainModel = mainModel;
    }

    @Override
    protected void preInitialize(){
        super.preInitialize();
        setGridLinesVisible(true);
//        setPaddingColor(Color.RED);
//        gridID.setGridLinesVisible(false);
    }

}
