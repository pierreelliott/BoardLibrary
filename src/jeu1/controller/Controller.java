package jeu1.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import jeu1.model.Model;
import mainlib.controller.LController;
import mainlib.model.LPiece;
import mainlib.model.LPosition;

public class Controller extends LController {

    private boolean pause;

    public Controller(Model model) throws Exception {
        super(model);
        setCellPadding(5);

        pause = false;

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5D), event -> timing()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    private void timing() {
        if(!pause)
            ((Model) lModel).play();
        refresh();
    }


    @Override
    public void handleKeyPressed(KeyEvent event){
        System.out.println(event.getCode());
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
                pause = !pause;
                break;
        }
        refresh();
    }
}
