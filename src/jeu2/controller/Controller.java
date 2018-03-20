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
        model.spawnPiece();
    }

    protected void preInitialize(){
        super.preInitialize();
        gridID.setGridLinesVisible(true);
    }

    @Override
    protected void cellMouseClicked(int row, int col) {
        //System.out.println("Cell clicked at " + row + "," + col);
        ((Model) lModel).selectPiece(new LPosition(col, row));
        System.out.println("Sélectionné !");
        refresh();
    }

    protected void cellMouseEnter(int row, int col) {
        previewPiece(new LPosition(col, row));
        refresh();
    }

    @Override
    public void handleKeyPressed(KeyEvent event){
        switch (event.getCode()) {
            case DOWN:
                ((Model) lModel).moveUp();
                break;
            case LEFT:
                ((Model) lModel).moveLeft();
                break;
            case RIGHT:
                ((Model) lModel).moveRight();
                break;
            case UP:
                ((Model) lModel).moveDown();
                break;
            case SPACE:
                ((Model) lModel).rotatePiece();
                break;
        }
        refresh();
    }

    public void previewPiece(LPosition pos) {
        if(((Model) lModel).hasCurrentPiece()) {
            ((Model) lModel).safelyPlaceAt(pos);
        }
    }
}
