package assignment6;
import static org.junit.Assert.*;

import org.junit.Test;

import assignment6.Maze.Direction;

/**
 * 
 */

/**
 * @author Benjamin
 *
 */
public class MazeTest
{

	private Maze mainMaze;
	
	/**
	 * Test method for {@link Maze#getStartingPillar()}.
	 */
	@Test
	public void testGetStartingPillar()
	{
		
		mainMaze = new Maze(4, 4);
		
		Pillar startingPillar = mainMaze.getStartingPillar();
		
		assertSame(startingPillar, mainMaze.getPillar(0, 0));
	}

	/**
	 * Test method for {@link Maze#areAdjacent(Pillar, Pillar)}.
	 */
	@Test
	public void testAreAdjacent()
	{
		mainMaze = new Maze(4,4);
		
		Pillar startingPillar = mainMaze.getStartingPillar();
		Pillar pillarR0C2 = mainMaze.getPillar(0, 2);
		
		//comaring the 2 pillars. should NOT be adjacent
		
		assertFalse(mainMaze.areAdjacent(startingPillar, pillarR0C2));
		
		Pillar pillarR0C1 = mainMaze.getPillar(0, 1);
		
		//should be adjacent;
		
		assertTrue(mainMaze.areAdjacent(startingPillar, pillarR0C1));

	}


	/**
	 * Test method for {@link Maze#getPillar(int, int)}.
	 */
	@Test
	public void testGetPillar()
	{
		mainMaze = new Maze(2,2);
		
		Pillar pillar1 = new Pillar(0,0);
		
		mainMaze.setPillar(pillar1);
		
		assertSame(mainMaze.getPillar(0, 0), pillar1);
		
	}

	/**
	 * Test method for {@link Maze#getNextPillar(int, int, Maze.Direction)}.
	 */
	@Test
	public void testGetNextPillar()
	{
		mainMaze = new Maze(2,2);
		
		Pillar pillarR0C0 = new Pillar(0,0);
		
		Pillar pillarR0C1 = new Pillar(0,1);
		
		mainMaze.setPillar(pillarR0C1);
		
		assertSame(mainMaze.getNextPillar(0, 0, Direction.RIGHT), pillarR0C1);
	}

	/**
	 * Test method for {@link Maze#havePlank(Pillar, Pillar)}.
	 */
	@Test
	public void testHavePlank()
	{
		mainMaze = new Maze(2,2);
		
		Pillar pillarR0C0 = new Pillar(0,0);
		
		Pillar pillarR0C1 = new Pillar(0,1);
		
		//should return false
		
		mainMaze.setPillar(pillarR0C0);
		mainMaze.setPillar(pillarR0C1);
		
		assertFalse(mainMaze.havePlank(pillarR0C0, pillarR0C1));
		
		
		
		pillarR0C0 = new Pillar(0,0,false, true, false, false);
		
		pillarR0C1 = new Pillar(0,1,true, false, false, false);
		
		mainMaze.setPillar(pillarR0C0);
		mainMaze.setPillar(pillarR0C1);
		
		assertTrue(mainMaze.havePlank(pillarR0C0, pillarR0C1));
		
	}

	/**
	 * Test method for {@link Maze#setPillar(Pillar)}.
	 */
	@Test
	public void testSetPillar()
	{
		mainMaze = new Maze(2,2);
		
		Pillar pillarR0C0 = new Pillar(0,0,false, true, false, false);
		
		assertNotSame(mainMaze.getPillar(0, 0), pillarR0C0);
		
		mainMaze.setPillar(pillarR0C0);
		
		assertSame(mainMaze.getPillar(0, 0), pillarR0C0);
	}

	/**
	 * Test method for {@link Maze#numColumns()}.
	 */
	@Test
	public void testNumColumns()
	{
		int numColumns = 5;
		
		mainMaze = new Maze(3,5);
		
		assertSame(numColumns, mainMaze.numColumns());
		
	}

	/**
	 * Test method for {@link Maze#numRows()}.
	 */
	@Test
	public void testNumRows()
	{
			int numRows = 5;
		
			mainMaze = new Maze(5,3);
		
			assertSame(numRows, mainMaze.numRows());
	}

}
