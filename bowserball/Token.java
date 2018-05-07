package bowserball;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * Base class for objects on the frame ie pillars and bird
 */

public class Token{
    
    String fileN = "";
    ImageIcon tokenImage;
    protected  int width =  0;
    protected  int height = 0;
    protected int powerLevel = 1;
    protected int x, y;
    
    /**
     * Constructors for token only. A token is made up of two images. Both of these images should be the same size, but represent
     * an image that has the token going up and down. 
     * @param neutral image file name for token that is going straight
     */
    public Token(String neutral){
        String src = new File("").getAbsolutePath()+"/src/";
        try{
         
          tokenImage = new ImageIcon((src+neutral)); 
        }catch(Exception e){
            System.out.println("no file found: "+src+neutral);
            System.exit(-1);
        }   
        
        
    }

    
    public ImageIcon rescaleImage(File source,int maxHeight, int maxWidth)
    {
        int newHeight = maxHeight, newWidth = maxWidth;        // Variables for the new height and width
        int priorHeight = 0, priorWidth = 0;
        BufferedImage image = null;
        ImageIcon sizeImage;
        height = maxHeight;
        try {
           image = ImageIO.read(source);        // get the image
        } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Picture upload attempted & failed");
        }

        sizeImage = new ImageIcon(image);

        if(sizeImage != null)
        {
            priorHeight = sizeImage.getIconHeight(); 
            priorWidth = sizeImage.getIconWidth();
        }
        
      
        // 1. Create a new Buffered Image and Graphic2D object
        BufferedImage resizedImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();

        // 2. Use the Graphic object to draw a new image to the image in the buffer
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(image, 0, 0, newWidth, newHeight, null);
        g2.dispose();

        // 3. Convert the buffered image into an ImageIcon for return
        return (new ImageIcon(resizedImg));
    }   
    
    public void setPowerLevel(int powerLevel){
        this.powerLevel= powerLevel;
    }
    
    public int getPowerLevel(){
        return powerLevel;
    }
    
    /**
     * Method to set the position of a token. This is used to update the position of the pillars.
     * You shouldn't need to use this.
     * @param x
     * @param y 
     */
    public void setPosition(int x, int y ){
        this.x = x;
        this.y = y;
        if(this.x+this.width <= -50){
            this.x = 500;
        }
    }
    
    /**
     * Getter for x position
     * @return x
     */
    public int getX(){
        return x;
    }
    
    /**
     * Getter for y position
     * @return y
     */
    public int getY(){
        return y;
    }
    
    /**
     * Setter for y position
     * @param y 
     */
    public void updateY(int y){
        this.y = y;
    }
    
    /**
     * Getter for height
     * @return height
     */
    public int getHeight(){
        return height;
    }
    
    /**
     * Getter for width
     * @return width in pixels
     */
    public int getWidth(){
        return width;
    }

}
