package jeu2.model;

import javafx.scene.paint.Color;
import mainlib.model.LBoard;
import mainlib.model.LPiece;

public class Board extends LBoard {
    /**
     * Constructor.
     * List of piece are empty by default.
     *
     * @param width  Width of the board. Must be strict positive.
     * @param height Height of the board. Must be strict positive.
     * @throws Exception If Width or Height are not strict positive.
     * @see #pieces
     */
    public Board(int width, int height) throws Exception {
        super(width, height);
    }

    public void changePiecesColor(Color color){
        for (LPiece p: pieces) {
            p.setColor(color);
        }
    }
}
