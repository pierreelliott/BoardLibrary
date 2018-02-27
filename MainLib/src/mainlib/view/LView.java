package mainlib.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class LView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(getTitle());
        primaryStage.setScene(getScene());
        primaryStage.show();
    }

    protected String getTitle(){
        return "MainLib View";
    }

    protected Scene getScene() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(getRessource()));
        fxmlLoader.setController(getController());
        return new Scene(fxmlLoader.load(), getWidth(), getHeight());
    }

    protected String getRessource(){
        return "/mainlib/fxml/LView.fxml";
    }

    protected abstract Object getController() throws Exception;

    protected int getWidth(){
        return 600;
    }

    protected int getHeight(){
        return 600;
    }
}
