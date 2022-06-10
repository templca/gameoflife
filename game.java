
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
 * 10/06
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
            switch (command.toLowerCase()) {
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
                for (int t=1;t<=turns;t++) { 
                    //for whatever turns is, it will change the present board into the 
                    //future board that many times
                    genNumber++;
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
                            check(present[x][y]);
                            if (present[x][y]==true){
                                System.out.print("x  ");
                            } else System.out.print("0  ");
                        }
                        System.out.println();
                    }
                    for (y=1;y<=arraySize;y++){
                        for (x=1;x<=arraySize;x++){
                            if (future[x][y]) { present[x][y]=true; }
                            else { present[x][y]=false; }
                        }
                    }
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
                case "glider":
                genNumber=1;
                for (y=1;y<=arraySize;y++){ 
                    for (x=1;x<=arraySize;x++){ //clears board
                        if (present[x][y]==true){
                            present[x][y]=false;
                        } 
                    }
                }
                //makes glider
                present[4][4]=true;
                present[5][5]=true;
                present[5][6]=true;
                present[4][6]=true;
                present[3][6]=true;
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
                case "z":
                genNumber=1;
                for (y=1;y<=arraySize;y++){ 
                    for (x=1;x<=arraySize;x++){ //clears board
                        if (present[x][y]==true){
                            present[x][y]=false;
                        } 
                    }
                }
                present[8][8]=true;
                present[9][8]=true;
                present[9][9]=true;
                present[9][10]=true;
                present[9][11]=true;
                present[10][11]=true;
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
                case "onion rings":
                genNumber=1;
                for (y=1;y<=arraySize;y++){ 
                    for (x=1;x<=arraySize;x++){ //clears board
                        if (present[x][y]==true){
                            present[x][y]=false;
                        } 
                    }
                }
                //first square
                present[6][6]=true;
                present[6][7]=true;
                present[6][8]=true;
                present[6][9]=true;
                present[7][6]=true;
                present[8][6]=true;
                present[9][6]=true;
                present[9][7]=true;
                present[9][8]=true;
                present[9][9]=true;
                present[7][9]=true;
                present[8][9]=true;
                //second square
                present[11][5]=true;
                present[12][5]=true;
                present[13][5]=true;
                present[14][5]=true;
                present[15][5]=true;
                present[16][5]=true;
                present[11][6]=true;
                present[16][6]=true;
                present[11][7]=true;
                present[13][7]=true;
                present[14][7]=true;
                present[16][7]=true;
                present[11][8]=true;
                present[13][8]=true;
                present[14][8]=true;
                present[16][8]=true;
                present[11][9]=true;
                present[16][9]=true;
                present[11][10]=true;
                present[12][10]=true;
                present[13][10]=true;
                present[14][10]=true;
                present[15][10]=true;
                present[16][10]=true;
                //bottom right square
                present[12][12]=true;
                present[12][13]=true;
                present[12][14]=true;
                present[12][15]=true;
                present[13][12]=true;
                present[14][12]=true;
                present[15][12]=true;
                present[15][13]=true;
                present[15][14]=true;
                present[15][15]=true;
                present[13][15]=true;
                present[14][15]=true;
                //bottom left square
                present[5][11]=true;
                present[6][11]=true;
                present[7][11]=true;
                present[8][11]=true;
                present[9][11]=true;
                present[10][11]=true;
                present[5][12]=true;
                present[10][12]=true;
                present[5][13]=true;
                present[7][13]=true;
                present[8][13]=true;
                present[10][13]=true;
                present[5][14]=true;
                present[7][14]=true;
                present[8][14]=true;
                present[10][14]=true;
                present[5][15]=true;
                present[10][15]=true;
                present[5][16]=true;
                present[6][16]=true;
                present[7][16]=true;
                present[8][16]=true;
                present[9][16]=true;
                present[10][16]=true;

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
                default: System.out.println("try something else");
            }
        }

    } 
}