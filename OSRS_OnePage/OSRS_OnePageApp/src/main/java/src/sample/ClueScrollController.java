/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sample;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author mlewe
 */
public class ClueScrollController extends pageOpener{
    
    @FXML public BorderPane borderpane;
    @FXML public GridPane gridpane;
    @FXML private Label usernameLabel;
    @FXML private ImageView saved;
    @FXML public Button exit;
    @FXML private Label beginnerLabel;
    @FXML private Label easyLabel;
    @FXML private Label mediumLabel;
    @FXML private Label hardLabel;
    @FXML private Label eliteLabel;
    @FXML private Label masterLabel;

    

    // Prepare page before showing, called within pageController when opening page
    public void myFunction(){
        // Set Label at the top of the page to the username being searched
        usernameLabel.setText(getSkills.user.getUsername());
        
        // new getSkills to allow access to static User 
        getSkills gS = new getSkills();

        // Set 'saved' image as a filled star if User saved and an outline if not
        if(getSkills.user.isSaved == true){
            Image image = new Image("/assets/images/star_filled.png");
            saved.setImage(image);
        }else{
            Image image = new Image("/assets/images/star.png");
            saved.setImage(image);
        }        
        
        // Beginner clue count
        String beginnerScrollCount = gS.beginnerScrolls();
        beginnerLabel.setText(beginnerScrollCount);
        
        // Easy clue count
        String easyScrollCount = gS.easyScrolls();
        easyLabel.setText(easyScrollCount);
        
        // Medium clue count
        String mediumClueCount = gS.mediumScrolls();
        mediumLabel.setText(mediumClueCount);
        
        // Hard clue count
        String hardClueCount = gS.hardScrolls();
        hardLabel.setText(hardClueCount);
        
        // Elite clue count
        String eliteClueCount = gS.eliteScrolls();
        eliteLabel.setText(eliteClueCount);
        
        // Master clue count
        String masterClueCount = gS.masterScrolls();
        masterLabel.setText(masterClueCount);
    }






// Checks if the user is currently saved, if not, changes icon and calls 'openPopupNewSave'
    // If the user is saved already, 'openPopupNewSave' is called without the icon changing as user descision is not yet final
    public void saveUser(MouseEvent event) throws IOException{
        if (getSkills.user.isSaved == false && LoadAndSave.users.size() < 10){
            openPopupNewSave(event);
            Image image = new Image("/assets/images/star_filled.png");
            saved.setImage(image);
            
            
        }else{
            openPopupNewSave(event);
            
        }
    }
    
    // New pop-up window when saving / un-saving a user
    public void openPopupNewSave(MouseEvent event) throws IOException{
// SETTING UP PAGE //
        LoadAndSave lnS = new LoadAndSave();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/popUpSaveUser.fxml"));
        Parent root = (Parent)loader.load();
        // Blur the backgrund to bring focus to pop-up
        GaussianBlur gaussianBlur = new GaussianBlur();       
        gaussianBlur.setRadius(10.5); 
        borderpane.setEffect(gaussianBlur);
        saveUserPopup pop = loader.getController(); 
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/assets/saveUserPopupStyle.css").toExternalForm());
        Stage window = new Stage();
        // Load pop-up as trasparent so it appears to float over the blurred scene, no toolbar
        window.initStyle(StageStyle.TRANSPARENT);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        
// OPTIONS //
        // If the User is not currently saved, and there are less than 10 users saved: 
        // display the 'success' version of the pop-up and fade out
        // Add to JSON
        if(getSkills.user.isSaved == false && lnS.users.size() < 10){
            fadeOut(pop.pane);
            window.show();
            getSkills.user.setIsSaved(true);
            PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
            pop.text.setStyle("-fx-font-weight:bold; -fx-text-fill:#95C623;");
            pause.setOnFinished(e ->{
                GaussianBlur endGaus = new GaussianBlur();       
                gaussianBlur.setRadius(0); 
                borderpane.setEffect(gaussianBlur);
                getSkills.user.isSaved = true;
                window.close();
                try {
                    lnS.saveUser();
                } catch (IOException ex) {
                    Logger.getLogger(allSkillHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            pause.play();
            
        // If the user is currently saved, prompt with two buttons for final confirmation
        }else if (getSkills.user.isSaved == true){
            pop.text.setText("Are you sure?");
            pop.text.setStyle("-fx-text-fill: #F02D3A; -fx-font-weight:bold;");
            pop.yes.setVisible(true);
            pop.no.setVisible(true);
            pop.warning.setVisible(true);
            pop.warning.setStyle("-fx-font-size:11px;-fx-text-fill: #F02D3A;");
            window.show();
            
            // Control what happens when the user clicks the yes button
            // Will remove from JSON when completed
            pop.yes.setOnAction(e1 ->{
                fadeOut(pop.pane);
                PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
                pause.setOnFinished(e ->{
                    GaussianBlur endGaus = new GaussianBlur();       
                    gaussianBlur.setRadius(0); 
                    borderpane.setEffect(gaussianBlur);
                    Image image = new Image("/assets/images/star.png");
                    saved.setImage(image);
                    getSkills.user.isSaved = false;
                    window.close();
                    try {
                        lnS.removeUser();
                    } catch (IOException ex) {
                        Logger.getLogger(allSkillHome.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                });
                pause.play();
            });
            
            // Control what happens when the user clicks the no button
            // Closes the pop-up, no changes made
            pop.no.setOnAction(e->{
                fadeOut(pop.pane);
                PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
                pause.setOnFinished(ei ->{
                    GaussianBlur endGaus = new GaussianBlur();       
                    gaussianBlur.setRadius(0); 
                    borderpane.setEffect(gaussianBlur);
                    Image image = new Image("/assets/images/star_filled.png");
                    saved.setImage(image);
                    getSkills.user.isSaved = true;
                    window.close();
                    lnS.loadUsers();
                });
                pause.play();
            });
        }else if(getSkills.user.isSaved == false && lnS.users.size() == 10){
            Image image = new Image("/assets/images/star.png");
            saved.setImage(image);
            pop.text.setText("Saved List Full!");
            pop.text.setStyle("-fx-text-fill: #F02D3A; -fx-font-weight:bold;");
            window.show();
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(e ->{
                GaussianBlur endGaus = new GaussianBlur();       
                gaussianBlur.setRadius(0); 
                borderpane.setEffect(gaussianBlur);
                window.close();
            });
            
            pause.play();
    }
    

    }
    
}
