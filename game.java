
/**
 * Write a description of class game here.
 *
 * @author cara templeton
 * @version 12/05
 * 13/05
 * 18/05
 * 19/05
 * 20/05
 */
public class game
{
    // instance variables - replace the example below with your own

    boolean present [][] = new boolean [22][22];
    boolean future [][] = new boolean [22][22];
    int neighbours=0;
    int y;
    int x;

    void check(boolean alive){
        neighbours=0;
        if (present[x][y+1]==true) {
            neighbours++;
        } 
        if (present[x][y-1]==true) {
            neighbours++;
        }
        if (present[x+1][y+1]==true) {
            neighbours++; 
        }
        if (present[x+1][y-1]==true) {
            neighbours++; 
        }
        if (present[x+1][y]==true) {
            neighbours++; 
        }
        if (present[x-1][y+1]==true) {
            neighbours++; 
        }
        if (present[x-1][y]==true) {
            neighbours++; 
        }
        if (present[x-1][y-1]==true) {
            neighbours++; 
        }

        if (present[x][y]==true && neighbours==2||neighbours==3){ 
            future[x][y]=true; }
        else if (present[x][y]==false && neighbours==3) { 
            future[x][y]=true; }
        else if (present[x][y]==true && neighbours < 2) { 
            future[x][y]=false; }
        else if (present[x][y]==true && neighbours > 3) { 
            future[x][y]=false; }
        else {
            future[x][y]=false; 
        }

    }

    /**
     * Constructor for objects of class game
     */
    public game()
    {
        // initialise instance variables
        present[20][20]=true;
        present[15][3]=true;
        present[3][2]=true;
        present[1][1]=true;
        present[3][5]=true;
        present[4][5]=true;
        present[5][5]=true;
        
        System.out.println("first gen");
        for (y=1;y<21;y++){
            for (x=1;x<21;x++){
                if (present[x][y]==true){
                    System.out.print("x ");
                } else System.out.print("0 ");
            }
            System.out.println();
        }

        System.out.println("next gen");
        for (y=1;y<21;y++){
            for (x=1;x<21;x++){
                check(present[x][y]);
                if (future[x][y]==true){
                    System.out.print("x ");
                } else System.out.print("0 ");
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