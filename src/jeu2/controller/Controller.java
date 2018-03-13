package jeu2.controller;

import javafx.scene.input.KeyEvent;
import jeu2.model.Model;
import mainlib.controller.LController;
import mainlib.model.LPiece;
import mainlib.model.LPosition;

public class Controller extends LController {
    public Controller(Model model) throws Exception {
        super(model);
        setCellPadding(5);
//        setCellDefaultColor(Color.RED);
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
