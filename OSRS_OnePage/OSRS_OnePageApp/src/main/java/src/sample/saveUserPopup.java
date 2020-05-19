/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 *
 * @author mlewe
 */
public class saveUserPopup extends pageOpener{
    @FXML public ImageView backLogo;
    @FXML public AnchorPane ancpane;
    @FXML public BorderPane borderpane;
    @FXML public StackPane stackpane;
    @FXML public VBox vbox;
    @FXML public Label text;
    @FXML public Button yes;
    @FXML public Button no;
    @FXML public Label warning;
    
    
        public void close(){
            Stage stage = (Stage) ancpane.getScene().getWindow();
            stage.close();
        }
}
