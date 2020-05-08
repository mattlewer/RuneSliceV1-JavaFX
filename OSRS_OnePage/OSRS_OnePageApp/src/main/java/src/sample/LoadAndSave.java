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

/**
 *
 * @author mlewe
 */
public class LoadAndSave {
   
    
    public static ArrayList<User> users = new ArrayList<>();
    
    
    public void saveUser() throws IOException{
        users.add(getSkills.user);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fileWriter = new FileWriter("users.json");
        gson.toJson(users, fileWriter);
        fileWriter.close();
    }
    
    public void removeUser() throws IOException{
        users.remove(getSkills.user);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fileWriter = new FileWriter("users.json");
        gson.toJson(users, fileWriter);
        fileWriter.close();
    }
    
    public void loadUsers(){
        Gson gson = new Gson();
        try (Reader reader = new FileReader("users.json")) {
            // Convert JSON File to Java Object
            User[] user = gson.fromJson(reader, User[].class);

            // print user
            for(User usersssss : user){
                System.out.println(usersssss.username);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

}
