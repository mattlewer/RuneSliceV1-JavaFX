/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sample;

import java.util.HashMap;

/**
 *
 * @author mlewe
 */

// Extends getSkills so we can access individual user skills with ease
public class User extends getSkills {

    // User has a username and a HashMap of Skills, navigated through getSkills
    public String username;
    public HashMap<String, Skill> skills;
    public HashMap<String, Boss> bossKills;
    public Boolean isSaved = false;

    public User(String username, HashMap<String, Skill> skills, HashMap<String, Boss> bossKills, Boolean isSaved){
        this.username = username;
        this.skills = skills;
        this.bossKills = bossKills;
        this.isSaved = isSaved;
    }
    
    
    // Simple getters and setters for the username and skills
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public HashMap<String, Skill> getSkills() {
        return skills;
    }

    public void setSkills(HashMap<String, Skill> skills) {
        this.skills = skills;
    }

    public HashMap<String, Boss> getBossKills() {
        return bossKills;
    }

    public void setBossKills(HashMap<String, Boss> bossKills) {
        this.bossKills = bossKills;
    }
    
    

    public Boolean getIsSaved() {
        return isSaved;
    }

    public void setIsSaved(Boolean isSaved) {
        this.isSaved = isSaved;
    }
    
    
}
