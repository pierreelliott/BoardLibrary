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

    public Controller(Model model) throws Exception {
        super(model);
        setCellPadding(5);
//        setCellDefaultColor(Color.RED);




        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> TEST()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }


    //FIXME
    private void TEST() {
        ((Model) lModel).play();
//        ((Model) lModel).spawnPiece();
        refresh();
//        try {
//            ((Model) lModel).reset();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println("TEST");
    }

    @Override
    protected void cellMouseClicked(int row, int col) {
        System.out.println("Cell clicked at " + row + "," + col);
        LPiece lPiece = lModel.getBoard().getPiece(new LPosition(row, col));
        System.out.println(lPiece);
        if(lPiece != null){
            lPiece.move(new LPosition(1,1));
        }
        refresh();
    }


    @Override
    public void handleKeyPressed(KeyEvent event){
        System.out.println(event.getCode());
        switch (event.getCode()) {
            case DOWN:
                // TODO model.speedUpPiece()
        }
    }
}
