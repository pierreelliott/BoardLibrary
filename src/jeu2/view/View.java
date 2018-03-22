package jeu2.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import jeu2.controller.ControllerScore;
import jeu2.controller.Controller;
import jeu2.model.Model;
import mainlib.view.LView;

public class View extends LView {

    public View() throws Exception {
        setTitle("Blokus");

        int ratio = 35;
        int sizeScore = 200;

        Model model = new Model();
        Controller controller = new Controller(model);

        ControllerScore controllerScore = new ControllerScore(model);


        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(DEFAULTRES));
        fxmlLoader.setController(controller);
        AnchorPane anchorPaneGrid = fxmlLoader.load();

        FXMLLoader fxmlLoaderScore = new FXMLLoader();
        fxmlLoaderScore.setLocation(getClass().getResource("/jeu2/fxml/ViewScore.fxml"));
        fxmlLoaderScore.setController(controllerScore);
        AnchorPane anchorPaneScore = fxmlLoaderScore.load();

        anchorPaneGrid.setPrefWidth(ratio*20);
        anchorPaneScore.setPrefWidth(sizeScore);

        HBox hbox = new HBox(10, anchorPaneGrid, anchorPaneScore);

        Scene scene = new Scene(hbox, ratio*20 + sizeScore +10, ratio*20);

        setlModel(model);
        setlController(controller);
        setScene(scene);
    }
}
