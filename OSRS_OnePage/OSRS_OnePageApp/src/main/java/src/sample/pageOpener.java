package src.sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class pageOpener {

    public HashMap<String, Skill> myskills;


    public void openAllSkills(ActionEvent event, String account) throws IOException {
        String acc = account;
        if(acc.length() > 0) {
            getSkills getMySkills = new getSkills();
            myskills = getMySkills.searchAndRetrieveSkills(acc);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/allSkillHome.fxml"));
            Parent root = (Parent) loader.load();
            
            allSkillHome allSkill = loader.getController();
            allSkill.myFunction(myskills, acc);
            
            fade(allSkill.vbox);
            
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();            
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/assets/allSkillStyle.css").toExternalForm());
            window.setScene(scene);
            window.hide();
            window.show();
            
        }
        else{
            searchUserHome sc = new searchUserHome();
            sc.myskills.clear();
            sc.reRun(event);

        }

    }

    public void openPage(MouseEvent event, String whichPage, HashMap<String, Skill> skills, String user) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/WIP.fxml"));
        Parent root = (Parent) loader.load();
        
        skillPageController skillPage = loader.getController();

        if(null != whichPage)switch (whichPage) {
            case "agility": 
                getSkills agilitySkills = new getSkills();
                Skill ag = agilitySkills.agility(skills);
                skillPageController agile = loader.getController();
                agile.myFunction(skills, ag, user, "Agility", "/assets/Agility_icon.png");
                fade(agile.vbox);
                break;
            case "attack":
                getSkills attackSkills = new getSkills();
                Skill at = attackSkills.attack(skills);
                skillPageController attk = loader.getController();
                attk.myFunction(skills, at, user, "Attack", "/assets/Attack_icon.png");
                fade(attk.vbox);
                break;
            case "construction":
                getSkills consSkills = new getSkills();
                Skill con = consSkills.construction(skills);
                skillPageController cons = loader.getController();
                cons.myFunction(skills, con, user, "Construction", "/assets/Construction_icon.png");
                fade(cons.vbox);
                break;
            case "cooking":
                getSkills cookSkill = new getSkills();
                Skill coo = cookSkill.cooking(skills);
                skillPageController cook = loader.getController();
                cook.myFunction(skills, coo, user, "Cooking", "/assets/Cooking_icon.png");
                fade(cook.vbox);
                break;
            case "crafting":
                getSkills craftSkills = new getSkills();
                Skill cr = craftSkills.crafting(skills);
                skillPageController craft = loader.getController();
                craft.myFunction(skills, cr, user, "Crafting", "/assets/Crafting_icon.png");
                fade(craft.vbox);
                break;
            case "defence":
                getSkills defSkills = new getSkills();
                Skill de = defSkills.defense(skills);
                skillPageController defence = loader.getController();
                defence.myFunction(skills, de, user, "Defence", "/assets/Defence_icon.png");
                fade(defence.vbox);
                break;
            case "farming":
                getSkills farmSkills = new getSkills();
                Skill fa = farmSkills.farming(skills);
                skillPageController farm = loader.getController();
                farm.myFunction(skills, fa, user, "Farming", "/assets/Farming_icon.png");
                fade(farm.vbox);
                break;
            case "firemaking":
                getSkills fireSkill = new getSkills();
                Skill fi = fireSkill.firemaking(skills);
                skillPageController fire = loader.getController();
                fire.myFunction(skills, fi, user, "Firemaking", "/assets/Firemaking_icon.png");
                fade(fire.vbox);
                break;
            case "fishing":
                getSkills fishSkill = new getSkills();
                Skill fis = fishSkill.fishing(skills);
                skillPageController fish = loader.getController();
                fish.myFunction(skills, fis, user, "Fishing", "/assets/Fishing_icon.png");
                fade(fish.vbox);
                break;
            case "fletching":
                getSkills fletchSkill = new getSkills();
                Skill fle = fletchSkill.fletching(skills);
                skillPageController fletch = loader.getController();
                fletch.myFunction(skills, fle, user, "Fletching", "/assets/Fletching_icon.png");
                fade(fletch.vbox);
                break;
            case "herblore":
                getSkills herbSkills = new getSkills();
                Skill hrb = herbSkills.herblore(skills);
                skillPageController herb = loader.getController();
                herb.myFunction(skills, hrb, user, "Herblore", "/assets/Herblore_icon.png");
                fade(herb.vbox);
                break;
            case "hitpoints":
                getSkills hpSkill = new getSkills();
                Skill hp = hpSkill.hitpoints(skills);
                skillPageController hit = loader.getController();
                hit.myFunction(skills, hp, user, "Hitpoints", "/assets/Hitpoints_icon.png");
                fade(hit.vbox);
                break;
            case "hunter":
                getSkills huntSkill = new getSkills();
                Skill hu = huntSkill.hunter(skills);
                skillPageController hunter = loader.getController();
                hunter.myFunction(skills, hu, user, "Hunter", "/assets/Hunter_icon.png");
                fade(hunter.vbox);
                break;
            case "magic":
                getSkills magicSkill = new getSkills();
                Skill ma = magicSkill.magic(skills);
                skillPageController magic = loader.getController();
                magic.myFunction(skills, ma, user, "Magic", "/assets/Magic_icon.png");
                fade(magic.vbox);
                break;
            case "mining":
                getSkills mineSkill = new getSkills();
                Skill min = mineSkill.mining(skills);
                skillPageController mining = loader.getController();
                mining.myFunction(skills, min, user, "Mining", "/assets/Mining_icon.png");
                fade(mining.vbox);
                break;
            case "prayer":
                getSkills prayerSkill = new getSkills();
                Skill pr = prayerSkill.prayer(skills);
                skillPageController prayer = loader.getController();
                prayer.myFunction(skills, pr, user, "Prayer", "/assets/Prayer_icon.png");
                fade(prayer.vbox);
                break;
            case "ranged":
                getSkills rangedSkill = new getSkills();
                Skill rn = rangedSkill.ranged(skills);
                skillPageController ranged = loader.getController();
                ranged.myFunction(skills, rn, user, "Ranged", "/assets/Ranged_icon.png");
                fade(ranged.vbox);
                break;
            case "runecrafting":
                getSkills rcSkill = new getSkills();
                Skill rc = rcSkill.runecrafting(skills);
                skillPageController runecrafting = loader.getController();
                runecrafting.myFunction(skills, rc, user, "Runecrafting", "/assets/Runecraft_icon.png");
                fade(runecrafting.vbox);
                break;
            case "slayer":
                getSkills slaySkill = new getSkills();
                Skill sla = slaySkill.slayer(skills);
                skillPageController slayer = loader.getController();
                slayer.myFunction(skills, sla, user, "Slayer", "/assets/Slayer_icon.png");
                fade(slayer.vbox);
                break;
            case "smithing":
                getSkills smithSkill = new getSkills();
                Skill smi = smithSkill.smithing(skills);
                skillPageController smith = loader.getController();
                smith.myFunction(skills, smi, user, "Smithing", "/assets/Smithing_icon.png");
                fade(smith.vbox);
                break;
            case "strength":
                getSkills strengthSkill = new getSkills();
                Skill str = strengthSkill.strength(skills);
                skillPageController strength = loader.getController();
                strength.myFunction(skills, str, user, "Strength", "/assets/Strength_icon.png");
                fade(strength.vbox);
                break;
            case "thieving":
                getSkills thievSkill = new getSkills();
                Skill thi = thievSkill.thieving(skills);
                skillPageController thieving = loader.getController();
                thieving.myFunction(skills, thi, user, "Thieving", "/assets/Thieving_icon.png");
                fade(thieving.vbox);
                break;
            case "woodcutting":
                getSkills woodcuttingSkill = new getSkills();
                Skill wc = woodcuttingSkill.woodcutting(skills);
                skillPageController woodcutting = loader.getController();
                woodcutting.myFunction(skills, wc, user, "Woodcutting", "/assets/Woodcutting_icon.png");
                fade(woodcutting.vbox);
                break;
            default:
                break;
        }

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/assets/skillStyle.css").toExternalForm());
        window.setScene(scene);
        window.hide();
        window.show();
    }
    
    
    public void searchNewUser(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/searchUserHome.fxml"));
        Parent root = (Parent) loader.load();
        searchUserHome sec = loader.getController();
        fade(sec.gridpane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
        
        scene.getStylesheets().add(getClass().getResource("/assets/stylesheethome.css").toExternalForm());
        window.setScene(scene);
        window.hide();
        window.show();
    }

    public void exitSkill(ActionEvent event,  HashMap<String, Skill> allSkills, String username) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/allSkillHome.fxml"));
        Parent root = (Parent)loader.load();
        allSkillHome sec = loader.getController();
        sec.myFunction(allSkills, username);
        fade(sec.vbox);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/assets/allSkillStyle.css").toExternalForm());
        window.setScene(scene);
        window.hide();
        window.show();
    }
    
 
    public void openSavedUsers(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/mySavedUsers.fxml"));
        Parent root = (Parent)loader.load();
        mySavedUsers sec = loader.getController();
        fade(sec.gridpane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/assets/mySavedUsersStyle.css").toExternalForm());
        window.setScene(scene);
        window.hide();
        window.show();
    }
    
   
    
    public void fade(Node node){
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }
    
    public void fadeOut(Node node){
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play();
    }
}
