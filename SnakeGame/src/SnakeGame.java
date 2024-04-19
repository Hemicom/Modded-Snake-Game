// **********************************************************************************
// Title: Modded Snake game
// Author: Johan Torres-Medina
// Course Section: CMIS201-ONL1 (Seidel) Spring 2024
// File: SnakeGame
// Description: This is a simple game made into a complex and more challenging for user.
// This has a modern take to what snake game used to be.
// **********************************************************************************
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Group;


import java.awt.*;
import java.util.*;
import java.util.List;

public class SnakeGame extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int TILE_SIZE = 20;

    private int playerSpeed = TILE_SIZE;
    private Direction direction = Direction.RIGHT;

    private LinkedList<Position> snake = new LinkedList<>();
    private Set<Position> foodPositions = new HashSet<>();
    private Map<Position, Object> gameBoard = new HashMap<>(); // Object represents different types of cells (e.g., snake, food, obstacle)

    private int initialLength = 3;

    private List<SuicideBomber> bombers = new ArrayList<>();

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Initialize snake segments
        for (int i = 0; i < initialLength; i++) {
            Position segment = new Position(WIDTH / 2 - i * TILE_SIZE, HEIGHT / 2);
            snake.add(segment);
            gameBoard.put(segment, "snake"); // Marking the position as part of the snake
        }

        // Adding initial food positions
        addFood();

        // Adding bombers
        addBombers();

        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 1000000000 / 10) {
                    update();
                    draw(gc);
                    lastUpdate = now;
                }
            }
        };
        timer.start();

        Group root = new Group(canvas);
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    direction = Direction.UP;
                    break;
                case DOWN:
                    direction = Direction.DOWN;
                    break;
                case LEFT:
                    direction = Direction.LEFT;
                    break;
                case RIGHT:
                    direction = Direction.RIGHT;
                    break;
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake Game");
        primaryStage.show();
    }

    private void update() {
        // Move the snake
        Position head = snake.getFirst().copy();
        switch (direction) {
            case UP:
                head.setY(head.getY() - playerSpeed);
                break;
            case DOWN:
                head.setY(head.getY() + playerSpeed);
                break;
            case LEFT:
                head.setX(head.getX() - playerSpeed);
                break;
            case RIGHT:
                head.setX(head.getX() + playerSpeed);
                break;
        }

        // Wrap around if the snake hits the edge
        if (head.getX() >= WIDTH) {
            head.setX(0);
        } else if (head.getX() < 0) {
            head.setX(WIDTH - TILE_SIZE);
        }
        if (head.getY() >= HEIGHT) {
            head.setY(0);
        } else if (head.getY() < 0) {
            head.setY(HEIGHT - TILE_SIZE);
        }

        // Check for collisions with food
        if (foodPositions.contains(head)) {
            // Snake eats the food
            addFood();
        } else {
            // Update the snake segments
            Position tail = snake.removeLast();
            gameBoard.remove(tail);
        }
        snake.addFirst(head);
        gameBoard.put(head, "snake");

        // Update bombers
        for (SuicideBomber bomber : bombers) {
            bomber.update();
        }
    }

    private void draw(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        // Draw snake
        gc.setFill(Color.GREEN);
        for (Position segment : snake) {
            gc.fillRect(segment.getX(), segment.getY(), TILE_SIZE, TILE_SIZE);
        }

        // Draw food
        gc.setFill(Color.RED);
        for (Position foodPos : foodPositions) {
            gc.fillOval(foodPos.getX(), foodPos.getY(), TILE_SIZE, TILE_SIZE);
        }

        // Draw bombers
        gc.setFill(Color.BLACK);
        for (SuicideBomber bomber : bombers) {
            gc.fillRect(bomber.getX(), bomber.getY(), TILE_SIZE, TILE_SIZE);
        }
    }


    private void addFood() {
        // Add food at a random position not occupied by the snake
        int foodX, foodY;
        do {
            foodX = (int) (Math.random() * (WIDTH / TILE_SIZE)) * TILE_SIZE;
            foodY = (int) (Math.random() * (HEIGHT / TILE_SIZE)) * TILE_SIZE;
        } while (gameBoard.containsKey(new Position(foodX, foodY)));

        foodPositions.add(new Position(foodX, foodY));
        gameBoard.put(new Position(foodX, foodY), "food");
    }

    private void addBombers() {
        // Add bombers
        bombers.add(new SuicideBomber(WIDTH, HEIGHT, TILE_SIZE, WIDTH / 3, HEIGHT / 3));
        bombers.add(new SuicideBomber(WIDTH, HEIGHT, TILE_SIZE, WIDTH / 3 * 2, HEIGHT / 3));
        bombers.add(new SuicideBomber(WIDTH, HEIGHT, TILE_SIZE, WIDTH / 3, HEIGHT / 3 * 2));
        bombers.add(new SuicideBomber(WIDTH, HEIGHT, TILE_SIZE, WIDTH / 3 * 2, HEIGHT / 3 * 2));







    }

    public static void main(String[] args) {
        launch(args);
    }

    class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Position copy() {
            return new Position(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Position position = (Position) obj;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
