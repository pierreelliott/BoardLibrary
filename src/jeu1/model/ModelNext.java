package jeu1.model;

import mainlib.model.LBoard;
import mainlib.model.LModel;
import mainlib.model.LPiece;
import mainlib.model.LPosition;

public class ModelNext extends LModel {

    private Model model;

    public ModelNext(Model model) throws Exception {
        super();
        LBoard board = new LBoard(4,4);
        setBoard(board);
        this.model = model;
    }

    public void refreshPiece(){
        getBoard().resetBoard();
        if(model.getCurrentPiece() == null || model.getNextPiece() == null)
            return;
        LPiece piece = new LPiece(model.getNextPiece());

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (LPosition position : piece.getPositions()) {
            if(position.getPosX() < minX) {
                minX = position.getPosX();
            }
            if(position.getPosY() < minY) {
                minY = position.getPosY();
            }
        }
        LPosition transPos = new LPosition(-minX, -minY);
        piece.move(transPos);
        try {
            getBoard().addPiece(piece);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
