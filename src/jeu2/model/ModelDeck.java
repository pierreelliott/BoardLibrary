package jeu2.model;

import javafx.scene.paint.Color;
import mainlib.model.LBoard;
import mainlib.model.LModel;
import mainlib.model.LPiece;
import mainlib.model.LPosition;

public class ModelDeck extends LModel {

    private Model model;
    private int WIDTH = 15;
    private int HEIGHT = 15;

    private Color color;

    public ModelDeck(Model model, Color color) throws Exception {
        super();
        LBoard board = new LBoard(WIDTH,HEIGHT);
        setBoard(board);
        this.model = model;
        this.color = color;

        Piece p;
        for (PieceEnum pe : PieceEnum.values()) {
            p = model.generatePiece(pe, color);
            p.moveToStartPos();
            getBoard().addPiece(p);
        }
    }

    public void selectPiece(int col, int row){
        Piece p = (Piece) getBoard().getPiece(new LPosition(col, row));
        if(p == null){
            model.resetCurrentPiece();
            resetCurrentPiece();
            return;
        }
        setCurrentPiece(p);
        model.setCurrentPiece(new LPiece(p));
    }

    public void removePiece(){
        if(hasCurrentPiece())
            getBoard().removePiece(getCurrentPiece());
        resetCurrentPiece();
    }
}
