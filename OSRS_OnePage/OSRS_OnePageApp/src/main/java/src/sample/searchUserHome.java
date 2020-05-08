package src.sample;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class searchUserHome extends pageOpener {


    @FXML public ImageView logo;
    @FXML public Button search;
    @FXML public TextField username;
    @FXML public Label textUsername;
    @FXML public Label error;
    @FXML public GridPane gridpane;

    public void enterKey(ActionEvent event) {
        username.setOnKeyReleased(e -> {
                    if (e.getCode().equals(KeyCode.ENTER)) {
                        search.fire();
                    }
                }
        );
    }


    public void openStage(ActionEvent event){
        rotate(logo);
        username.setDisable(true);
        textUsername.setText("Loading...");
        search.setDisable(true);
        String user = username.getText();
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(e ->{
            try {
                openAllSkills(event, user);
            } catch (Exception err) {
                try {
                    System.out.println(err);
                    reRun(event);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        pause.play();
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
    
    public void rotate(ImageView imageView){
        RotateTransition rt = new RotateTransition(Duration.millis(1000), imageView);
        rt.setByAngle(360);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);
        fade(imageView);
        rt.play();
        
    }
    
    public void fade(ImageView node){
        FadeTransition ft = new FadeTransition(Duration.millis(1000));
        ft.setNode(node);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play();
    }



    public void removeFocus(){
        username.setFocusTraversable(false);
    }


    public void clearTextField(MouseEvent event){
        username.setText("");
    }
    
    public void focusOff(MouseEvent event){
        gridpane.requestFocus();
    }
    
}
