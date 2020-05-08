/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sample;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 *
 * @author mlewe
 */
public class mySavedUsers extends pageOpener {
    
    @FXML private Button search;
    @FXML public ScrollPane scrollPane;
    @FXML public GridPane gridpane;
    @FXML public ImageView icon;
    @FXML public Label loading;
    
    @FXML private Label userOne;
    @FXML private Label userTwo;
    @FXML private Label userThree;
    @FXML private Label userFour;
    @FXML private Label userFive;
    @FXML private Button searchOne;
    @FXML private Button searchTwo;
    @FXML private Button searchThree;
    @FXML private Button searchFour;
    @FXML private Button searchFive;
    @FXML private Button searchTen;
    @FXML private Label userSix; 
    @FXML private Label userSeven;
    @FXML private Label userEight;
    @FXML private Label userNine;
    @FXML private Label userTen;
    @FXML private Button searchSix;
    @FXML private Button searchSeven;
    @FXML private Button searchEight;
    @FXML private Button searchNine;
    
    public String name;
    
    
    public void getUserToSearch(ActionEvent event) throws IOException{
        if(event.getSource() == searchOne){
            name = userOne.getText();
        }else if( event.getSource() == searchTwo){
            name = userTwo.getText();
        }else if( event.getSource() == searchThree){
            name = userThree.getText();
        }else if( event.getSource() == searchFour){
            name = userFour.getText();
        }else if( event.getSource() == searchFive){
            name = userFive.getText();
        }else if( event.getSource() == searchSix){
            name = userSix.getText();
        }else if( event.getSource() == searchSeven){
            name = userSeven.getText();
        }else if( event.getSource() == searchEight){
            name = userEight.getText();
        }else if( event.getSource() == searchNine){
            name = userNine.getText();
        }else if( event.getSource() == searchTen){
            name = userTen.getText();
        }
        
        
        
        loading.setVisible(true);
        loading.setText("Loading...");
        PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
        pause.setOnFinished(e ->{
            try {
                openUser(event, name);
            } catch (Exception err) {
                loading.setText("Error: User not found!");
            }
        });
        
        RotateTransition rt = new RotateTransition(Duration.millis(1500), icon);
        rt.setByAngle(360);
        rt.setInterpolator(Interpolator.LINEAR);
        fadeOut(icon);
        rt.setOnFinished(e3->{
            pause.play();
        });
        rt.play();
        
        
    }
    
    public void openUser(ActionEvent event, String name) throws IOException{
        openAllSkills(event, name);
    }
    
    
  
    
     public void rotate(ImageView imageView){
        RotateTransition rt = new RotateTransition(Duration.millis(1500), imageView);
        rt.setByAngle(360);
        rt.setInterpolator(Interpolator.LINEAR);
        fade(imageView);
        rt.play();
        
    }
    
}
