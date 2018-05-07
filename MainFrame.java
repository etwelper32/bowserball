/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowserball;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author nikitavarfolomeev
 */
public class MainFrame extends JPanel{
    private BufferedImage field, cannon;  
    private int score = 0, level = 1;
    public ArrayList<Ball> balls = new ArrayList<Ball>();
    private boolean start = false;
    Logic log = new Logic();
    
    public MainFrame(){
        String src = new File("").getAbsolutePath() + "/src/";
        setup();
        try {
            field = ImageIO.read(new File(src+"background.jpg"));
            cannon = ImageIO.read(new File(src+"b_down.gif"));
        } catch (Exception e) {
            System.out.println("background file not found");
        }
    }
    
    public void setup() {
        JFrame frame = new JFrame("Flappy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(this);
        frame.setSize(750, 750);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public void score(){
        if (start) {
            score = log.updateScore(balls, score);
        }
    }
    
    public void level(){
        if (start) {
            level = log.updateScore(balls, score);
        }
    }
    
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g; 
        g2.drawImage(field, 50, 50, null);
        g2.drawImage(cannon,50,50,null);
        g2.drawImage(cannon,650,50,null);
        g2.drawImage(cannon,50,650,null);
        g2.drawImage(cannon,650,650,null);
        g2.drawString("Score: " + score, 245, 200);
        g2.drawString("Level: " + level, 300, 200);
    }
    
}
