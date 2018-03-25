package jeu2.model;

import javafx.scene.paint.Color;
import mainlib.model.LModel;
import mainlib.model.LPiece;
import mainlib.model.LPosition;

import java.util.Observable;
import java.util.Observer;

public class ModelDeck extends LModel implements Observer {

    private Model model;
    private int WIDTH = 15;

    private int HEIGHT = 15;

    private Color color;
    private Color colorDark;
    private int playerI;

    public ModelDeck(Model model, Color color, Color colorDark, int playerI) throws Exception {
        super();
        Board board = new Board(WIDTH,HEIGHT);
        setBoard(board);
        this.model = model;
        this.model.addObserver(this);
        this.color = color;
        this.colorDark = colorDark;
        this.playerI = playerI;

        Piece p;
        for (PieceEnum pe : PieceEnum.values()) {
            p = model.generatePiece(pe, playerI == 0 ? color : colorDark);
            p.moveToStartPos();
            getBoard().addPiece(p);
        }
    }

    public void selectPiece(int col, int row){
        if(!canPlay())
            return;
        Piece p = (Piece) getBoard().getPiece(new LPosition(col, row));
        if(p == null){
            if(hasCurrentPiece()) {
                getCurrentPiece().setColor(color);
            }
            model.resetCurrentPiece();
            resetCurrentPiece();
            return;
        }
        if(hasCurrentPiece() && p != getCurrentPiece()) {
            getCurrentPiece().setColor(color);
        }
        setCurrentPiece(p);
        model.setCurrentPiece(new LPiece(p));
        p.setColor(Color.GRAY);
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

    @Override
    public void update(Observable o, Object arg) {
        removePiece();
        if(canPlay()){
            enable();
        } else {
            disable();
        }
        setChanged();
        notifyObservers();
    }

    private boolean canPlay(){
        return model.getPlayerI() == playerI;
    }
}
