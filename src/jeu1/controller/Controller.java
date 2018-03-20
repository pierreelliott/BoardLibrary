package jeu1.controller;

import javafx.scene.input.KeyEvent;
import jeu1.model.Model;
import mainlib.controller.LController;

public class Controller extends LController {

    public Controller(Model model) throws Exception {
        super(model);
        setCellPadding(2);

        model.addObserver(this);
    }

    @Override
    protected void preInitialize(){
        super.preInitialize();
        gridID.setGridLinesVisible(false);
    }


    @Override
    public void handleKeyPressed(KeyEvent event){
//        System.out.println(event.getCode());
        switch (event.getCode()) {
            case DOWN:
                ((Model) lModel).speedUpPiece();
                break;
            case LEFT:
                ((Model) lModel).moveLeft();
                break;
            case RIGHT:
                ((Model) lModel).moveRight();
                break;
            case UP:
                ((Model) lModel).rotate();
                break;
            case SPACE: //FIXME enlever ce cheat
                ((Model) lModel).togglePause();
                break;
        }
        refresh();
    }
}
