package jeu2.model;

import javafx.scene.paint.Color;
import mainlib.model.LBoard;
import mainlib.model.LPiece;

import java.util.List;

public class Player {
    private PlayerEnum type;
    private LBoard board;

    public Player(Model m, PlayerEnum p) {
        type = p;
        generateBoard(m);
    }

    private void generateBoard(Model modele) {
        PieceEnum[] pieces = PieceEnum.values();
        for(int i = 0; i < pieces.length; i++) {
            LPiece piece = modele.generatePiece(pieces[i], Color.valueOf(type.toString()));
            // Place the piece
            //board.addPiece(piece);
        }
    }
}
