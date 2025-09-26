import java.awt.Rectangle;

public class Collision {

    // Wall coordinates
    private int x1 = 283;
    private int y1 = 69;
    private int x2 = 289;
    private int y2 = 284;

    public boolean checkCollision(int charX, int charY, int charWidth, int charHeight) {
        // Character rectangle
        Rectangle charRect = new Rectangle(charX, charY, charWidth, charHeight);

        // Wall rectangle
        int wallLeft = Math.min(x1, x2);
        int wallTop = Math.min(y1, y2);
        int wallWidth = Math.abs(x2 - x1);
        int wallHeight = Math.abs(y2 - y1);

        // Make sure wall has at least 1px width/height
        if (wallWidth == 0) wallWidth = 1;
        if (wallHeight == 0) wallHeight = 1;

        Rectangle wallRect = new Rectangle(wallLeft, wallTop, wallWidth, wallHeight);

        return charRect.intersects(wallRect);
    }
}
