package jeu3.controller;

import javafx.scene.input.KeyEvent;
import jeu3.model.Model;
import jeu3.view.View;
import mainlib.controller.LController;
import mainlib.model.LPosition;

import java.util.Observable;

public class Controller extends LController {

    private View view;

    public Controller(Model model, View view) throws Exception {
        super(model);
        setCellPadding(2);
        this.view = view;

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

    public void startGame() throws Exception {
        ((Model)lModel).start();
    }

    @Override
    public void update(Observable o, Object arg) {
        super.update(o, arg);
        if(!lModel.isFinished()) {
            return;
        }
        if(view.gameFinished()) {
            try {
                startGame();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            lModel.setExit(true);
            lModel.setFinished(true);
        }
    }
}
