package mainlib.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import mainlib.model.LModel;

import java.net.URL;
import java.util.ResourceBundle;

public class LController  implements Initializable {

    @FXML
    protected GridPane gridID;

    protected LModel lModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lModel = new LModel();
        for (int i = 0; i < 10; i++) {
            RowConstraints row = new RowConstraints(50);

            gridID.getRowConstraints().add(row);

            Rectangle square = new Rectangle();
            Color color;
            if(i % 2 == 0)
                color = Color.rgb(255, 206, 158);
            else color = Color.rgb(205, 133, 63);
            square.setFill(color);
            gridID.add(square, 1, i);
        }
    }
}
