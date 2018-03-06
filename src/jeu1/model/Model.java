package jeu1.model;

import javafx.scene.paint.Color;
import mainlib.model.LBoard;
import mainlib.model.LModel;
import mainlib.model.LPiece;
import mainlib.model.LPosition;

import java.util.ArrayList;

public class Model extends LModel {

    private int WIDTH = 10;
    private int HEIGHT = 20;

    public Model() throws Exception { //FIXME enlever les essaies
        LBoard board = new LBoard(WIDTH,HEIGHT);
        setBoard(board);
    }

    public void spawnPiece() {
        spawnPiece(generateRandomPiece());
    }

    public void spawnPiece(LPiece p) {
        placeAtCenter(p);
        try {
            lBoard.addPiece(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LPiece generateRandomPiece() {
        int rand = (int)(Math.random()*1000*(PieceEnum.values().length))/1000;
        return generatePiece(PieceEnum.values()[rand]);
    }

    public LPiece generatePiece(PieceEnum p) {
        ArrayList<LPosition> list = new ArrayList<>();
        LPosition base = null;

        switch (p) {
            case TETROMINO_I:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                list.add(new LPosition(3,0));
                base = list.get(1);
                break;
            case TETROMINO_J:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                list.add(new LPosition(2,1));
                base = list.get(2);
                break;
            case TETROMINO_L:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                list.add(new LPosition(0,1));
                base = list.get(0);
                break;
            case TETROMINO_O:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(0,1));
                list.add(new LPosition(1,1));
                base = list.get(0); // FIXME Je sais pas lequel prendre
                break;
            case TETROMINO_S:
                list.add(new LPosition(0,1));
                list.add(new LPosition(1,1));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                base = list.get(2);
                break;
            case TETROMINO_T:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                list.add(new LPosition(1,1));
                base = list.get(1);
                break;
            case TETROMINO_Z:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(1,1));
                list.add(new LPosition(2,1));
                base = list.get(1);
                break;
        }

        return new LPiece(list, base);
    }

    public void placeAtCenter(LPiece piece) {

    }
}
