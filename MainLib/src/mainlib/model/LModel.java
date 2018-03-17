package mainlib.model;

/**
 * The LModel class is the main model class.
 * It is directly instantiated by the LView in order to coordinate front-end functions.
 * A LBoard class must be instantiated to work properly.
 * The class provides basic functions interacting with the board.
 * It aims to be extended and fully completed by a project.
 *
 * @author  Tancrède SUARD 11505293
 * @author  Pierre-Elliott THIBOUD 11402690
 * @version 1.0
 * @since   2018-01-17
 *
 * @see LBoard
 * @see LPosition
 * @see LPiece
 */
public class LModel {

    /**
     * Instance of LBoard containing pieces.
     */
    protected LBoard lBoard = null;
    /**
     * Specify if the game if over.
     */
    protected boolean finished = false;

    /**
     * Relative position for up movement.
     */
    protected static final LPosition GOUP = new LPosition(0, -1);
    /**
     * Relative position for down movement.
     */
    protected static final LPosition GODOWN = new LPosition(0, 1);
    /**
     * Relative position for left movement.
     */
    protected static final LPosition GOLEFT = new LPosition(-1, 0);
    /**
     * Relative position for right movement.
     */
    protected static final LPosition GORIGHT = new LPosition(1, 0);

    /**
     * Main constructor
     */
    public LModel(){
    }

    /**
     * LBoard setter
     * @param lBoard LBoard
     */
    public void setBoard(LBoard lBoard){
        this.lBoard = lBoard;
    }

    /**
     * LBoard getter
     * @return LBoard
     */
    public LBoard getBoard(){
        return lBoard;
    }

    /**
     * Process a safely movement on a piece.
     * @param piece LPiece to move
     * @param position Relative LPosition for movement.
     * @return <em>true</em> if no error occurred.
     */
    public boolean moveSafely(LPiece piece, LPosition position){
        if(piece == null)
            return false;
        if(lBoard.canMove(position, piece)) {
            piece.move(position);
            return true;
        }
        return false;
    }

    /**
     * Process a safely rotation on a pice.
     * @param piece LPiece to rotate
     * @param trigo <em>true</em> to 90 degrees inverse-clockwise rotation.
     *              <em>false</em> to 90 degrees clockwise rotation.
     * @return <em>true</em> if no error occurred.
     */
    public boolean rotateSafely(LPiece piece, boolean trigo){
        if(piece == null)
            return false;
        if(lBoard.canRotate(piece, trigo)) {
            piece.rotate(trigo);
            return true;
        }
        return false;
    }

    /**
     * Process a relative movement on the piece without checking if it's possible.
     * @param piece LPiece to move.
     * @param position Relative LPosition for movement.
     */
    public void moveOverwrite(LPiece piece, LPosition position){
        piece.move(position);
    }

    /**
     * Process a rotation on the piece without checking if it's possible.
     * @param piece LPiece to rotate.
     * @param trigo <em>true</em> to 90 degrees inverse-clockwise rotation.
     *              <em>false</em> to 90 degrees clockwise rotation.
     */
    public void rotateOverwrite(LPiece piece, boolean trigo){
        piece.rotate(trigo);
    }

    /**
     * Change game state.
     * <em>true</em> when game is over.
     * @param finished boolean
     */
    public void setFinished(boolean finished){
        this.finished = finished;
    }

    /**
     * Game state getter.
     * @return <em>true</em> when game is over.
     */
    public boolean isFinished(){
        return finished;
    }
}
