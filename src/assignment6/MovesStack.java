package assignment6;

import java.util.Stack;
/**
 *
 * @author Benjamin Poreh
 */


public class MovesStack
{
    private Stack<Pillar> moves;
    private Maze maze;
    
    public MovesStack(Maze maze)
    {
        moves = new Stack<Pillar>();
        this.maze = maze;
    }
    
    public MovesStack(Maze maze, Stack<Pillar> stack)
    {
        moves = stack;
        this.maze = maze;
    }
    
    public Stack<Pillar> getStack()
    {
        return moves;
    }
    
    /**
     * checks if the given row and column can be added to the current stack
     * @param row
     * @param col
     * @return 
     */
    public boolean canAdd(int row, int col, boolean extraPlank)
    {
        Pillar currentPillar = moves.peek();
        int currentRow = currentPillar.getRowNumber();
        int currentColumn = currentPillar.getColumnNumber();
        //check to see if the two pillars are adjacent
        if(!isAdjacent(row, col, currentRow, currentColumn))
        {
            return false;
        }
        else if(maze.havePlank(currentRow, currentColumn, row, col))
        {
            return true;
        }
        else if(extraPlank)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private boolean isAdjacent(int row1, int col1, int row2, int col2)
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
    
}
