/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author mlewe
 */


public class CompareUsersController extends pageOpener {
    
    
    @FXML public HBox hbox;
    @FXML public ComboBox combo;
    @FXML public StackPane stackpane;
    
    // Ranks Labels
    @FXML private Label rankOne;
    @FXML private Label rankTwo;
    @FXML private Label rankThree;
    @FXML private Label rankFour;
    @FXML private Label rankFive;
    @FXML private Label rankSix;
    @FXML private Label rankSeven;
    @FXML private Label rankEight;
    @FXML private Label rankNine;
    @FXML private Label rankTen;
    
    //User labels
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
    
    // XP Labels
    @FXML private Label xpOne;
    @FXML private Label xpTwo;
    @FXML private Label xpThree;
    @FXML private Label xpFour;
    @FXML private Label xpFive;
    @FXML private Label xpSix;
    @FXML private Label xpSeven;
    @FXML private Label xpEight;
    @FXML private Label xpNine;
    @FXML private Label xpTen;
    
    // Crowns & Gnomes
    @FXML private ImageView firstPlace;
    @FXML private ImageView secondPlace;
    @FXML private ImageView thirdPlace;
    @FXML private ImageView fourthPlace;
    @FXML private ImageView fifthPlace;
    @FXML private ImageView sixthPlace;
    @FXML private ImageView seventhPlace;
    @FXML private ImageView eighthPlace;
    @FXML private ImageView ninthPlace;
    @FXML private ImageView tenthPlace;
      
    private Label[] rankLabelss;
    private Label[] userLabelss;
    private Label[] xpLabelss;
    private ImageView[] images;
    private ArrayList<User> reorderedList;
    
    // Setup Page
    public void myFunction(){
      
        reorderedList = LoadAndSave.getUsers();
      // Setup Skills to search
        String skills[] = {"Overall", "Agility", "Attack", "Construction", "Cooking", 
         "Crafting", "Defence", "Farming", "Fishing", "Fletching", "Herblore",
         "Hitpoints", "Hunter", "Prayer", "Magic", "Mining", "Firemaking",  "Ranged", 
         "Runecraft", "Slayer",  "Smithing",  "Strength",  "Thieving", "Woodcutting" };
        // Add skills to drop down combo box
        for(String s : skills){
            combo.getItems().add(s); 
        }
        // Set intial value as comparing by overall 
        combo.setValue("Overall");
        
        // Create array of buttons, as create on page load will set without null pointer
        Label rankLabels[]={rankOne, rankTwo, rankThree, rankFour, rankFive, rankSix, rankSeven, rankEight, rankNine, rankTen};
        Label userLabels[] = {userOne, userTwo, userThree, userFour, userFive, userSix, userSeven, userEight, userNine, userTen};
        Label xpLabels[] = {xpOne, xpTwo, xpThree, xpFour, xpFive, xpSix, xpSeven, xpEight, xpNine, xpTen};
        ImageView image[] = {firstPlace, secondPlace, thirdPlace, fourthPlace, fifthPlace, sixthPlace, seventhPlace, eighthPlace, ninthPlace, tenthPlace};
        
        rankLabelss = rankLabels;
        images = image;
        userLabelss = xpLabels;
        xpLabelss = xpLabels;
        
     
        // Order saved users by Overall level
        Collections.sort(reorderedList, new Comparator<User>() {
            @Override public int compare(User p1, User p2) {
                return (int) (p2.skills.get("Overall").getExperience() - p1.skills.get("Overall").getExperience()); // Descending
            }
        });     
    
        
        // Set saved users to fields in order  
        int i = 0;
        for(User u3 : reorderedList){
            String level = String.valueOf(u3.getSkills().get("Overall").getLevel());
            userLabels[i].setText(u3.username);
            xpLabels[i].setText(level);
            userLabels[i].setVisible(true);
            xpLabels[i].setVisible(true);
            image[i].setVisible(true);
            rankLabels[i].setVisible(true);
            i++;
        }   
    }
    
    // Function to switch ordering of users and replace data shown dependant on skill selected
    public void chosenSkill(ActionEvent event){
        
        // Fade the StackPane containing the infomation out and back in again whilst change taking place
        refreshFade(stackpane);
        // Get value from ComboBox, this will be the skill we are comparing
        String compSkill = combo.getValue().toString();
        
         // Order saved users by selected skill
        Collections.sort(reorderedList, new Comparator<User>() {
            @Override public int compare(User p1, User p2) {
                return (int) (p2.skills.get(compSkill).getExperience() - p1.skills.get(compSkill).getExperience()); // Descending
            }
        });   
        
         
        // Set saved users to fields in order  
        int i = 0;
        for(User u3 : reorderedList){
            
            Label userLabels2[] = {userOne, userTwo, userThree, userFour, userFive, userSix, userSeven, userEight, userNine, userTen};
            String level = String.valueOf(u3.getSkills().get(compSkill).getLevel());
            String User = String.valueOf(u3.getUsername());
  
            userLabels2[i].setText(User);
            xpLabelss[i].setText(level);
            userLabels2[i].setVisible(true);
            xpLabelss[i].setVisible(true);
            images[i].setVisible(true);
            rankLabelss[i].setVisible(true);
            i++;
        }   
        close = true;
        combo.hide();
    }
    
   public boolean close = false;
    public void opener(){
        if(close == false){
            combo.show();
        }else{
            combo.hide();
            close = false;
        }
    }
    // Function for visually resfreshing the user data
    public void refreshFade(Node node){
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(true);
        ft.play();
    }
    
}
