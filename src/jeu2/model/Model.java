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

    public LPiece generateRandomPiece(Color color) {
        int rand = (int)(Math.random()*1000*(PieceEnum.values().length))/1000;
        return (new Piece()).generatePiece(PieceEnum.values()[rand], color);
    }

    public LPiece generateRandomPiece() { return generateRandomPiece(Color.BLACK); }

    public LPiece generatePiece(PieceEnum p) { return (new Piece()).generatePiece(p, Color.BLACK); }

    public void play() {

    }

    public void placeAt(LPosition p, boolean permanent) {
        boolean placed = placeSafely(getCurrentPiece(), p);
        if(permanent && placed) {
            spawnPiece();
        }
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
}
