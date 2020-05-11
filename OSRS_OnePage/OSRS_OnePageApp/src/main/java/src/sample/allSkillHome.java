    package src.sample;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class allSkillHome extends pageOpener implements Initializable {


    // LABELS //


    @FXML private ImageView saved;
    @FXML private Label overallSkill;
    @FXML private Label strengthLabel;
    @FXML private Label magicLabel;
    @FXML private Label rangedLabel;
    @FXML private Label wcLabel;
    @FXML private Label fishingLabel;
    @FXML private Label craftingLabel;
    @FXML private Label miningLabel;
    @FXML private Label agilityLabel;
    @FXML private Label slayerLabel;
    @FXML private Label rcLabel;
    @FXML private Label constructionLabel;
    @FXML private Label hitpointsLabel;
    @FXML private Label attackLabel;
    @FXML private Label defenseLabel;
    @FXML private Label prayerLabel;
    @FXML private Label cookingLabel;
    @FXML private Label fletchingLabel;
    @FXML private Label firemakingLabel;
    @FXML private Label smithingLabel;
    @FXML private Label herbloreLabel;
    @FXML private Label thievingLabel;
    @FXML private Label farmingLabel;
    @FXML private Label hunterLabel;
    
    @FXML public VBox vbox;

    @FXML Label usernameLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    
    // Sets up the page with the users level for each skill 
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
        
        
        
        // Setting up skill Labels //
        //HP
        Skill hp = gS.hitpoints();
        String hpLevel = String.valueOf(hp.getLevel());
        hitpointsLabel.setText(hpLevel);

        //DEFENSE
        Skill def = gS.defense();
        String defLevel = String.valueOf(def.getLevel());
        defenseLabel.setText(defLevel);

        //STRENGTH
        Skill str = gS.strength();
        String strLevel = String.valueOf(str.getLevel());
        strengthLabel.setText(strLevel);

        //ATTACK
        Skill attk = gS.attack();
        String attkLevel = String.valueOf(attk.getLevel());
        attackLabel.setText(attkLevel);

        //RANGED
        Skill ranged = gS.ranged();
        String rangeLevel = String.valueOf(ranged.getLevel());
        rangedLabel.setText(rangeLevel);

        //PRAYER
        Skill prayer = gS.prayer();
        String prayerLevel = String.valueOf(prayer.getLevel());
        prayerLabel.setText(prayerLevel);

        //MAGIC
        Skill mage = gS.magic();
        String mageLevel = String.valueOf(mage.getLevel());
        magicLabel.setText(mageLevel);

        //COOKING
        Skill cook = gS.cooking();
        String cookLevel = String.valueOf(cook.getLevel());
        cookingLabel.setText(cookLevel);

        //WOODCUTTING
        Skill wc = gS.woodcutting();
        String wcLevel = String.valueOf(wc.getLevel());
        wcLabel.setText(wcLevel);

        //FLETCHING
        Skill fletch = gS.fletching();
        String fletchLevel = String.valueOf(fletch.getLevel());
        fletchingLabel.setText(fletchLevel);

        //FISHING
        Skill fish = gS.fishing();
        String fishLvl = String.valueOf(fish.getLevel());
        fishingLabel.setText(fishLvl);

        //FIREMAKING
        Skill fire = gS.firemaking();
        String fireLevel = String.valueOf(fire.getLevel());
        firemakingLabel.setText(fireLevel);

        //CRAFTING
        Skill craft = gS.crafting();
        String craftLevel = String.valueOf(craft.getLevel());
        craftingLabel.setText(craftLevel);

        //SMITHING
        Skill smith = gS.smithing();
        String smithLevel = String.valueOf(smith.getLevel());
        smithingLabel.setText(smithLevel);

        //MINING
        Skill mine = gS.mining();
        String mineLevel = String.valueOf(mine.getLevel());
        miningLabel.setText(mineLevel);

        //HERBLORE
        Skill herb = gS.herblore();
        String herbLevel = String.valueOf(herb.getLevel());
        herbloreLabel.setText(herbLevel);

        //AGILITY
        Skill agile = gS.agility();
        String agileLevel = String.valueOf(agile.getLevel());
        agilityLabel.setText(agileLevel);

        //THIEVING
        Skill thieve = gS.thieving();
        String thieveLevel = String.valueOf(thieve.getLevel());
        thievingLabel.setText(thieveLevel);

        //SLAYER
        Skill slay = gS.slayer();
        String slayLevel = String.valueOf(slay.getLevel());
        slayerLabel.setText(slayLevel);

        //FARMING
        Skill farm = gS.farming();
        String farmLevel = String.valueOf(farm.getLevel());
        farmingLabel.setText(farmLevel);

        //RUNECRAFTING
        Skill rc = gS.runecrafting();
        String rcLevel = String.valueOf(rc.getLevel());
        rcLabel.setText(rcLevel);

        //HUNTER
        Skill hunt = gS.hunter();
        String huntLevel = String.valueOf(hunt.getLevel());
        hunterLabel.setText(huntLevel);

        //CONSTRUCTION
        Skill cons = gS.construction();
        String consLevel = String.valueOf(cons.getLevel());
        constructionLabel.setText(consLevel);

        Skill overall = gS.overall();
        String overallLevel = String.valueOf(overall.getLevel());
        overallSkill.setText(overallLevel);
    }




    // Funtions for the opening of individual skill pages

    public void openAgility(MouseEvent event) throws IOException {
        openPage(event, "agility");
    }
    public void openAttack(MouseEvent event) throws IOException {
        openPage(event, "attack");
    }
    public void openCons(MouseEvent event) throws IOException {
        openPage(event, "construction");
    }
    public void openCooking(MouseEvent event) throws IOException {
        openPage(event, "cooking");
    }
    public void openCrafting(MouseEvent event) throws IOException {
        openPage(event, "crafting");
    }
    public void openDefence(MouseEvent event) throws IOException {
        openPage(event, "defence");
    }
    public void openFarming(MouseEvent event) throws IOException {
        openPage(event, "farming");
    }
    public void openFiremaking(MouseEvent event) throws IOException {
        openPage(event, "firemaking");
    }
    public void openFishing(MouseEvent event) throws IOException {
        openPage(event, "fishing");
    }
    public void openFletching(MouseEvent event) throws IOException {
        openPage(event, "fletching");
    }
    public void openHerblore(MouseEvent event) throws IOException {
        openPage(event, "herblore");
    }
    public void openHitpoints(MouseEvent event) throws IOException {
        openPage(event, "hitpoints");
    }
    public void openHunter(MouseEvent event) throws IOException {
        openPage(event, "hunter");
    }
    public void openMagic(MouseEvent event) throws IOException {
        openPage(event, "magic");
    }
    public void openMining(MouseEvent event) throws IOException {
        openPage(event, "mining");
    }
    public void openPrayer(MouseEvent event) throws IOException {
        openPage(event, "prayer");
    }
    public void openRanged(MouseEvent event) throws IOException {
        openPage(event, "ranged");
    }
    public void openRC(MouseEvent event) throws IOException {
        openPage(event, "runecrafting");
    }
    public void openSlayer(MouseEvent event) throws IOException {
        openPage(event, "slayer");
    }
    public void openSmithing(MouseEvent event) throws IOException {
        openPage(event, "smithing");
    }
    public void openStrength(MouseEvent event) throws IOException {
        openPage(event, "strength");
    }
    public void openThieving(MouseEvent event) throws IOException {
        openPage(event, "thieving");
    }
    public void openWoodcutting(MouseEvent event) throws IOException {
        openPage(event, "woodcutting");
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
        vbox.setEffect(gaussianBlur);
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
            pause.setOnFinished(e ->{
                GaussianBlur endGaus = new GaussianBlur();       
                gaussianBlur.setRadius(0); 
                vbox.setEffect(gaussianBlur);
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
            pop.text.setStyle("-fx-text-fill: #F02D3A");
            pop.yes.setVisible(true);
            pop.no.setVisible(true);
            pop.warning.setVisible(true);
            window.show();
            
            // Control what happens when the user clicks the yes button
            // Will remove from JSON when completed
            pop.yes.setOnAction(e1 ->{
                fadeOut(pop.pane);
                PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
                pause.setOnFinished(e ->{
                    GaussianBlur endGaus = new GaussianBlur();       
                    gaussianBlur.setRadius(0); 
                    vbox.setEffect(gaussianBlur);
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
                    vbox.setEffect(gaussianBlur);
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
            pop.text.setStyle("-fx-text-fill: #F02D3A; -fx-font-size:14px;");
            window.show();
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(e ->{
                GaussianBlur endGaus = new GaussianBlur();       
                gaussianBlur.setRadius(0); 
                vbox.setEffect(gaussianBlur);
                window.close();
            });
            
            pause.play();
    }
    

    }

   
}
