package assignment6;
import java.util.ArrayList;
import java.awt.Point;

import assignment6.Maze.Direction;
/**
 *
 * @author Benjamin Poreh
 */


public class Person 
{
    private Maze maze;
    private MovesStack movesStack;
    boolean plank;
    
    public Person(Maze maze)
    {
        this.maze = maze;
        movesStack = new MovesStack(maze);
        plank = false;
    }
    
    public Person(Maze maze, Pillar firstPillar)
    {
        this.maze = maze;
        movesStack = new MovesStack(maze, firstPillar);
        plank = false;
    }
    
    public Maze getMaze()
    {
        return maze;
    }
    
    public MovesStack getMovesStack()
    {
        return movesStack;
    }
    
    public boolean hasPlank()
    {
        return plank;
    }
    
    public Pillar getCurrentPillar()
    {
        return movesStack.getCurrentPillar();
    }
    
    public boolean makeMove(Pillar nextPillar)
    {
        Pillar currentPillar = movesStack.getCurrentPillar();
        Direction dir = currentPillar.getDirectionTowardsPillar(nextPillar);
        
        boolean currentPlank = maze.havePlank(currentPillar, nextPillar);
        
        //checks if it can add the next pillar and that it does not currently exist in the stack
        if(movesStack.canAdd(nextPillar)&&!movesStack.containsMove(nextPillar))
        {
            if(canMoveInDirection(dir, currentPlank))
            {
                movesStack.move(dir);
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    
    private boolean canMoveInDirection(Direction dir, boolean hasPlank)
    {
        //moves in the correct direction.
        if(hasPlank)
        {
            return true;
        }
        else if(this.plank)
        {
            return false;
        }
        else
        {
            setPlankAsTrue();
            return true;
        }
    }
    
    private void setPlankAsTrue()
    {
        this.plank = true;
    }
    
    public ArrayList<Pillar> getSurroundingPillars()
    {
        Pillar pillar = getCurrentPillar();
        
        ArrayList<Point> points = new ArrayList(4);
        
        int row = pillar.getRowNumber();
        int column = pillar.getColumnNumber();
        
        //top
        points.add(new Point(row - 1, column));
        //bottom
        points.add(new Point(row + 1, column));
        //left
        points.add(new Point(row, column - 1));
        //right
        points.add(new Point(row, column + 1));
        
        points = processPointValidities(points);
        
        return arrayOfPillarsFromPoints(maze, points);
    }
    
    private ArrayList<Point> processPointValidities(ArrayList<Point> points)
    {
        //number of rows in the maze
        int mazeRows = maze.numRows();
        //number of columns in the maze
        int mazeColumns = maze.numColumns();
        
        //goes through the points and checks to see if they are valid
        for(int x = 0; x < points.size(); x = x)
        {
            Point point = points.get(x);
            //if the point is not valid, removes the point from the array lists of points
            //if the pillar is not aggenst any wall/barrier
            if(!isPointValid(point))
            {
                points.remove(x);
                continue;
            }
            x++;
        }
        return points;
    }
    
    public void addMoves(MovesStack stack)
    {
        for(Pillar pillar:stack.getStack())
        {
            if(this.movesStack.size()==0)
            {
                movesStack.getStack().push(pillar);
            }
            else
            { 
                boolean makeMove = this.makeMove(pillar);
                if(!makeMove)
                    break;
            }
        }
    }
    
    //checks that both the row number and the column number is valid (past the mazes wall)
    private boolean isPointValid(Point point)
    {
        if(isRowValid(point.x) && isColumnValid(point.y))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //adds 
    private ArrayList<Pillar> arrayOfPillarsFromPoints(Maze maze, ArrayList<Point> points)
    {
        ArrayList<Pillar> pillars = new ArrayList<Pillar>();
        //go through the points in the array list of points.
        for(Point point: points)
        {
            //find the pillar associated with the given point
            Pillar currentPillar = maze.getPillar(point.x, point.y);
            //add the pillar to the stack of pillars
            pillars.add(currentPillar);
        }
        return pillars;
    }
    
    private boolean isRowValid(int row)
    {
        return (row >= 0 && row < maze.numRows());
    }
    
    private boolean isColumnValid(int column)
    {
        return (column >= 0 && column < maze.numColumns());
    }
    
    public boolean finished()
    {
        return movesStack.onLastPillar();
    }
    
    public String toString()
    {
        return movesStack.toString();
    }
    
}
