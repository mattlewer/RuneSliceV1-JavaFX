package src.sample;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import static javafx.util.Duration.millis;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        // Load our saved users from JSON if any exist  
        LoadAndSave lns = new LoadAndSave();
        lns.loadUsers();
        
        // Starts our application and loads the FXML
        
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/splashScreen.fxml"));
        Parent root = (Parent)loader.load();
        SplashScreenController splash = loader.getController();
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        
        // Set the size of our app the the size of the users screen
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        
        // Pause to show splash screen
        primaryStage.show();
        PauseTransition pt = new PauseTransition(millis(200));
        
        // Fade for removing splash screen
        FadeTransition ft = new FadeTransition(Duration.millis(2000));
        ft.setNode(splash.hbox);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setOnFinished(e1->{
           
            try {
                newstage();
                primaryStage.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        // On pause finish...
        pt.setOnFinished(e->{
            try {
                // Update saved users
                lns.updateUsers();
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                 splash.progress.setText("ERROR: No Connection Found");
            }
            // Close splash screen and show Homepage
            ft.play();
        });
        pt.play();
     
        
        

    }
    
    
    // Open Homepage
    public void newstage() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/assets/searchUserHome.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/assets/stylesheethome.css").toExternalForm());
        Stage window = new Stage();
        window.setScene(scene);
        // Set the size of our app the the size of the users screen
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        window.setX(bounds.getMinX());
        window.setY(bounds.getMinY());
        window.setWidth(bounds.getWidth());
        window.setHeight(bounds.getHeight());

        // Ensure no element is focused upon loading
        root.requestFocus();
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
