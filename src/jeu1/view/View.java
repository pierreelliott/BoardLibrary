package jeu1.view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import jeu1.controller.Controller;
import jeu1.controller.ControllerNext;
import jeu1.controller.ControllerScore;
import jeu1.model.Model;
import jeu1.model.ModelNext;
import mainlib.view.LView;

public class View extends LView {

    public View() throws Exception {
        setTitle("Tetris");

        int ratio = 35;
        int sizeScore = 200;
        int spacing = 10;

        Model model = new Model();
        Controller controller = new Controller(model);

        ControllerScore controllerScore = new ControllerScore(model);

        ModelNext modelNext = new ModelNext(model);
        ControllerNext controllerNext = new ControllerNext(model, modelNext);

        AnchorPane anchorPaneGrid = loadDefaultFxml(controller);
        anchorPaneGrid.setPrefWidth(ratio*10);

        AnchorPane anchorPaneScore = loadFxml("/jeu1/fxml/ViewScore.fxml", controllerScore);
        anchorPaneScore.setPrefWidth(sizeScore);

        AnchorPane anchorPaneGridNext = loadDefaultFxml(controllerNext);
        anchorPaneGridNext.setMaxHeight(ratio*4);
        anchorPaneGridNext.setPrefHeight(ratio*4);
        anchorPaneGridNext.setMaxWidth(ratio*4);
        anchorPaneGridNext.setPrefWidth(ratio*4);

        VBox vBox = new VBox(0, anchorPaneScore, anchorPaneGridNext);

        HBox hbox = new HBox(spacing, anchorPaneGrid, vBox);


        Scene scene = new Scene(hbox, ratio*10 + sizeScore + 2*spacing, ratio*20);

        setlModel(model);
        setlController(controller);
        setScene(scene);

        model.start();
    }
}
