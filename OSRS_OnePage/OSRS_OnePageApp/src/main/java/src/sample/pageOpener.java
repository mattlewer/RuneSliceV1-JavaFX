package src.sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import static javafx.util.Duration.seconds;

public class pageOpener {    
    
    // Open chosen skill page through image or level on 'All Skill' home
    public void openPage(MouseEvent event, String whichPage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/WIP.fxml"));
        Parent root = (Parent) loader.load();
        
        getSkills gs = new getSkills();
        skillPageController sPC = loader.getController();
        
        // Each page will take its section of relevant data from the users Skills
        // Along with this an image to be displayed
        if(null != whichPage)switch (whichPage) {
            case "agility": 
                sPC.myFunction(gs.agility(), "Agility", "/assets/images/Agility_icon.png");
                break;
            case "attack":
                sPC.myFunction(gs.attack(), "Attack", "/assets/images/Attack_icon.png");
                break;
            case "construction":
                sPC.myFunction(gs.construction(), "Construction", "/assets/images/Construction_icon.png");
                break;
            case "cooking":
                sPC.myFunction(gs.cooking(), "Cooking", "/assets/images/Cooking_icon.png");
                break;
            case "crafting":
                sPC.myFunction(gs.crafting(), "Crafting", "/assets/images/Crafting_icon.png");
                break;
            case "defence":
                sPC.myFunction(gs.defense(), "Defence", "/assets/images/Defence_icon.png");
                break;
            case "farming":
                sPC.myFunction(gs.farming(), "Farming", "/assets/images/Farming_icon.png");
                break;
            case "firemaking":
                sPC.myFunction(gs.firemaking(), "Firemaking", "/assets/images/Firemaking_icon.png");
                break;
            case "fishing":
                sPC.myFunction(gs.fishing(), "Fishing", "/assets/images/Fishing_icon.png");
                break;
            case "fletching":
                sPC.myFunction(gs.fletching(), "Fletching", "/assets/images/Fletching_icon.png");
                break;
            case "herblore":
                sPC.myFunction(gs.herblore(), "Herblore", "/assets/images/Herblore_icon.png");
                break;
            case "hitpoints":
                sPC.myFunction(gs.hitpoints(), "Hitpoints", "/assets/images/Hitpoints_icon.png");
                break;
            case "hunter":
                sPC.myFunction(gs.hunter(), "Hunter", "/assets/images/Hunter_icon.png");
                break;
            case "magic":
                sPC.myFunction(gs.magic(), "Magic", "/assets/images/Magic_icon.png");
                break;
            case "mining":
                sPC.myFunction(gs.mining(), "Mining", "/assets/images/Mining_icon.png");
                break;
            case "prayer":
                sPC.myFunction(gs.prayer(), "Prayer", "/assets/images/Prayer_icon.png");
                break;
            case "ranged":
                sPC.myFunction(gs.ranged(), "Ranged", "/assets/images/Ranged_icon.png");
                break;
            case "runecrafting":
                sPC.myFunction(gs.runecrafting(), "Runecrafting", "/assets/images/Runecraft_icon.png");
                break;
            case "slayer":
                sPC.myFunction(gs.slayer(), "Slayer", "/assets/images/Slayer_icon.png");
                break;
            case "smithing":
                sPC.myFunction(gs.smithing(), "Smithing", "/assets/images/Smithing_icon.png");
                break;
            case "strength":
                sPC.myFunction(gs.strength(), "Strength", "/assets/images/Strength_icon.png");
                break;
            case "thieving":
                sPC.myFunction(gs.thieving(), "Thieving", "/assets/images/Thieving_icon.png");
                break;
            case "woodcutting":
                sPC.myFunction(gs.woodcutting(), "Woodcutting", "/assets/images/Woodcutting_icon.png");
                break;
            default:
                break;
        }
        fade(sPC.borderpane); 
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if(t.getCode()==KeyCode.ESCAPE){
                    sPC.exit.fire();
                }
            }
        });
        scene.getStylesheets().add(getClass().getResource("/assets/skillStyle.css").toExternalForm());
        window.setScene(scene);
        root.requestFocus();
        window.hide();
        window.show();
    }
    
        
    // Exit all Skills and return to the home page
    public void searchNewUser(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/searchUserHome.fxml"));
        Parent root = (Parent) loader.load();
        searchUserHome sec = loader.getController();
        fade(sec.borderpane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root); 
        scene.getStylesheets().add(getClass().getResource("/assets/stylesheethome.css").toExternalForm());
        window.setScene(scene);
        root.requestFocus();
        window.hide();
        window.show();
    }
    
    // View all boss kills for a user
    public void viewAllBosses(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/allBossHome.fxml"));
        Parent root = (Parent) loader.load();
        AllBossHomeController sec = loader.getController();
        sec.myFunction();
        fade(sec.stackpane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root); 
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent t) {
                    if(t.getCode()==KeyCode.ESCAPE){
                        sec.exit.fire();
                    }
                }
            });
        scene.getStylesheets().add(getClass().getResource("/assets/allBossHomeStyle.css").toExternalForm());
        window.setScene(scene);
        root.requestFocus();
        window.hide();
        window.show();
    }
    
    // Show all clue scrolls
    public void viewAllClues(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/userClueScrolls.fxml"));
        Parent root = (Parent) loader.load();
        ClueScrollController sec = loader.getController();
        sec.myFunction();
        fade(sec.gridpane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root); 
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent t) {
                    if(t.getCode()==KeyCode.ESCAPE){
                        sec.exit.fire();
                    }
                }
            });
        scene.getStylesheets().add(getClass().getResource("/assets/userClueScrollStyle.css").toExternalForm());
        window.setScene(scene);
        root.requestFocus();
        window.hide();
        window.show();
    }
    
    
        // Exit each individual skill page back to 'All Skills'
    public void exitSkill(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/allSkillHome.fxml"));
        Parent root = (Parent)loader.load();
        allSkillHome sec = loader.getController();
        sec.myFunction();
        fade(sec.gridpane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if(t.getCode()==KeyCode.ESCAPE){
                    Event.fireEvent(sec.exit, new MouseEvent(MouseEvent.MOUSE_CLICKED,
                            0,0,0,0, MouseButton.PRIMARY,1, true, true, true, true, true, true, true, true, true, true, null));
                }
            }
        });
        scene.getStylesheets().add(getClass().getResource("/assets/allSkillStyle.css").toExternalForm());
        window.setScene(scene);
        root.requestFocus();
        window.hide();
        window.show();
    }

    // Exit each individual skill page back to 'All Skills'
    public void exitSkillMouse(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/allSkillHome.fxml"));
        Parent root = (Parent)loader.load();
        allSkillHome sec = loader.getController();
        sec.myFunction();
        fade(sec.gridpane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if(t.getCode()==KeyCode.ESCAPE){
                    Event.fireEvent(sec.exit, new MouseEvent(MouseEvent.MOUSE_CLICKED,
                            0,0,0,0, MouseButton.PRIMARY,1, true, true, true, true, true, true, true, true, true, true, null));
                }
            }
        });
        scene.getStylesheets().add(getClass().getResource("/assets/allSkillStyle.css").toExternalForm());
        window.setScene(scene);
        root.requestFocus();
        window.hide();
        window.show();
    }
    
 
    // Open page with saved Users
    public void openSavedUsers(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/mySavedUsers.fxml"));
        Parent root = (Parent)loader.load();
        mySavedUsers sec = loader.getController();
        sec.myFunction();
        fade(sec.borderpane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if(t.getCode()==KeyCode.ESCAPE){
                    Event.fireEvent(sec.search, new MouseEvent(MouseEvent.MOUSE_CLICKED,
                            0,0,0,0, MouseButton.PRIMARY,1, true, true, true, true, true, true, true, true, true, true, null));
                }
            }
        });
        scene.getStylesheets().add(getClass().getResource("/assets/mySavedUsersStyle.css").toExternalForm());
        window.setScene(scene);
        root.requestFocus();
        window.hide();
        window.show();
    }
    
    // Open compare users homepage
    public void compareUsersHome(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/compareUserHome.fxml"));
        Parent root = (Parent)loader.load();
        CompareUserHome sec = loader.getController();
        fade(sec.borderpane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if(t.getCode()==KeyCode.ESCAPE){
                    Event.fireEvent(sec.returnToSaved, new MouseEvent(MouseEvent.MOUSE_CLICKED,
                            0,0,0,0, MouseButton.PRIMARY,1, true, true, true, true, true, true, true, true, true, true, null));
                }
            }
        });
        window.setScene(scene);
        root.requestFocus();
        window.hide();
        window.show();
    }
    
    // Open page to compare users skills
    public void compareUsers(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/compareUsersData.fxml"));
        Parent root = (Parent)loader.load();
        CompareUsersController sec = loader.getController();
        
        String text = ((JFXButton)event.getSource()).getText();

        if(text.equals("compare by skill")){
            CompareUsersController.skillOrBoss = 0;
            sec.mySkillFunction();
        }else if (text.equals("compare by boss kills")){
            CompareUsersController.skillOrBoss = 1;
            sec.myBossFunction();
        }else{
            CompareUsersController.skillOrBoss = 3;
            sec.myClueFunction();
        }
        fade(sec.borderpane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if(t.getCode()==KeyCode.ESCAPE){
                    Event.fireEvent(sec.returnToSaved, new MouseEvent(MouseEvent.MOUSE_CLICKED,
                            0,0,0,0, MouseButton.PRIMARY,1, true, true, true, true, true, true, true, true, true, true, null));
                }
            }
        });
        scene.getStylesheets().add(getClass().getResource("/assets/compareUserDataStyle.css").toExternalForm());
        window.setScene(scene);
        root.requestFocus();
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
       public void openInfo(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/infoPage.fxml"));
        Parent root = (Parent)loader.load();
        InfoController sec = loader.getController();
        fade(sec.scrollPane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if(t.getCode()==KeyCode.ESCAPE){
                    Event.fireEvent(sec.returnToHome, new MouseEvent(MouseEvent.MOUSE_CLICKED,
                            0,0,0,0, MouseButton.PRIMARY,1, true, true, true, true, true, true, true, true, true, true, null));
                }
            }
        });
        scene.getStylesheets().add(getClass().getResource("/assets/infoPageStyle.css").toExternalForm());
        window.setScene(scene);
        root.requestFocus();
        window.hide();
        window.show();
    }
    
       public void openContact(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/contactPage.fxml"));
        Parent root = (Parent)loader.load();
        ContactController sec = loader.getController();
        fade(sec.vbox);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if(t.getCode()==KeyCode.ESCAPE){
                    Event.fireEvent(sec.returnToHome, new MouseEvent(MouseEvent.MOUSE_CLICKED,
                            0,0,0,0, MouseButton.PRIMARY,1, true, true, true, true, true, true, true, true, true, true, null));
                }
            }
        });
        scene.getStylesheets().add(getClass().getResource("/assets/contactPageStyle.css").toExternalForm());
        window.setScene(scene);
        root.requestFocus();
        window.hide();
        window.show();
    }
       
       public void openSettings(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/settings.fxml"));
        Parent root = (Parent)loader.load();
        SettingsController sec = loader.getController();
        fade(sec.borderpane);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if(t.getCode()==KeyCode.ESCAPE){
                    Event.fireEvent(sec.returnToHome, new MouseEvent(MouseEvent.MOUSE_CLICKED,
                            0,0,0,0, MouseButton.PRIMARY,1, true, true, true, true, true, true, true, true, true, true, null));
                }
            }
        });
        window.setScene(scene);
        root.requestFocus();
        window.hide();
        window.show();
       }
    
    
    public void fadeOut(Node node){
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play();
    }
    
    public void pulse(Node node){
        ScaleTransition st = new ScaleTransition(Duration.millis(700), node);
        st.setByX(-0.05f);
        st.setByY(-0.05f);
        st.setCycleCount(Animation.INDEFINITE);
        st.setAutoReverse(true);
        st.play();
    }
    
    public void popUpLoading() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/popUpSaveUser.fxml"));
        Parent root = (Parent)loader.load();
        // Blur the backgrund to bring focus to pop-up
        saveUserPopup pop = loader.getController(); 
        GaussianBlur gaussianBlur = new GaussianBlur();       
        gaussianBlur.setRadius(20.5); 
        pop.backLogo.setEffect(gaussianBlur);
        pulse(pop.backLogo);
        
        Scene scene = new Scene(root);
        Stage window = new Stage();
        // Load pop-up as trasparent so it appears to float over the blurred scene, no toolbar
        window.initStyle(StageStyle.TRANSPARENT);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        pop.text.setText("loading");
        pop.text.setStyle("-fx-font-weight:bold; -fx-text-fill:#F02D3A; -fx-font-size:40px;");
        window.show();
        PauseTransition pt = new PauseTransition(seconds(45));
        pt.setOnFinished(e->{
           window.close(); 
        });
        pt.play();
        
    }
    
    
   
}
