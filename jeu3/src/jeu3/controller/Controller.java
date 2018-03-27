package jeu3.controller;

import javafx.scene.input.KeyEvent;
import jeu3.model.Model;
import mainlib.controller.LController;
import mainlib.model.LPosition;

public class Controller extends LController {

    public Controller(Model model) throws Exception {
        super(model);
        setCellPadding(2);

        model.addObserver(this);
    }

    protected void cellMouseClicked(int row, int col) {
        ((Model) lModel).select(new LPosition(col, row));
        refresh();
    }

    @Override
    public void handleKeyPressed(KeyEvent event){
//        System.out.println(event.getCode());
        switch (event.getCode()) {
            case DOWN:
                ((Model) lModel).move("DOWN");
                break;
            case LEFT:
                ((Model) lModel).move("LEFT");
                break;
            case RIGHT:
                ((Model) lModel).move("RIGHT");
                break;
            case UP:
                ((Model) lModel).move("UP");
                break;
        }
        refresh();
    }
}
