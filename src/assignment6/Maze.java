package assignment6;

import java.util.ArrayList;

/**
 * @author Benjamin Poreh
 * @version v1.0
 */

public class Maze {
    //2D array that holds the pillars
    private Pillar[][] pillars;
    
    public static enum Direction
    {
         LEFT(0), RIGHT(1), UP(2), DOWN(3);
         int side;

        private Direction(int side)
        {
            this.side = side;
        }

        public int getSide()
        {
            return side;
        }
        
        public Direction getOtherSide()
        {
            switch(this)
            {
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            default:
                return null;
            }
        }
        
    }
    
    public boolean areAdjacent(int row1, int col1, int row2, int col2)
    {
        if(row1 - row2 < -1 || row1 - row2 > 1)
        {
            return false;
        }
        else if(col1 - col2 < -1 || col1 - col2 > 1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public Maze(int rows, int columns)
    {
        this.pillars = new Pillar[columns][rows];
        populateEmptyMaze();
    }
    
    public Pillar getPillar(int row, int col)
    {
        return pillars[col][row];
    }
    
    public Pillar getNextPillar(int row, int col, Direction dir)
    {
        switch(dir)
        {
        case LEFT:
            return getPillar(row, col-1);
        case RIGHT:
            return getPillar(row, col+1);
        case UP:
            return getPillar(row+1, col);
        case DOWN:
            return getPillar(row-1, col);
        default:
            return null;
        }
    }
    /**
     * Assuming the pillar is adjacent, gets the direction given the 2 pillar's rows and columns
     * @param row1
     * @param col1
     * @param row2
     * @param col2
     * @return 
     */
    public Direction getDirection(int row1, int col1, int row2, int col2)
    {
        if(row1 - row2 == 1)
        {
            return Direction.DOWN;
        }
        else if(row1 - row2 == -1)
        {
            return Direction.UP;
        }
        else if (col1 - col2 == 1)
        {
            return Direction.LEFT;
        }
        else if (col1 - col2 == -1)
        {
            return Direction.RIGHT;
        }
        else
        {
            return null;
        }
    }
    
    public boolean havePlank(int row1, int col1, int row2, int col2)
    {
        Direction dir = getDirection(row1, col1, row2, col2);
        Pillar pillar1 = getPillar(row1, col1);
        Pillar pillar2 = getNextPillar(row1, col1, dir);
        
        if(pillar1.hasPlank(dir) && pillar2.hasPlank(dir.getOtherSide()))
        {
            return true;
        }
        else 
        {
            return false;
        }        
    }
    
    public void setPillar(Pillar pillar)
    {
        pillars[pillar.getColumnNumber()][pillar.getRowNumber()]=pillar;
    }
    
    public int numColumns()
    {
        return pillars[0].length;
    }
     
    public int numRows()
    {
        return pillars.length;
    }
    
    private void populateEmptyMaze()
    {
        for(int y = 0; y < pillars.length; y++)
        {
            for(int x = 0; x < pillars[0].length; x++)
            {
                pillars[y][x] = new Pillar(x, y); 
            }
        }
    }
    
    public String toString()
    {
        String str = "";
        for(int y = 0; y < pillars[0].length; y++)
        {
            for(int x = 0; x < pillars.length; x++)
            {   
                str+="[]\t";
            }
            str+="\n";
        }
        return str;
    }
    
}
