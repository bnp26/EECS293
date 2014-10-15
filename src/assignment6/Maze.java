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
        
        public String toString()
        {
            switch(this)
            {
            case LEFT:
                return "LEFT";
            case RIGHT:
                return "RIGHT";
            case UP:
                return "UP";
            case DOWN:
                return "DOWN";
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
    
    public boolean havePlank(Pillar pillar1, Pillar pillar2)
    {
        //finds the current direction
        Direction dir = pillar1.getDirectionTowardsPillar(pillar2);
        
        if(pillar1.hasPlank(dir) && pillar2.hasPlank(dir.getOtherSide()))
        {
            return true;
        }
        else 
        {
            return false;
        }     
    }
    
    private boolean findPlank(Pillar pillar1, Pillar pillar2)
    {
        Direction dir = pillar1.getDirectionTowardsPillar(pillar2);
        
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
