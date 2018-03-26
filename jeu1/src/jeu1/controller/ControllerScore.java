package jeu1.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import jeu1.model.Model;
import mainlib.model.LModel;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class ControllerScore implements Initializable, java.util.Observer {

    @FXML
    AnchorPane scoreAnchorID;

    @FXML
    Label scoreLabelID;

    @FXML
    Label stateLabelID;

    @FXML
    Label nextLabelID;

    @FXML
    Button restartButtonID;

    private LModel lModel;

    public ControllerScore(LModel lModel){
        this.lModel = lModel;
        this.lModel.addObserver(this);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scoreLabelID.setText("Score : " + lModel.getScore());
        restartButtonID.setOnMouseClicked(event -> restart());
    }

    @Override
    public void update(Observable o, Object arg) {
        Platform.runLater(() -> {
            scoreLabelID.setText("Score : " + lModel.getScore());
            stateLabelID.setText("");

            // Exemple of use
            if(lModel.isFinished()){
                stateLabelID.setText("Game Over !");
                restartButtonID.setDisable(false);
            }
        });
    }

    public void restart() {
        restartButtonID.setDisable(true);
        try {
            ((Model)lModel).restart();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
