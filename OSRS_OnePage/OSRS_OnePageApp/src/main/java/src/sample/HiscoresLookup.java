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

    }

    public User boot(String username) throws IOException {
        webpage = downloadHiscoresWebpage(username);
        extractSkills();
        
        // Build our User and return
        User newuser = new User(username, mySkills, false);
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

    private static void extractSkills() {
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




    public static HashMap<String, Skill> mySkills = new HashMap<>();


    private static SkillStatistic extractSkill(String name) throws NumberFormatException {

        SkillStatistic statistic = null;

        int rank;
        int level;
        long experience;


        Pattern p = Pattern.compile(String.format(SKILL_STATISTIC_MATCH, name));
        Matcher m = p.matcher(webpage);

        if (m.find()) {

            rank       = Integer.parseInt(m.group(2).replaceAll(",", ""));
            level      = Integer.parseInt(m.group(3).replaceAll(",", ""));
            experience = Long.parseLong(m.group(4).replaceAll(",", ""));


            statistic = new SkillStatistic(rank, level, experience);
            int myRank = statistic.getRank();
            int myLevel = statistic.getAmount();
            Long xp = statistic.getExperience();


            Skill skill = new Skill(myRank, myLevel, xp);
            mySkills.put(name, skill);

        }

        return statistic;
    }




    public static class SkillStatistic implements Statistic {

        private final int rank;
        private final int level;
        private final long experience;

        public SkillStatistic(int rank, int level, long experience) {
            super();
            this.rank = rank;
            this.level = level;
            this.experience = experience;


        }



        @Override
        public String toString() {
            String result = String.format("{ \"rank\": %s, \"level\": %s, \"experience\": %s }", rank, level, experience);
            return result;
        }


        @Override
        public int getRank() {
            return rank;
        }

        @Override
        public int getAmount() {
            return level;
        }

        public long getExperience() {
            return experience;
        }

    }


    public static interface Statistic {

        int getRank();

        int getAmount();
    }
}