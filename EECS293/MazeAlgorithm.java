package assignment6;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/**
 *
 * @author Benjamin
 */


public class MazeAlgorithm {

    private Maze maze;
    /**
     * @param args the command line arguments
     */
    public MazeAlgorithm(Maze maze)
    {
        this.maze = maze;   
    }
    
    public List<Person> solveMaze()
    {
        List<Person> people = new ArrayList<Person>();
        
        //get starting pillar which is always (0,0)
        Person person = new Person(maze, maze.getStartingPillar());
        
        //add person to the list of people
        people.add(person);
        
        int peopleSize = people.size();
        boolean finished = false;
        
        //Algorithm
        //while array of people is not 0 or we are not finished.
        while(people.size()!=0&&!finished)
        {
            //initialize an array of people
            ArrayList<Person> allPeople = new ArrayList<Person>();
            //for each person in the array:
            for(int x = 0; x < people.size(); x++)
            {
                //currentPerson <- current person in the array
                Person currentPerson = people.get(x);
                if(currentPerson.finished())
                {
                    finished = true;
                    //returns all the people who are finished.
                    allPeople = (ArrayList<Person>) getFinalFinishedPeople(people);
                    break;
                }
                //adds all the people after a move is made and actually works
                allPeople.addAll(processPerson(currentPerson));
            }
            people = allPeople;
        }
    
        return people;
    }
    
    private List<Person> getFinalFinishedPeople(List<Person> people)
    {
        //for each person in people
        for(int x = 0; x < people.size();)
        {
            //if this person has finished the maze just increment x
            //otherwise, remove that person from the array of people
            if(people.get(x).finished())
            {
                x++;
            }
            else
            {
                people.remove(x);
            }
        }
        //return the array of people who finished the maze
        return people;
    }
    
    private ArrayList<Person> processPerson(Person person)
    {
        ArrayList<Person> people = new ArrayList<Person>();
        ArrayList<Pillar> surroundingPillars = person.getSurroundingPillars();
        ArrayList<Boolean> madeMoves = new ArrayList<Boolean>();
        
        //for each of the surrounding pillars:
        for(int x = 0; x < surroundingPillars.size(); x++)
        {
            //create a new person that is a copy of the old person
            Person newPerson = new Person(person.getMaze());
            //add the old moves of the old person so it becomes Identical to the old person
            newPerson.addMoves(person.getMovesStack());
            
            //get the current pillar of the surrounding pillars
            Pillar currentPillar = surroundingPillars.get(x);
            //make a move to the new pillar
            //madeMove <- wether or not the move was made
            boolean madeMove = newPerson.makeMove(currentPillar);
            //add the current move to the list of made moves
            madeMoves.add(madeMove);
            //add the current person who made this move to the list of people
            people.add(newPerson);
        }
        //for each of the new people who made moves to each of the surounding pilars
        for(int x = 0; x < people.size(); x++)
        {
            // currentPerson <- current person that is being analized 
            Person currentPerson = people.get(x);
            //get the boolean value of whether the move was made
            if(madeMoves.get(x))
            {
                //if it was made, just go to the next person
                continue;
            }
            else
            {
                //if the move was NOT made:
                    //remove that person and the failed move from there corrosponding lists.
                people.remove(x);
                surroundingPillars.remove(x);
                madeMoves.remove(x);
                x--;
            }
        }
        //return the people who made valid moves
        return people;
    }
    
}
