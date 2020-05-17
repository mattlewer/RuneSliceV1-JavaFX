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
public class ClueScroll {
    
    private int rank;
    private int numberOfScrollsCompleted;
    
    public ClueScroll(int rank, int numberOfScrollsCompleted){
        this.rank = rank;
        this.numberOfScrollsCompleted = numberOfScrollsCompleted;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getNumberOfScrollsCompleted() {
        return numberOfScrollsCompleted;
    }

    public void setNumberOfScrollsCompleted(int numberOfScrollsCompleted) {
        this.numberOfScrollsCompleted = numberOfScrollsCompleted;
    }
    
    
    
}
