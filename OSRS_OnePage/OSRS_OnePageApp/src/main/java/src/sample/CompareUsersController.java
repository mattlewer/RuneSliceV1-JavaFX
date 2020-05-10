/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author mlewe
 */


public class CompareUsersController extends pageOpener {
    
    
    @FXML public HBox hbox;
    @FXML public ComboBox combo;
    
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
    
      
    private Label[] userLabelss;
    private Label[] xpLabelss;
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
        Label userLabels[] = {userOne, userTwo, userThree, userFour, userFive, userSix, userSeven, userEight, userNine, userTen};
        Label xpLabels[] = {xpOne, xpTwo, xpThree, xpFour, xpFive, xpSix, xpSeven, xpEight, xpNine, xpTen};
        userLabelss = xpLabels;
        xpLabelss = xpLabels;
        
     
        // Order saved users by Overall level
        Collections.sort(reorderedList, new Comparator<User>() {
            @Override public int compare(User p1, User p2) {
                return (int) (p2.skills.get("Overall").getLevel() - p1.skills.get("Overall").getLevel()); // Descending
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
            i++;
        }   
    }
    
    
    public void chosenSkill(ActionEvent event){
        String compSkill = combo.getValue().toString();
         // Order saved users by selected skill
        Collections.sort(reorderedList, new Comparator<User>() {
            @Override public int compare(User p1, User p2) {
                return (int) (p2.skills.get(compSkill).getLevel() - p1.skills.get(compSkill).getLevel()); // Descending
            }
        });   
        
          // Set saved users to fields in order  
        int i = 0;
        for(User u3 : reorderedList){
            
            Label userLabels2[] = {userOne, userTwo, userThree, userFour, userFive, userSix, userSeven, userEight, userNine, userTen};
            String level = String.valueOf(u3.getSkills().get(compSkill).getLevel());
            String User = String.valueOf(u3.getUsername());
            
            System.out.println(User);
            System.out.println(level);
            System.out.println("--------------");
            
            userLabels2[i].setText(User);
            xpLabelss[i].setText(level);
            userLabels2[i].setVisible(true);
            xpLabelss[i].setVisible(true);
            i++;
        }   
        
    }
    
}
