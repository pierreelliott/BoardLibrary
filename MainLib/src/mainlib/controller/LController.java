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

import java.net.URL;
import java.util.ResourceBundle;

public class LController implements Initializable {

    @FXML
    protected VBox vBoxID;

    @FXML
    protected GridPane gridID;

    protected LModel lModel;

    private int GRID_SIZE_ROW;
    private int GRID_SIZE_COL;

    private int cellPadding = 0;
    private Color cellDefaultColor = Color.WHITE;

    private Rectangle[][] rectangles;

    public LController(LModel lModel) throws Exception {
        if(lModel.getBoard() == null){
            throw new Exception("Board not initialized on Model");
        }
        this.lModel = lModel;
        GRID_SIZE_ROW = lModel.getBoard().getHeight();
        GRID_SIZE_COL = lModel.getBoard().getWidth();
        this.rectangles = new Rectangle[GRID_SIZE_ROW][GRID_SIZE_COL];
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
    }

    protected void creatingCellSquares(int row, int col){
        Rectangle square = new Rectangle();

//        Color color;
//        if ((row + col) % 2 == 0) color = Color.rgb(255, 206, 158);
//        else color = Color.rgb(205, 133, 63);
//        square.setFill(color);

        gridID.add(square, col, row);
        square.widthProperty().bind(gridID.widthProperty().divide(GRID_SIZE_COL).subtract(cellPadding));
        square.heightProperty().bind(gridID.heightProperty().divide(GRID_SIZE_ROW).subtract(cellPadding));

        square.setOnMouseClicked(event -> cellMouseClicked(row, col));
        square.setOnMouseEntered(event -> cellMouseEnter(row, col));
        square.setOnMouseExited(event -> cellMouseExited(row, col));

        rectangles[row][col] = square;
        refreshCell(row, col);
    }

    protected void refresh(){
        for (int row = 0; row < GRID_SIZE_ROW; row++) {
            for(int col = 0; col < GRID_SIZE_COL; col++){
                refreshCell(row, col);
            }
        }
    }

    protected void refreshCell(int row, int col){
        LPiece lPiece = lModel.getBoard().getPiece(new LPosition(col, row));
        if(lPiece != null)
            rectangles[row][col].setFill(lPiece.getColor());
        else
            rectangles[row][col].setFill(cellDefaultColor);
    }

    protected void cellMouseClicked(int row, int col) {
    }

    protected void cellMouseEnter(int row, int col) {
    }

    protected void cellMouseExited(int row, int col) {
    }

    protected void setCellPadding(int cellPadding){
        this.cellPadding = cellPadding;
    }

    protected void setCellDefaultColor(Color color){
        this.cellDefaultColor = color;
    }

    public void handleKeyPressed(KeyEvent event){
    }

    public void handleKeyReleased(KeyEvent event) {
    }

    public void handleKeyTyped(KeyEvent event) {

    }
}
