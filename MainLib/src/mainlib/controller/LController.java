package mainlib.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import mainlib.model.LModel;
import mainlib.model.LPiece;
import mainlib.model.LPosition;
import mainlib.view.LView;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

/**
 * The LController class is a default controller used by Javafx ans the GUI
 * It uses variables used in the template of <i>LView.fxml</i>
 * This class provides every interactions between the View and the Model.
 *
 *
 * @author  Tancrède SUARD 11505293
 * @author  Pierre-Elliott THIBOUD 11402690
 * @version 1.0
 * @since   2018-01-17
 *
 * @see LModel
 * @see LPiece
 * @see LPosition
 */
public class LController implements Initializable, java.util.Observer {

    /**
     * AnchorPane id from fxml
     */
    @FXML
    protected AnchorPane anchorID;

    /**
     * Grid id from fxml
     */
    @FXML
    protected GridPane gridID;

    /**
     * Model var
     */
    protected LModel lModel;

    /**
     * Number of row for the grid
     */
    private int GRID_SIZE_ROW;

    /**
     * Number of column for the grid
     */
    private int GRID_SIZE_COL;

    /**
     * Padding cell for color of piece.
     * Must be positive.
     */
    private int cellPadding = 0;

    /**
     * Default color for cells
     */
    private Color cellDefaultColor = Color.WHITE;

    /**
     * Two dimensional for rectangles pointers.
     */
    private Rectangle[][] rectangles;

    /**
     * Determine if the grid line will be visible.
     */
    private boolean gridLinesVisible = false;

    /**
     * Padding color
     */
    private Color paddingColor = Color.WHITE;

    /**
     * Constructor
     * @param lModel Model to use.
     * @throws Exception If board into the model is not initialized.
     * @see LModel#getBoard()
     */
    public LController(LModel lModel) throws Exception {
        if(lModel.getBoard() == null){
            throw new Exception("Board not initialized on Model");
        }
        this.lModel = lModel;
        GRID_SIZE_ROW = lModel.getBoard().getHeight();
        GRID_SIZE_COL = lModel.getBoard().getWidth();
        this.rectangles = new Rectangle[GRID_SIZE_ROW][GRID_SIZE_COL];
    }

    /**
     * Allow modifications of JavaFX elements which were not instantiated during constructor.
     */
    protected void preInitialize(){
        this.anchorID.styleProperty().set(
                this.anchorID.styleProperty().getValue() + ";" +
                "-fx-background-color: white;");
    }

    /**
     * Allow modifications of JavaFX elements after the initialize call.
     * @see #initialize(URL, ResourceBundle)
     */
    protected void postInitialize(){
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        preInitialize();
        ColumnConstraints colDefault = new ColumnConstraints(0,0,Double.MAX_VALUE, Priority.ALWAYS, HPos.CENTER, true);
        RowConstraints rowDefault = new RowConstraints(0,0,Double.MAX_VALUE, Priority.ALWAYS, VPos.CENTER, true);
        for (int row = 0; row < GRID_SIZE_ROW; row++)
            gridID.getRowConstraints().add(rowDefault);
        for(int col = 0; col < GRID_SIZE_COL; col++)
            gridID.getColumnConstraints().add(colDefault);

        for (int row = 0; row < GRID_SIZE_ROW; row++) {
            for(int col = 0; col < GRID_SIZE_COL; col++){
                creatingCellSquares(row, col);
            }
        }
        postInitialize();
    }

    /**
     * Create cell squares.
     * Register events with mouse.
     * Color of squares is not specified here.
     * Call <em>refreshCell(row, col)</em> function.
     * @param row Row
     * @param col Column
     * @see #cellMouseClicked(int, int)
     * @see #cellMouseEnter(int, int)
     * @see #cellMouseExited(int, int)
     * @see #refreshCell(int, int)
     */
    protected void creatingCellSquares(int row, int col){

        Rectangle squareBackground = new Rectangle();
        squareBackground.setFill(paddingColor);
        Rectangle square = new Rectangle();

        gridID.add(squareBackground, col, row);
        gridID.add(square, col, row);
        squareBackground.widthProperty().bind(gridID.widthProperty().divide(GRID_SIZE_COL).subtract(gridLinesVisible ? 1 : 0));
        squareBackground.heightProperty().bind(gridID.heightProperty().divide(GRID_SIZE_ROW).subtract(gridLinesVisible ? 1 : 0));

        square.widthProperty().bind(gridID.widthProperty().divide(GRID_SIZE_COL).subtract(cellPadding));
        square.heightProperty().bind(gridID.heightProperty().divide(GRID_SIZE_ROW).subtract(cellPadding));

        square.setOnMouseClicked(event -> cellMouseClicked(row, col));
        squareBackground.setOnMouseClicked(event -> cellMouseClicked(row, col));
        squareBackground.setOnMouseEntered(event -> cellMouseEnter(row, col));
        squareBackground.setOnMouseExited(event -> cellMouseExited(row, col));

        rectangles[row][col] = square;
        refreshCell(row, col);
    }

    /**
     * Refresh all cell of the grid.
     * @see #refreshCell(int, int)
     */
    protected void refresh(){
        for (int row = 0; row < GRID_SIZE_ROW; row++) {
            for(int col = 0; col < GRID_SIZE_COL; col++){
                refreshCell(row, col);
            }
        }
    }

    /**
     * Refresh the color of a cell second to piece color.
     * If there is no piece, use default color.
     * @param row Row
     * @param col Column
     * @see LPiece#getColor()
     * @see #setCellDefaultColor(Color)
     */
    protected void refreshCell(int row, int col){
        LPiece lPiece = lModel.getBoard().getPiece(new LPosition(col, row));
        if (lPiece != null) {
            rectangles[row][col].setFill(lPiece.getColor());
        }
        else
            rectangles[row][col].setFill(cellDefaultColor);
    }

    /**
     * Triggered when a cell is clicked.
     * @param row Row
     * @param col Column
     * @see #creatingCellSquares(int, int)
     */
    protected void cellMouseClicked(int row, int col) {
    }

    /**
     * Triggered when mouse enters over a cell
     * @param row Row
     * @param col Column
     * @see #creatingCellSquares(int, int)
     */
    protected void cellMouseEnter(int row, int col) {
    }

    /**
     * Triggered when mouse go out the cell
     * @param row Row
     * @param col Column
     * @see #creatingCellSquares(int, int)
     */
    protected void cellMouseExited(int row, int col) {
    }

    /**
     * Set padding for cells
     * @param cellPadding int Must be positive. If not, reset to 0.
     */
    protected void setCellPadding(int cellPadding){
        if(cellPadding < 0)
            cellPadding = 0;
        this.cellPadding = cellPadding;
    }

    /**
     * Set default color for cells
     * @param color Color
     */
    protected void setCellDefaultColor(Color color){
        this.cellDefaultColor = color;
    }

    /**
     * Triggered when a key is pressed.
     * @param event KeyEvent
     * @see LView#loadHandlers()
     */
    public void handleKeyPressed(KeyEvent event){
    }

    /**
     * Triggered when a key is released.
     * @param event KeyEvent
     * @see LView#loadHandlers()
     */
    public void handleKeyReleased(KeyEvent event) {
    }

    /**
     * Triggered when a key is typed.
     * @param event KeyEvent
     * @see LView#loadHandlers()
     */
    public void handleKeyTyped(KeyEvent event) {
    }

    @Override
    public void update(Observable o, Object arg) {
        refresh();
    }


    /**
     * Set grid lines visibility
     * @param gridLinesVisible boolean
     */
    public void setGridLinesVisible(boolean gridLinesVisible) {
        this.gridLinesVisible = gridLinesVisible;
        this.gridID.setGridLinesVisible(gridLinesVisible);
    }

    /**
     * Return the grid lines visibility
     * @return <em>true</em> if grid lines are visible
     */
    public boolean isGridLinesVisible() {
        return gridLinesVisible;
    }

    /**
     * Return the padding color background
     * @return Color
     */
    public Color getPaddingColor() {
        return paddingColor;
    }

    /**
     * Padding color background setter
     * @param paddingColor Color
     */
    public void setPaddingColor(Color paddingColor) {
        this.paddingColor = paddingColor;
    }
}
