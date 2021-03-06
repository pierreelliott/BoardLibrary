package jeu2.model;

import javafx.scene.paint.Color;
import mainlib.model.LBoard;
import mainlib.model.LModel;
import mainlib.model.LPiece;
import mainlib.model.LPosition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model extends LModel {

    private int WIDTH = 20;
    private int HEIGHT = 20;

    private int playerI = 0;
    private List<Integer> eliminated = new ArrayList<>();

    // Liste des couleurs actives.
    private ArrayList<Color> colors = new ArrayList<>(Arrays.asList(
            Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN));
    // Liste des couleurs désactivées.
    private ArrayList<Color> colorsDark = new ArrayList<>(Arrays.asList(
            Color.DARKBLUE, Color.DARKGOLDENROD, Color.DARKRED, Color.DARKGREEN));

    public Model() throws Exception {
        LBoard board = new LBoard(WIDTH,HEIGHT);
        setBoard(board);
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
        addCurrentPiece();
        boolean placed = placeSafely(getCurrentPiece(), p);
        if(!placed)
            getBoard().removePiece(getCurrentPiece());
        return placed;
    }

    public void click(LPosition p){
        if(!hasCurrentPiece())
            return;
        boolean placed = placeSafely(getCurrentPiece(), p);
        getBoard().removePiece(getCurrentPiece());
        if(!placed){
            return;
        }
        placePersistencePiece();
    }

    public void enter(){
        placePersistencePiece();
    }

    private void placePersistencePiece(){
        // FIXME Je sais pas si faut placer la vérification des règles ici
        if(!followGameRules()) {
            return;
        }
        addCurrentPiece();
        resetCurrentPiece();
        // FIXME Trouver comment ajouter le joueur qui a terminé à "eliminated"
        if(nextPlayerI() == -1) {
            setFinished(true);
        }
        setChanged();
        notifyObservers();
    }

    public boolean followGameRules() {
        // FIXME Vérification si la currentPiece existe, non ?
        return followGameRules(getCurrentPiece());
    }

    public boolean followGameRules(LPiece piece) {
        // FIXME Je considère que la pièce ne collide pas avec les autres (pour réduire la complexité)
        int count = 0;
        List<LPiece> pieces = getBoard().getPieces();
        if(pieces.size() < 4) {
            pieces = addStartingPositions(pieces); //FIXME Les pièces de départ s'ajoutent définitivement dans le board à cause des pointeurs de java
        }
        for(LPiece p : pieces) {
            if(p.getColor().equals(colors.get(playerI))) { // FIXME The piece belong to the current player
                if(isAdjacentTo(piece, p, 1))
                {
                    return false;
                }
                if(isAdjacentTo(piece, p, -1))
                {
                    count++;
                }
            }
        }
        // Il faut aussi tester qu'elle touche une pièce (càd, qu'elle soit au moins adjacente à une pièce)
        return (count > 0);
    }

    private List<LPiece> addStartingPositions(List<LPiece> pieces) {
        pieces.add(startPos(new LPosition(-1,-1), 0));
        pieces.add(startPos(new LPosition(WIDTH,-1), 1));
        pieces.add(startPos(new LPosition(WIDTH,HEIGHT), 2));
        pieces.add(startPos(new LPosition(-1,HEIGHT), 3));

        return pieces;
    }

    private LPiece startPos(LPosition p, int color) {
        ArrayList<LPosition> pos = new ArrayList<>();
        pos.add(p);
        return new LPiece(pos, p, colors.get(color));
    }

    public void moveRight(){
        if(!hasCurrentPiece())
            return;
        getBoard().removePiece(getCurrentPiece());
        moveSafely(getCurrentPiece(), GORIGHT);
        addCurrentPiece();
    }

    public void moveLeft(){
        if(!hasCurrentPiece())
            return;
        getBoard().removePiece(getCurrentPiece());
        moveSafely(getCurrentPiece(), GOLEFT);
        addCurrentPiece();
    }

    public void moveUp(){
        if(!hasCurrentPiece())
            return;
        getBoard().removePiece(getCurrentPiece());
        moveSafely(getCurrentPiece(), GOUP);
        addCurrentPiece();
    }

    public void moveDown(){
        if(!hasCurrentPiece())
            return;
        getBoard().removePiece(getCurrentPiece());
        moveSafely(getCurrentPiece(), GODOWN);
        addCurrentPiece();
    }

    public void rotatePiece(){
        if(!hasCurrentPiece())
            return;
        getBoard().removePiece(getCurrentPiece());
        rotateSafely(getCurrentPiece(), true);
        addCurrentPiece();
    }

    public void flipXPiece() {
        if(!hasCurrentPiece())
            return;
        getBoard().removePiece(getCurrentPiece());
        flipSafely(getCurrentPiece(), true);
        addCurrentPiece();
    }

    public void flipYPiece() {
        if(!hasCurrentPiece())
            return;
        getBoard().removePiece(getCurrentPiece());
        flipSafely(getCurrentPiece(), false);
        addCurrentPiece();
    }

    public void selectPiece(LPosition pos) {
        setCurrentPiece(getBoard().getPiece(pos));
    }

    public void removeCurrentPiece(){
        if(hasCurrentPiece()){
            getBoard().removePiece(getCurrentPiece());
        }
    }

    private void addCurrentPiece(){
        if(!hasCurrentPiece())
            return;
        try {
            getBoard().addPiece(getCurrentPiece());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int nextPlayerI(){
        playerI++;
        if(playerI > 3)
            playerI = 0;
        if(eliminated.size() == 4) { // S'ils sont tous "éliminés", le jeu s'arrête
            return -1;
        }
        if(eliminated.contains(playerI)) {
            return nextPlayerI();
        }
        return playerI;
    }

    public int getPlayerI(){
        return playerI;
    }

    public void eliminate(int player) {

    }
}
