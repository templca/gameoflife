
/**
 * Write a description of class game here.
 *
 * @author cara templeton
 * @version 12/05
 * 13/05
 * 18/05
 * 19/05
 * 20/05
 * 25/05
 * 26/05
 */

import java.util.Scanner;
public class game
{
    // instance variables - replace the example below with your own
    boolean present [][] = new boolean [22][22];
    boolean future [][] = new boolean [22][22];
    int neighbours=0;
    int y;
    int x;
    boolean running=true;
    String command;

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
        Scanner type = new Scanner(System.in);
        future[20][20]=true;
        future[15][3]=true;
        future[3][2]=true;
        future[1][1]=true;
        future[3][5]=true;
        future[4][5]=true;
        future[5][5]=true;

        present[20][20]=true;
        present[15][3]=true;
        present[3][2]=true;
        present[1][1]=true;
        present[3][5]=true;
        present[4][5]=true;
        present[5][5]=true;

        System.out.println("first generation");
        for (y=1;y<21;y++){
            for (x=1;x<21;x++){
                if (present[x][y]==true){
                    System.out.print("x ");
                } else System.out.print("0 ");
            }
            System.out.println();
        }

        while (running==true) {
            command=type.nextLine();
            switch (command) {
                case "next": 
                System.out.println("next generation");
                for (y=1;y<21;y++){
                    for (x=1;x<21;x++){
                        check(present[x][y]);
                        if (future[x][y]==true){
                            System.out.print("x ");
                        } else System.out.print("0 ");
                    }
                    System.out.println();
                }
                break;
                case "end": running=false;
                break;
                case "current": 
                System.out.println("this generation");
                for (y=1;y<21;y++){
                    for (x=1;x<21;x++){
                        if (present[x][y]==true){
                            System.out.print("x ");
                        } else System.out.print("0 ");
                    }
                    System.out.println();
                }
                break;
                case "make alive":
                int row;
                int column;
                System.out.println("what row number?");
                row=type.nextInt();
                System.out.println("what column number?");
                column=type.nextInt();
                System.out.println("Coordinate [" + row + ", "+ column + "] changed to alive");
                present[row][column]=true;
                break;
                case "make dead":
                System.out.println("what row number?");
                row=type.nextInt();
                System.out.println("what column number?");
                column=type.nextInt();
                System.out.println("Coordinate [" + row + ", " + column + "] changed to dead");
                present[row][column]=false;
                break;
                default: System.out.println("try something else");
            }
        }

    } 
}