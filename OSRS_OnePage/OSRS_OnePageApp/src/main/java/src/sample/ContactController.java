/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sample;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import static javafx.util.Duration.millis;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author mlewe
 */
public class ContactController extends pageOpener {
    
    @FXML public BorderPane borderpane;
    @FXML public BorderPane nameBorderPane;
    @FXML public BorderPane emailBorderPane;
    @FXML public BorderPane mssgBorderPane;
    @FXML public VBox vbox;
    @FXML private Label header;
    @FXML private Label namePrompt;
    @FXML private TextField nameField;
    @FXML private Label emailPrompt;
    @FXML private TextField emailField;
    @FXML private Label mssgPrompt;
    @FXML private TextArea mssgField;
    @FXML private JFXButton submit;
    @FXML private Label errorLabel;
    @FXML public JFXButton returnToHome;
    
    @FXML private TextField popName;
    @FXML private Button nameClose;
    @FXML private TextField popEmail;
    @FXML private Button emailClose;
    @FXML private TextArea popMssg;
    @FXML private Button mssgClose;
    
//    static String readFile(String path, Charset encoding) throws IOException {
//        byte[] encoded = Files.readAllBytes(Paths.get(path));
//        return new String(encoded, encoding);
//    }
//    
    public void sendMail(MouseEvent event) throws IOException{
        checkForm(event);
    }
    
    private final String errorStyle = "-fx-text-fill: #F02D3A;";
    private final String completeStyle = "-fx-text-fill: #95C623;";
    
    public void checkForm(MouseEvent event) throws IOException{
        if(nameField.getText().isEmpty()){
            namePrompt.setStyle(errorStyle);
            nameField.setPromptText("Name required...");
        }else{
            namePrompt.setStyle(completeStyle);
        }
        if(emailField.getText().isEmpty()){
            emailPrompt.setStyle(errorStyle);
            emailField.setPromptText("Valid email address required...");
        }else{
            emailPrompt.setStyle(completeStyle);
        }
        if(mssgField.getText().isEmpty()){
            mssgPrompt.setStyle(errorStyle); 
            mssgField.setPromptText("Please enter a message...");
        }else{
            mssgPrompt.setStyle(completeStyle);
        }
        if((!nameField.getText().isEmpty() && !emailField.getText().isEmpty() && !mssgPrompt.getText().isEmpty())){
                    // Blur the backgrund to bring focus to pop-up
            GaussianBlur gaussianBlur = new GaussianBlur();       
            gaussianBlur.setRadius(10.5); 
            borderpane.setEffect(gaussianBlur);
            PauseTransition pt = new PauseTransition(millis(200));
            pt.setOnFinished(e->{
                try {
                    sendToRuneSlice(event, "runeslice.connect@gmail.com");
                } catch (IOException ex) {
                    Logger.getLogger(ContactController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            pt.play();
        }else{
            //do nothing
     
        }
        
 
    }
    
    
    public void sendToRuneSlice(MouseEvent event, String recepient) throws IOException{
        String content = "7e_<C?$A%by8U=zD";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        String myAccount = "runeslice.connect@gmail.com";
        String p = content;
        
        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccount, p);
            }
        });
        String name = nameField.getText();
        String replyEmail = emailField.getText();
        String mssg = mssgField.getText();
        
        Message message = prepareMessage(session, myAccount, recepient, name, replyEmail, mssg);
        Message confirmMessage = confirmMessage(session, replyEmail, myAccount, name);
        try {
            // Sending confirmation email first - if email provided by user is not valid it will fail
            // saves our imbox being sent non active email addresses to reply to
            Transport.send(confirmMessage);
            Transport.send(message);
            openPopup(event, true);
        } catch (MessagingException ex) {
            Logger.getLogger(ContactController.class.getName()).log(Level.SEVERE, null, ex);
            openPopup(event, false);
            System.out.println("Failed");
            
        }
    }
    
    public static Message prepareMessage(Session session, String myAccount, String recepient, String name, String replyEmail, String mssg){
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(name + " - " + replyEmail);
            message.setText(mssg);
            return message;
        }catch(Exception ex){
            
            
        }
        return null;
    }
    
    public static Message confirmMessage(Session session, String toEmail, String fromEmail, String name){
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("RuneSlice - Message Received!");
            String htmlCode = "<h1 style='color:#F02D3A;'>RuneSlice</h1><br/>"
                    + "<h3>Hi %s, thank you for contacting RuneSlice!</h3>"
                    + "<p>Your message has been recieved and we will be in contact shortly.</p>";
            String text = String.format(htmlCode, name);
            message.setContent(text, "text/html");
            return message;
        }catch(Exception ex){
            
            
        }
        return null;
    }
    
    
    public void hidePlaceHolder(MouseEvent event){
        GaussianBlur gaussianBlur = new GaussianBlur();
        gaussianBlur.setRadius(63.0); 
        borderpane.setEffect(gaussianBlur);  
        if(event.getSource() == nameField){
            nameField.setPromptText("");
            nameBorderPane.setVisible(true);
            popName.requestFocus();
            
        }else if(event.getSource() == emailField){
            emailField.setPromptText("");
            emailBorderPane.setVisible(true);
            popEmail.requestFocus();
            
        }else if(event.getSource() == mssgField){
            mssgField.setPromptText("");
            mssgBorderPane.setVisible(true);
            popMssg.requestFocus();
        }
    }
    
    public void focusOff(MouseEvent event){
        borderpane.requestFocus();
    }
    
    public void close(MouseEvent event){
        GaussianBlur gaussianBlur = new GaussianBlur();
        gaussianBlur.setRadius(0.0);
        borderpane.setEffect(gaussianBlur);
        if(event.getSource() == nameClose){
             nameField.setText(popName.getText());
             nameBorderPane.setVisible(false);
             if(!nameField.getText().isEmpty()){
                 namePrompt.setStyle(completeStyle);
             }
             
        }else if(event.getSource() == emailClose){
            emailField.setText(popEmail.getText());
            emailBorderPane.setVisible(false);
            if(!emailField.getText().isEmpty()){
                emailPrompt.setStyle(completeStyle);
            }
            
        }else if(event.getSource() == mssgClose){
            mssgField.setText(popMssg.getText());
            mssgBorderPane.setVisible(false);
            if(!mssgField.getText().isEmpty()){
                mssgPrompt.setStyle(completeStyle);
            }
        }
        borderpane.requestFocus();
    }
    
    public void checkStyle(KeyEvent event){
        if(event.getSource() == nameField && namePrompt.getStyle().equals(errorStyle)){
            namePrompt.setStyle(completeStyle);
        }else if(event.getSource() == emailField && emailPrompt.getStyle().equals(errorStyle)){
            emailPrompt.setStyle(completeStyle);
        }else if(event.getSource() == mssgField && mssgPrompt.getStyle().equals(errorStyle)){
            mssgPrompt.setStyle(completeStyle);
        }
    }
    
    
    
 // New pop-up window when saving / un-saving a user
    public void openPopup(MouseEvent event, Boolean sent) throws IOException{
// SETTING UP PAGE //
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/popUpSaveUser.fxml"));
        Parent root = (Parent)loader.load();
        saveUserPopup pop = loader.getController(); 
        Scene scene = new Scene(root);
        Stage window = new Stage();
        // Load pop-up as trasparent so it appears to float over the blurred scene, no toolbar
        window.initStyle(StageStyle.TRANSPARENT);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        if(sent == true){
            pop.text.setText("Success!");
            pop.text.setStyle("-fx-text-fill: #95C623;-fx-font-weight:bold;");
            pop.warning.setText("message sent");
            pop.warning.setVisible(true);
            pop.warning.setStyle("-fx-text-fill:#95C623;");
            nameField.clear();
            emailField.clear();
            mssgField.clear();
        }else{
            pop.text.setText("Failed:");
            pop.text.setStyle("-fx-text-fill:#F02D3A;-fx-font-weight:bold;");

            pop.warning.setText("please check connection");
            pop.warning.setVisible(true);
            pop.warning.setStyle("-fx-text-fill:#F02D3A;");
        }
        window.show();
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e ->{
            GaussianBlur endGaus = new GaussianBlur();       
            endGaus.setRadius(0); 
            borderpane.setEffect(endGaus);    
            window.close();
            header.requestFocus();
        });
            pause.play();
    }
   
}
