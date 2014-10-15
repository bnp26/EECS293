package assignment6;

import assignment6.Maze.Direction;
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
    
    public void move(Direction dir)
    {
        Pillar currentPillar = moves.peek();
        Pillar nextPillar = maze.getNextPillar(currentPillar.getRowNumber(), currentPillar.getColumnNumber(), dir);
        moves.push(nextPillar);
    }
    
    public boolean containsMove(int row, int col)
    {
        Pillar pillar = maze.getPillar(row, col);
        int location = moves.search(pillar);
        
        if(location == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public Pillar getCurrentPillar()
    {
        return moves.peek();
    }
    
    /**
     * checks if the given row and column can be added to the current stack
     * @param row
     * @param col
     * @param extraPlank
     * @return 
     */
    public boolean canAdd(int row, int col)
    {
        Pillar nextPillar = maze.getPillar(row, col);
        Pillar currentPillar = moves.peek();
        
        int currentRow = currentPillar.getRowNumber();
        int currentColumn = currentPillar.getColumnNumber();
        //check to see if the two pillars are adjacent
        if(!maze.areAdjacent(row, col, currentRow, currentColumn))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public String toString()
    {
        String str = "";
        Pillar currentPillar = moves.get(0);
        
        for(int x = 1; x < moves.size()-2; x++)
        {
            str += moveToString(currentPillar,moves.get(x));
            str += ", ";
            currentPillar = moves.get(x);
        }
        
        str += moveToString(currentPillar,moves.peek());
        str += ".";
        return str;
    }
    
    private String moveToString(Pillar pillar1, Pillar pillar2)
    {
        return pillar1.getDirectionTowardsPillar(pillar2).toString();
    }
}
