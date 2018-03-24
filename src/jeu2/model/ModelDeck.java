package jeu2.model;

import javafx.scene.paint.Color;
import mainlib.model.LBoard;
import mainlib.model.LModel;
import mainlib.model.LPiece;
import mainlib.model.LPosition;

public class ModelDeck extends LModel {

    private Model model;
    private int WIDTH = 15;
    private int HEIGHT = 15;

    private Color color;

    public ModelDeck(Model model, Color color) throws Exception {
        super();
        LBoard board = new LBoard(WIDTH,HEIGHT);
        setBoard(board);
        this.model = model;
        this.color = color;

        Piece p;
        for (PieceEnum pe : PieceEnum.values()) {
            p = model.generatePiece(pe, color);
            p.moveToStartPos();
            getBoard().addPiece(p);
        }
    }

    public Color getColor() {
        return this.color;
    }

    public LPiece getPiece(LPosition pos) {
        return getBoard().getPiece(pos);
    }

}
