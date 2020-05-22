/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sample;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author mlewe
 */
public class SettingsController extends pageOpener{
    public BorderPane borderpane;
    public Button removeUser;
    public Button returnToHome;
    
    public void removeUsers() throws IOException{
        // Open popup
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/popUpSaveUser.fxml"));
        Parent root = (Parent)loader.load();
        // Blur the back logo, blur and pulse it, gives effect of glow behind front image as loading icon
        saveUserPopup pop = loader.getController(); 
        GaussianBlur gauss = new GaussianBlur();       
        gauss.setRadius(20.5); 
        borderpane.setEffect(gauss);
        borderpane.setOpacity(0.25);
        pop.backLogo.setEffect(gauss);
        Scene scene = new Scene(root);
        Stage window = new Stage();
        // Load pop-up as trasparent so it appears to float over the blurred scene, no toolbar
        window.initStyle(StageStyle.TRANSPARENT);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        pulse(pop.backLogo);
        pop.text.setText("Are you sure?");
        pop.text.setStyle("-fx-font-weight:bold; -fx-text-fill:#F02D3A;");
        pop.yes.setVisible(true);
        pop.no.setVisible(true);
        pop.warning.setVisible(true);
        pop.warning.setText("WARNING:\nAll data will be removed!");
        pop.warning.setStyle("-fx-font-size:13px;-fx-text-fill: #F02D3A;");
        pop.ancpane.requestFocus();
        window.show();
        
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(pop.ancpane);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setOnFinished(e3->{
           window.close();
           borderpane.setEffect(null);
           borderpane.setOpacity(1);
        });
        
        LoadAndSave lns = new LoadAndSave();
        pop.yes.setOnAction(e1->{
            try {
                lns.removeAllUsers();
            } catch (IOException ex) {
                Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            pop.text.setText("Users Removed");
            pop.warning.setVisible(false);
            pop.yes.setVisible(false);
            pop.no.setVisible(false);
            ft.play();
    
            
        });
        pop.no.setOnAction(e2->{
           ft.play();
          
  
        });
        
        
        
        
        
        
    }
    
    

}
