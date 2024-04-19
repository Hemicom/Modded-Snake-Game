// **********************************************************************************
// Title: Modded Snake game
// Author: Johan Torres-Medina
// Course Section: CMIS201-ONL1 (Seidel) Spring 2024
// File: SnakeGame
// Description: This is a simple game made into a complex and more challenging for user.
// This has a modern take to what snake game used to be.
// **********************************************************************************
import java.awt.*;

public class SuicideBomber {
    private int width;
    private int height;
    private int tileSize;
    private int x;
    private int y;
    private int speed; // Assuming you have a speed variable

    public SuicideBomber(int width, int height, int tileSize, int x, int y) {
        this.width = width;
        this.height = height;
        this.tileSize = tileSize;
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void updatePosition() {
        // Update position based on movement behavior
        y += speed;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, tileSize, tileSize);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, tileSize, tileSize);
        // customize the appearance of the bomber here
    }

    public void update() {
        // Update any other properties or behaviors here
    }


}
