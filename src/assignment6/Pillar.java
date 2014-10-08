package assignment6;

/**
 * @author Benjamin Poreh
 * @version v1.0
 */
public class Pillar 
{
    //the row number that the pillar is apart of in the maze (x value)
    private int rowNumber;
    //the column number that the pillar is apart of in the maze (y value)
    private int columnNumber;
    //left plank
    private Plank leftPlank;
    //right plank
    private Plank rightPlank;
    //top plank
    private Plank topPlank;
    //bottom plank
    private Plank bottomPlank;    
   
    /**
     * private constructor for the pillar
     * @param row
     * @param col 
     */
    public Pillar(int row, int col)
    {
        rowNumber = row;
        columnNumber = col;
        leftPlank = null;
        rightPlank = null;
        topPlank = null;
        bottomPlank = null;
    }
    
    public Pillar(int row, int col, boolean left, boolean right, boolean top, boolean bottom)
    {
        rowNumber = row;
        columnNumber = col;
        addPlanks(left, right, top, bottom);
    }
    
    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public Plank getLeftPlank() {
        return leftPlank;
    }

    public void setLeftPlank(Plank leftPlank) {
        this.leftPlank = leftPlank;
    }

    public Plank getRightPlank() {
        return rightPlank;
    }

    public void setRightPlank(Plank rightPlank) {
        this.rightPlank = rightPlank;
    }

    public Plank getTopPlank() {
        return topPlank;
    }

    public void setTopPlank(Plank topPlank) {
        this.topPlank = topPlank;
    }

    public Plank getBottomPlank() {
        return bottomPlank;
    }

    public void setBottomPlank(Plank bottomPlank) {
        this.bottomPlank = bottomPlank;
    }
    
    private void addPlanks(boolean left, boolean right, boolean top, boolean bottom)
    {
        if(left) leftPlank = Plank.LEFT;
        if(right) rightPlank = Plank.RIGHT;
        if(top) topPlank = Plank.TOP;
        if(bottom) bottomPlank = Plank.BOTTOM;
    }    
}
