package eecs293;

import assignment6.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/**
 *
 * @author Benjamin
 */


public class EECS293 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Maze maze = new Maze(5,5);
        
        //pillar (0,0)
        Pillar pillarR0C0 = maze.getPillar(0, 0);
        //pillar (0,1)
        Pillar pillarR0C1 = maze.getPillar(0, 1);
        //pillar (0,2)
        Pillar pillarR0C2 = maze.getPillar(0, 2);
        //pillar (0,3)
        Pillar pillarR0C3 = maze.getPillar(0, 3);
        //pillar (0,4)
        Pillar pillarR0C4 = maze.getPillar(0, 4);
        //pillar (1,0)
        Pillar pillarR1C0 = maze.getPillar(1, 0);
        //pillar (1,1)
        Pillar pillarR1C1 = maze.getPillar(1, 1);
        //pillar (1,2)
        Pillar pillarR1C2 = maze.getPillar(1, 2);
        //pillar (1,3)
        Pillar pillarR1C3 = maze.getPillar(1, 3);
        //pillar (1,4)
        Pillar pillarR1C4 = maze.getPillar(1, 4);
        //pillar (2,0)
        Pillar pillarR2C0 = maze.getPillar(2, 0);
        //pillar (2,1)
        Pillar pillarR2C1 = maze.getPillar(2, 1);
        //pillar (2,2)
        Pillar pillarR2C2 = maze.getPillar(2, 2);
        //pillar (2,3)
        Pillar pillarR2C3 = maze.getPillar(2, 3);
        //pillar (2,4)
        Pillar pillarR2C4 = maze.getPillar(2, 4);
        //pillar (3,0)
        Pillar pillarR3C0 = maze.getPillar(3, 0);
        //pillar (3,1)
        Pillar pillarR3C1 = maze.getPillar(3, 1);
        //pillar (3,2)
        Pillar pillarR3C2 = maze.getPillar(3, 2);
        //pillar (3,3)
        Pillar pillarR3C3 = maze.getPillar(3, 3);
        //pillar (3,4)
        Pillar pillarR3C4 = maze.getPillar(3, 4);
        //pillar (4,0)
        Pillar pillarR4C0 = maze.getPillar(4, 0);
        //pillar (4,1)
        Pillar pillarR4C1 = maze.getPillar(4, 1);
        //pillar (4,2)
        Pillar pillarR4C2 = maze.getPillar(4, 2);
        //pillar (4,3)
        Pillar pillarR4C3 = maze.getPillar(4, 3);
        //pillar (4,4)
        Pillar pillarR4C4 = maze.getPillar(4, 4);
        
        
        //left, right, up, down
        //row1
        pillarR0C0.setPlanks(false, true, false, false);
        pillarR0C1.setPlanks(true, true, false, false);
        pillarR0C2.setPlanks(true, false, false, true);
        pillarR0C3.setPlanks(false, true, false, false);    
        pillarR0C4.setPlanks(true, false, false, true);
        
        //ROW1
        //[0,0]-[0,1]-[0,2] [0,3]-[0,4]
        //              |           |
        
        //row2
        pillarR1C0.setPlanks(false, true, false, false);
        pillarR1C1.setPlanks(true, false, false, true);
        pillarR1C2.setPlanks(false, true, true, true);
        pillarR1C3.setPlanks(true, false, false, false);
        pillarR1C4.setPlanks(false, false, true, true);
        
        //row3
        pillarR2C0.setPlanks(false, false, false, true);
        pillarR2C1.setPlanks(false, true, true, true);
        pillarR2C2.setPlanks(true, false, true, false);
        pillarR2C3.setPlanks(false, false, false, true);
        pillarR2C4.setPlanks(false, false, true, false);
        
        //row4
        pillarR3C0.setPlanks(false, false, true, false);
        pillarR3C1.setPlanks(false, true, true, false);
        pillarR3C2.setPlanks(true, true, false, true);
        pillarR3C3.setPlanks(true, true, true, true);
        pillarR3C4.setPlanks(true, false, false, true);
        
        //row5
        pillarR4C0.setPlanks(false, false, false, false);
        pillarR4C1.setPlanks(false, false, false, false);
        pillarR4C2.setPlanks(false, false, true, false);
        pillarR4C3.setPlanks(false, false, true, false);
        pillarR4C4.setPlanks(false, false, true, false);
        
        List<Person> people = new ArrayList<Person>();
        
        Person person = new Person(maze, pillarR0C0);
        
        System.out.println(person);
        people.add(person);
        int peopleSize = people.size();
        boolean finished = false;
        
        while(people.size()!=0&&!finished)
        {
            if(people.get(people.size()-1).finished())
            {
                finished = true;
                break;
            }
            ArrayList<Person> allPeople = new ArrayList<Person>();
            for(int x = 0; x < people.size(); x++)
            {
                Person currentPerson = people.get(x);
                System.out.println("people size: "+people.size());
                allPeople.addAll(processPerson(currentPerson));
            }
            people = allPeople;
        }
    
        for(Person current: people)
        {
            System.out.println(current);
        }
    }
    
    private static ArrayList<Person> processPerson(Person person)
    {
        ArrayList<Person> people = new ArrayList<Person>();
        ArrayList<Pillar> surroundingPillars = person.getSurroundingPillars();
        ArrayList<Boolean> madeMoves = new ArrayList<Boolean>();
        
        for(int x = 0; x < surroundingPillars.size(); x++)
        {
            Person newPerson = new Person(person.getMaze());
            
            newPerson.addMoves(person.getMovesStack());
            
            Pillar currentPillar = surroundingPillars.get(x);
            boolean madeMove = newPerson.makeMove(currentPillar);
            madeMoves.add(madeMove);
            people.add(newPerson);
        }
        System.out.println(people.size());
        for(int x = 0; x < people.size(); x++)
        {
            Person currentPerson = people.get(x);
            if(madeMoves.get(x))
            {
                continue;
            }
            else
            {
                people.remove(x);
                surroundingPillars.remove(x);
                madeMoves.remove(x);
                x--;
            }
        }
        return people;
    }
    
}
