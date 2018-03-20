package jeu1.view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import jeu1.controller.Controller;
import jeu1.controller.ControllerScore;
import jeu1.model.Model;
import mainlib.view.LView;

public class View extends LView {

    public View() throws Exception {
        setTitle("Tetris");

        int ratio = 35;
        int sizeScore = 200;

        Model model = new Model();
        Controller controller = new Controller(model);

        ControllerScore controllerScore = new ControllerScore(model);

        AnchorPane anchorPaneGrid = loadDefaultFxml(controller);
        anchorPaneGrid.setPrefWidth(ratio*10);

        AnchorPane anchorPaneScore = loadFxml("/jeu1/fxml/ViewScore.fxml", controllerScore);
        anchorPaneScore.setPrefWidth(sizeScore);

        HBox hbox = new HBox(10, anchorPaneGrid, anchorPaneScore);

        Scene scene = new Scene(hbox, ratio*10 + sizeScore, ratio*20);

        setlModel(model);
        setlController(controller);
        setScene(scene);

        model.start();
    }
}
