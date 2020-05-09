/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
    
    // Function to save a user
    public void saveUser() throws IOException{
        // Add the currently searched user to the 'users' ArrayList
        users.add(getSkills.user);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fileWriter = new FileWriter("users.json");
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
        System.out.println(users.size());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fileWriter = new FileWriter("users.json");
        // Write the updated ArrayList to JSON
        gson.toJson(users, fileWriter);
        fileWriter.close();
    }
    
    // Function to load saved users
    public void loadUsers(){
        Gson gson = new Gson();
        // Read the users.json file
        try (Reader reader = new FileReader("users.json")) {
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
    

}
