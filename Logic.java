/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowserball;

import java.util.ArrayList;

/**
 *
 * @author nikitavarfolomeev
 */
public class Logic {
    public int updateScore(ArrayList<Ball>balls, int score){  
        for(Ball o: balls){
            if(o.getX()<0||o.getX()>750||o.getY()<0||o.getY()>750){
                score++;
            }
        }
        return score;
    }
    
    public int updateLevel(int level, ArrayList<Ball>balls, int score){
        if(updateScore(balls,score)%50==0){
            level++;
        }
        return level;
    }
}
