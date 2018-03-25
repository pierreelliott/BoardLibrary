package jeu2.controller;

import javafx.scene.input.KeyEvent;
import jeu2.model.Model;
import mainlib.controller.LController;
import mainlib.model.LPosition;

public class Controller extends LController {
    public Controller(Model model) throws Exception {
        super(model);
        setCellPadding(5);
    }

    protected void preInitialize(){
        super.preInitialize();
        setGridLinesVisible(true);
    }

    @Override
    protected void cellMouseClicked(int row, int col) {
        ((Model) lModel).click(new LPosition(col, row));
        refresh();
    }

    protected void cellMouseEnter(int row, int col) {
        ((Model) lModel).placeAt(new LPosition(col, row));
        refresh();
    }

    protected void cellMouseExited(int row, int col) {
        ((Model) lModel).removeCurrentPiece();
    }

    @Override
    public void handleKeyPressed(KeyEvent event){
        switch (event.getCode()) {
            case DOWN:
                ((Model) lModel).moveDown();
                break;
            case LEFT:
                ((Model) lModel).moveLeft();
                break;
            case RIGHT:
                ((Model) lModel).moveRight();
                break;
            case UP:
                ((Model) lModel).moveUp();
                break;
            case SPACE:
                ((Model) lModel).rotatePiece();
                break;
            case L:
                ((Model) lModel).flipXPiece();
                break;
            case M:
                ((Model) lModel).flipYPiece();
                break;
            case ENTER:
                ((Model) lModel).enter();
                break;
        }
        refresh();
    }
}
