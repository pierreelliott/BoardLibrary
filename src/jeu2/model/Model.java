package jeu2.model;

import javafx.scene.paint.Color;
import mainlib.model.LBoard;
import mainlib.model.LModel;
import mainlib.model.LPiece;
import mainlib.model.LPosition;

import java.util.ArrayList;

public class Model extends LModel {

    private int WIDTH = 10;
    private int HEIGHT = 20;

    public Model() throws Exception {
        LBoard board = new LBoard(WIDTH,HEIGHT);
        setBoard(board);
    }

    public void spawnPiece() {
        setCurrentPiece(spawnPiece(generateRandomPiece()));
    }

    public LPiece spawnPiece(LPiece p) {
        getBoard().placeAtTopCenter(p);
        try {
            getBoard().addPiece(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public LPiece generateRandomPiece() {
        int rand = (int)(Math.random()*1000*(PieceEnum.values().length))/1000;
        return generatePiece(PieceEnum.values()[rand]);
    }

    public LPiece generatePiece(PieceEnum p) { return generatePiece(p, Color.BLACK); }

    public LPiece generatePiece(PieceEnum p, Color color) {
        ArrayList<LPosition> list = new ArrayList<>();
        LPosition base = null;

        switch (p) {
            case P1:
                list.add(new LPosition(0,0));
                base = new LPosition(0,0);
                break;
            case P2:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                base = new LPosition(0,0);
                break;
            case P3:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(1,1));
                base = new LPosition(1,0);
                break;
            case P4:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                base = new LPosition(1,0);
                break;
            case P5:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(0,1));
                list.add(new LPosition(1,1));
                base = new LPosition(1,0);
                break;
            case P6:
                list.add(new LPosition(0,0));
                list.add(new LPosition(0,-1));
                list.add(new LPosition(1,0));
                list.add(new LPosition(-1,0));
                base = new LPosition(0,0);
                break;
            case P7:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                list.add(new LPosition(3,0));
                base = new LPosition(1,0);
                break;
            case P8:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                list.add(new LPosition(2,-1));
                base = new LPosition(1,0);
                break;
            case P9:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(1,-1));
                list.add(new LPosition(2,-1));
                base = new LPosition(1,0);
                break;
            case P10:
                list.add(new LPosition(0,0));
                list.add(new LPosition(0,1));
                list.add(new LPosition(1,1));
                list.add(new LPosition(2,1));
                list.add(new LPosition(3,1));
                base = new LPosition(1,1);
                break;
            case P11:
                list.add(new LPosition(1,0));
                list.add(new LPosition(1,1));
                list.add(new LPosition(1,2));
                list.add(new LPosition(0,2));
                list.add(new LPosition(2,2));
                base = new LPosition(1,2);
                break;
            case P12:
                list.add(new LPosition(0,0));
                list.add(new LPosition(0,1));
                list.add(new LPosition(0,2));
                list.add(new LPosition(1,2));
                list.add(new LPosition(2,2));
                base = new LPosition(0,2);
                break;
            case P13:
                list.add(new LPosition(0,1));
                list.add(new LPosition(1,1));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                list.add(new LPosition(3,0));
                base = new LPosition(1,0);
                break;
            case P14:
                list.add(new LPosition(0,1));
                list.add(new LPosition(0,2));
                list.add(new LPosition(1,1));
                list.add(new LPosition(2,1));
                list.add(new LPosition(2,0));
                base = new LPosition(1,1);
                break;
            case P15:
                list.add(new LPosition(0,0));
                list.add(new LPosition(0,1));
                list.add(new LPosition(0,2));
                list.add(new LPosition(0,3));
                list.add(new LPosition(0,4));
                base = new LPosition(0,2);
                break;
            case P16:
                list.add(new LPosition(0,0));
                list.add(new LPosition(0,1));
                list.add(new LPosition(0,2));
                list.add(new LPosition(1,1));
                list.add(new LPosition(1,2));
                base = new LPosition(0,1);
                break;
            case P17:
                list.add(new LPosition(0,1));
                list.add(new LPosition(0,2));
                list.add(new LPosition(1,1));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                base = new LPosition(1,1);
                break;
            case P18:
                list.add(new LPosition(0,0));
                list.add(new LPosition(0,1));
                list.add(new LPosition(0,2));
                list.add(new LPosition(1,2));
                list.add(new LPosition(1,0));
                base = new LPosition(0,1);
                break;
            case P19:
                list.add(new LPosition(0,0));
                list.add(new LPosition(0,-1));
                list.add(new LPosition(1,-1));
                list.add(new LPosition(-1,0));
                list.add(new LPosition(0,1));
                base = new LPosition(0,0);
                break;
            case P20:
                list.add(new LPosition(0,0));
                list.add(new LPosition(0,-1));
                list.add(new LPosition(1,0));
                list.add(new LPosition(-1,0));
                list.add(new LPosition(0,1));
                base = new LPosition(0,0);
                break;
            case P21:
                list.add(new LPosition(1,0));
                list.add(new LPosition(0,1));
                list.add(new LPosition(1,1));
                list.add(new LPosition(2,1));
                list.add(new LPosition(3,1));
                base = new LPosition(1,1);
                break;
        }

        return new LPiece(list, base, color);
    }

    public void play() {

    }

    public void safelyPlaceAt(LPosition p) {
        getCurrentPiece().placeAt(p);
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
}
