// **********************************************************************************
// Title: Modded Snake game
// Author: Johan Torres-Medina
// Course Section: CMIS201-ONL1 (Seidel) Spring 2024
// File: SnakeGame
// Description: This is a simple game made into a complex and more challenging for user.
// This has a modern take to what snake game used to be.
// **********************************************************************************

import java.util.List;

public class Game {

    private Snake snake;
    private Board board;
    private List<MovableObstacle> movableObstacles;
    private List<SuicideBomber> suicideBombers;
    private boolean gameOver;

    public Game(Snake snake, Board board, List<MovableObstacle> movableObstacles, List<SuicideBomber> suicideBombers) {
        this.snake = snake;
        this.board = board;
        this.movableObstacles = movableObstacles;
        this.suicideBombers = suicideBombers;
        this.gameOver = false;
    }

    public void update(int direction) {
        if (!gameOver) {
            moveSnake(direction);
            moveMovableObstacles();
            moveSuicideBombers();
            checkCollisions();
        }
    }

    private void moveSnake(int direction) {
        // Update snake's direction and move to next cell
        // Implementation omitted for brevity
    }

    private void moveMovableObstacles() {
        // Move movable obstacles according to their movement behavior
        // Implementation omitted for brevity
    }

    private void moveSuicideBombers() {
        // Move suicide bombers according to their movement behavior
        // Implementation omitted for brevity
    }

    private void checkCollisions() {
        // Check collisions between snake, obstacles, and bombers
        // Implementation omitted for brevity
    }

    // Other methods, such as getters and setters, omitted for brevity
}
