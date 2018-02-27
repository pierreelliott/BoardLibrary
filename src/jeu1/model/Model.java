package jeu1.model;

import mainlib.model.LBoard;
import mainlib.model.LModel;

public class Model extends LModel {

    public Model() throws Exception {
        setBoard(new LBoard(10,5));
    }
}
