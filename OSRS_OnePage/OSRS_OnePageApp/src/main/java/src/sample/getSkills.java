package src.sample;

import java.io.IOException;
import static src.sample.LoadAndSave.users;

public class getSkills {
    
    // Static user, called from other classes to determine info
    static public User user;

    
    // Function for retreiving a users data, will call upon 'HiscoresLookup' and store data in Static
    public void searchAndRetrieveSkills(String username) throws IOException {
                HiscoresLookup hi = new HiscoresLookup();
                user = hi.boot(username);
                
                // Checks if the user is currently stored, if it is, set the user as saved
                for(User n : users){
                    if(user.username.equals(n.username)){
                        user.setIsSaved(true);
                    }
                }
    }

    
    // Functions for retrieving specific sections of data
    public Skill woodcutting(){
        Skill wc = user.skills.get("Woodcutting");
        return wc;
    }
    public Skill attack(){
        Skill attack = user.skills.get("Attack");
        return attack;
    }
    public Skill strength(){
        Skill strength = user.skills.get("Strength");
        return strength;
    }
    public Skill defense(){
        Skill defense = user.skills.get("Defence");
        return defense;
    }
    public Skill ranged(){
        Skill ranged = user.skills.get("Ranged");
        return ranged;
    }
    public Skill prayer(){
        Skill prayer = user.skills.get("Prayer");
        return prayer;
    }
    public Skill magic(){
        Skill magic = user.skills.get("Magic");
        return magic;
    }
    public Skill hitpoints(){
        Skill hitpoints = user.skills.get("Hitpoints");
        return hitpoints;
    }
    public Skill crafting(){
        Skill crafting = user.skills.get("Crafting");
        return crafting;
    }
    public Skill mining(){
        Skill mining = user.skills.get("Mining");
        return mining;
    }
    public Skill smithing(){
        Skill smithing = user.skills.get("Smithing");
        return smithing;
    }
    public Skill agility(){
        Skill agility = user.skills.get("Agility");
        return agility;
    }
    public Skill herblore(){
        Skill herblore = user.skills.get("Herblore");
        return herblore;
    }
    public Skill thieving(){
        Skill thieving = user.skills.get("Thieving");
        return thieving;
    }
    public Skill fletching(){
        Skill fletching = user.skills.get("Fletching");
        return fletching;
    }
    public Skill slayer(){
        Skill slayer = user.skills.get("Slayer");
        return slayer;
    }
    public Skill farming(){
        Skill farming = user.skills.get("Farming");
        return farming;
    }
    public Skill construction(){
        Skill construction = user.skills.get("Construction");
        return construction;
    }
    public Skill hunter(){
        Skill hunter = user.skills.get("Hunter");
        return hunter;
    }
    public Skill cooking(){
        Skill cooking = user.skills.get("Cooking");
        return cooking;
    }
    public Skill fishing(){
        Skill fishing = user.skills.get("Fishing");
        return fishing;
    }
    public Skill firemaking(){
        Skill firemaking = user.skills.get("Firemaking");
        return firemaking;
    }

    public Skill runecrafting(){
        Skill runecrafting = user.skills.get("Runecraft");
        return runecrafting;
    }

    public Skill overall(){
        Skill overall = user.skills.get("Overall");
        return overall;
    }

    // Retrieve the user
    public static User getUser() {
        return user;
    }





}
