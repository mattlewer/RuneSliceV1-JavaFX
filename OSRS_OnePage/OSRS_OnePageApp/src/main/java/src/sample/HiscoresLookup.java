package src.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HiscoresLookup {

    static String webpage;

    private static final String HISCORES_WEB_ADDRESS = "https://secure.runescape.com/m=hiscore_oldschool/hiscorepersonal.ws";
    private static final String FAKE_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36";
    private static final String SKILL_STATISTIC_MATCH;
    private static final String ACHIEVEMENT_STATISTIC_MATCH;

    
    public HashMap<String, Skill> mySkills = new HashMap<>();
    public HashMap<String, Boss> myBossKills = new HashMap<>();
    public HashMap<String, ClueScroll> clues = new HashMap<>();
    
    

    static {

        StringBuilder sb;

        { /* Match skills */
            sb = new StringBuilder();

            sb.append("<tr>.*?");
            sb.append("<td align=\"left\"><a[^>]*>(%s)</a></td>");
            sb.append("<td align=\"right\">(.*?)</td>");
            sb.append("<td align=\"right\">(.*?)</td>");
            sb.append("<td align=\"right\">(.*?)</td>");
            sb.append("</tr>");

            SKILL_STATISTIC_MATCH = sb.toString();
        }
        {/* Match other (clues, bounty, etc.) */
			sb = new StringBuilder();
                        
			sb.append("<tr>");
			sb.append("<td align=\"right\">.*?</td>.*?");
			sb.append("<td><a[^>]*>(%s)</a></td>");
			sb.append("<td align=\"right\">(.*?)</td>");
			sb.append("<td colspan=\"2\" align=\"right\">(.*?)</td>");
			sb.append("</tr>");
			
			ACHIEVEMENT_STATISTIC_MATCH = sb.toString();
		}
    }
    
    
    
    
    
    public static int hi = 0;
    
    public User boot(String username) throws IOException {
        try{
            apiCollector(username);
        }catch(Exception e){
            System.out.println(e);
            webpage = downloadHiscoresWebpage(username);
            extractSkills();
            extractBossKills();
        }
        
        // Build our User and return
        User newuser = new User(username, mySkills, myBossKills, clues, false);
        return newuser;
    }
    
    
    public static String ourStats[] = {
    

        "Overall", // 0
        "Attack", // 1
        "Defence", // 2
        "Strength", // 3
        "Hitpoints", // 4
        "Ranged", // 5
        "Prayer", // 6
        "Magic", // 7
        "Cooking", // 8
        "Woodcutting", // 9
        "Fletching", // 10
        "Fishing", // 11
        "Firemaking", // 12
        "Crafting", // 13 
        "Smithing", // 14
        "Mining", // 15
        "Herblore", // 16
        "Agility", // 17
        "Thieving", // 18
        "Slayer", // 19
        "Farming", // 20
        "Runecraft", // 21
        "Hunter", // 22
        "Construction", // 23
        "", // 24
        "", // 25
        "", // 26
        "", // 27
        "Beginner", // 28
        "Easy", // 29
        "Medium", // 30
        "Hard",  // 31
        "Elite",  // 32
        "Master",  // 33
        "",  // 34
        "Abyssal Sire",  // 35
        "Alchemical Hydra", // 36
        "Barrows Chests",  // 37
        "Bryophyta", // 38
        "Callisto",  // 39
        "Cerberus", // 40
        "Chambers of Xeric", // 41
        "Chambers of Xeric: Challenge Mode",
        "Chaos Elemental", // 42
        "Chaos Fanatic",  // 43
        "Commander Zilyana", // 44
        "Corporeal Beast", // 45
        "Crazy Archaeologist",  // 46
        "Dagannoth Prime",  // 47
        "Dagannoth Rex",  // 48
        "Dagannoth Supreme", // 49
        "Deranged Archaeologist",  // 50
        "General Graardor", // 51
        "Giant Mole", // 52
        "Grotesque Guardians", // 53 
        "Hespori",  // 54
        "Kalphite Queen", // 55 
        "King Black Dragon",  // 56
        "Kraken",  // 57
        "Kree'Arra",  // 58
        "K'ril Tsutsaroth", // 59 
        "Mimic", // 60
        "The Nightmare",
        "Obor", // 62
        "Sarachnis",  // 63
        "Scorpia", // 64
        "Skotizo",  // 65
        "The Gauntlet",  // 66
        "The Corrupted Gauntlet", // 67
        "Theatre of Blood",  // 68
        "Thermonuclear Smoke Devil", // 69 
        "TzKal-Zuk", // 70
        "TzTok-Jad",  // 71
        "Venenatis", // 72
        "Vet'ion",  // 73
        "Vorkath",  // 74
        "Wintertodt", // 75
        "Zalcano", // 76 
        "Zulrah"  // 78
    
    };
    
    public void apiCollector(String username) throws IOException{
        String url = "https://secure.runescape.com/m=hiscore_oldschool/index_lite.ws?player=" + username;
        String html = Jsoup.connect(url).get().html();
        Document doc = Jsoup.parse(html);
        String text = doc.body().text(); 
        text = text.replace(' ', '\n');
        String skills[] = text.split("\\r?\\n");
        int skillCount = 0;
        while(skillCount < 24){
            String skillName = ourStats[skillCount];
            String values[] = skills[skillCount].split(",");
            // Stats
            int rank;
            int level;
            long xp;
                   
            // Check Rank
            if(Integer.parseInt(values[0]) == -1){
                rank = 0;
            }else{
                rank = Integer.parseInt(values[0]);
            }
            
            // Check Level
            if(Integer.parseInt(values[1]) == -1){
                level = 1;
            }else{
                level = Integer.parseInt(values[1]);
            }
            
            // Check XP
            if(Long.parseLong(values[2]) == -1){
                xp = 0;
            }else{
                xp = Long.parseLong(values[2]);
            }
            
            // Set as new skill
            Skill skill = new Skill(rank, level, xp);
            mySkills.put(skillName, skill);
            skillCount++;
        }
        
        
        // Get Clue Scrolls
        int scrollCount = 28;
        while(scrollCount < 34){
            String scrollName = ourStats[scrollCount];
            String values[] = skills[scrollCount].split(",");
            // Stats
            int rank;
            int cluesFound;
            
            // Check rank values
            if(Integer.parseInt(values[0]) == -1){
                rank = 0;
            }else{
                rank = Integer.parseInt(values[0]);
            }
            
            // Check clues found valye
            if(Integer.parseInt(values[1]) == -1){
                cluesFound = 0;
            }else{
                cluesFound = Integer.parseInt(values[1]);
            }
            // Set as new scroll
            ClueScroll clue = new ClueScroll(rank, cluesFound);
            clues.put(scrollName, clue);
            scrollCount++;
        }
        
        // Get Bosses
        int bossCount = 35;
        while(bossCount < 79){
            
            String bossName = ourStats[bossCount];
            String values[] = skills[bossCount].split(",");
            // Stats
            int rank;  
            int kills;
            
            // Check rank
            if(Integer.parseInt(values[0]) == -1){
                rank = 0;
            }else{
                rank = Integer.parseInt(values[0]);
            }
            
            // Check kills
            if(Integer.parseInt(values[1]) == -1){
                kills = 0;
            }else{
                kills = Integer.parseInt(values[1]);
            }
            
            // If the user has no kills do nothing
            if(kills == 0 && rank == 0){

            }else{
                // add boss to users boss list if the user has kills
                Boss boss = new Boss(rank, kills);
                myBossKills.put(bossName, boss);
            }
            bossCount++;
        }

    }

    
    
    private static String downloadHiscoresWebpage(String username) throws IOException {
        username = username.replaceAll("\\s", "+");

        StringBuilder webpage = new StringBuilder();
        URL url = new URL(HISCORES_WEB_ADDRESS);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", FAKE_USER_AGENT);
        connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
        connection.setDoInput(true);
        connection.setDoOutput(true);

        OutputStream out = connection.getOutputStream();
        out.write(String.format("user1=%s&submit=Search", username).getBytes());
        out.flush();
        out.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        in.lines().forEach(webpage::append);
        in.close();

        return webpage.toString();
    }
    
    // Maintanable list of Skills to extract from Hi-Scores
    private void extractSkills() {
        ArrayList<String> skills = new ArrayList<>();

        skills.add("Overall");
        skills.add("Attack");
        skills.add("Defence");
        skills.add("Strength");
        skills.add("Hitpoints");
        skills.add("Ranged");
        skills.add("Prayer");
        skills.add("Magic");
        skills.add("Cooking");
        skills.add("Woodcutting");
        skills.add("Fletching");
        skills.add("Fishing");
        skills.add("Firemaking");
        skills.add("Crafting");
        skills.add("Smithing");
        skills.add("Mining");
        skills.add("Herblore");
        skills.add("Agility");
        skills.add("Thieving");
        skills.add("Slayer");
        skills.add("Farming");
        skills.add("Runecraft");
        skills.add("Hunter");
        skills.add("Construction");

        for(String i : skills){
            extractSkill(i);
        }
       

    }
    
    // Maintanable list of bosses to extract from Hi-Scores
    private void extractBossKills() {
        ArrayList<String> bosses = new ArrayList<>();
        bosses.add("Abyssal Sire");
        bosses.add("Alchemical Hydra");
        bosses.add("Barrows Chests");
        bosses.add("Bryophyta");
        bosses.add("Callisto");
        bosses.add("Cerberus");
        bosses.add("Chambers of Xeric");
        bosses.add("Chaos Elemental");
        bosses.add("Chaos Fanatic");
        bosses.add("Commander Zilyana");
        bosses.add("Corporeal Beast");
        bosses.add("Crazy Archaeologist");
        bosses.add("Dagannoth Prime");
        bosses.add("Dagannoth Rex");
        bosses.add("Dagannoth Supreme");
        bosses.add("Deranged Archaeologist");
        bosses.add("General Graardor");
        bosses.add("Giant Mole");
        bosses.add("Grotesque Guardians");
        bosses.add("Hespori");
        bosses.add("Kalphite Queen");
        bosses.add("King Black Dragon");
        bosses.add("Kraken");
        bosses.add("Kree'Arra");
        bosses.add("K'ril Tsutsaroth");
        bosses.add("Mimic");
        bosses.add("Nightmare");
        bosses.add("Obor");
        bosses.add("Sarachnis");
        bosses.add("Scorpia");
        bosses.add("Skotizo");
        bosses.add("The Gauntlet");
        bosses.add("The Corrupted Gauntlet");
        bosses.add("Theatre of Blood");
        bosses.add("Thermonuclear Smoke Devil");
        bosses.add("TzKal-Zuk");
        bosses.add("TzTok-Jad");
        bosses.add("Venenatis");
        bosses.add("Vet'ion");
        bosses.add("Vorkath");
        bosses.add("Wintertodt");
        bosses.add("Zalcano");
        bosses.add("Zulrah");
        
        // Clue scrolls whilst not bosses use same layout, get at same time
        bosses.add("Clue Scrolls \\(beginner\\)");
        bosses.add("Clue Scrolls \\(easy\\)");
        bosses.add("Clue Scrolls \\(medium\\)");
        bosses.add("Clue Scrolls \\(hard\\)");
        bosses.add("Clue Scrolls \\(elite\\)");
        bosses.add("Clue Scrolls \\(master\\)");
        for(String i : bosses){
            extractBossKills(i);
        }
    }
        



    
    // Extract Skills
    private  void extractSkill(String name) throws NumberFormatException {

        int rank;
        int level;
        long experience;

        Pattern p = Pattern.compile(String.format(SKILL_STATISTIC_MATCH, name));
        Matcher m = p.matcher(webpage);

        if (m.find()) {

            rank       = Integer.parseInt(m.group(2).replaceAll(",", ""));
            level      = Integer.parseInt(m.group(3).replaceAll(",", ""));
            experience = Long.parseLong(m.group(4).replaceAll(",", ""));

            Skill skill = new Skill(rank, level, experience);
            mySkills.put(name, skill);
        }
    }

    // Extract Boss Kills
    private void extractBossKills(String name) throws NumberFormatException {

		int rank;
		int score;

		Pattern p = Pattern.compile(String.format(ACHIEVEMENT_STATISTIC_MATCH, name));
		Matcher m = p.matcher(webpage);

		if (m.find()) {
			rank = Integer.parseInt(m.group(2).replaceAll(",", ""));
			score = Integer.parseInt(m.group(3).replaceAll(",", ""));

                        // Set the name of Clue Scrolls so we dont have to change it later
                        if(name.contains("Clue Scrolls")){
                            if(name.contains("beginner")){
                                name = "Beginner";
                            }else if(name.contains("easy")){
                                name = "Easy";
                            }else if(name.contains("medium")){
                                name = "Medium";
                            }else if(name.contains("hard")){
                                name = "Hard";
                            }else if(name.contains("elite")){
                                name = "Elite";
                            }else if(name.contains("master")){
                                name = "Master";
                            }
                            // bossRank -> Clue Rank, bossKills -> number of clues
                            ClueScroll clue = new ClueScroll(rank, score);
                            clues.put(name, clue);
                        }else{
                            Boss boss = new Boss(rank, score);
                            myBossKills.put(name, boss);
                        }
		}  	
	}


}