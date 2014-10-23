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
    
    public MovesStack(Maze maze, Pillar pillar)
    {
        this.moves = new Stack<Pillar>();
        this.maze = maze;
        moves.push(pillar);
//        System.out.println(pillar.getRowNumber() + ", " + pillar.getColumnNumber());
//        System.out.println(moves.peek().getRowNumber() + ", " + moves.peek().getColumnNumber());
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
    
    public int size()
    {
        return moves.size();
    }
    
    public boolean addMovesToStack(MovesStack stack)
    {
        for(Pillar pillar:stack.getStack())
        {
            if(canAdd(pillar))
            {
                moves.push(pillar);
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    
    public boolean containsMove(Pillar pillar)
    {
        //checking nullability of pillar.
        
        isPillarNull(pillar);
        if(moves.search(pillar)==-1)
            return false;
        else
            return true;
    }
    
    public boolean onLastPillar()
    {
        if(moves.peek().equals(maze.getPillar(maze.numRows()-1, maze.numColumns()-1)))
        {
            return true;
        }
        else
        {
            return false;
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
    public boolean canAdd(Pillar nextPillar)
    {
        //checks nullability of pillar
        isPillarNull(nextPillar);
        
        Pillar currentPillar = moves.peek();
        //check to see if the two pillars are adjacent
        if(maze.areAdjacent(currentPillar, nextPillar))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String toString()
    {
        String str = "Moves Stack: ";
        Pillar currentPillar = moves.firstElement();
        for(Pillar pillar: moves.subList(0, moves.size()))
        {
            str += pillar.toString()+" ";
        }
        return str;
    }
    
    private String moveToString(Pillar pillar1, Pillar pillar2)
    {
        return pillar1.getDirectionTowardsPillar(pillar2).toString();
    }
    
    //throws null pointer exception
    private void isPillarNull(Pillar pillar)
    {
        if(pillar == null)
            throw new NullPointerException("pillar is null");
    }
}

