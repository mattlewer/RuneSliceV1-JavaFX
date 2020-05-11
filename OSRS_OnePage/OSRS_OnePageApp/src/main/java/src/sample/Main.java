package src.sample;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
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
import static src.sample.LoadAndSave.ROOT_DIR;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        // Get rid of API restriction
        doHorribleHack();
        // Load our saved users from JSON if any exist  
        LoadAndSave lns = new LoadAndSave();
        lns.loadUsers();
        
        // Loads the FXML and gets the controller
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
                ft.play();
            } catch (Exception ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                 String lastedit = getLastModified();
                 splash.errorMssg.setVisible(true);
                 splash.errorImage.setVisible(true);
                 splash.dateModLabel.setVisible(true);
                 splash.progress.setText("ERROR:");
                 splash.errorMssg.setText("No Connection Found \n\nSaved users will not be updated!");
                 splash.dateModLabel.setText("Using historical data from: \n" + lastedit);
                 PauseTransition ps = new PauseTransition(millis(4000));
                 ps.setOnFinished(Ee->{
                     ft.play();
                 });
                 ps.play();
                 
            }
            
        });
        pt.play();
    }
    
    public String getLastModified(){
        File usersFile = new File(ROOT_DIR, "users.json");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
        String lastEdited = sdf.format(usersFile.lastModified());
        return lastEdited;
        
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
    
    public static void doHorribleHack() {
    try {
        try {
            Class<?> testCls = Class.forName("dalvik.system.VMRuntime");
            Method method = testCls.getDeclaredMethod("setHiddenApiExemptions", String[].class);
        } catch (Exception ex) {
            // This will fail
            ex.printStackTrace();
        }
        Method forName = Class.class.getDeclaredMethod("forName", String.class);
        Method getDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
        Class<?> vmRuntimeClass = (Class<?>) forName.invoke(null, "dalvik.system.VMRuntime");
        Method getRuntimeMethod = (Method) getDeclaredMethod.invoke(vmRuntimeClass, "getRuntime", null);
        Method setHiddenApiExemptions = (Method) getDeclaredMethod.invoke(vmRuntimeClass, "setHiddenApiExemptions", new Class[]{String[].class});
        if (getRuntimeMethod != null && setHiddenApiExemptions != null) {
            Object vmRuntime = getRuntimeMethod.invoke(null);
            setHiddenApiExemptions.invoke(vmRuntime, (Object) new String[]{"L"});
        }
        try {
            Class<?> testCls = Class.forName("dalvik.system.VMRuntime");
            Method method = testCls.getDeclaredMethod("setHiddenApiExemptions", String[].class);
        } catch (Exception ex) {
            // This will not
            ex.printStackTrace();
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}


    public static void main(String[] args) {
        launch(args);
    }
}
