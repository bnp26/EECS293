package assignment6;

/**
 * Plank Class
 * @author Benjamin Poreh
 * @version 1.0
 */

public enum Plank
{
    LEFT(0), RIGHT(1), TOP(2), BOTTOM(3);

    int side;

    private Plank(int side)
    {
        this.side = side;
    }

    public Plank createNewPlank(Plank plank)
    {
        return plank;
    }
    
    public int getSide()
    {
        return side;
    }
}
