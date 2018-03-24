package jeu2.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import jeu2.controller.Controller;
import jeu2.controller.ControllerDeck;
import jeu2.model.Model;
import jeu2.model.ModelDeck;
import mainlib.view.LView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class View extends LView {

    public View() throws Exception {
        setTitle("Blokus");

        int ratio = 33;
        int spacing = 10;
        int ratioDecks = 10;

        Model model = new Model();
        Controller controller = new Controller(model);

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(DEFAULTRES));
        fxmlLoader.setController(controller);
        AnchorPane anchorPaneGrid = fxmlLoader.load();

        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(
                Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW));
        ArrayList<Color> colorsDark = new ArrayList<>(Arrays.asList(
                Color.DARKRED, Color.DARKGREEN, Color.DARKBLUE, Color.DARKGOLDENROD));

        ArrayList<ModelDeck> modelDecks = new ArrayList<>();
        for (int i = 0; i<4; i++)
            modelDecks.add(new ModelDeck(model, colors.get(i), colorsDark.get(i), i));

        model.addModelDecks(modelDecks);

        ArrayList<ControllerDeck> controllerDecks = new ArrayList<>();
        for (int i = 0; i<4; i++)
            controllerDecks.add(new ControllerDeck(model, modelDecks.get(i)));

        ArrayList<AnchorPane> anchorPaneDecks = new ArrayList<>();
        for(int i = 0; i<4; i++){
            anchorPaneDecks.add(loadDefaultFxml(controllerDecks.get(i)));
            anchorPaneDecks.get(i).setMaxHeight(ratio*ratioDecks);
            anchorPaneDecks.get(i).setPrefHeight(ratio*ratioDecks);
            anchorPaneDecks.get(i).setMaxWidth(ratio*ratioDecks);
            anchorPaneDecks.get(i).setPrefWidth(ratio*ratioDecks);
        }

        anchorPaneGrid.setPrefWidth(ratio*20);

        VBox vBoxLeft = new VBox(spacing, anchorPaneDecks.get(0), anchorPaneDecks.get(1));
        VBox vBoxRight = new VBox(spacing, anchorPaneDecks.get(2), anchorPaneDecks.get(3));
        HBox hbox = new HBox(spacing, vBoxLeft, anchorPaneGrid, vBoxRight);

        Scene scene = new Scene(hbox, 2*spacing + 2*ratio*ratioDecks + ratio*20, ratio*20);

        setlModel(model);
        setlController(controller);
        setScene(scene);
    }
}
