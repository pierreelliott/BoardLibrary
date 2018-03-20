package jeu1.view;

import javafx.fxml.FXMLLoader;
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
        controller.addNotifiableObject(controllerScore);



//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(getClass().getResource(DEFAULTRES));
//        fxmlLoader.setController(controller);
//        AnchorPane anchorPaneGrid = fxmlLoader.load();
        AnchorPane anchorPaneGrid = loadDefaultFxml(controller);

//        FXMLLoader fxmlLoaderScore = new FXMLLoader();
//        fxmlLoaderScore.setLocation(getClass().getResource("/jeu1/fxml/ViewScore.fxml"));
//        fxmlLoaderScore.setController(controllerScore);
//        AnchorPane anchorPaneScore = fxmlLoaderScore.load();
        AnchorPane anchorPaneScore = loadFxml("/jeu1/fxml/ViewScore.fxml", controllerScore);

        anchorPaneGrid.setPrefWidth(ratio*10);
        anchorPaneScore.setPrefWidth(sizeScore);

        HBox hbox = new HBox(10, anchorPaneGrid, anchorPaneScore);

        Scene scene = new Scene(hbox, ratio*10 + sizeScore, ratio*20);

        setlModel(model);
        setlController(controller);
        setScene(scene);
    }
}
