package jeu2.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import mainlib.model.LModel;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerScore implements Initializable {

    @FXML
    AnchorPane scoreAnchorID;

    @FXML
    Label scoreLabelID;

    private LModel lModel;

    public ControllerScore(LModel lModel){
        this.lModel = lModel;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scoreLabelID.setText("Score : " + lModel.getScore());
    }

    public void whenNotified(){ //TODO faire proprement cette fonction.
        System.out.println("Notified");
        scoreLabelID.setText("Score : " + lModel.getScore());

        // Exemple of use
        if(lModel.isFinished()){
            Label finishedlabel = new Label("Game Over !");
            finishedlabel.setPadding(new Insets(15));
            scoreAnchorID.getChildren().add(finishedlabel);
        }
    }
}
