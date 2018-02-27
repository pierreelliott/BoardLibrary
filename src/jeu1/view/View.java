package jeu1.view;

import jeu1.controller.Controller;
import jeu1.model.Model;
import mainlib.view.LView;

public class View extends LView {
    @Override
    protected Object getController() throws Exception {
        return new Controller(new Model());
    }
}
