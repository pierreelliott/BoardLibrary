package jeu3.view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import jeu3.controller.Controller;
import jeu3.model.Model;
import mainlib.view.LView;

public class View extends LView {

    public View() throws Exception {
        setTitle("Rush Hour");

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
        Controller controller = new Controller(model, this);

        /*
            Chargement des composants JavaFXML
         */

        // JavafXML pour la grille principale
        AnchorPane anchorPaneGrid = loadDefaultFxml(controller);
        anchorPaneGrid.setPrefWidth(ratio*10);

        /*
            Partie graphique javaFX
            Création de la vue finale en composant les différents éléments.
         */

        Scene scene = new Scene(anchorPaneGrid, ratio*10 + sizeScore + 2*spacing, ratio*20);

        setlModel(model);
        setlController(controller);
        setScene(scene);

        /*
            Démarrage de la partie
         */
        model.start();
    }

    public boolean gameFinished() {
        return true;
    }
}
