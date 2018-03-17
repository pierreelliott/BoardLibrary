package jeu2.model;

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

    public LPiece generatePiece(PieceEnum p) {
        ArrayList<LPosition> list = new ArrayList<>();
        LPosition base = null;

        switch (p) {
            case PENTOMINO:
                break;
            case TETROMINO:
                break;
            case TRIOMINO:
                break;
            case DOMINO:
                break;
            case UNOMINO:
                break;
        }

        return new LPiece(list, base);
    }

    public void play() {

    }
}
