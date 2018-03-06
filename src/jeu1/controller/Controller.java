package jeu1.controller;

import javafx.scene.paint.Color;
import jeu1.model.Model;
import mainlib.controller.LController;
import mainlib.model.LPiece;
import mainlib.model.LPosition;

import java.util.Scanner;

public class Controller extends LController {
    public Controller(Model model) throws Exception {
        super(model);
        setCellPadding(5);
//        setCellDefaultColor(Color.RED);
    }

    @Override
    protected void cellMouseClicked(int row, int col) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Cell clicked at " + row + "," + col);
        LPiece lPiece = lModel.getBoard().getPiece(new LPosition(row, col));
        System.out.println(lPiece);
        if(lPiece != null){
            lPiece.move(new LPosition(1,1));
        }
        refresh();
    }
}
