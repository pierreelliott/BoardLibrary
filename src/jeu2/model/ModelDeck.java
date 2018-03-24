package jeu2.model;

import javafx.scene.paint.Color;
import mainlib.model.LBoard;
import mainlib.model.LModel;

public class ModelDeck extends LModel {

    private Model model;
    private int WIDTH = 17;
    private int HEIGHT = 17;

    private Color color;

    public ModelDeck(Model model, Color color) throws Exception {
        super();
        LBoard board = new LBoard(WIDTH,HEIGHT);
        setBoard(board);
        this.model = model;
        this.color = color;
    }

}
