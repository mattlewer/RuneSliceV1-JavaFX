package src.sample;

import java.io.IOException;
import static src.sample.LoadAndSave.users;

public class getSkills {
    
    // Static user, called from other classes to determine info
    static public User user;

    
    // Function for retreiving a users data, will call upon 'HiscoresLookup' and store data in Static user
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
   

    
    // Functions for retrieving specific sections of data for skills
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

    // Functions for retreiving specific Boss kills from searched User
    //If the user has no registered kills return "0"
    
    // Abyssal Sire
    public String sireKills(){
        String sireKills;
        try{
            sireKills = String.valueOf(user.bossKills.get("Abyssal Sire").getKills());
        }catch(NullPointerException e){
            sireKills = "0";
        }
        return sireKills;
    }
    
    // Alchemical Hydra
    public String hydraKills(){
        String hydraKills;
        try{
            hydraKills = String.valueOf(user.bossKills.get("Alchemical Hydra").getKills());
        }catch(NullPointerException e){
            hydraKills = "0";
        }
        return hydraKills;
    }
    
    // Barrows Chests
    public String barrowsKills(){
        String barrowsKills;
        try{
            barrowsKills = String.valueOf(user.bossKills.get("Barrows Chests").getKills());
        }catch(NullPointerException e){
            barrowsKills = "0";
        }
        return barrowsKills;
    }
    
    // Bryophyta
    public String bryoKills(){
        String bryoKills;
        try{
            bryoKills = String.valueOf(user.bossKills.get("Bryophyta").getKills());
        }catch(NullPointerException e){
            bryoKills = "0";
        }
        return bryoKills;
    }
    
    // Callisto
    public String callistoKills(){
        String callistoKills;
        try{
            callistoKills = String.valueOf(user.bossKills.get("Callisto").getKills());
        }catch(NullPointerException e){
            callistoKills = "0";
        }
        return callistoKills;
    }
    
    // Cerberus
    public String cerberusKills(){
        String cerberusKills;
        try{
            cerberusKills = String.valueOf(user.bossKills.get("Cerberus").getKills());
        }catch(NullPointerException e){
            cerberusKills = "0";
        }
        return cerberusKills;
    }
    
    // Chambers of Xeric
    public String xericKills(){
        String xericKills;
        try{
            xericKills = String.valueOf(user.bossKills.get("Chambers of Xeric").getKills());
        }catch(NullPointerException e){
            xericKills = "0";
        }
        return xericKills;
    }
    
    // Chambers of Xeric : Challenge Mode
    public String xericChallengeKills(){
        String xericChallengeKills;
        try{
            xericChallengeKills = String.valueOf(user.bossKills.get("Chambers of Xeric: Challenge Mode").getKills());
        }catch(NullPointerException e){
            xericChallengeKills = "0";
        }
        return xericChallengeKills;
    }
    
    // Chaos Elemental
    public String chaosElementalKills(){
        String chaosElementalKills;
        try{
            chaosElementalKills = String.valueOf(user.bossKills.get("Chaos Elemental").getKills());
        }catch(NullPointerException e){
            chaosElementalKills = "0";
        }
        return chaosElementalKills;
    }
    
    // Chaos Fanatic
    public String chaosFanaticKills(){
        String chaosFanaticKills;
        try{
            chaosFanaticKills = String.valueOf(user.bossKills.get("Chaos Fanatic").getKills());
        }catch(NullPointerException e){
            chaosFanaticKills = "0";
        }
        return chaosFanaticKills;
    }
    
    // Commander Zilyana
    public String zilyanaKills(){
        String zilyanaKills;
        try{
            zilyanaKills = String.valueOf(user.bossKills.get("Commander Zilyana").getKills());
        }catch(NullPointerException e){
            zilyanaKills = "0";
        }
        return zilyanaKills;
    }
    
    // Corporal Beast
    public String corpKills(){
        String corpKills;
        try{
            corpKills = String.valueOf(user.bossKills.get("Corporeal Beast").getKills());
        }catch(NullPointerException e){
            corpKills = "0";
        }
        return corpKills;
    }
    
    // Crazy Archaeologist
    public String crazyArchaeologistKills(){
        String crazyArchaeologistKills;
        try{
            crazyArchaeologistKills = String.valueOf(user.bossKills.get("Crazy Archaeologist").getKills());
        }catch(NullPointerException e){
            crazyArchaeologistKills = "0";
        }
        return crazyArchaeologistKills;
    }
    
    // Dagannoth Prime
    public String primeKills(){
        String primeKills;
        try{
            primeKills = String.valueOf(user.bossKills.get("Dagannoth Prime").getKills());
        }catch(NullPointerException e){
            primeKills = "0";
        }
        return primeKills;
    }
    
    // Dagannoth Rex
    public String rexKills(){
        String rexKills;
        try{
            rexKills = String.valueOf(user.bossKills.get("Dagannoth Rex").getKills());
        }catch(NullPointerException e){
            rexKills = "0";
        }
        return rexKills;
    }
    
        
    // Dagannoth Supreme
    public String supremeKills(){
        String supremeKills;
        try{
            supremeKills = String.valueOf(user.bossKills.get("Dagannoth Supreme").getKills());
        }catch(NullPointerException e){
            supremeKills = "0";
        }
        return supremeKills;
    }
    
    // Deranged Archaeologist
    public String derangedArchaeologistKills(){
        String derangedArchaeologistKills;
        try{
            derangedArchaeologistKills = String.valueOf(user.bossKills.get("Deranged Archaeologist").getKills());
        }catch(NullPointerException e){
            derangedArchaeologistKills = "0";
        }
        return derangedArchaeologistKills;
    }
    
    // General Graardor
    public String graardorKills(){
        String graardorKills;
        try{
            graardorKills = String.valueOf(user.bossKills.get("General Graardor").getKills());
        }catch(NullPointerException e){
            graardorKills = "0";
        }
        return graardorKills;
    }
    
    // Giant Mole
    public String giantMoleKills(){
        String giantMoleKills;
        try{
            giantMoleKills = String.valueOf(user.bossKills.get("Giant Mole").getKills());
        }catch(NullPointerException e){
            giantMoleKills = "0";
        }
        return giantMoleKills;
    }
    
    // Grotesque Guardians
    public String guardianKills(){
        String guardianKills;
        try{
            guardianKills = String.valueOf(user.bossKills.get("Grotesque Guardians").getKills());
        }catch(NullPointerException e){
            guardianKills = "0";
        }
        return guardianKills;
    }
    
    // Hespori
    public String hesporiKills(){
        String hesporiKills;
        try{
            hesporiKills = String.valueOf(user.bossKills.get("Hespori").getKills());
        }catch(NullPointerException e){
            hesporiKills = "0";
        }
        return hesporiKills;
    } 
    
    // Kalphite Queen
    public String kalphiteKills(){
        String kalphiteKills;
        try{
            kalphiteKills = String.valueOf(user.bossKills.get("Kalphite Queen").getKills());
        }catch(NullPointerException e){
            kalphiteKills = "0";
        }
        return kalphiteKills;
    } 
    
    
    // King Black Dragon
    public String kbdKills(){
        String kbdKills;
        try{
            kbdKills = String.valueOf(user.bossKills.get("King Black Dragon").getKills());
        }catch(NullPointerException e){
            kbdKills = "0";
        }
        return kbdKills;
    } 
    
    
    // Kraken
    public String krakenKills(){
        String krakenKills;
        try{
            krakenKills = String.valueOf(user.bossKills.get("Kraken").getKills());
        }catch(NullPointerException e){
            krakenKills = "0";
        }
        return krakenKills;
    } 
    
    // Kree'Arra
    public String kreeKills(){
        String kreeKills;
        try{
            kreeKills = String.valueOf(user.bossKills.get("Kree'Arra").getKills());
        }catch(NullPointerException e){
            kreeKills = "0";
        }
        return kreeKills;
    } 

    // K'ril Tsutsaroth
    public String krilKills(){
        String krilKills;
        try{
            krilKills = String.valueOf(user.bossKills.get("K'ril Tsutsaroth").getKills());
        }catch(NullPointerException e){
            krilKills = "0";
        }
        return krilKills;
    } 
    
    // Mimic
    public String mimicKills(){
        String mimicKills;
        try{
            mimicKills = String.valueOf(user.bossKills.get("Mimic").getKills());
        }catch(NullPointerException e){
            mimicKills = "0";
        }
        return mimicKills;
    } 
    
    // Obor
    public String oborKills(){
        String oborKills;
        try{
            oborKills = String.valueOf(user.bossKills.get("Obor").getKills());
        }catch(NullPointerException e){
            oborKills = "0";
        }
        return oborKills;
    } 
    
    // Sarachnis
    public String sarachnisKills(){
        String sarachnisKills;
        try{
            sarachnisKills = String.valueOf(user.bossKills.get("Sarachnis").getKills());
        }catch(NullPointerException e){
            sarachnisKills = "0";
        }
        return sarachnisKills;
    } 
    
    // Scorpia
    public String scorpiaKills(){
        String scorpiaKills;
        try{
            scorpiaKills = String.valueOf(user.bossKills.get("Scorpia").getKills());
        }catch(NullPointerException e){
            scorpiaKills = "0";
        }
        return scorpiaKills;
    } 
    
    // Skotizo
    public String skotizoKills(){
        String skotizoKills;
        try{
            skotizoKills = String.valueOf(user.bossKills.get("Skotizo").getKills());
        }catch(NullPointerException e){
            skotizoKills = "0";
        }
        return skotizoKills;
    } 
    
    // The Gauntlet
    public String gauntletKills(){
        String gauntletKills;
        try{
            gauntletKills = String.valueOf(user.bossKills.get("The Gauntlet").getKills());
        }catch(NullPointerException e){
            gauntletKills = "0";
        }
        return gauntletKills;
    } 
    
    // The Corrupted Gauntlet
    public String corruptedGauntletKills(){
        String corruptedGauntletKills;
        try{
            corruptedGauntletKills = String.valueOf(user.bossKills.get("The Corrupted Gauntlet").getKills());
        }catch(NullPointerException e){
            corruptedGauntletKills = "0";
        }
        return corruptedGauntletKills;
    } 
    
    
    // Theatre of Blood
    public String tobKills(){
        String tobKills;
        try{
            tobKills = String.valueOf(user.bossKills.get("Theatre of Blood").getKills());
        }catch(NullPointerException e){
            tobKills = "0";
        }
        return tobKills;
    } 
    
    
    // Thermonuclear Smoke Devil
    public String thermoSmokeKills(){
        String thermoSmokeKills;
        try{
            thermoSmokeKills = String.valueOf(user.bossKills.get("Thermonuclear Smoke Devil").getKills());
        }catch(NullPointerException e){
            thermoSmokeKills = "0";
        }
        return thermoSmokeKills;
    } 
    
    
    // TzKal-Zuk
    public String zukKills(){
        String zukKills;
        try{
            zukKills = String.valueOf(user.bossKills.get("TzKal-Zuk").getKills());
        }catch(NullPointerException e){
            zukKills = "0";
        }
        return zukKills;
    } 
    
    // TzTok-Jad
    public String jadKills(){
        String jadKills;
        try{
            jadKills = String.valueOf(user.bossKills.get("TzTok-Jad").getKills());
        }catch(NullPointerException e){
            jadKills = "0";
        }
        return jadKills;
    } 
    
    // Venenatis
    public String venenatisKills(){
        String venenatisKills;
        try{
            venenatisKills = String.valueOf(user.bossKills.get("Venenatis").getKills());
        }catch(NullPointerException e){
            venenatisKills = "0";
        }
        return venenatisKills;
    } 
    
    // Vet'ion
    public String vetionKills(){
        String vetionKills;
        try{
            vetionKills = String.valueOf(user.bossKills.get("Vet'ion").getKills());
        }catch(NullPointerException e){
            vetionKills = "0";
        }
        return vetionKills;
    } 
    
    
    // Vorkath
    public String vorkathKills(){
        String vorkathKills;
        try{
            vorkathKills = String.valueOf(user.bossKills.get("Vorkath").getKills());
        }catch(NullPointerException e){
            vorkathKills = "0";
        }
        return vorkathKills;
    } 
    
    // Wintertodt
    public String wintertodtKills(){
        String wintertodtKills;
        try{
            wintertodtKills = String.valueOf(user.bossKills.get("Wintertodt").getKills());
        }catch(NullPointerException e){
            wintertodtKills = "0";
        }
        return wintertodtKills;
    } 
    
    // Zalcano
    public String zalcanoKills(){
        String zalcanoKills;
        try{
            zalcanoKills = String.valueOf(user.bossKills.get("Zalcano").getKills());
        }catch(NullPointerException e){
            zalcanoKills = "0";
        }
        return zalcanoKills;
    } 
    
    // Zulrah
    public String zulrahKills(){
        String zulrahKills;
        try{
            zulrahKills = String.valueOf(user.bossKills.get("Zulrah").getKills());
        }catch(NullPointerException e){
            zulrahKills = "0";
        }
        return zulrahKills;
    }
    
    // Functions to retreive clue scroll data
    
    // Beginner Scrolls
    public String beginnerScrolls(){
        String beginnerScrollCount;
        try{
            beginnerScrollCount = String.valueOf(user.clues.get("Beginner").getNumberOfScrollsCompleted());
        }catch(NullPointerException e){
            beginnerScrollCount = "0";
        }
        return beginnerScrollCount;
    }
    
    // Beginner Scrolls
    public String easyScrolls(){
        String easyScrollCount;
        try{
            easyScrollCount = String.valueOf(user.clues.get("Easy").getNumberOfScrollsCompleted());
        }catch(NullPointerException e){
            easyScrollCount = "0";
        }
        return easyScrollCount;
    }
    
    // Medium Scrolls
    public String mediumScrolls(){
        String mediumScrollCount;
        try{
            mediumScrollCount = String.valueOf(user.clues.get("Medium").getNumberOfScrollsCompleted());
        }catch(NullPointerException e){
            mediumScrollCount = "0";
        }
        return mediumScrollCount;
    }
    
    // Hard Scrolls
    public String hardScrolls(){
        String hardScrollCount;
        try{
            hardScrollCount = String.valueOf(user.clues.get("Hard").getNumberOfScrollsCompleted());
        }catch(NullPointerException e){
            hardScrollCount = "0";
        }
        return hardScrollCount;
    }
    
    // Elite Scrolls
    public String eliteScrolls(){
        String eliteScrollCount;
        try{
            eliteScrollCount = String.valueOf(user.clues.get("Elite").getNumberOfScrollsCompleted());
        }catch(NullPointerException e){
            eliteScrollCount = "0";
        }
        return eliteScrollCount;
    }
    
    
    // Elite Scrolls
    public String masterScrolls(){
        String masterScrollCount;
        try{
            masterScrollCount = String.valueOf(user.clues.get("Master").getNumberOfScrollsCompleted());
        }catch(NullPointerException e){
            masterScrollCount = "0";
        }
        return masterScrollCount;
    }
    
    // Retrieve the user
    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        getSkills.user = user;
    }

    




}
