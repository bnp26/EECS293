package assignment6;

import java.util.ArrayList;

/**
 * @author Benjamin Poreh
 * @version v1.0
 */

public class Maze {
    //2D array that holds the pillars
    private Pillar[][] pillars;
    
    public Maze(int rows, int columns)
    {
        this.pillars = new Pillar[columns][rows];
        populateEmptyMaze();
    }
    
    public Pillar getPillar(int row, int col)
    {
        return pillars[col][row];
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
