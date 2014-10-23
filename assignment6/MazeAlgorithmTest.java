package assignment6;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


public class MazeAlgorithmTest
{

	@Test
	public void testSolveMaze()
	{
		Maze maze = new Maze(5,5);
        //pillar (0,0)
        Pillar pillarR0C0 = new Pillar(0, 0);
        //pillar (0,1)
        Pillar pillarR0C1 = new Pillar(0, 1);
        //pillar (0,2)
        Pillar pillarR0C2 = new Pillar(0, 1);
        //pillar (0,3)
        Pillar pillarR0C3 = new Pillar(0, 3);
        //pillar (0,4)
        Pillar pillarR0C4 = new Pillar(0, 4);
        //pillar (1,0)
        Pillar pillarR1C0 = new Pillar(1, 0);
        //pillar (1,1)
        Pillar pillarR1C1 = new Pillar(1, 1);
        //pillar (1,2)
        Pillar pillarR1C2 = new Pillar(1, 2);
        //pillar (1,3)
        Pillar pillarR1C3 = new Pillar(1, 3);
        //pillar (1,4)
        Pillar pillarR1C4 = new Pillar(1, 4);
        //pillar (2,0)
        Pillar pillarR2C0 = new Pillar(2, 0);
        //pillar (2,1)
        Pillar pillarR2C1 = new Pillar(2, 1);
        //pillar (2,2)
        Pillar pillarR2C2 = new Pillar(2, 2);
        //pillar (2,3)
        Pillar pillarR2C3 = new Pillar(2, 3);
        //pillar (2,4)
        Pillar pillarR2C4 = new Pillar(2, 4);
        //pillar (3,0)
        Pillar pillarR3C0 = new Pillar(3, 0);
        //pillar (3,1)
        Pillar pillarR3C1 = new Pillar(3, 1);
        //pillar (3,2)
        Pillar pillarR3C2 = new Pillar(3, 2);
        //pillar (3,3)
        Pillar pillarR3C3 = new Pillar(3, 3);
        //pillar (3,4)
        Pillar pillarR3C4 = new Pillar(3, 4);
        //pillar (4,0)
        Pillar pillarR4C0 = new Pillar(4, 0);
        //pillar (4,1)
        Pillar pillarR4C1 = new Pillar(4, 1);
        //pillar (4,2)
        Pillar pillarR4C2 = new Pillar(4, 2);
        //pillar (4,3)
        Pillar pillarR4C3 = new Pillar(4, 3);
        //pillar (4,4)
        Pillar pillarR4C4 = new Pillar(4, 4);

        //left, right, up, down
        //row1
        pillarR0C0.setPlanks(false, true, false, false);
        maze.setPillar(pillarR0C0);
        pillarR0C1.setPlanks(true, true, false, false);
        maze.setPillar(pillarR0C1);
        pillarR0C2.setPlanks(true, false, false, true);
        maze.setPillar(pillarR0C2);
        pillarR0C3.setPlanks(false, true, false, false);    
        maze.setPillar(pillarR0C3);
        pillarR0C4.setPlanks(true, false, false, true);
        maze.setPillar(pillarR0C4);
        //ROW1
        //[0,0]-[0,1]-[0,2] [0,3]-[0,4]
        //              |           |

        //row2
        pillarR1C0.setPlanks(false, true, false, false);
        maze.setPillar(pillarR1C0);
        pillarR1C1.setPlanks(true, false, false, true);
        maze.setPillar(pillarR1C1);
        pillarR1C2.setPlanks(false, true, true, true);
        maze.setPillar(pillarR1C2);
        pillarR1C3.setPlanks(true, false, false, false);
        maze.setPillar(pillarR1C3);
        pillarR1C4.setPlanks(false, false, true, true);
        maze.setPillar(pillarR1C4);

        //row3
        pillarR2C0.setPlanks(false, false, false, true);
        maze.setPillar(pillarR2C0);
        pillarR2C1.setPlanks(false, true, true, true);
        maze.setPillar(pillarR2C1);
        pillarR2C2.setPlanks(true, false, true, false);
        maze.setPillar(pillarR2C2);
        pillarR2C3.setPlanks(false, false, false, true);
        maze.setPillar(pillarR2C3);
        pillarR2C4.setPlanks(false, false, true, false);
        maze.setPillar(pillarR2C4);

        //row4
        pillarR3C0.setPlanks(false, false, true, false);
        maze.setPillar(pillarR3C0);
        pillarR3C1.setPlanks(false, true, true, false);
        maze.setPillar(pillarR3C1);
        pillarR3C2.setPlanks(true, true, false, true);
        maze.setPillar(pillarR3C2);
        pillarR3C3.setPlanks(true, true, true, true);
        maze.setPillar(pillarR3C3);
        pillarR3C4.setPlanks(true, false, false, true);
        maze.setPillar(pillarR3C4);
        //row5
        pillarR4C0.setPlanks(false, false, false, false);
        maze.setPillar(pillarR4C0);
        pillarR4C1.setPlanks(false, false, false, false);
        maze.setPillar(pillarR4C1);
        pillarR4C2.setPlanks(false, false, true, false);
        maze.setPillar(pillarR4C2);
        pillarR4C3.setPlanks(false, false, true, false);
        maze.setPillar(pillarR4C3);
        pillarR4C4.setPlanks(false, false, true, false);
        maze.setPillar(pillarR4C4);
        
        MazeAlgorithm mazeAlgorithm = new MazeAlgorithm(maze);
        
        List<Person> peopleWhoMadeItInShortestMoves = mazeAlgorithm.solveMaze();
        
        Person person1 = new Person(maze, pillarR0C0);
        Person person2 = new Person(maze, pillarR0C0);
        
        person1.makeMove(pillarR1C0);person1.makeMove(pillarR1C1);person1.makeMove(pillarR2C1);person1.makeMove(pillarR3C1);person1.makeMove(pillarR3C2);person1.makeMove(pillarR3C3);person1.makeMove(pillarR3C4);person1.makeMove(pillarR4C4);
        person2.makeMove(pillarR0C1);person2.makeMove(pillarR1C1);person2.makeMove(pillarR2C1);person2.makeMove(pillarR3C1);person2.makeMove(pillarR3C2);person2.makeMove(pillarR3C3);person2.makeMove(pillarR3C4);person2.makeMove(pillarR4C4);
        

        Person person1Maybe = peopleWhoMadeItInShortestMoves.get(0);
        Person person2Maybe = peopleWhoMadeItInShortestMoves.get(1);
        
        
        assertSame(person1.toString(), person1Maybe.toString());
        
        assertSame(person2.toString(), person2Maybe.toString());
        
	}

}
