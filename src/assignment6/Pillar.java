package assignment6;
import assignment6.Maze.Direction;

/**
 * @author Benjamin Poreh
 * @version v1.0
 */
public class Pillar 
{
    //the row number that the pillar is apart of in the maze (x value)
    private int rowNumber;
    //the column number that the pillar is apart of in the maze (y value)
    private int columnNumber;
    //left plank
    private boolean leftPlank;
    //right plank
    private boolean rightPlank;
    //top plank
    private boolean topPlank;
    //bottom plank
    private boolean bottomPlank;    
   
    private Maze maze;
    
    /**
     * private constructor for the pillar
     * @param row
     * @param col 
     */
    public Pillar(int row, int col)
    {
        rowNumber = row;
        columnNumber = col;
        addPlanks(false, false, false, false);
    }
    
    public Pillar(int row, int col, boolean left, boolean right, boolean top, boolean bottom)
    {
        rowNumber = row;
        columnNumber = col;
        addPlanks(left, right, top, bottom);
    }
    
    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public void setPlanks(boolean left, boolean right, boolean up, boolean down)
    {
        addPlanks(left, right, up, down);
    }
    
    public boolean hasLeftPlank() {
        return leftPlank;
    }
    
    public boolean hasRightPlank() {
        return rightPlank;
    }

    public boolean hasTopPlank() {
        return topPlank;
    }

    public boolean hasBottomPlank() {
        return bottomPlank;
    }

    public Pillar getPillarAbove(int row, int col)
    {
        return maze.getPillar(row+1, col);
    }
    
    public Pillar getPillarBelow(int row, int col)
    {
        return maze.getPillar(row-1, col);
    }
    public Pillar getPillarLeft(int row, int col)
    {
        return maze.getPillar(row, col-1);
    }
    public Pillar getPillarRight(int row, int col)
    {
        return maze.getPillar(row+1, col+1);
    }
    
    public Direction getDirectionTowardsPillar(Pillar pillar)
    {
        int row1 = rowNumber;
        int column1 = columnNumber;
        
        int row2 = pillar.getRowNumber();
        int column2 = pillar.getColumnNumber();
        
        if(row1 - row2 == -1)
        {
            return Direction.DOWN;
        }
        else if(row1 - row2 == 1)
        {
            return Direction.UP;
        }
        else if (column1 - column2 == 1)
        {
            return Direction.LEFT;
        }
        else if (column1 - column2 == -1)
        {
            return Direction.RIGHT;
        }
        else
        {
            return Direction.NONE;
        }
    }
    
    public boolean hasPlank(Direction dir)
    {
        if(dir == Direction.LEFT)
            return leftPlank;
        else if(dir == Direction.RIGHT)
            return rightPlank;
        else if(dir == Direction.UP)
            return topPlank;
        else if(dir == Direction.DOWN)
            return bottomPlank;
        return false;
    }
    
    private void addPlanks(boolean left, boolean right, boolean top, boolean bottom)
    {
        leftPlank = left;
        rightPlank = right;
        topPlank = top;
        bottomPlank = bottom;
    }
    
    public String toString()
    {
        return "("+rowNumber+", "+columnNumber+")";
    }
}
