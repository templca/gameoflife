
/**
 * Write a description of class game here.
 *
 * @author cara templeton
 * @version 12/05
 */
public class game
{
    // instance variables - replace the example below with your own

    boolean present [][] = new boolean [21][21];
    boolean future [][] = new boolean [21][21];
    int neighbours;
    int y;
    int x;
    

    boolean check(boolean alive){
        alive=present[x][y];
        
        if (present[x][y+1]==true) {
            neighbours++;
        } 
        if (present[x][y-1]==true) {
            neighbours++;
        }
        if (present[x+1][y]==true) {
            neighbours++;
        }
        if (present[x+1][y+1]==true) {
            neighbours++;
        }
        if (present[x+1][y-1]==true) {
            neighbours++;
        }
        if (present[x-1][y]==true) {
            neighbours++;
        }
        if (present[x-1][y+1]==true) {
            neighbours++;
        }
        if (present[x-1][y-1]==true) {
            neighbours++;
        }
        
        if (alive==true && neighbours==2||neighbours==3){ return alive;  }
        else if (alive==false && neighbours==3) { return alive;}
        else if (alive==true && neighbours < 2) { return!alive;}
        else if (alive==true && neighbours > 3) { return !alive;}
        else {return !alive;}
    }

    /**
     * Constructor for objects of class game
     */
    public game()
    {
        // initialise instance variables
        present[2][2]=true;
        x = 0;
        for (x=0;x<20;x++){
            for (y=0;y<20;y++){
                if (check(present[x][y]==true)){
                    System.out.print("x ");
                }
                if (check(present[x][y]==false)){
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
