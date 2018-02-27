package mainlib.model;

import java.util.ArrayList;
import java.util.List;

public class LBoard {

    private List<LPiece> pieces;
    private int width;
    private int height;

    public LBoard(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public LPiece[][] getMatrix() {
        LPiece[][] matrix = new LPiece[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                matrix[i][j] = getPiece(new LPosition(j, i)); // stocke un pointeur sur la pièce qui l'occupe ou null sinon
            }
        }

        return matrix;
    }

    public void resetBoard() {
        pieces.clear();
    }

    public LPiece getPiece(LPosition p) {
        for(LPiece piece : pieces) {
            if(piece.isOnPosition(p)) {
                return piece;
            }
        }
        return null;
    }

    public void removeLine(int y) {
        List<LPosition> line = new ArrayList<>();
        for(int i = 0; i < width; i++) {
            line.add(new LPosition(i, y));
        }

        for(LPiece piece : pieces) {
            piece.removePositions(line);
        }
    }

    public boolean isColumnEmpty(int x) {
        for(LPiece piece : pieces) {
            if(piece.isOnColumn(x)) {
                return false;
            }
        }
        return true;
    }

    public boolean isLineEmpty(int y) {
        for(LPiece piece : pieces) {
            if(piece.isOnLine(y)) {
                return false;
            }
        }
        return true;
    }

    public boolean isOnBoard(LPosition p) {
        return (p.getPosY() < height && p.getPosY() >= 0 && p.getPosX() < width && p.getPosX() >= 0);
    }

    public void addPiece(LPiece p) throws Exception {
        for(LPosition pos : p.getPositions()) {
            if(!isOnBoard(pos)) {
                throw new Exception("Out of the board");
            }
        }
        pieces.add(p);
    }

    public void removePiece(LPiece p) {
        pieces.remove(p);
    }

    public boolean isColumnFull(int x) {
        int count = 0;
        for(LPiece piece : pieces) {
            if(piece.isOnColumn(x)) {
                count++;
            }
        }
        return (count == height);
    }

    public boolean isLineFull(int y) {
        int count = 0;
        for(LPiece piece : pieces) {
            if(piece.isOnLine(y)) {
                count++;
            }
        }
        return (count == width);
    }
}
