package jeu1.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import mainlib.controller.LNotifiable;
import mainlib.model.LModel;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerScore implements Initializable, LNotifiable {

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

    public void whenNotified(){
        System.out.println("Notified");
        scoreLabelID.setText("Score : " + lModel.getScore());
    }
}
