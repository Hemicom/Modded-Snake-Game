// **********************************************************************************
// Title: Modded Snake game
// Author: Johan Torres-Medina
// Course Section: CMIS201-ONL1 (Seidel) Spring 2024
// File: SnakeGame
// Description: This is a simple game made into a complex and more challenging for user.
// This has a modern take to what snake game used to be.
// **********************************************************************************
import java.awt.*;

public class MovableObstacle {
    private int x;
    private int y;
    private int speedX;
    private int speedY;
    private int width;
    private int height;
    private static final int DEFAULT_WIDTH = 800; // Default width of the game panel
    private static final int DEFAULT_HEIGHT = 600; // Default height of the game panel

    public MovableObstacle(int x, int y, int speedX, int speedY, int width, int height) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
        this.width = width;
        this.height = height;
    }

    public void updatePosition() {
        // Update position based on movement behavior
        x += speedX;
        y += speedY;

        // Reverse direction if the obstacle hits the boundary
        if (x <= 0 || x + width >= DEFAULT_WIDTH) {
            speedX = -speedX;
        }
        if (y <= 0 || y + height >= DEFAULT_HEIGHT) {
            speedY = -speedY;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }


}
