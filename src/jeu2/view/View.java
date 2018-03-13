package jeu2.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import jeu2.controller.Controller;
import jeu2.model.Model;
import mainlib.view.LView;

public class View extends LView {

    public View() throws Exception {
        setTitle("Tetris");

        Model model = new Model();
        Controller controller = new Controller(model);

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(DEFAULTRES));
        fxmlLoader.setController(controller);
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);

        setlModel(model);
        setlController(controller);
        setScene(scene);
    }
}
