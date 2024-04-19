// **********************************************************************************
// Title: Modded Snake game
// Author: Johan Torres-Medina
// Course Section: CMIS201-ONL1 (Seidel) Spring 2024
// File: SnakeGame
// Description: This is a simple game made into a complex and more challenging for user.
// This has a modern take to what snake game used to be.
// **********************************************************************************
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Snake {
    private Cell[] snakePartArray;
    private int size;
    private Cell head;
    private final int TILE_SIZE;

    public Snake(Cell initPos, int maxSize, int tileSize) {
        this.TILE_SIZE = tileSize;
        snakePartArray = new Cell[maxSize];
        head = initPos;
        snakePartArray[0] = head;
        size = 1;
        head.setCellType(CellType.SNAKE_NODE);
    }

    public void grow() {
        if (size < snakePartArray.length) {
            // Create a new cell to represent the new head position after growth
            Cell newHead = new Cell(head.getRow(), head.getCol());
            newHead.setCellType(CellType.SNAKE_NODE);

            // Add the new head to the snakePartArray
            snakePartArray[size] = newHead;
            size++;
        }
    }

    public void move(Cell nextCell) {
        System.out.println("Snake is moving to " + nextCell.getRow() + " " + nextCell.getCol());
        Cell tail = snakePartArray[size - 1];
        tail.setCellType(CellType.EMPTY);

        // Shifting elements to the right to make space for the new head
        for (int i = size - 1; i > 0; i--) {
            snakePartArray[i] = snakePartArray[i - 1];
        }

        head = nextCell;
        head.setCellType(CellType.SNAKE_NODE);
        snakePartArray[0] = head;
    }

    public boolean checkCrash(Cell nextCell) {
        System.out.println("Going to check for Crash");
        for (int i = 0; i < size; i++) {
            if (snakePartArray[i] == nextCell) {
                return true;
            }
        }
        return false;
    }

    public Cell[] getSnakePartArray() {
        return snakePartArray;
    }

    public void setSnakePartArray(Cell[] snakePartArray) {
        this.snakePartArray = snakePartArray;
    }

    public Cell getHead() {
        return head;
    }

    public void setHead(Cell head) {
        this.head = head;
    }

    public void draw(GraphicsContext gc) {
        // Draw the snake
        gc.setFill(Color.GREEN);
        for (int i = 0; i < size; i++) {
            Cell segment = snakePartArray[i];
            gc.fillRect(segment.getCol() * TILE_SIZE, segment.getRow() * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }
    }
}


