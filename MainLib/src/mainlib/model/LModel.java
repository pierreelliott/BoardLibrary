package mainlib.model;

public class LModel {

    protected LBoard lBoard = null;

    protected final LPosition GOUP = new LPosition(0, -1);
    protected final LPosition GODOWN = new LPosition(0, 1);
    protected final LPosition GOLEFT = new LPosition(-1, 0);
    protected final LPosition GORIGHT = new LPosition(1, 0);

    public LModel(){
    }

    public void setBoard(LBoard lBoard){
        this.lBoard = lBoard;
    }

    public LBoard getBoard(){
        return lBoard;
    }

    public void keyPressed(String key) { System.out.println(key); }

    public boolean moveSafely(LPiece piece, LPosition position){
        if(piece == null)
            return false;
        if(lBoard.canMove(position, piece)) {
            piece.move(position);
            return true;
        }
        return false;
    }

    public boolean rotateSafely(LPiece piece, boolean trigo){
        if(piece == null)
            return false;
        if(lBoard.canRotate(piece, trigo)) {
            piece.rotate(trigo);
            return true;
        }
        return false;
    }

    public void moveOverwrite(LPiece piece, LPosition position){
        piece.move(position);
    }

    public void rotateOverwrite(LPiece piece, boolean trigo){
        piece.rotate(trigo);
    }
}
