package mainlib.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainlib.controller.LController;
import mainlib.model.LModel;

public class LView extends Application {

    private String title = null;
    private Scene scene = null;
    private LController lController = null;
    private LModel lModel = null;

    protected static final String DEFAULTRES = "/mainlib/fxml/LView.fxml";

    public LView(){
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        if(title == null) throw new Exception("Title null");
        if(scene == null) throw new Exception("Scene null");
        if(lController == null) throw new Exception("LController null");
        if(lModel == null) throw new Exception("LModel null");

        primaryStage.setTitle(this.title);
        primaryStage.setScene(this.scene);
        primaryStage.show();
        loadHandlers();
    }

    protected void setTitle(String title){
        this.title = title;
    }

    protected void setScene(Scene scene){
        this.scene = scene;
    }

    protected void setlController(LController lController){
        this.lController = lController;
    }

    protected void setlModel(LModel lModel){
        this.lModel = lModel;
    }

    protected void loadHandlers(){
        scene.setOnKeyPressed(event -> lController.handleKeyPressed(event));
        scene.setOnKeyReleased(event -> lController.handleKeyReleased(event));
        scene.setOnKeyTyped(event -> lController.handleKeyTyped(event));
    }
}
