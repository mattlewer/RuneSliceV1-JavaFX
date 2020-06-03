/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sample;

import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.StorageService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author mlewe
 */
public class LoadAndSave {
   
    
    // ArrayList of saved users
    public static ArrayList<User> users = new ArrayList<>();
    
    // Get local storage to save file to
    public static final File ROOT_DIR;
    static{
        ROOT_DIR = Services.get(StorageService.class).flatMap(StorageService::getPrivateStorage)
                .orElseThrow(()-> new RuntimeException("Error retrieving private storage"));
    }
    
    // Function to save a user
    public void saveUser() throws IOException{
        // Add the currently searched user to the 'users' ArrayList
        users.add(getSkills.user);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File usersFile = new File(ROOT_DIR, "users.json");
        FileWriter fileWriter = new FileWriter(usersFile);
        // Write the updated ArrayList to JSON
        gson.toJson(users, fileWriter);
        fileWriter.close();
    }
    
    
    // Function to remove a user
    public void removeUser() throws IOException{
        // Remove the current user from the 'users' ArrayList
        int i = 0;
        while(i < users.size()){
            if(getSkills.user.username.equals(users.get(i).username)){
                users.remove(i);
            }
            i++;
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File usersFile = new File(ROOT_DIR, "users.json");
        FileWriter fileWriter = new FileWriter(usersFile);
        // Write the updated ArrayList to JSON
        gson.toJson(users, fileWriter);
        fileWriter.close();
    }
    
    // Function to load saved users
    public void loadUsers(){
        Gson gson = new Gson();
        // Read the users.json file
        File usersFile = new File(ROOT_DIR, "users.json");
        try (Reader reader = new FileReader(usersFile)) {
            // Convert JSON File to Java Object
            User[] jsonlist = gson.fromJson(reader, User[].class);
            // Convert array to ArrayList
            ArrayList<User> userlist = new ArrayList<>(Arrays.asList(jsonlist));
            // Store this ArrayList as our static list to be accessed
            users = userlist;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
    // Function to update stats of current saved users
    public ArrayList<User> updateUsers() throws IOException{
        HiscoresLookup hsl = new HiscoresLookup();
        ArrayList<User> tempUsers = new ArrayList<>();
        int i = 0;
        while(i < users.size()){
            User updatedUser = hsl.boot(users.get(i).username);
            updatedUser.setIsSaved(true);
            tempUsers.add(updatedUser);
            users.remove(i);
            i++;
        }
        users.addAll(tempUsers);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File usersFile = new File(ROOT_DIR, "users.json");
        FileWriter fileWriter = new FileWriter(usersFile);
        // Write the updated ArrayList to JSON
        gson.toJson(users, fileWriter);
        fileWriter.close();
        loadUsers();
        // return the updated list of users to be set as our users
        return users;
    }
    
    public void removeAllUsers() throws IOException{
        users.clear();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File usersFile = new File(ROOT_DIR, "users.json");
        FileWriter fileWriter = new FileWriter(usersFile);
        // Write the updated ArrayList to JSON
        gson.toJson(users, fileWriter);
        fileWriter.close();
        
    }

    
    
    

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        LoadAndSave.users = users;
    }
    
    
    
    

}
