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
    private LPiece currentPiece = null;

    public Model() throws Exception {
        reset();
    }

    public void reset() throws Exception {
        LBoard board = new LBoard(WIDTH,HEIGHT);
        setBoard(board);
    }

    public void spawnPiece() {
        currentPiece = spawnPiece(generateRandomPiece());
        if(currentPiece == null)
            finished = true;
    }

    public LPiece spawnPiece(LPiece p) {
        if(!lBoard.placeAtTopCenter(p)){
            return null;
        }
        try {
            lBoard.addPiece(p);
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
        Color color = Color.BLACK;

        switch (p) {
            case TETROMINO_I:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                list.add(new LPosition(3,0));
                base = new LPosition(0,0);
                color = Color.RED;
                break;
            case TETROMINO_J:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                list.add(new LPosition(2,1));
                base = new LPosition(2,0);
                color = Color.MAGENTA;
                break;
            case TETROMINO_L:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                list.add(new LPosition(0,1));
                base = new LPosition(0,0);
                color = Color.YELLOW;
                break;
            case TETROMINO_O:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(0,1));
                list.add(new LPosition(1,1));
                base = new LPosition(0,0);
                color = Color.CYAN;
                break;
            case TETROMINO_S:
                list.add(new LPosition(0,1));
                list.add(new LPosition(1,1));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                base = new LPosition(1,0);
                color = Color.BLUE;
                break;
            case TETROMINO_T:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(2,0));
                list.add(new LPosition(1,1));
                base = new LPosition(1,0);
                color = Color.SILVER;
                break;
            case TETROMINO_Z:
                list.add(new LPosition(0,0));
                list.add(new LPosition(1,0));
                list.add(new LPosition(1,1));
                list.add(new LPosition(2,1));
                base = new LPosition(1,0);
                color = Color.GREEN;
                break;
        }

        return new LPiece(list, base, color);
    }

    public void play() {
        if(finished)
            return;

        if(currentPiece == null) {
            spawnPiece();
            return;
        } else {
            if(!moveSafely(currentPiece, GODOWN)){
                lBoard.explodeLPiece(currentPiece);
                currentPiece = null;
            }
        }
        fullRow();
    }

    public void speedUpPiece() {
        while (currentPiece != null && moveSafely(currentPiece, GODOWN));
    }

    public void moveRight(){
        moveSafely(currentPiece, GORIGHT);
    }

    public void moveLeft(){
        moveSafely(currentPiece, GOLEFT);
    }

    public void rotate() {
        rotateSafely(currentPiece, true);
    }

    public void fullRow(){
        for(int i = 0 ; i < HEIGHT; i++){
            if(lBoard.isFullLine(new LPosition(0, i), new LPosition(1,0))){
                System.out.println("Line " + i + " full !");
                lBoard.clearLine(new LPosition(0, i), new LPosition(1,0));
                lBoard.movePieces(
                        new LPosition(0, 0),
                        new LPosition(WIDTH -1, i),
                        new LPosition(0,1)
                );
            }
        }
    }
}
