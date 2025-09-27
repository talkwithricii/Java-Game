import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable { 

       public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private PixelPosition pixelPosition;

      private Map1 map1;  
      private CharacterLoad character; 
      private KeyHandler keyHandler; 
      private Thread gameThread;  

      private Collision collision;
      
      private Enemy enemy = new Enemy();
      


    public GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.WHITE);         
        this.setDoubleBuffered(true);   

        keyHandler = new KeyHandler();
        this.addKeyListener(keyHandler); 
        this.setFocusable(true); 
        map1 = new Map1(); 
        character = new CharacterLoad(100, 100); 

        gameThread = new Thread(this); 
        gameThread.start();  

        pixelPosition = new PixelPosition();
        this.addMouseListener(pixelPosition);  

        collision = new Collision(); 
        enemy = new Enemy();

        
    }

 
    @Override
    public void run() {
        while (true) {
            update();
            repaint();
            try {
                Thread.sleep(16); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

   public void update() {
    int speed = 2;
    boolean moving = false;
    String direction = "";

    int nextX = character.getX();
    int nextY = character.getY();


    if (keyHandler.isUpPressed()) {
        nextY -= speed;
        if (!collision.checkCollision(nextX, nextY, character.getWidth(), character.getHeight())) {
            character.setPosition(nextX, nextY);
        }
        moving = true;
        direction = "up";
    }

    if (keyHandler.isLeftPressed()) {
        nextX = character.getX() - speed;
        nextY = character.getY();
        if (!collision.checkCollision(nextX, nextY, character.getWidth(), character.getHeight())) {
            character.setPosition(nextX, nextY);
        }
        moving = true;
        direction = "left";
    }

    if (keyHandler.isRightPressed()) {
        nextX = character.getX() + speed;
        nextY = character.getY();
        if (!collision.checkCollision(nextX, nextY, character.getWidth(), character.getHeight())) {
            character.setPosition(nextX, nextY);
        }
        moving = true;
        direction = "right";
    }

    if (keyHandler.isDownPressed()) {
        nextX = character.getX();
        nextY = character.getY() + speed;
        if (!collision.checkCollision(nextX, nextY, character.getWidth(), character.getHeight())) {
            character.setPosition(nextX, nextY);
        }
        moving = true;
        direction = "down";
    }

    character.update(moving, direction);

    enemy.update();


}



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

     
        map1.draw(g, WIDTH, HEIGHT);
        character.draw(g); 

        enemy.draw(g); // new 


    }
}
