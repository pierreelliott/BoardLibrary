package jeu3.view;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;
import jeu3.controller.Controller;
import jeu3.model.Model;
import mainlib.view.LView;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class View extends LView {

    public View() throws Exception {
        setTitle("Rush Hour");

        /*
            Constantes de tailles pour la répartition des éléments dans le GUI
         */
        int ratio = 70;

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

        Scene scene = new Scene(anchorPaneGrid, ratio*8, ratio*8);

        setlModel(model);
        setlController(controller);
        setScene(scene);

        /*
            Démarrage de la partie
         */
        model.start();
    }

    public static final String YES = "Recommencer";
    public static final String NO = "Quitter";
    public static final String OK = "OK";
    public static final String CANCEL = "Cancel";

    public static String showConfirm(String title, String message, String... options) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Choose an option");
        alert.setHeaderText(title);
        alert.setContentText(message);

        //To make enter key press the actual focused button, not the first one. Just like pressing "space".
        alert.getDialogPane().addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                event.consume();
                try {
                    Robot r = new Robot();
                    r.keyPress(java.awt.event.KeyEvent.VK_SPACE);
                    r.keyRelease(java.awt.event.KeyEvent.VK_SPACE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        if (options == null || options.length == 0) {
            options = new String[]{OK, CANCEL};
        }

        List<ButtonType> buttons = new ArrayList<>();
        for (String option : options) {
            buttons.add(new ButtonType(option));
        }

        alert.getButtonTypes().setAll(buttons);

        Optional<ButtonType> result = alert.showAndWait();
        if (!result.isPresent()) {
            return CANCEL;
        } else {
            return result.get().getText();
        }
    }

    public boolean gameFinished() {
        String res =showConfirm("Partie terminée !", "Partie terminée !\nVoulez-vous recommencer ?", YES, NO);
        if (res.equals(YES)) {
            return true;
        }
        if(res.equals(NO)) {
            Platform.exit();
        }
        return false;
    }
}