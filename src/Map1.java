import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Map1 {

    private BufferedImage background;

    public Map1() {
        try {
            background = ImageIO.read(new File("C:\\Users\\THOR\\Desktop\\final\\map1\\map1.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Map1 image not found!");
        }
    }

    public void draw(Graphics g, int width, int height) {
        if (background != null) {
            g.drawImage(background, 0, 0, width, height, null);
        }
    }
}
