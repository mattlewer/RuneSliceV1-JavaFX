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

public class HiscoresLookup {

    static String webpage;

    private static final String HISCORES_WEB_ADDRESS = "https://secure.runescape.com/m=hiscore_oldschool/hiscorepersonal.ws";
    private static final String FAKE_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36";
    private static final String SKILL_STATISTIC_MATCH;
    private static final String ACHIEVEMENT_STATISTIC_MATCH;


    

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
    

    public User boot(String username) throws IOException {
//        String url = "https://secure.runescape.com/m=hiscore_oldschool/index_lite.ws?player=" + username;
//        String html = Jsoup.connect(url).get().html();
//        Document doc = Jsoup.parse(html);
//        System.out.println(doc.html());

        webpage = downloadHiscoresWebpage(username);
        extractSkills();
        extractBossKills();
        // Build our User and return
        User newuser = new User(username, mySkills, myBossKills, clues, false);

        return newuser;
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
        



    public HashMap<String, Skill> mySkills = new HashMap<>();
    public HashMap<String, Boss> myBossKills = new HashMap<>();
    public HashMap<String, ClueScroll> clues = new HashMap<>();
    
    
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