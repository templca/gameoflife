
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
 * 27/05
 * 1/06
 * 2/06
 * 8/06
 * 9/06
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
    int labelA=1;
    int label1=1;
    int arraySize=20;
    int genNumber=1;

    void check(boolean alive){
        // checks for neighbours around the cell
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
        //game of life rules

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

        present[20][20]=true;
        present[15][3]=true;
        present[1][1]=true;
        present[3][5]=true;
        present[4][5]=true;
        present[5][5]=true;
        // just test starting cells

        labelA=1;
        label1=1;
        System.out.println("generation: "+genNumber);
        //prints out column numebrs
        System.out.print("    ");
        for (int i=1;i<=arraySize;i++) {
            if (labelA>=10) { System.out.print(labelA++ + " "); }
            else { System.out.print(labelA++ + "  "); }
        }
        System.out.println();
        for (y=1;y<=arraySize;y++){
            //prints out rownumbers
            if (label1>=10) { System.out.print(label1++  + "  "); }
            else { System.out.print(" " +label1++  + "  "); }
            for (x=1;x<=arraySize;x++){ //prints board x for true 0 for false
                if (present[x][y]==true){
                    System.out.print("x  ");
                } else System.out.print("0  ");
            }
            System.out.println();
        }

        while (running==true) {
            command=type.nextLine();
            switch (command) {
                case "next": 
                case "n":
                labelA=1;
                label1=1;
                genNumber++;
                System.out.println("generation: "+genNumber); // next turn
                //prints column numbers
                System.out.print("    ");
                for (int i=1;i<=arraySize;i++) {
                    if (labelA>=10) { System.out.print(labelA++ + " "); }
                    else { System.out.print(labelA++ + "  "); }
                }
                System.out.println();
                for (y=1;y<=arraySize;y++){
                    //prints row numbers
                    if (label1>=10) { System.out.print(label1++  + "  "); }
                    else { System.out.print(" " +label1++  + "  "); }
                    for (x=1;x<=arraySize;x++){
                        // runs method that checks for neighbours and then prints new board
                        check(present[x][y]);
                        if (future[x][y]==true){
                            System.out.print("x  ");
                        } else System.out.print("0  ");
                    }
                    System.out.println();
                }
                // turns the future array into the present array so it goes infinite turns
                for (y=1;y<=arraySize;y++){
                    for (x=1;x<=arraySize;x++){
                        if (future[x][y]) { present[x][y]=true; }
                        else { present[x][y]=false; }
                    }
                }
                break;
                case "multiple turns":
                case "t":
                int turns;
                System.out.println("how many turns to advance?");
                turns=type.nextInt();
                for (y=1;y<=arraySize;y++){
                    for (x=1;x<=arraySize;x++){
                        // runs method that checks for neighbours and then prints new board
                        check(present[x][y]);
                    }
                }
                for (int t=1;t<=turns;t++) { 
                    //for whatever turns is, it will change the present board into the 
                    //future board that many times
                    genNumber++;
                    for (y=1;y<=arraySize;y++){
                        for (x=1;x<=arraySize;x++){
                            if (future[x][y]) { present[x][y]=true; }
                            else { present[x][y]=false; }
                        }
                    }
                }
                //prints current board
                labelA=1;
                label1=1;
                System.out.println("generation: "+genNumber);
                //prints out column numbers
                System.out.print("    ");
                for (int i=1;i<=arraySize;i++) {
                    if (labelA>=10) { System.out.print(labelA++ + " "); }
                    else { System.out.print(labelA++ + "  "); }
                }
                System.out.println();
                for (y=1;y<=arraySize;y++){ 
                    //prints out row numbers
                    if (label1>=10) { System.out.print(label1++  + "  "); }
                    else { System.out.print(" " +label1++  + "  "); }
                    for (x=1;x<=arraySize;x++){ //prints board
                        if (present[x][y]==true){
                            System.out.print("x  ");
                        } else System.out.print("0  ");
                    }
                    System.out.println();
                }
                command=type.nextLine();
                break;
                //ends loop
                case "end": running=false;
                break;
                case "current":
                case "c":
                //prints current board
                labelA=1;
                label1=1;
                System.out.println("generation: "+genNumber);
                //prints out column numbers
                System.out.print("    ");
                for (int i=1;i<=arraySize;i++) {
                    if (labelA>=10) { System.out.print(labelA++ + " "); }
                    else { System.out.print(labelA++ + "  "); }
                }
                System.out.println();
                for (y=1;y<=arraySize;y++){ 
                    //prints out row numbers
                    if (label1>=10) { System.out.print(label1++  + "  "); }
                    else { System.out.print(" " +label1++  + "  "); }
                    for (x=1;x<=arraySize;x++){ //prints board
                        if (present[x][y]==true){
                            System.out.print("x  ");
                        } else System.out.print("0  ");
                    }
                    System.out.println();
                }
                break;
                case "make alive":
                case "resurrect":
                case "revive":
                case "r":
                //changes cells to alive
                int row;
                int column;
                System.out.println("what column number?");
                row=type.nextInt();
                System.out.println("what row number?");
                column=type.nextInt();
                if (row>20|| column>20|| row<=0|| column<=0) { 
                    System.out.println("coordinate not available.");
                } else {
                    System.out.println("coordinate [" + row + ", "+ column + "] changed to alive");
                    present[row][column]=true; 
                }
                command=type.nextLine();
                break;
                case "make dead":
                case "kill":
                case "k":
                //changes cells to dead
                System.out.println("what column number?");
                row=type.nextInt();
                System.out.println("what row number?");
                column=type.nextInt();
                if (row>20|| column>20|| row<=0|| column<=0) { 
                    System.out.println("coordinate not available.");
                } else {
                    System.out.println("coordinate [" + row + ", "+ column + "] changed to dead");
                    present[row][column]=false; 
                }
                command=type.nextLine();
                break;
                default: System.out.println("try something else");
            }
        }

    } 
}