package jeu3.model;

import javafx.scene.paint.Color;
import mainlib.model.LBoard;
import mainlib.model.LModel;
import mainlib.model.LPiece;
import mainlib.model.LPosition;

import java.util.ArrayList;
import java.util.List;

public class Model extends LModel {

    private int WIDTH = 8;
    private int HEIGHT = 8;
    private LPosition finish;
    private LPiece car;

    private int speedTime = 50;

    private Thread tprocess;

    public Model() throws Exception {
        reset();
    }

    public void start() throws Exception {
        loadLevel();
        tprocess = new Thread(() -> {
            System.out.println("Thread started !");
            while(true){
                if(isFinished()) {
                    // Print "Gagné"
                }
                setChanged();
                notifyObservers();
//                System.out.println("Thread ping !");
                try {
                    Thread.sleep(speedTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(isExit())
                    break;
            }
            System.out.println("##################");
            System.out.println("# Game finished. #");
            System.out.println("##################");
        });
        tprocess.start();
    }

    public void reset() throws Exception {
        LBoard board = new LBoard(WIDTH,HEIGHT);
        setBoard(board);
    }

    public void restart() throws Exception {
        reset();
        setFinished(false);
        setScore(0);
    }

    public void select(LPosition pos) {
        setCurrentPiece(getBoard().getPiece(pos));
    }

    public void moveDown() {
        if(!hasCurrentPiece()) return;
        moveSafely(getCurrentPiece(), GODOWN);
    }

    public void moveRight(){
        if(!hasCurrentPiece()) return;
        moveSafely(getCurrentPiece(), GORIGHT);
    }

    public void moveLeft(){
        if(!hasCurrentPiece()) return;
        moveSafely(getCurrentPiece(), GOLEFT);
    }

    public void moveUp(){
        if(!hasCurrentPiece()) return;
        moveSafely(getCurrentPiece(), GOUP);
    }

    public void finishing() {
        if(car.isOnPosition(finish)) {
            setFinished(true);
        }
    }

    public void loadLevel() throws Exception {
        reset();
        getBoard().addPiece(createBorder());
        finish = new LPosition(WIDTH-1,3);

        ArrayList<LPosition> pos = new ArrayList<>();
        pos.add(new LPosition(1,3));
        pos.add(new LPosition(2,3));
        car = new Piece(pos, new LPosition(1,3), Color.RED, true);
        getBoard().addPiece(car);

        ArrayList<LPosition> pos2 = new ArrayList<>();
        pos2.add(new LPosition(4,2));
        pos2.add(new LPosition(4,3));
        pos2.add(new LPosition(4,4));
        getBoard().addPiece(new Piece(pos2, new LPosition(4,3), Color.GREEN, false));
    }

    public LPiece createBorder() {
        ArrayList<LPosition> pos = new ArrayList<>();
        for(int i = 0; i < WIDTH; i++) {
            pos.add(new LPosition(i,0));
            pos.add(new LPosition(i,HEIGHT-1));
        }
        for(int i = 0; i < HEIGHT; i++) {
            pos.add(new LPosition(0,i));
            if(i != 3) {
                pos.add(new LPosition(WIDTH-1,i));
            }
        }
        return new LPiece(pos, new LPosition(0,0), Color.BLACK);
    }
}
