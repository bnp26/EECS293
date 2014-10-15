package eecs293;

import assignment6.*;
/**
 *
 * @author Benjamin
 */


public class EECS293 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Maze maze = new Maze(4,8);
        Person person = new Person(maze);
        
        System.out.println(maze.toString());
    }
    
}
