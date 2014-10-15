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
    private Plank leftPlank;
    //right plank
    private Plank rightPlank;
    //top plank
    private Plank topPlank;
    //bottom plank
    private Plank bottomPlank;    
   
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
    
    public Plank getLeftPlank() {
        return leftPlank;
    }
    
    public Plank getRightPlank() {
        return rightPlank;
    }

    public Plank getTopPlank() {
        return topPlank;
    }

    public Plank getBottomPlank() {
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
    
    public boolean hasPlank(Plank plank) {
        if(plank.getSide() == Plank.NONE.getSide())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public Direction getDirectionTowardsPillar(Pillar pillar)
    {
        int row1 = rowNumber;
        int column1 = columnNumber;
        
        int row2 = pillar.getRowNumber();
        int column2 = pillar.getColumnNumber();
        
        if(row1 - row2 == 1)
        {
            return Direction.DOWN;
        }
        else if(row1 - row2 == -1)
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
            return null;
        }
    }
    
    public boolean hasPlank(Maze.Direction direction)
    {
        if(getPlank(direction.getSide())==null||getPlank(direction.getSide())==Plank.NONE)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    private Plank getPlank(int direction)
    {
        switch(direction)
        {
        case 0:
            return getLeftPlank();
        case 1:
            return getRightPlank();
        case 2:
            return getTopPlank();
        case 3:
            return getBottomPlank();
        default:
            return null;
        }
    }
    
    private void addPlanks(boolean left, boolean right, boolean top, boolean bottom)
    {
        if(left) leftPlank = Plank.LEFT; 
        else leftPlank = Plank.NONE;
        
        if(right) rightPlank = Plank.RIGHT; 
        else rightPlank = Plank.NONE;
        
        if(top) topPlank = Plank.TOP; 
        else topPlank = Plank.NONE;
        
        if(bottom) bottomPlank = Plank.BOTTOM; 
        else bottomPlank = Plank.NONE;
    }
}
