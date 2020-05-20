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
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.concurrent.Task;
import javafx.fxml.Initializable;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import static javafx.util.Duration.millis;
import static javafx.util.Duration.seconds;


public class searchUserHome extends pageOpener implements Initializable{


    @FXML public ImageView logo;
    @FXML public JFXButton search;
    @FXML public TextField username;
    @FXML public Label textUsername;
    @FXML public Label error;
    @FXML public BorderPane borderpane;


    public void enterKey(ActionEvent event) {
        username.setOnKeyReleased(e -> {
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
        
//        RotateTransition rt = new RotateTransition(Duration.millis(700), logo);
//        rt.setByAngle(360);
//        rt.setCycleCount(1);
//        rt.setInterpolator(Interpolator.LINEAR);
        
        ScaleTransition st = new ScaleTransition(Duration.millis(700), logo);
        st.setByX(0.6f);
        st.setByY(0.6f);
        st.setCycleCount(1);
        st.setAutoReverse(false);
        st.play();
        ParallelTransition parat = new ParallelTransition(st);
        
        
        // Open popup
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/popUpSaveUser.fxml"));
        Parent root = (Parent)loader.load();
        // Blur the back logo, blur and pulse it, gives effect of glow behind front image as loading icon
        saveUserPopup pop = loader.getController(); 
        GaussianBlur gauss = new GaussianBlur();       
        gauss.setRadius(20.5); 
        pop.backLogo.setEffect(gauss);
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
     
        String user = username.getText();
        
        
        PauseTransition pt = new PauseTransition(millis(200));
        pt.setOnFinished(e->{
            try{
                Task<User> mytask = new Task(){  
                    @Override
                    protected User call() {
                        HiscoresLookup hsl = new HiscoresLookup();
                        User searchedUser = null;
                        try {
                            System.out.println("booting user");
                            searchedUser = hsl.boot(user);
                        } catch (IOException ex) {
                            System.out.println("What");
                            Logger.getLogger(searchUserHome.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        return searchedUser;
                        
                    }
                };
                mytask.setOnSucceeded(e1->{
                    window.close();
                    getSkills.setUser(mytask.getValue());
                    try {
                        exitSkill(event);
                    } catch (Exception ex) {
                        try {
                            reRun(event);
                        } catch (IOException ex1) {
                            Logger.getLogger(searchUserHome.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                        Logger.getLogger(searchUserHome.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                mytask.setOnFailed(e2->{
                    window.close();
                    try {
                        System.out.println(e2.getSource());
                        reRun(event);
                    } catch (IOException ex) {
                        Logger.getLogger(searchUserHome.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                new Thread(mytask).start();

            }catch(Exception e1){
                System.out.println(e1);
            }
        });

        
        //On finish of rotate
        parat.setOnFinished(e1->{
            logo.setVisible(false);
     
                pt.play();
        });
        parat.play();
        

        

    }

    
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
