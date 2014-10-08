package assignment6;

import java.awt.Point;
import java.util.Stack;
import java.util.ArrayList;
/**
 *
 * @author Benjamin Poreh
 * @version v1.0
 */


public class Person 
{
    //one time use plank
    private Plank plank;
    //tells you wether the plank was used.
    private ArrayList<Stack<Pillar>> movesArray;
    
    public Person()
    {
        movesArray = new ArrayList<Stack<Pillar>>();
    }
    
    public Stack<Pillar> findShortestPath(Maze maze)
    {
        Point start = new Point(maze.numRows(), maze.numColumns());
        Point end = new Point(0, 0);
        
        
        
        return new Stack<Pillar>();
    }
    
    private void processCurrentPillar(Maze maze, Stack<Pillar> currentMoves)
    {
        int currentIndex = movesArray.indexOf(currentMoves);
        
        Pillar currentPillar = currentMoves.peek();
        //gets the surrounding valid pillars
        ArrayList<Pillar> surroundingPillars = getSurroundingPillars(maze, currentPillar.getRowNumber(), currentPillar.getColumnNumber());
        
        for(int x = 0; x < surroundingPillars.size(); x++)
        {
            Stack<Pillar> newMoves = new Stack();
            newMoves.addAll(currentMoves);
            newMoves.push(surroundingPillars.get(x));
            movesArray.add(currentIndex+x, currentMoves);
        }
        
        
    }
    
    private Pillar getCurrentPillar(Maze maze, Point point)
    {
        return maze.getPillar(point.x, point.y);
    }
    
    private ArrayList<Pillar> getSurroundingPillars(Maze maze, int row, int column)
    {
        ArrayList<Pillar> surroundingPillars = new ArrayList();
        
        //number of rows in the maze
        int mazeRows = maze.numRows();
        //number of columns in the maze
        int mazeColumns = maze.numColumns();
        
        ArrayList<Point> points = new ArrayList(8);
        
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
            if(!isPointValid(point, mazeRows, mazeColumns))
            {
                points.remove(point);
            }
        }
        
        return addPillarsToStack(maze, points, surroundingPillars);
    }
    
    
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
    
    private boolean isRowValid(int row, int numRows)
    {
        return (row >= 0 && row <= numRows);
    }
    
    private boolean isColumnValid(int column, int numColumns)
    {
        return (column >= 0 && column <= numColumns);
    } 
    
}