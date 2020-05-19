/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sample;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author mlewe
 */
public class AllBossHomeController extends pageOpener implements Initializable{
    @FXML public BorderPane borderpane;
    @FXML public StackPane stackpane;
    @FXML public Label usernameLabel;
    @FXML public ImageView saved;
    @FXML public Label bosses;
    @FXML public Label skills;
    @FXML public JFXButton exit;
    
    //Boss kill number labels
    @FXML private Label hydraLabel;
    @FXML private Label callistoLabel;
    @FXML private Label barrowsLabel;
    @FXML private Label xericLabel;
    @FXML private Label chaosFanaticLabel;
    @FXML private Label chaosElementalLabel;
    @FXML private Label corpLabel;
    @FXML private Label primeLabel;
    @FXML private Label supremeLabel;
    @FXML private Label generalGraardorLabel;
    @FXML private Label grotesqueGuardianLabel;
    @FXML private Label kalphiteQueenLabel;
    @FXML private Label sireLabel;
    @FXML private Label bryophytaLabel;
    @FXML private Label cerberusLabel;
    @FXML private Label xericChallengeLabel;
    @FXML private Label zilyanaLabel;
    @FXML private Label crazyArchaeologistLabel;
    @FXML private Label rexLabel;
    @FXML private Label derangedArchaeologistLabel;
    @FXML private Label giantMoleLabel;
    @FXML private Label hesporiLabel;
    @FXML private Label kbdLabel;
    @FXML private Label krakenLabel;
    @FXML private Label krilLabel;
    @FXML private Label kreeLabel;
    @FXML private Label mimicLabel;
    @FXML private Label oborLabel;
    @FXML private Label scorpiaLabel;
    @FXML private Label gauntletLabel;
    @FXML private Label tobLabel;
    @FXML private Label zukLabel;
    @FXML private Label venenatisLabel;
    @FXML private Label vorkathLabel;
    @FXML private Label zalcanoLabel;
    @FXML private Label sarachnisLabel;
    @FXML private Label skotizoLabel;
    @FXML private Label corruptedGauntletLabel;
    @FXML private Label thermoSmokeLabel;
    @FXML private Label jadLabel;
    @FXML private Label vetionLabel;
    @FXML private Label wintertodtLabel;
    @FXML private Label zulrahLabel;
    
    
    
// Sets up the page with the users level for each skill 
    public void myFunction(){
        
        Label[] killLabels = {hydraLabel,callistoLabel,barrowsLabel,xericLabel,chaosFanaticLabel,chaosElementalLabel,corpLabel,
        primeLabel,supremeLabel,generalGraardorLabel,grotesqueGuardianLabel,kalphiteQueenLabel,sireLabel,bryophytaLabel,
        cerberusLabel,xericChallengeLabel,zilyanaLabel,crazyArchaeologistLabel,rexLabel,derangedArchaeologistLabel,giantMoleLabel,
        hesporiLabel,kbdLabel,krakenLabel,krilLabel,kreeLabel,mimicLabel,oborLabel,scorpiaLabel,gauntletLabel,tobLabel,zukLabel,
        venenatisLabel,vorkathLabel,zalcanoLabel,sarachnisLabel,skotizoLabel,corruptedGauntletLabel,thermoSmokeLabel,jadLabel,
        vetionLabel,wintertodtLabel,zulrahLabel
        };
        
        
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
        
        // Setting up all boss Labels //
        
        // Abyssal Sire Kills
        String abbySireKC = gS.sireKills();
        sireLabel.setText(abbySireKC);
        
        // Alchemical Hydra
        String hydraKC = gS.hydraKills();
        hydraLabel.setText(hydraKC);
        
        //Barrows Chests
        String barrowsKC = gS.barrowsKills();
        barrowsLabel.setText(barrowsKC);

        // Bryophyta
        String bryophytaKC = gS.bryoKills();
        bryophytaLabel.setText(bryophytaKC);
        
        // Callisto
        String callistoKC = gS.callistoKills();
        callistoLabel.setText(callistoKC);
        
        // Cerberus
        String cerberusKC = gS.cerberusKills();
        cerberusLabel.setText(cerberusKC);
        
        // Chambers of Xeric
        String chambersKC = gS.xericKills();
        xericLabel.setText(chambersKC);
        
        // Chambers of Xeric : Challenge Mode
        String chambersChallengeKC = gS.xericChallengeKills();
        xericChallengeLabel.setText(chambersChallengeKC);
        
        // Chaos Elemental
        String chaosEleKC = gS.chaosElementalKills();
        chaosElementalLabel.setText(chaosEleKC);
        
        // Chaos Fanatic
        String chaosFanaticKC = gS.chaosFanaticKills();
        chaosFanaticLabel.setText(chaosFanaticKC);
        
        // Commander Zilyana
        String zilyanaKC = gS.zilyanaKills();
        zilyanaLabel.setText(zilyanaKC);
        
        // Corporeal Beast
        String corpKC = gS.corpKills();
        corpLabel.setText(corpKC);
        
        // Crazy Archaeologist
        String crazyArchKC = gS.crazyArchaeologistKills();
        crazyArchaeologistLabel.setText(crazyArchKC);
        
        // Dagannoth Prime
        String primeKC = gS.primeKills();
        primeLabel.setText(primeKC);
        
        // Dagannoth Rex
        String rexKC = gS.rexKills();
        rexLabel.setText(rexKC);
        
        // Dagannoth Supreme
        String supremeKC = gS.supremeKills();
        supremeLabel.setText(supremeKC);
        
        // Deranged Archaeologist
        String derangedArch = gS.derangedArchaeologistKills();
        derangedArchaeologistLabel.setText(derangedArch);
        
        // General Graardor
        String graardorKC = gS.graardorKills();
        generalGraardorLabel.setText(graardorKC);
        
        // Giant Mole
        String moleKC = gS.giantMoleKills();
        giantMoleLabel.setText(moleKC);
        
        // Grotesque Guardians
        String guardianKC = gS.guardianKills();
        grotesqueGuardianLabel.setText(guardianKC);
        
        // Hespori
        String hesporiKC = gS.hesporiKills();
        hesporiLabel.setText(hesporiKC);
        
        // Kalphite Queen
        String kalphiteKC = gS.kalphiteKills();
        kalphiteQueenLabel.setText(kalphiteKC);
        
        // King Black Dragon
        String kbdKC = gS.kbdKills();
        kbdLabel.setText(kbdKC);
        
        // Kraken
        String krakenKC = gS.krakenKills();
        krakenLabel.setText(krakenKC);
        
        // Kree'Arra
        String kreeKC = gS.kreeKills();
        kreeLabel.setText(kreeKC);
        
        // K'ril Tsutsaroth
        String krillKC = gS.krilKills();
        krilLabel.setText(krillKC);
        
        // Mimic
        String mimicKC = gS.mimicKills();
        mimicLabel.setText(mimicKC);
        
        // Obor
        String oborKC = gS.oborKills();
        oborLabel.setText(oborKC);
        
        // Sarachnis
        String sarachnisKC = gS.sarachnisKills();
        sarachnisLabel.setText(sarachnisKC);
        
        // Scorpia
        String scorpiaKC = gS.scorpiaKills();
        scorpiaLabel.setText(scorpiaKC);
        
        // Skotizo
        String skotizoKC = gS.skotizoKills();
        skotizoLabel.setText(skotizoKC);
        
        // The Gauntlet
        String gauntletKC = gS.gauntletKills();
        gauntletLabel.setText(gauntletKC);
        
        // The Corrupted Gauntlet
        String corruptedGauntletKC = gS.corruptedGauntletKills();
        corruptedGauntletLabel.setText(corruptedGauntletKC);
        
        // Theatre of Blood
        String tobKills = gS.tobKills();
        tobLabel.setText(tobKills);
        
        // Thermonuclear Smoke Devil
        String thermoKC = gS.thermoSmokeKills();
        thermoSmokeLabel.setText(thermoKC);
        
        // TzKal-Zuk
        String zukKC = gS.zukKills();
        zukLabel.setText(zukKC);
        
        // TzTok-Jad
        String jadKC = gS.jadKills();
        jadLabel.setText(jadKC);
        
        // Venenatis
        String venenatisKC = gS.venenatisKills();
        venenatisLabel.setText(venenatisKC);
        
        // Vet'ion
        String vetionKC = gS.vetionKills();
        vetionLabel.setText(vetionKC);
        
        // Vorkath
        String vorkathKC = gS.vorkathKills();
        vorkathLabel.setText(vorkathKC);
        
        // Wintertodt
        String wintertodtKC = gS.wintertodtKills();
        wintertodtLabel.setText(wintertodtKC);
        
        // Zalcano
        String zalcanoKC = gS.zalcanoKills();
        zalcanoLabel.setText(zalcanoKC);
        
        // Zulrah
        String zulrahKC = gS.zulrahKills();
        zulrahLabel.setText(zulrahKC);
        
        for(Label l : killLabels){
            if(l.getText().equals("0")){
                l.setStyle("-fx-text-fill: #F02D3A;");
            }
        }

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
// SETTING UP POPUP //
        LoadAndSave lnS = new LoadAndSave();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/popUpSaveUser.fxml"));
        Parent root = (Parent)loader.load();
        // Blur the backgrund to bring focus to pop-up
        GaussianBlur gaussianBlur = new GaussianBlur();       
        gaussianBlur.setRadius(10.5); 
        borderpane.setEffect(gaussianBlur);
        saveUserPopup pop = loader.getController(); 
        Scene scene = new Scene(root);
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
            fadeOut(pop.borderpane);
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
            root.requestFocus();
            window.show();
            
            // Control what happens when the user clicks the yes button
            // Will remove from JSON when completed
            pop.yes.setOnAction(e1 ->{
                fadeOut(pop.borderpane);
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
                fadeOut(pop.borderpane);
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
}
