package jeu1.controller;

import javafx.application.Platform;
import jeu1.model.ModelNext;
import mainlib.controller.LController;
import mainlib.model.LModel;

import java.util.Observable;

public class ControllerNext extends LController{

    public ControllerNext(LModel lModel, LModel modelNext) throws Exception {
        super(modelNext);
        lModel.addObserver(this);
    }

    @Override
    protected void preInitialize(){
        super.preInitialize();
        setCellPadding(2);
    }

    @Override
    public void update(Observable o, Object arg) {
        ((ModelNext) lModel).refreshPiece();
        Platform.runLater(this::refresh);
    }
}
