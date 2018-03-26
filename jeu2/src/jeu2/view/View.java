package jeu2.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import jeu2.controller.Controller;
import jeu2.controller.ControllerDeck;
import jeu2.model.Model;
import jeu2.model.ModelDeck;
import mainlib.view.LView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class View extends LView {

    public View() throws Exception {
        setTitle("Blokus");

        /*
            Constantes de tailles pour la répartition des éléments dans le GUI
         */
        int ratio = 33;
        int spacing = 10;
        int ratioDecks = 10;

        /*
            Génération des membres principaux du jeu.
         */

        // Génération du model principal
        Model model = new Model();
        // Génération du controleur principal
        Controller controller = new Controller(model);

        // Chargement de la partie graphique JavaFXML
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(DEFAULTRES));
        fxmlLoader.setController(controller);
        AnchorPane anchorPaneGrid = fxmlLoader.load(); //< Grille principale du jeu
        anchorPaneGrid.setPrefWidth(ratio*20);

        /*
            Partie génération grilles joueurs.
         */

        // Liste des couleurs actives.
        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(
                Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN));
        // Liste des couleurs désactivées.
        ArrayList<Color> colorsDark = new ArrayList<>(Arrays.asList(
                Color.DARKBLUE, Color.DARKGOLDENROD, Color.DARKRED, Color.DARKGREEN));

        // Génération des models.
        ArrayList<ModelDeck> modelDecks = new ArrayList<>();
        for (int i = 0; i<4; i++)
            modelDecks.add(new ModelDeck(model, colors.get(i), colorsDark.get(i), i));

        // Génération des controlleurs.
        ArrayList<ControllerDeck> controllerDecks = new ArrayList<>();
        for (int i = 0; i<4; i++)
            controllerDecks.add(new ControllerDeck(modelDecks.get(i)));

        // Génération de la partie graphique JAVAFXML de chacunes des grilles joueurs.
        ArrayList<AnchorPane> anchorPaneDecks = new ArrayList<>();
        for(int i = 0; i<4; i++){
            anchorPaneDecks.add(loadDefaultFxml(controllerDecks.get(i)));
            anchorPaneDecks.get(i).setMaxHeight(ratio*ratioDecks);
            anchorPaneDecks.get(i).setPrefHeight(ratio*ratioDecks);
            anchorPaneDecks.get(i).setMaxWidth(ratio*ratioDecks);
            anchorPaneDecks.get(i).setPrefWidth(ratio*ratioDecks);
        }

        /*
            Partie graphique javaFX
            Création de la vue finale en composant les différents éléments.
         */
        VBox vBoxLeft = new VBox(spacing, anchorPaneDecks.get(0), anchorPaneDecks.get(3));
        VBox vBoxRight = new VBox(spacing, anchorPaneDecks.get(1), anchorPaneDecks.get(2));
        HBox hbox = new HBox(spacing, vBoxLeft, anchorPaneGrid, vBoxRight);

        Scene scene = new Scene(hbox, 2*spacing + 2*ratio*ratioDecks + ratio*20, ratio*20);

        setlModel(model);
        setlController(controller);
        setScene(scene);
    }

    public Pane bottomMenu(Controller controller) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/jeu2/fxml/bottomMenu.fxml"));
        fxmlLoader.setController(controller);
        AnchorPane anchorPaneGrid = fxmlLoader.load();

        return anchorPaneGrid;
    }
}
