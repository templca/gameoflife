
/**
 * Write a description of class game here.
 *
 * @author cara templeton
 * @version 12/05
 * 13/05
 */
public class game
{
    // instance variables - replace the example below with your own

    boolean present [][] = new boolean [22][22];
    boolean future [][] = new boolean [22][22];
    int neighbours;
    int y;
    int x;

    boolean check(boolean alive){
        alive=present[x][y];
        if (x==0) {
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
        } else if (x > 21) { 
            if (present[x][y+1]==true) {
                neighbours++;
            } 
            if (present[x][y-1]==true) {
                neighbours++;
            }
            if (present[x-1][y+1]==true) {
                neighbours++; }
            if (present[x-1][y]==true) {
                neighbours++; 
            }
            if (present[x-1][y-1]==true) {
                neighbours++; 
            }
        } else if (y==0) {
            if (present[x][y+1]==true) {
                neighbours++;
            } 
            if (present[x+1][y+1]==true) {
                neighbours++; 
            }
            if (present[x+1][y]==true) {
                neighbours++; 
            }
            if (present[x-1][y+1]==true) {
                neighbours++; }
            if (present[x-1][y]==true) {
                neighbours++; 
            }
        } else if (y > 21) {
            if (present[x][y-1]==true) {
                neighbours++;
            }
            if (present[x+1][y-1]==true) {
                neighbours++; 
            }
            if (present[x+1][y]==true) {
                neighbours++; 
            }
            if (present[x-1][y]==true) {
                neighbours++; 
            }
            if (present[x-1][y-1]==true) {
                neighbours++; 
            }
        } else {
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
                neighbours++; }
            if (present[x-1][y]==true) {
                neighbours++; 
            }
            if (present[x-1][y-1]==true) {
                neighbours++; 
            }
        }
        
        
        if (alive==true && neighbours==2||neighbours==3){ 
            future[x][y]=true;
            return alive;  }
        else if (alive==false && neighbours==3) { 
            future[x][y]=true;
            return alive;}
        else if (alive==true && neighbours < 2) { 
            future[x][y]=false;
            return!alive;}
        else if (alive==true && neighbours > 3) { 
            future[x][y]=false;
            return !alive;}
        else {
            future[x][y]=false;
            return !alive;
        }
    }

    /**
     * Constructor for objects of class game
     */
    public game()
    {
        // initialise instance variables
        present[3][5]=true;
        present[4][5]=true;
        present[5][5]=true;
        x = 0;
        System.out.println("first gen");
        for (x=1;x<21;x++){
            for (y=1;y<21;y++){
                if (present[x][y]==true){
                    System.out.print("x ");
                } else System.out.print("0 ");
            }
            System.out.println();
        }

        System.out.println("next gen");
        for (x=1;x<21;x++){
            for (y=1;y<21;y++){
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