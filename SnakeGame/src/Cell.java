// **********************************************************************************
// Title: Modded Snake game
// Author: Johan Torres-Medina
// Course Section: CMIS201-ONL1 (Seidel) Spring 2024
// File: SnakeGame
// Description: This is a simple game made into a complex and more challenging for user.
// This has a modern take to what snake game used to be.
// **********************************************************************************
public class Cell {

    private final int row, col;
    private CellType cellType;

    public Cell(int row, int col)
    {
        this.row = row;
        this.col = col;
        this.cellType = CellType.EMPTY;
    }

    public CellType getCellType() { return cellType; }

    public void setCellType(CellType cellType)
    {
        this.cellType = cellType;
    }

    public int getRow() { return row; }

    public int getCol() { return col; }
}
