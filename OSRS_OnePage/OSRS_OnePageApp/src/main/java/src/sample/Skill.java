package src.sample;


public class Skill {
    private int rank;
    private int level;
    private Long experience;

    public Skill(Integer rank, Integer level, Long experience ){
        this.rank = rank;
        this.level = level;
        this.experience = experience;
    }



    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }
}
