// **********************************************************************************
// Title: Modded Snake game
// Author: Johan Torres-Medina
// Course Section: CMIS201-ONL1 (Seidel) Spring 2024
// File: SnakeGame
// Description: This is a simple game made into a complex and more challenging for user.
// This has a modern take to what snake game used to be.
// **********************************************************************************
public class Board {
    private final int ROW_COUNT;
    private final int COL_COUNT;
    private Cell[][] cells;

    public Board(int rowCount, int columnCount) {
        this.ROW_COUNT = rowCount;
        this.COL_COUNT = columnCount;
        this.cells = new Cell[this.ROW_COUNT][this.COL_COUNT];

        // Initialize each cell in the board
        for (int row = 0; row < this.ROW_COUNT; row++) {
            for (int column = 0; column < this.COL_COUNT; column++) {
                this.cells[row][column] = new Cell(row, column);
            }
        }
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public void generateFood() {
        // Generates food at a random location on the board
        int row;
        int column;
        do {
            row = (int) (Math.random() * this.ROW_COUNT);
            column = (int) (Math.random() * this.COL_COUNT);
        } while (this.cells[row][column].getCellType() != CellType.EMPTY); // Make sure the cell is empty

        this.cells[row][column].setCellType(CellType.FOOD);
        System.out.println("Food generated at: " + row + ", " + column);
    }
}

