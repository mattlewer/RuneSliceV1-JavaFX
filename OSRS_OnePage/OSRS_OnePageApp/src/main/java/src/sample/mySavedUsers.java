/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sample;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 *
 * @author mlewe
 */
public class mySavedUsers extends pageOpener {
    
    @FXML public BorderPane borderpane;
    @FXML public ScrollPane scrollPane;
    @FXML public GridPane gridpane;
    @FXML public ImageView icon;
    @FXML public Label loading;
    
    // User Labels
    @FXML private Label userOne;
    @FXML private Label userTwo;
    @FXML private Label userThree;
    @FXML private Label userFour;
    @FXML private Label userFive;
    @FXML private Label userSix; 
    @FXML private Label userSeven;
    @FXML private Label userEight;
    @FXML private Label userNine;
    @FXML private Label userTen;
    
    // Search buttons
    @FXML private JFXButton searchOne;
    @FXML private JFXButton searchTwo;
    @FXML private JFXButton searchThree;
    @FXML private JFXButton searchFour;
    @FXML private JFXButton searchFive;
    @FXML private JFXButton searchTen;
    @FXML private JFXButton searchSix;
    @FXML private JFXButton searchSeven;
    @FXML private JFXButton searchEight;
    @FXML private JFXButton searchNine;
    
    // Return to seach user
    @FXML public JFXButton search;
    public String name;
    
    public void myFunction(){
        JFXButton[] buttons = new JFXButton[]{searchOne, searchTwo, searchThree, searchFour, searchFive, 
            searchSix, searchSeven, searchEight, searchNine, searchTen};
        
        Label[] labels = new Label[]{userOne, userTwo, userThree, userFour, userFive,
        userSix, userSeven, userEight, userNine, userTen};
        
        if(LoadAndSave.users.size() < 1){
            loading.setText("You have no saved users!");
            loading.setVisible(true);
        }
        int i = 0;
        while(i < LoadAndSave.users.size()){
            buttons[i].setVisible(true);
            labels[i].setVisible(true);
            labels[i].setText(LoadAndSave.users.get(i).username);
            i++;
        }
        
    }
    
    
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
        LoadAndSave lns = new LoadAndSave();
        pause.setOnFinished(e ->{
                try {
                    for(User u : lns.users){
                    if(u.getUsername().toString().equals(name)){
                        getSkills.user = u;
                        exitSkill(event);
                    }else{
                        loading.setText("ERROR: Please try again.");
                    }
                }
                }catch(Exception eeee){
                    System.out.println("All went wrong");
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
    
    
    public void openCompareUsers(MouseEvent event) throws IOException{
        compareUsersHome(event);
    }
    
    
  
    
     public void rotate(ImageView imageView){
        RotateTransition rt = new RotateTransition(Duration.millis(1500), imageView);
        rt.setByAngle(360);
        rt.setInterpolator(Interpolator.LINEAR);
        fade(imageView);
        rt.play();
        
    }
    
}
