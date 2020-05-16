/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sample;

/**
 *
 * @author mlewe
 */
public class Boss {
    
    private int rank;
    private int kills;
    
    public Boss(Integer rank, Integer kills){
        this.rank = rank;
        this.kills = kills;
        
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }
    
    
    
    
}
