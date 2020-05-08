/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sample;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author mlewe
 */
public class skillPageController extends pageOpener implements Initializable{
    
    @FXML public ImageView skillImage;
    @FXML public Label skillTitleLabel;
    @FXML public Label xpLabel;
    @FXML public Label levelLabel;
    @FXML public Label rankLabel;
    @FXML public Label nextLevelPercent;
    @FXML public ProgressBar nextLevelBar;
    @FXML public Label next10Percent;
    @FXML public ProgressBar multipleOfTenBar;
    @FXML public Label next99Percent;
    @FXML public ProgressBar to99Bar;
    @FXML public Button exit;
    @FXML public VBox vbox;
   
    public HashMap<String, Skill> allSkills;
    public String username;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
    public void myFunction(HashMap<String, Skill> allMySkills, Skill skill, String user, String title, String imageLoc) throws FileNotFoundException{
        allSkills = allMySkills;
        username = user;

        Image image = new Image(imageLoc);
        skillImage.setImage(image);
        
        String skillName = title;
        String level = String.valueOf(skill.getLevel());
        String xp = String.valueOf(skill.getExperience());
        String rank = String.valueOf(skill.getRank());
        
        skillTitleLabel.setText(skillName);
        levelLabel.setText(level);
        xpLabel.setText(xp);
        rankLabel.setText(rank);
        

        
        
        double[] skillxp = new double[]{0,0,83,174,276,388,512,650,801,969,1154,1358,1584,1833
        , 2107, 2411, 2746, 3115, 3523, 3973, 4470, 5018, 5624, 6291, 7028, 7842, 8740, 9730
        , 10824, 12031, 13363, 14833, 16456, 18247, 20224, 22406, 24815, 27473, 30408, 33648, 37224
        , 41171, 45529, 50229, 55649, 61512, 67983, 75127, 83014, 91721, 101333, 111945, 123660, 136594
        , 150872, 166636, 184040, 203254, 224466, 247886, 273742, 302288, 333804, 368599
        , 407015, 449428, 496254, 547953, 605032, 668051, 737627, 814445, 899257, 992895, 1096278, 1210421
        , 1336443, 1475581, 1629200, 1798068, 1986068, 2192818, 2421087, 2673114, 2951373, 3258594
        , 3597792, 3972294, 4385776, 4842295, 5346332, 5902831, 6517253, 7195629, 7944614, 8771558
        , 9684577, 10692629, 11805606, 13034431};
        
        double myxp =  skill.getExperience();

        // GET PERCENT THROUGH LEVEL
        for (int i = 0; i < skillxp.length; i++){
            if(skillxp[i] > myxp){
                double tilnext = ((myxp - skillxp[i-1]) / (skillxp[i] - skillxp[i-1]));           
                nextLevelBar.setProgress(tilnext);
                String ans = String.format("%.0f", tilnext * 100);
                nextLevelPercent.setText(ans + "%");
                break;
            }else if(myxp > 13034431){
                nextLevelBar.setProgress(1);
                nextLevelPercent.setText("100%");
            }
        }   
        
        for (int i = 0; i < skillxp.length; i++){
            if(skillxp[i] > myxp && i % 10 == 0){
                double perc = ((myxp -  skillxp[i-10]) / (skillxp[i] - skillxp[i-10]));
                multipleOfTenBar.setProgress(perc);
                String result = String.format("%.0f", perc * 100);
                next10Percent.setText(result+"%");
                break;
            }else if (i == 99){
                double perc = ((myxp - skillxp[i-10]) / (13034431 - skillxp[i-10]));
                multipleOfTenBar.setProgress(perc);
                String result = String.format("%.0f", perc * 100);
                next10Percent.setText(result+"%");
                break;    
            }else if(myxp > 13034431){
                multipleOfTenBar.setProgress(1);
                next10Percent.setText("100%");
                break;
            }
        }
    
        // GET PERCENT TO 99
        double levelelel = skill.getExperience();
        double barValue = levelelel / 13034431;
        if(myxp < 13034431){
            to99Bar.setProgress(barValue);
            String result = String.format("%.0f", barValue * 100);
            next99Percent.setText(result+"%");
        }else{
            to99Bar.setProgress(1);
            next99Percent.setText("100%");
        }
    }
    
    public HashMap<String, Skill> getAllSkills() {
        return allSkills;
    }

    public void setAllSkills(HashMap<String, Skill> allSkills) {
        this.allSkills = allSkills;
    }
    
    public void ex (ActionEvent event) throws IOException {
        exitSkill(event, allSkills, username);
    }
}
