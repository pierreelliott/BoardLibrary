package mainlib.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import mainlib.controller.LController;
import mainlib.model.LModel;

import java.io.IOException;

/**
 * Main class to initialize JavaFX extends Application.
 *
 * @author  Tancrède SUARD 11505293
 * @author  Pierre-Elliott THIBOUD 11402690
 * @version 1.0
 * @since   2018-01-17
 *
 * @see LController
 * @see LModel
 */
public class LView extends Application {

    /**
     * Title of the window
     */
    private String title = null;

    /**
     * Scene used for the main window
     */
    private Scene scene = null;

    /**
     * Controller used for the scene
     */
    private LController lController = null;

    /**
     * Model used for the application
     */
    private LModel lModel = null;

    /**
     * Default ressource path for the default view
     */
    protected static final String DEFAULTRES = "/mainlib/fxml/LView.fxml";

    /**
     * LView constructor.
     * <br>
     * <b><em>title</em>, <em>scene</em>, <em>lController</em> and <em>lModel</em> vars MUST be initialized on
     * constructor.</b><br>
     *     If not, Exception will be triggered on start function.
     * @see #setTitle(String)
     * @see #setScene(Scene)
     * @see #setlController(LController)
     * @see #setlModel(LModel)
     * @see #start(Stage)
     */
    public LView(){
    }

    /**
     * Load default object hierarchy FXML.
     * @param controller Default controller for LView javafx
     * @param <T> The loaded object hierarchy type.
     * @return The loaded object hierarchy.
     * @throws IOException
     * @see #loadFxml(String, Object)
     */
    public <T> T loadDefaultFxml(Object controller) throws IOException {
        return loadFxml(DEFAULTRES, controller);
    }

    /**
     * Loads an object hierarchy from a FXML document.
     * @param resURL URL source for FXML document.
     * @param <T> The loaded object hierarchy type.
     * @return The loaded object hierarchy.
     * @throws IOException
     * @see #loadFxml(String, Object)
     */
    public <T> T loadFxml(String resURL) throws IOException {
        return loadFxml(resURL, null);
    }

    /**
     * Loads an object hierarchy from a FXML document and set a controller.
     * @param resURL URL source for FXML document.
     * @param controller Controller
     * @param <T> The loaded object hierarchy type.
     * @return The loaded object hierarchy.
     * @throws IOException
     */
    public <T> T loadFxml(String resURL, Object controller) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(resURL));
        if(controller != null)
            fxmlLoader.setController(controller);
        return fxmlLoader.load();
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

        primaryStage.setOnCloseRequest(e -> lModel.setExit(true));
    }

    /**
     * Set the title for the main window
     * @param title Title of the main window
     */
    protected void setTitle(String title){
        this.title = title;
    }

    /**
     * Set the default scene for subsequent access
     * @param scene Scene initialized
     */
    protected void setScene(Scene scene){
        this.scene = scene;
    }

    /**
     * Set the controller for subsequent access.
     * @param lController Controller initialized
     */
    protected void setlController(LController lController){
        this.lController = lController;
    }

    /**
     * Model used for the application
     * @param lModel Model of the application
     */
    protected void setlModel(LModel lModel){
        this.lModel = lModel;
    }

    /**
     * Default handlers for keyboards.
     * @see LController#handleKeyPressed(KeyEvent)
     * @see LController#handleKeyReleased(KeyEvent)
     * @see LController#handleKeyTyped(KeyEvent)
     */
    protected void loadHandlers(){
        scene.setOnKeyPressed(event -> lController.handleKeyPressed(event));
        scene.setOnKeyReleased(event -> lController.handleKeyReleased(event));
        scene.setOnKeyTyped(event -> lController.handleKeyTyped(event));
    }
}
