/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sample;

import com.jfoenix.controls.JFXButton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author mlewe
 */


public class CompareUsersController extends pageOpener {
    
    
    @FXML public BorderPane borderpane;
    @FXML public JFXButton compareBy;
    @FXML public StackPane stackpane;
    @FXML public Label title;
    @FXML public Label levelKills;
    @FXML public Button returnToSaved;
    @FXML public BorderPane skillChoice;
    @FXML public BorderPane bossChoice;
    @FXML public BorderPane clueChoice;
    
    
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
    
    public static int skillOrBoss = 0;
    
    // Setup Page For Skills
    public void mySkillFunction(){
       
        reorderedList = LoadAndSave.getUsers();
   
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
            image[i].setVisible(true);
            rankLabels[i].setVisible(true);
            i++;
        }   
    }
    
    public void myBossFunction(){
        levelKills.setText("Kills");
        title.setText("Compare Boss Kills");
        reorderedList = LoadAndSave.getUsers();
        compareBy.setText("Abyssal Sire");
        // Create array of buttons, as create on page load will set without null pointer
        Label rankLabels[]={rankOne, rankTwo, rankThree, rankFour, rankFive, rankSix, rankSeven, rankEight, rankNine, rankTen};
        Label userLabels[] = {userOne, userTwo, userThree, userFour, userFive, userSix, userSeven, userEight, userNine, userTen};
        Label xpLabels[] = {xpOne, xpTwo, xpThree, xpFour, xpFive, xpSix, xpSeven, xpEight, xpNine, xpTen};
        ImageView image[] = {firstPlace, secondPlace, thirdPlace, fourthPlace, fifthPlace, sixthPlace, seventhPlace, eighthPlace, ninthPlace, tenthPlace};
        
        rankLabelss = rankLabels;
        images = image;
        userLabelss = xpLabels;
        xpLabelss = xpLabels;
        
        // Order saved users by Abyssal Sire kills as first alphabetically
        Collections.sort(reorderedList, new Comparator<User>() {
            @Override public int compare(User p1, User p2) {
               int p1Kills;
               int p2Kills;
               try{
                   p1Kills = p1.bossKills.get("Abyssal Sire").getKills(); 
               }catch(NullPointerException e){
                   p1Kills = 0;
               }
               try{
                   p2Kills = p2.bossKills.get("Abyssal Sire").getKills(); 
               }catch(NullPointerException e){
                   p2Kills = 0;
               }                
                return (int) (p2Kills - p1Kills); // Descending
            }
        });    
        
        // Set saved users to fields in order  
        int i = 0;
        for(User u3 : reorderedList){
            String level;
            try{
                level = String.valueOf(u3.getBossKills().get("Abyssal Sire").getKills());
            }catch(NullPointerException e1){
                level = "0";
            }
            userLabels[i].setText(u3.username);
            xpLabels[i].setText(level);
            userLabels[i].setVisible(true);
            xpLabels[i].setVisible(true);
            image[i].setVisible(true);
            rankLabels[i].setVisible(true);
            i++;
        }   
        
    }
    
    public void myClueFunction(){
        levelKills.setText("Clue Scrolls");
        title.setText("Compare Scrolls Achieved");
        reorderedList = LoadAndSave.getUsers();
        compareBy.setText("Beginner");
        // Create array of buttons, as create on page load will set without null pointer
        Label rankLabels[]={rankOne, rankTwo, rankThree, rankFour, rankFive, rankSix, rankSeven, rankEight, rankNine, rankTen};
        Label userLabels[] = {userOne, userTwo, userThree, userFour, userFive, userSix, userSeven, userEight, userNine, userTen};
        Label xpLabels[] = {xpOne, xpTwo, xpThree, xpFour, xpFive, xpSix, xpSeven, xpEight, xpNine, xpTen};
        ImageView image[] = {firstPlace, secondPlace, thirdPlace, fourthPlace, fifthPlace, sixthPlace, seventhPlace, eighthPlace, ninthPlace, tenthPlace};
        
        rankLabelss = rankLabels;
        images = image;
        userLabelss = xpLabels;
        xpLabelss = xpLabels;
        
        Collections.sort(reorderedList, new Comparator<User>() {
            @Override public int compare(User p1, User p2) {
               int p1Scrolls;
               int p2Scrolls;
               try{
                   p1Scrolls = Integer.parseInt(p1.beginnerScrolls());
               }catch(NullPointerException e){
                   p1Scrolls = 0;
               }
               try{
                   p2Scrolls = Integer.parseInt(p2.beginnerScrolls()); 
               }catch(NullPointerException e){
                   p2Scrolls = 0;
               }                
                return (int) (p2Scrolls - p1Scrolls); // Descending
            }
        });    
        
        // Set saved users to fields in order  
        int i = 0;
        for(User u3 : reorderedList){
            String scrollsObtained;
            try{
                scrollsObtained = String.valueOf(u3.beginnerScrolls());
            }catch(NullPointerException e1){
                scrollsObtained = "0";
            }
            userLabels[i].setText(u3.username);
            xpLabels[i].setText(scrollsObtained);
            userLabels[i].setVisible(true);
            xpLabels[i].setVisible(true);
            image[i].setVisible(true);
            rankLabels[i].setVisible(true);
            i++;
        }   
    }
    
    
    
    
    
    public void openChoice(MouseEvent event){
        
        if(skillOrBoss == 0){
            skillChoice.setVisible(true);
            fadeIn(skillChoice);
        }else if(skillOrBoss == 1){
            bossChoice.setVisible(true);
            fadeIn(bossChoice);
        }else{
            clueChoice.setVisible(true);
            fadeIn(clueChoice);
        }
    }
    
    
    
    
    public void reorderByChoice(MouseEvent event){
        String compSkill = ((JFXButton)event.getSource()).getText();
  
        compareBy.setText(compSkill);
        
        if(skillOrBoss == 0){
            // Fade the StackPane containing the infomation out and back in again whilst change taking place
            refreshFade(stackpane);

            // Order saved users by selected skill
            if(compSkill != "Overall"){
                Collections.sort(reorderedList, new Comparator<User>() {
                    @Override public int compare(User p1, User p2) {
                        return (int) (p2.skills.get(compSkill).getExperience() - p1.skills.get(compSkill).getExperience()); // Descending
                    }
                });   
            }else{
                    Collections.sort(reorderedList, new Comparator<User>() {
                        @Override public int compare(User p1, User p2) {
                            return (int) (p2.skills.get(compSkill).getLevel() - p1.skills.get(compSkill).getLevel()); // Descending
                        }
                    });  
                }
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
            fadeOut(skillChoice);
            skillChoice.setVisible(false);
            borderpane.requestFocus();
        }else if(skillOrBoss == 1){
            // Fade the StackPane containing the infomation out and back in again whilst change taking place
            refreshFade(stackpane);
            // Order saved users by selected boss
            Collections.sort(reorderedList, new Comparator<User>() {
               @Override public int compare(User p1, User p2) {
               int p1Kills;
               int p2Kills;
                try{
                   p1Kills = p1.bossKills.get(compSkill).getKills(); 
                }catch(NullPointerException e){
                    p1Kills = 0;
                }
                try{
                   p2Kills = p2.bossKills.get(compSkill).getKills(); 
                }catch(NullPointerException e){
                    p2Kills = 0;
                }
                    return (int) (p2Kills - p1Kills); // Descending
                }
            });   
            
            // Set saved users to fields in order  
            int i = 0;
            for(User u3 : reorderedList){
                Label userLabels2[] = {userOne, userTwo, userThree, userFour, userFive, userSix, userSeven, userEight, userNine, userTen};
                String level;
                try{
                    level = String.valueOf(u3.getBossKills().get(compSkill).getKills());
                }catch(NullPointerException e1){
                    level = "0";
                }
                String User = String.valueOf(u3.getUsername());
                userLabels2[i].setText(User);
                xpLabelss[i].setText(level);
                userLabels2[i].setVisible(true);
                xpLabelss[i].setVisible(true);
                images[i].setVisible(true);
                rankLabelss[i].setVisible(true);
                i++;     
            }
            fadeOut(bossChoice);
            bossChoice.setVisible(false);
            borderpane.requestFocus();
        }else{
            // Fade the StackPane containing the infomation out and back in again whilst change taking place
            refreshFade(stackpane);
            // Order saved users by selected boss
            Collections.sort(reorderedList, new Comparator<User>() {
               @Override public int compare(User p1, User p2) {
               int p1Kills;
               int p2Kills;
                try{
                   p1Kills = p1.clues.get(compSkill).getNumberOfScrollsCompleted();
                }catch(NullPointerException e){
                    p1Kills = 0;
                }
                try{
                   p2Kills = p2.clues.get(compSkill).getNumberOfScrollsCompleted();
                }catch(NullPointerException e){
                    p2Kills = 0;
                }
                    return (int) (p2Kills - p1Kills); // Descending
                }
            });  
                        // Set saved users to fields in order  
            int i = 0;
            for(User u3 : reorderedList){
                Label userLabels2[] = {userOne, userTwo, userThree, userFour, userFive, userSix, userSeven, userEight, userNine, userTen};
                String numberOfScrolls;
                try{
                    numberOfScrolls = String.valueOf(u3.getClues().get(compSkill).getNumberOfScrollsCompleted());
                }catch(NullPointerException e1){
                    numberOfScrolls = "0";
                }
                String User = String.valueOf(u3.getUsername());
                userLabels2[i].setText(User);
                xpLabelss[i].setText(numberOfScrolls);
                userLabels2[i].setVisible(true);
                xpLabelss[i].setVisible(true);
                images[i].setVisible(true);
                rankLabelss[i].setVisible(true);
                i++;     
            }
            fadeOut(clueChoice);
            clueChoice.setVisible(false);
            borderpane.requestFocus();
            
        }
        
    }
        
        
    
    
    

    //Function for visually resfreshing the user data
    public void refreshFade(Node node){
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(true);
        ft.play();
    }
    
    public void fadeOut(Node node){
        FadeTransition ft = new FadeTransition(Duration.millis(200));
        ft.setNode(node);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setCycleCount(1);
        ft.play();
    }
    
    public void fadeIn(Node node){
        FadeTransition ft = new FadeTransition(Duration.millis(200));
        ft.setNode(node);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.play();
    }
    
}
