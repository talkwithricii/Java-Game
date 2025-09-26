import java.awt.Rectangle;
import java.util.ArrayList; 
import java.util.List; 

public class Collision {

       private List<Rectangle> walls; 

 
       public Collision() {
        walls = new ArrayList<>();

        walls.add(makeRectangle(283, 69, 289, 284));

         // Second wall 
        walls.add(makeRectangle(49, 61, 286, 63));

        
        // Third wall 
        walls.add(makeRectangle(47, 63, 52, 519));

        // fourth object
        walls.add(makeRectangle(52, 516, 510, 516));

        walls.add(makeRectangle(575, 516, 745, 518));

        walls.add(makeRectangle(557, 365, 698, 363));

          walls.add(makeRectangle(285, 288, 510, 286));

    }


     private Rectangle makeRectangle(int x1, int y1, int x2, int y2) {
        int left = Math.min(x1, x2);
        int top = Math.min(y1, y2);
        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);

        if (width == 0) width = 1;
        if (height == 0) height = 1;

        return new Rectangle(left, top, width, height);
    }

    public boolean checkCollision(int charX, int charY, int charWidth, int charHeight) {
        Rectangle charRect = new Rectangle(charX, charY, charWidth, charHeight);

        for (Rectangle wall : walls) {
            if (charRect.intersects(wall)) {
                return true;
            }
        }
        return false;
    }

}
