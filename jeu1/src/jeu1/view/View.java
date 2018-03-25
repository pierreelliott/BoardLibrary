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

        /*
            Constantes de tailles pour la répartition des éléments dans le GUI
         */
        int ratio = 35;
        int sizeScore = 200;
        int spacing = 10;

         /*
            Génération des membres principaux du jeu.
         */

        // Génération du model principal
        Model model = new Model();
        // Génération du controleur principal
        Controller controller = new Controller(model);

        // Génération du controleur pour les scores
        ControllerScore controllerScore = new ControllerScore(model);

        // Génération du model et du controleur pour l'affichage de la pièce suivante
        ModelNext modelNext = new ModelNext(model);
        ControllerNext controllerNext = new ControllerNext(model, modelNext);

        /*
            Chargement des composants JavaFXML
         */

        // JavafXML pour la grille principale
        AnchorPane anchorPaneGrid = loadDefaultFxml(controller);
        anchorPaneGrid.setPrefWidth(ratio*10);

        // JavafXML pour l'affichage du score
        AnchorPane anchorPaneScore = loadFxml("/jeu1/fxml/ViewScore.fxml", controllerScore);
        anchorPaneScore.setPrefWidth(sizeScore);

        // JavafXML pour la grille affichant la pièce suivante
        AnchorPane anchorPaneGridNext = loadDefaultFxml(controllerNext);
        anchorPaneGridNext.setMaxHeight(ratio*4);
        anchorPaneGridNext.setPrefHeight(ratio*4);
        anchorPaneGridNext.setMaxWidth(ratio*4);
        anchorPaneGridNext.setPrefWidth(ratio*4);

        /*
            Partie graphique javaFX
            Création de la vue finale en composant les différents éléments.
         */
        VBox vBox = new VBox(0, anchorPaneScore, anchorPaneGridNext);
        HBox hbox = new HBox(spacing, anchorPaneGrid, vBox);

        Scene scene = new Scene(hbox, ratio*10 + sizeScore + 2*spacing, ratio*20);

        setlModel(model);
        setlController(controller);
        setScene(scene);

        /*
            Démarrage de la partie
         */
        model.start();
    }
}
