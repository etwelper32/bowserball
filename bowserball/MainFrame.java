/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowserball;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
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
    private BufferedImage field;   
    public static Token token;
    private double esize;
    private Ellipse2D.Float ellipse = new Ellipse2D.Float();
    
    public MainFrame(){
        String src = new File("").getAbsolutePath() + "/src/";
        setup();
        try {
            //
            field = ImageIO.read(new File(src+"background.jpg"));
        } catch (Exception e) {
            System.out.println("background file not found");
        }
    }
    public MainFrame(Token token) {
        this.token = token;
        setXY(20 * Math.random(), 200, 200);  
    }
    
    public void setXY(double size, int w, int h) {
        esize = size;
        ellipse.setFrame(10, 10, size, size);
    }
    
    /*public void placePillars(BufferedImage a){
        a.setPosition(100,100);
    }*/
    public void setup() {
        JFrame frame = new JFrame("Flappy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(this);
        frame.setSize(750, 750);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(field, 50, 50, null);
        g2.drawImage(token.tokenImage.getImage(), 50, 50, null);
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
