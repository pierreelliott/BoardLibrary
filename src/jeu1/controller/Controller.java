package jeu1.controller;

import jeu1.model.Model;
import mainlib.controller.LController;

public class Controller extends LController {
    public Controller(Model model) throws Exception {
        super(model);
        setCellPadding(5);
    }

    @Override
    protected void cellMouseClicked(int row, int col) {
        System.out.println("Cell clicked at " + row + "," + col);
    }
}
