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
    private Color colorDark;

    public ModelDeck(Model model, Color color, Color colorDark) throws Exception {
        super();
        Board board = new Board(WIDTH,HEIGHT);
        setBoard(board);
        this.model = model;
        this.color = color;
        this.colorDark = colorDark;

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

    public boolean hasNoMorePiece(){
        return getBoard().countPieces() == 0;
    }

    public Color getColor(){
        return color;
    }

    public void enable(){
        ((Board) getBoard()).changePiecesColor(color);
    }

    public void disable(){
        ((Board) getBoard()).changePiecesColor(colorDark);
    }
}
