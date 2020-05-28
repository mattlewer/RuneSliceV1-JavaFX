/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sample;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author mlewe
 */
public class AboutPageController extends pageOpener{
    @FXML public GridPane gridpane;
    @FXML public Button returnToHome;
    
    
    @FXML Hyperlink osrsLink;
    
    
    
    
    public void openOSRS() throws URISyntaxException{
        WebView myWebView = new WebView();
        WebEngine web = myWebView.getEngine();
        web.load("https://yoururl.com");
    }
    
    
}



