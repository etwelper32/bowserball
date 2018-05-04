/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

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
    private BufferedImage field, wall, border;   
    
    public MainFrame(){
        setup();
        try {
            //
            field = ImageIO.read(new File("ASGARD.jpeg"));
            wall = ImageIO.read(new File("wall.jpeg"));
            border = ImageIO.read(new File("border.jpeg"));
        } catch (Exception e) {
            System.out.println("background file not found");
        }
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
}
