package jeu2.model;

import javafx.scene.paint.Color;
import mainlib.model.LBoard;
import mainlib.model.LModel;
import mainlib.model.LPiece;
import mainlib.model.LPosition;

import java.util.ArrayList;
import java.util.List;

public class Model extends LModel {

    private int WIDTH = 20;
    private int HEIGHT = 20;
    private PlayerEnum player;
    private List<PlayerEnum> eliminated;

    public Model() throws Exception {
        LBoard board = new LBoard(WIDTH,HEIGHT);
        setBoard(board);
        player = PlayerEnum.BLUE;
        eliminated = new ArrayList<>();
    }

    public Piece generatePiece(PieceEnum p, Color color) {
        ArrayList<LPosition> list = new ArrayList<>();
        LPosition base = null;
        LPosition startPos = null;

        switch (p) {
            case P1:
                list.add(new LPosition(0,0));
                base = new LPosition(0,0);
                startPos = new LPosition(14,0);
                break;
            case P2:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                base = new LPosition(0,0);
                startPos = new LPosition(9,10);
                break;
            case P3:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(1,1));
                base = new LPosition(1,0);
                startPos = new LPosition(6,0);
                break;
            case P4:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                base = new LPosition(1,0);
                startPos = new LPosition(0,14);
                break;
            case P5:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(0,1));
                list.add(new LPosition(1,1));
                base = new LPosition(1,0);
                startPos = new LPosition(0,5);
                break;
            case P6:
                list.add(new LPosition(1,0));
                list.add(new LPosition(0,1));
                list.add(new LPosition(1,1));
                list.add(new LPosition(1,2));
                base = new LPosition(1,1);
                startPos = new LPosition(13,11);
                break;
            case P7:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                list.add(new LPosition(3,0));
                base = new LPosition(1,0);
                startPos = new LPosition(3,6);
                break;
            case P8:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(1,1));
                list.add(new LPosition(1,2));
                base = new LPosition(1,1);
                startPos = new LPosition(10,6);
                break;
            case P9:
                list.add(new LPosition(0,1));
                list.add(new LPosition(1,1));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                base = new LPosition(1,1);
                startPos = new LPosition(5,13);
                break;
            case P10:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                list.add(new LPosition(3,0));
                list.add(new LPosition(3,1));
                base = new LPosition(2,0);
                startPos = new LPosition(9,0);
                break;
            case P11:
                list.add(new LPosition(0,0));
                list.add(new LPosition(0,1));
                list.add(new LPosition(0,2));
                list.add(new LPosition(1,1));
                list.add(new LPosition(2,1));
                base = new LPosition(1,1);
                startPos = new LPosition(4,10);
                break;
            case P12:
                list.add(new LPosition(0,0));
                list.add(new LPosition(0,1));
                list.add(new LPosition(0,2));
                list.add(new LPosition(1,2));
                list.add(new LPosition(2,2));
                base = new LPosition(0,2);
                startPos = new LPosition(4,2);
                break;
            case P13:
                list.add(new LPosition(1,0));
                list.add(new LPosition(0,1));
                list.add(new LPosition(1,1));
                list.add(new LPosition(0,2));
                list.add(new LPosition(0,3));
                base = new LPosition(1,0);
                startPos = new LPosition(13,6);
                break;
            case P14:
                list.add(new LPosition(0,1));
                list.add(new LPosition(0,2));
                list.add(new LPosition(1,1));
                list.add(new LPosition(2,1));
                list.add(new LPosition(2,0));
                base = new LPosition(1,1);
                startPos = new LPosition(6,7);
                break;
            case P15:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                list.add(new LPosition(3,0));
                list.add(new LPosition(4,0));
                base = new LPosition(2,0);
                startPos = new LPosition(0,0);
                break;
            case P16:
                list.add(new LPosition(0,0));
                list.add(new LPosition(0,1));
                list.add(new LPosition(1,0));
                list.add(new LPosition(1,1));
                list.add(new LPosition(2,1));
                base = new LPosition(0,1);
                startPos = new LPosition(0,11);
                break;
            case P17:
                list.add(new LPosition(2,0));
                list.add(new LPosition(1,1));
                list.add(new LPosition(2,1));
                list.add(new LPosition(0,2));
                list.add(new LPosition(1,2));
                base = new LPosition(1,1);
                startPos = new LPosition(12,2);
                break;
            case P18:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                list.add(new LPosition(0,1));
                list.add(new LPosition(2,1));
                base = new LPosition(0,1);
                startPos = new LPosition(0,2);
                break;
            case P19:
                list.add(new LPosition(1,1));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                list.add(new LPosition(0,1));
                list.add(new LPosition(1,2));
                base = new LPosition(1,1);
                startPos = new LPosition(9,12);
                break;
            case P20:
                list.add(new LPosition(1,1));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,1));
                list.add(new LPosition(0,1));
                list.add(new LPosition(1,2));
                base = new LPosition(1,1);
                startPos = new LPosition(8,2);
                break;
            case P21:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                list.add(new LPosition(3,0));
                list.add(new LPosition(2,1));
                base = new LPosition(1,1);
                startPos = new LPosition(0,8);
                break;
        }

        return new Piece(list, base, color, startPos);
    }

    public boolean placeAt(LPosition p) {
        if(!hasCurrentPiece())
            return false;
        try {
            getBoard().addPiece(getCurrentPiece());
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean placed = placeSafely(getCurrentPiece(), p);
        if(!placed)
            getBoard().removePiece(getCurrentPiece());
        return placed;
    }

    public void click(LPosition p){
        if(!hasCurrentPiece())
            return;
        boolean placed = placeSafely(getCurrentPiece(), p);
        if(!placed){
            getBoard().removePiece(getCurrentPiece());
            return;
        }

        getBoard().removePiece(getCurrentPiece());
        try {
            getBoard().addPiece(new LPiece(getCurrentPiece()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        resetCurrentPiece();
        setChanged();
        notifyObservers();
    }

    public void moveRight(){
        moveSafely(getCurrentPiece(), GORIGHT);
    }

    public void moveLeft(){
        moveSafely(getCurrentPiece(), GOLEFT);
    }

    public void moveUp(){
        moveSafely(getCurrentPiece(), GOUP);
    }

    public void moveDown(){
        moveSafely(getCurrentPiece(), GODOWN);
    }

    public void rotatePiece(){ rotateSafely(getCurrentPiece(), true); }

    public void selectPiece(LPosition pos) { setCurrentPiece(getBoard().getPiece(pos)); }

    public void nextPlayer() {
        player = player.next();
        if(eliminated.size() < 4 && eliminated.contains(player)) {
            nextPlayer();
        }
    }

    public void eliminate(PlayerEnum p) {
        eliminated.add(p);
        if(eliminated.size() >= 4) {
            setFinished(true);
        }
    }

    public void flipXPiece() {
        flipSafely(getCurrentPiece(), true);
    }

    public void flipYPiece() {
        flipSafely(getCurrentPiece(), false);
    }

    public void removeCurrentPiece(){
        if(hasCurrentPiece()){
            getBoard().removePiece(getCurrentPiece());
        }
    }
}
