package bowserball;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SamBruns
 */
public class Chara extends Token{
     
    public Chara(String neutral){
        super(neutral);
        this.setPosition(250-getWidth(), 200); 
    }
    
     public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getWidth(){
        return width;
    }

}
