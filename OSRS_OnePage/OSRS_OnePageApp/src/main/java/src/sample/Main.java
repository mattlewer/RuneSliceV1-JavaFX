package src.sample;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
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
        // Import class so we can call methods to update / load saved users within a task 
        LoadAndSave lns = new LoadAndSave();
        
        // Loads the FXML and gets the controller, sets some effects
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/splashScreen.fxml"));
        Parent root = (Parent)loader.load();
        SplashScreenController splash = loader.getController();
        pulse(splash.logo);
        splash.errorMssg.setVisible(true);
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
        
        // Task for updating saved users
        Task<Void> mytask = new Task(){  
                    @Override
                    protected Void call() throws Exception {
                        lns.loadUsers();
                        
                        lns.updateUsers();
                         
                        return null;
                    }  
        };
          
        // If the task fails prompt the user with an error
        mytask.setOnFailed(e1->{
            String lastedit = getLastModified();
            splash.errorImage.setVisible(true);
            splash.dateModLabel.setVisible(true);
            splash.tip.setVisible(false);
            splash.progress.setText("ERROR:");
            splash.errorMssg.setText("No Connection Found \n\nSaved users will not be updated!");
            splash.dateModLabel.setText("Using historical data from: \n" + lastedit);
            PauseTransition ps = new PauseTransition(millis(5000));
            ps.setOnFinished(e3->{
                ft.play();
            });
            ps.play();
        });
        // If it completes, set the users and play the fade transition
        mytask.setOnSucceeded(e2->{
            ft.play();
        });

        // Start new thread with our task
        Thread thread = new Thread(mytask);
        thread.setDaemon(true);
        thread.start();

    }
    
    
    // Get the last date the users were updated
    public String getLastModified(){
        File usersFile = new File(ROOT_DIR, "users.json");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
        String lastEdited = sdf.format(usersFile.lastModified());
        return lastEdited;
        
    }
    
    // Open Homepage
    public void newstage() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/searchUserHome.fxml"));
        Parent root = (Parent) loader.load();
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
    
    
    
    public void pulse(Node node){
        ScaleTransition st = new ScaleTransition(Duration.millis(700), node);
        st.setByX(0.05f);
        st.setByY(0.05f);
        st.setCycleCount(Animation.INDEFINITE);
        st.setAutoReverse(true);
        st.play();
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}
