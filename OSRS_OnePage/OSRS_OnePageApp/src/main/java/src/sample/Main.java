package src.sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/assets/searchUserHome.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/assets/stylesheethome.css").toExternalForm());
        primaryStage.setScene(scene);
      
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());

      
        root.requestFocus();
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
