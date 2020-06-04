package src.sample;

import com.jfoenix.controls.JFXButton;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.concurrent.Task;
import javafx.fxml.Initializable;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import static javafx.util.Duration.millis;


public class searchUserHome extends pageOpener implements Initializable{


    @FXML public ImageView logo;
    @FXML public JFXButton search;
    @FXML public TextField username;
    @FXML public Label textUsername;
    @FXML public Label error;
    @FXML public BorderPane borderpane;
    @FXML public AnchorPane loadingPane;
    @FXML public ImageView loadingImage;


    public void enterKey(ActionEvent event) {
        username.setOnKeyReleased(e -> {
            username.setVisible(false);
            username.setVisible(true);
            username.requestFocus();
                    if (e.getCode().equals(KeyCode.ENTER)) {
                        search.fire();
                    }
                }
        );
    }


    public void openStage(ActionEvent event) throws IOException{
        // Style homepage for popup
        borderpane.requestFocus();
        GaussianBlur gaussianBlur = new GaussianBlur();       
        gaussianBlur.setRadius(20.5); 
        borderpane.setEffect(gaussianBlur);
        logo.setVisible(false);
        
        loadingPane.setVisible(true);
        pulse(loadingImage);

        String user = username.getText();
        
        // Check if user is saved, set a boolean number
        int isSaved = 0;
        for(User v : LoadAndSave.getUsers()){
            // If a match is found set the user to the saved user and open all skills
            if(v.username.equals(user)){
                isSaved = 1;
                getSkills.setUser(v);
                exitSkill(event);
            }
        }
        
        // If the User is not saved
        if(isSaved == 0){
            PauseTransition pt = new PauseTransition(millis(100));
            pt.setOnFinished(e->{
                try{
                    // Task to get user data in the background 
                    Task<User> mytask = new Task(){  
                        @Override
                        protected User call() {
                            HiscoresLookup hsl = new HiscoresLookup();
                            User searchedUser = null;
                            try {
                                searchedUser = hsl.boot(user);
                            } catch (IOException ex) {
                                Logger.getLogger(searchUserHome.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            return searchedUser;

                        }
                    };
                    // If the task succeeds, set the user returned from the task
                    mytask.setOnSucceeded(e1->{
                        getSkills.setUser(mytask.getValue());
                        try {
                            // Open the all skills page
                            exitSkill(event);
                        } catch (Exception ex) {
                            try {
                                // If this fails, open the home page
                                reRun(event);
                            } catch (IOException ex1) {
                                Logger.getLogger(searchUserHome.class.getName()).log(Level.SEVERE, null, ex1);
                            }
                            Logger.getLogger(searchUserHome.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                    // If the task failes print the error and go back to the home page
                    mytask.setOnFailed(e2->{
                        try {
                            System.out.println(e2.getSource());
                            reRun(event);
                        } catch (IOException ex) {
                            Logger.getLogger(searchUserHome.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });

                    // Start the task
                    new Thread(mytask).start();

                }catch(Exception e1){
                    System.out.println(e1);
                }
            });
            pt.play();
        }
    }

    // If the search fails return to the home screen and display the error message
    public void reRun(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/searchUserHome.fxml"));
        Parent root = (Parent) loader.load();
        searchUserHome sh = loader.getController();
        sh.error.setVisible(true);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/assets/stylesheethome.css").toExternalForm());
        window.setScene(scene);
        window.hide();
        window.show();
    }
    
   
    public void pulse(){
        ScaleTransition st = new ScaleTransition(Duration.millis(700), logo);
        st.setByX(0.04f);
        st.setByY(0.04f);
        st.setCycleCount(Animation.INDEFINITE);
        st.setAutoReverse(true);
        st.play();
    }

    public void removeFocus(){
        username.setFocusTraversable(false);
    }


    public void clearTextField(MouseEvent event){
        username.setText("");
    }
    
    public void focusOff(MouseEvent event){
        borderpane.requestFocus();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pulse();
        
    }
    
}
