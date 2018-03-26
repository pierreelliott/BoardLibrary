package mainlib.model;

import java.util.Observable;

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
public class LModel extends Observable {

    /**
     * Instance of LBoard containing pieces.
     */
    private LBoard lBoard = null;
    /**
     * Specify if the game if over.
     */
    private boolean finished = false;

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
     * Selected LPiece
     */
    private LPiece currentPiece = null;

    /**
     * Game score
     */
    private int score = 0;

    /**
     * <em>true</em> for exiting.
     */
    private boolean exit = false;

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
     * Safely place a piece at a specific position
     * @param piece LPiece to place
     * @param position LPosition to place the piece at
     * @return <em>true</em> if no error occurred.
     */
    public boolean placeSafely(LPiece piece, LPosition position){
        if(piece == null)
            return false;
        if(lBoard.canPlaceAt(position, piece)) {
            piece.placeAt(position);
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
     * Process a safely flip on a piece.
     * @param piece LPiece to flip
     * @param axeX <em>true</em> for X axe. Y axe otherwise.
     * @return <em>true</em> if no error occurred.
     */
    public boolean flipSafely(LPiece piece, boolean axeX){
        if(piece == null)
            return false;
        if(lBoard.canFlip(piece, axeX)) {
            piece.flip(axeX);
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

    public boolean isAdjacentTo(LPiece p1, LPiece p2, boolean withDiag) {
        return lBoard.isAdjacentTo(p1, p2, withDiag);
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

    /**
     * Current selected piece getter.
     * @return LPiece
     */
    public LPiece getCurrentPiece() {
        return currentPiece;
    }

    /**
     * Current selected piece setter.
     * @param currentPiece LPiece
     */
    public void setCurrentPiece(LPiece currentPiece) {
        this.currentPiece = currentPiece;
    }

    /**
     * Reset the selected piece to null.
     */
    public void resetCurrentPiece(){
        this.currentPiece = null;
    }

    /**
     * Check if a piece has been selected.
     * @return <em>true</em> when a piece has been selected.
     */
    public boolean hasCurrentPiece(){
        return this.currentPiece != null;
    }

    /**
     * Score getter
     * @return int
     */
    public int getScore() {
        return score;
    }

    /**
     * Score setter
     * @param score int
     */
    public void setScore(int score) {
        this.score = score;
        setChanged();
    }

    /**
     * Inscrease score by given int.
     * @param pointsToAdd int Score to add to.
     */
    public void setScoreAdd(int pointsToAdd){
        this.score += pointsToAdd;
        setChanged();
    }

    /**
     * Check if platform exited
     * @return <em>true</em> to exit
     */
    public boolean isExit() {
        return exit;
    }

    /**
     * Set exit state
     * @param exit boolean <em>true</em> for exiting
     */
    public void setExit(boolean exit) {
        this.exit = exit;
    }
}
