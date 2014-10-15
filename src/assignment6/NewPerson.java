package assignment6;

import java.util.ArrayList;
import assignment6.Maze.Direction;
import java.awt.Point;
/**
 *
 * @author Benjamin Poreh
 */


public class NewPerson 
{
    private Maze maze;
    private MovesStack movesStack;
    boolean plank;
    
    
    public NewPerson(Maze maze)
    {
        this.maze = maze;
        movesStack = new MovesStack(maze);
        plank = false;
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
        if(movesStack.canAdd(nextPillar.getRowNumber(), nextPillar.getColumnNumber())&&!movesStack.containsMove(nextPillar.getRowNumber(), nextPillar.getColumnNumber()))
        {
            //moves in the correct direction.
            movesStack.move(dir);
            if(!currentPlank)
            {
                plank = true;
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public ArrayList<Pillar> getSurroundingPillars(Pillar pillar)
    {
        ArrayList<Pillar> surroundingPillars = new ArrayList();
        
        //number of rows in the maze
        int mazeRows = maze.numRows();
        //number of columns in the maze
        int mazeColumns = maze.numColumns();
        
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
        
        //goes through the points and checks to see if they are valid
        for(Point point: points)
        {
            //if the point is not valid, removes the point from the array lists of points
            //if the pillar is not aggenst any wall/barrier
            if(!isPointValid(point, mazeRows, mazeColumns))
            {
                points.remove(point);
            }
        }
        
        return addPillarsToStack(maze, points, surroundingPillars);
    }
    
    //checks that both the row number and the column number is valid (past the mazes wall)
    private boolean isPointValid(Point point, int numRows, int numColumns)
    {
        if(isRowValid(point.x, numRows) && isColumnValid(point.y, numColumns))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //adds 
    private ArrayList addPillarsToStack(Maze maze, ArrayList<Point> points, ArrayList<Pillar> pillars)
    {
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
    
    private boolean isRowValid(int row, int numRows)
    {
        return (row >= 0 && row <= numRows);
    }
    
    private boolean isColumnValid(int column, int numColumns)
    {
        return (column >= 0 && column <= numColumns);
    }
    
    
    
}
