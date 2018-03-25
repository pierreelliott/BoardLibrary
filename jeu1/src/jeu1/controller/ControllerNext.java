package jeu1.controller;

import jeu1.model.ModelNext;
import mainlib.controller.LController;
import mainlib.model.LModel;

import java.util.Observable;

public class ControllerNext extends LController{

    public ControllerNext(LModel lModel, LModel modelNext) throws Exception {
        super(modelNext);
        modelNext.addObserver(this);
    }

    @Override
    protected void preInitialize(){
        super.preInitialize();
        setCellPadding(2);
    }
}
