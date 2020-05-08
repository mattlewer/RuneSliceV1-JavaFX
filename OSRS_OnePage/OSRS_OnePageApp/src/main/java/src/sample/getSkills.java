package src.sample;

import java.io.IOException;
import java.util.HashMap;

public class getSkills {

    public HashMap<String, Skill> searchAndRetrieveSkills(String username) throws IOException {
                HiscoresLookup hi = new HiscoresLookup();
                return hi.boot(username);
    }

    public Skill woodcutting(HashMap<String, Skill> data){
        Skill wc = data.get("Woodcutting");
        return wc;

    }
    public Skill attack(HashMap<String, Skill> data){
        Skill attack = data.get("Attack");
        return attack;

    }
    public Skill strength(HashMap<String, Skill> data){
        Skill strength = data.get("Strength");
        return strength;

    }
    public Skill defense(HashMap<String, Skill> data){
        Skill defense = data.get("Defence");
        return defense;

    }
    public Skill ranged(HashMap<String, Skill> data){
        Skill ranged = data.get("Ranged");
        return ranged;

    }

    public Skill prayer(HashMap<String, Skill> data){
        Skill prayer = data.get("Prayer");
        return prayer;

    }
    public Skill magic(HashMap<String, Skill> data){
        Skill magic = data.get("Magic");
        return magic;

    }

    public Skill hitpoints(HashMap<String, Skill> data){
        Skill hitpoints = data.get("Hitpoints");
        return hitpoints;

    }
    public Skill crafting(HashMap<String, Skill> data){
        Skill crafting = data.get("Crafting");
        return crafting;

    }
    public Skill mining(HashMap<String, Skill> data){
        Skill mining = data.get("Mining");
        return mining;

    }
    public Skill smithing(HashMap<String, Skill> data){
        Skill smithing = data.get("Smithing");
        return smithing;

    }
    public Skill agility(HashMap<String, Skill> data){
        Skill agility = data.get("Agility");
        return agility;

    }
    public Skill herblore(HashMap<String, Skill> data){
        Skill herblore = data.get("Herblore");
        return herblore;

    }
    public Skill thieving(HashMap<String, Skill> data){
        Skill thieving = data.get("Thieving");
        return thieving;

    }
    public Skill fletching(HashMap<String, Skill> data){
        Skill fletching = data.get("Fletching");
        return fletching;

    }
    public Skill slayer(HashMap<String, Skill> data){
        Skill slayer = data.get("Slayer");
        return slayer;

    }
    public Skill farming(HashMap<String, Skill> data){
        Skill farming = data.get("Farming");
        return farming;

    }
    public Skill construction(HashMap<String, Skill> data){
        Skill construction = data.get("Construction");
        return construction;

    }
    public Skill hunter(HashMap<String, Skill> data){
        Skill hunter = data.get("Hunter");
        return hunter;

    }
    public Skill cooking(HashMap<String, Skill> data){
        Skill cooking = data.get("Cooking");
        return cooking;

    }
    public Skill fishing(HashMap<String, Skill> data){
        Skill fishing = data.get("Fishing");
        return fishing;

    }
    public Skill firemaking(HashMap<String, Skill> data){
        Skill firemaking = data.get("Firemaking");
        return firemaking;

    }

    public Skill runecrafting(HashMap<String, Skill> data){
        Skill runecrafting = data.get("Runecraft");
        return runecrafting;

    }

    public Skill overall(HashMap<String, Skill> data){
        Skill overall = data.get("Overall");
        return overall;

    }





}
