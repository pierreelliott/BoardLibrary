package jeu1.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import jeu1.controller.Controller;
import jeu1.model.Model;
import mainlib.view.LView;

public class View extends LView {

    public View() throws Exception {
        setTitle("Tetris");

        int ratio = 35;
        int sizeScore = 200;

        Model model = new Model();
        Controller controller = new Controller(model);

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(DEFAULTRES));
        fxmlLoader.setController(controller);
        AnchorPane anchorPaneGrid = fxmlLoader.load();

        FXMLLoader fxmlLoaderScore = new FXMLLoader();
        fxmlLoaderScore.setLocation(getClass().getResource("/jeu1/fxml/ViewScore.fxml"));
        AnchorPane anchorPaneScore = fxmlLoaderScore.load();

        anchorPaneGrid.setPrefWidth(ratio*10);
        anchorPaneScore.setPrefWidth(sizeScore);

        HBox hbox = new HBox(10, anchorPaneGrid, anchorPaneScore);

        Scene scene = new Scene(hbox, ratio*10 + sizeScore, ratio*20);

        setlModel(model);
        setlController(controller);
        setScene(scene);
    }
}
