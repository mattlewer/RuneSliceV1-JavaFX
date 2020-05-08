    package src.sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
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
    @FXML private ImageView hpImage;
    
    @FXML public VBox vbox;

    @FXML Label usernameLabel;

    public HashMap<String, Skill> allSkills;
    public String username;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void myFunction(HashMap<String, Skill> skills, String user){

        username = user;
        usernameLabel.setText(username);
        allSkills = skills;
        System.out.println(allSkills);
        getSkills getMySkills = new getSkills();

        //HP
        Skill hp = getMySkills.hitpoints(allSkills);
        String hpLevel = String.valueOf(hp.getLevel());
        hitpointsLabel.setText(hpLevel);

        //DEFENSE
        Skill def = getMySkills.defense(allSkills);
        String defLevel = String.valueOf(def.getLevel());
        defenseLabel.setText(defLevel);

        //STRENGTH
        Skill str = getMySkills.strength(allSkills);
        String strLevel = String.valueOf(str.getLevel());
        strengthLabel.setText(strLevel);

        //ATTACK
        Skill attk = getMySkills.attack(allSkills);
        String attkLevel = String.valueOf(attk.getLevel());
        attackLabel.setText(attkLevel);

        //RANGED
        Skill ranged = getMySkills.ranged(allSkills);
        String rangeLevel = String.valueOf(ranged.getLevel());
        rangedLabel.setText(rangeLevel);

        //PRAYER
        Skill prayer = getMySkills.prayer(allSkills);
        String prayerLevel = String.valueOf(prayer.getLevel());
        prayerLabel.setText(prayerLevel);

        //MAGIC
        Skill mage = getMySkills.magic(allSkills);
        String mageLevel = String.valueOf(mage.getLevel());
        magicLabel.setText(mageLevel);

        //COOKING
        Skill cook = getMySkills.cooking(allSkills);
        String cookLevel = String.valueOf(cook.getLevel());
        cookingLabel.setText(cookLevel);

        //WOODCUTTING
        Skill wc = getMySkills.woodcutting(allSkills);
        String wcLevel = String.valueOf(wc.getLevel());
        wcLabel.setText(wcLevel);

        //FLETCHING
        Skill fletch = getMySkills.fletching(allSkills);
        String fletchLevel = String.valueOf(fletch.getLevel());
        fletchingLabel.setText(fletchLevel);

        //FISHING
        Skill fish = getMySkills.fishing(allSkills);
        String fishLvl = String.valueOf(fish.getLevel());
        fishingLabel.setText(fishLvl);

        //FIREMAKING
        Skill fire = getMySkills.firemaking(allSkills);
        String fireLevel = String.valueOf(fire.getLevel());
        firemakingLabel.setText(fireLevel);

        //CRAFTING
        Skill craft = getMySkills.crafting(allSkills);
        String craftLevel = String.valueOf(craft.getLevel());
        craftingLabel.setText(craftLevel);

        //SMITHING
        Skill smith = getMySkills.smithing(allSkills);
        String smithLevel = String.valueOf(smith.getLevel());
        smithingLabel.setText(smithLevel);

        //MINING
        Skill mine = getMySkills.mining(allSkills);
        String mineLevel = String.valueOf(mine.getLevel());
        miningLabel.setText(mineLevel);

        //HERBLORE
        Skill herb = getMySkills.herblore(allSkills);
        String herbLevel = String.valueOf(herb.getLevel());
        herbloreLabel.setText(herbLevel);

        //AGILITY
        Skill agile = getMySkills.agility(allSkills);
        String agileLevel = String.valueOf(agile.getLevel());
        agilityLabel.setText(agileLevel);

        //THIEVING
        Skill thieve = getMySkills.thieving(allSkills);
        String thieveLevel = String.valueOf(thieve.getLevel());
        thievingLabel.setText(thieveLevel);

        //SLAYER
        Skill slay = getMySkills.slayer(allSkills);
        String slayLevel = String.valueOf(slay.getLevel());
        slayerLabel.setText(slayLevel);

        //FARMING
        Skill farm = getMySkills.farming(allSkills);
        String farmLevel = String.valueOf(farm.getLevel());
        farmingLabel.setText(farmLevel);

        //RUNECRAFTING
        Skill rc = getMySkills.runecrafting(allSkills);
        String rcLevel = String.valueOf(rc.getLevel());
        rcLabel.setText(rcLevel);

        //HUNTER
        Skill hunt = getMySkills.hunter(allSkills);
        String huntLevel = String.valueOf(hunt.getLevel());
        hunterLabel.setText(huntLevel);

        //CONSTRUCTION
        Skill cons = getMySkills.construction(allSkills);
        String consLevel = String.valueOf(cons.getLevel());
        constructionLabel.setText(consLevel);

        Skill overall = getMySkills.overall(allSkills);
        String overallLevel = String.valueOf(overall.getLevel());
        overallSkill.setText(overallLevel);
    }





    public void openAgility(MouseEvent event) throws IOException {
        openPage(event, "agility" , allSkills, username );
    }


    public void openAttack(MouseEvent event) throws IOException {
        openPage(event, "attack", allSkills, username );
    }

    public void openCons(MouseEvent event) throws IOException {
        openPage(event, "construction", allSkills, username );
    }

    public void openCooking(MouseEvent event) throws IOException {
        openPage(event, "cooking", allSkills, username);
    }
    public void openCrafting(MouseEvent event) throws IOException {
        openPage(event, "crafting", allSkills, username);
    }
    public void openDefence(MouseEvent event) throws IOException {
        openPage(event, "defence", allSkills,username );
    }
    public void openFarming(MouseEvent event) throws IOException {
        openPage(event, "farming", allSkills,username );
    }
    public void openFiremaking(MouseEvent event) throws IOException {
        openPage(event, "firemaking", allSkills, username );
    }
    public void openFishing(MouseEvent event) throws IOException {
        openPage(event, "fishing", allSkills, username );
    }
    public void openFletching(MouseEvent event) throws IOException {
        openPage(event, "fletching", allSkills, username );
    }
    public void openHerblore(MouseEvent event) throws IOException {
        openPage(event, "herblore", allSkills, username );
    }
    public void openHitpoints(MouseEvent event) throws IOException {
        openPage(event, "hitpoints", allSkills, username );
    }
    public void openHunter(MouseEvent event) throws IOException {
        openPage(event, "hunter", allSkills,  username );
    }
    public void openMagic(MouseEvent event) throws IOException {
        openPage(event, "magic", allSkills, username );
    }
    public void openMining(MouseEvent event) throws IOException {
        openPage(event, "mining", allSkills, username );
    }
    public void openPrayer(MouseEvent event) throws IOException {
        openPage(event, "prayer", allSkills, username);
    }
    public void openRanged(MouseEvent event) throws IOException {
        openPage(event, "ranged", allSkills,  username );
    }
    public void openRC(MouseEvent event) throws IOException {
        openPage(event, "runecrafting", allSkills, username );
    }
    public void openSlayer(MouseEvent event) throws IOException {
        openPage(event, "slayer", allSkills, username );
    }
    public void openSmithing(MouseEvent event) throws IOException {
        openPage(event, "smithing", allSkills, username );
    }
    public void openStrength(MouseEvent event) throws IOException {
        openPage(event, "strength", allSkills, username );
    }
    public void openThieving(MouseEvent event) throws IOException {
        openPage(event, "thieving", allSkills, username );
    }
    public void openWoodcutting(MouseEvent event) throws IOException {
        openPage(event, "woodcutting", allSkills, username );
    }

    
    public boolean issaved = false;
    public void saveUser(MouseEvent event) throws IOException{
        if (issaved == false){
            openPopupNewSave(event);
            Image image = new Image("/assets/star_filled.png");
            saved.setImage(image);
            
        }else{
            openPopupNewSave(event);
            
        }
    }
    
    public void openPopupNewSave(MouseEvent event) throws IOException{
        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/popUpSaveUser.fxml"));
        Parent root = (Parent)loader.load();
        GaussianBlur gaussianBlur = new GaussianBlur();       
        gaussianBlur.setRadius(10.5); 
        vbox.setEffect(gaussianBlur);
        saveUserPopup pop = loader.getController(); 
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/assets/saveUserPopupStyle.css").toExternalForm());
        Stage window = new Stage();
        window.initStyle(StageStyle.TRANSPARENT);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
     
        if(issaved == false){
            fadeOut(pop.pane);
            window.show();
            PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
            pause.setOnFinished(e ->{
                GaussianBlur endGaus = new GaussianBlur();       
                gaussianBlur.setRadius(0); 
                vbox.setEffect(gaussianBlur);
                issaved = true;
                window.close();
            });
            
            pause.play();
        }else{
            pop.text.setText("Are you sure?");
            pop.text.setStyle("-fx-text-fill: #F02D3A");
            pop.yes.setVisible(true);
            pop.no.setVisible(true);
            pop.warning.setVisible(true);
            window.show();
            
            
            
            
            
            pop.yes.setOnAction(e1 ->{
                fadeOut(pop.pane);
                PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
                pause.setOnFinished(e ->{
                    GaussianBlur endGaus = new GaussianBlur();       
                    gaussianBlur.setRadius(0); 
                    vbox.setEffect(gaussianBlur);
                    Image image = new Image("/assets/star.png");
                    saved.setImage(image);
                    issaved = false;
                    window.close();
                });
                pause.play();
            });
            
            
            pop.no.setOnAction(e->{
                fadeOut(pop.pane);
                PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
                pause.setOnFinished(ei ->{
                    GaussianBlur endGaus = new GaussianBlur();       
                    gaussianBlur.setRadius(0); 
                    vbox.setEffect(gaussianBlur);
                    Image image = new Image("/assets/star_filled.png");
                    saved.setImage(image);
                    issaved = true;
                    window.close();
                });
                pause.play();
            });
        }
    }




    public HashMap<String, Skill> getAllSkills() {
        return allSkills;
    }

    public void setAllSkills(HashMap<String, Skill> allSkills) {
        this.allSkills = allSkills;
    }
}
