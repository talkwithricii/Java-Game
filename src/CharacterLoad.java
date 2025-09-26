import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class CharacterLoad {


    private int frameIndex = 0;    
    private int frameDelay = 10; 
    private int frameCount = 0; 
    private BufferedImage[] rightSprites; 
    private int x;
    private int y;
     private BufferedImage[] downSprites;
      private BufferedImage[] upSprites; 
    private BufferedImage[] leftSprites; 

  
    private int width = 50;  
    private int height = 50;  


    private String currentDirection = "right"; 


    public CharacterLoad(int startX, int startY) {
        this.x = startX;
        this.y = startY;

        
        rightSprites = new BufferedImage[5];
        

         try {
            for (int i = 0; i < 5; i++) {
                rightSprites[i] = ImageIO.read(
                    new File("C:\\Users\\THOR\\Desktop\\final\\walkright\\right" + (i + 1) + ".png")
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading right walk sprites!");
        }


  
        downSprites = new BufferedImage[3];
        try {
            for (int i = 0; i < 3; i++) {
                downSprites[i] = ImageIO.read(
                    new File("C:\\Users\\THOR\\Desktop\\final\\downwalk\\down" + (i + 1) + ".png")
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading down walk sprites!");
        }

      
        upSprites = new BufferedImage[3];
        try {
            for (int i = 0; i < 3; i++) {
                upSprites[i] = ImageIO.read(
                    new File("C:\\Users\\THOR\\Desktop\\final\\upwalk\\up" + (i + 1) + ".png")
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading up walk sprites!");
        }

    
        leftSprites = new BufferedImage[5];
        try {
            for (int i = 0; i < 5; i++) {
                leftSprites[i] = ImageIO.read(
                    new File("C:\\Users\\THOR\\Desktop\\final\\leftwalk\\left" + (i + 1) + ".png")
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading left walk sprites!");
        }

    }


    public void update(boolean moving, String direction) {
        if (moving) {
            currentDirection = direction;
            frameCount++;
            if (frameCount >= frameDelay) {
                switch (direction) {
                    case "right":
                        frameIndex = (frameIndex + 1) % rightSprites.length;
                        break;
                    case "down":
                        frameIndex = (frameIndex + 1) % downSprites.length;
                        break;
                    case "up":
                        frameIndex = (frameIndex + 1) % upSprites.length;
                        break;
                    case "left":
                        frameIndex = (frameIndex + 1) % leftSprites.length;
                        break;
                }
                frameCount = 0;
            }
        } else {
            frameIndex = 0;
        }
    }

 
    public void draw(Graphics g) {
        BufferedImage currentFrame = null;

        switch (currentDirection) {
            case "right":
                currentFrame = rightSprites[frameIndex];
                break;
            case "down":
                currentFrame = downSprites[frameIndex];
                break;
            case "up":
                currentFrame = upSprites[frameIndex];
                break;
            case "left":
                currentFrame = leftSprites[frameIndex];
                break;
        }
         if (currentFrame != null) {
            g.drawImage(currentFrame, x, y, width, height, null);
        }
    }

    

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

// new
public int getX() { return x; }
public int getY() { return y; }
public int getWidth() { return width; }
public int getHeight() { return height; }

public void setPosition(int newX, int newY) {
    this.x = newX;
    this.y = newY;
}


  

}
