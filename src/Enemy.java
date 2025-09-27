import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Enemy {

    private int x = 385, y = 391; // Fixed position
    private int width = 100, height = 100;

    private BufferedImage[] enemySprites;
    private int frameIndex = 0;
    private int frameDelay = 15;  // Adjust for animation speed
    private int frameCount = 0;

    public Enemy() {
        enemySprites = new BufferedImage[3];
        try {
            enemySprites[0] = ImageIO.read(new File("C:\\Users\\THOR\\Desktop\\final\\enemy\\tiktik.png"));
            enemySprites[1] = ImageIO.read(new File("C:\\Users\\THOR\\Desktop\\final\\enemy\\tiktik2.png"));
            enemySprites[2] = ImageIO.read(new File("C:\\Users\\THOR\\Desktop\\final\\enemy\\tiktik3.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading enemy sprites!");
        }
    }

    public void update() {
        // Animate only (no movement)
        frameCount++;
        if (frameCount >= frameDelay) {
            frameIndex = (frameIndex + 1) % enemySprites.length;
            frameCount = 0;
        }
    }

    public void draw(Graphics g) {
        if (enemySprites[frameIndex] != null) {
            g.drawImage(enemySprites[frameIndex], x, y, width, height, null);
        }
    }

    // For collision detection
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
