
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
 * 15/06
 * 16/06
 * 17/06
 * 29/06
 * 30/06
 * 1/07
 */

import java.util.Scanner;
public class game
{
    // instance variables - replace the example below with your own
    boolean present [][] = new boolean [22][22];
    boolean future [][] = new boolean [22][22];
    boolean past [][] = new boolean [22][22];
    int neighbours=0;
    int nextCommand=0;
    int y;
    int x;
    boolean running=true; //while loop
    String command;
    int labelA=1; //row and columm numbers
    int label1=1;
    int arraySize=20;
    int genNumber=1;
    String alive= "*  "; //dead and alive cell character
    String dead= "-  ";

    void update(boolean alive){
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

        present[8][3]=true;
        present[9][3]=true;
        present[10][3]=true;
        present[11][3]=true;
        present[12][3]=true;
        present[7][4]=true;
        present[6][4]=true;
        present[13][4]=true;
        present[14][4]=true;
        present[15][5]=true;
        present[5][5]=true;
        present[16][6]=true;
        present[4][6]=true;
        present[16][7]=true;
        present[4][7]=true;
        present[17][8]=true;
        present[17][9]=true;
        present[17][10]=true;
        present[17][11]=true;
        present[17][12]=true;
        present[3][8]=true;
        present[3][9]=true;
        present[3][10]=true;
        present[3][11]=true;
        present[3][12]=true;
        present[4][13]=true;
        present[4][14]=true;
        present[16][13]=true;
        present[16][14]=true;
        present[5][15]=true;
        present[15][15]=true;
        present[6][16]=true;
        present[14][16]=true;
        present[7][16]=true;
        present[13][16]=true;
        present[8][17]=true;
        present[9][17]=true;
        present[10][17]=true;
        present[11][17]=true;
        present[12][17]=true;
        //circle

        present[8][7]=true;
        present[8][8]=true;

        present[12][7]=true;
        present[12][8]=true;

        present[6][12]=true;
        present[7][13]=true;
        present[8][14]=true;
        present[9][14]=true;
        present[10][14]=true;
        present[11][14]=true;
        present[12][14]=true;
        present[13][13]=true;
        present[14][12]=true;

        //starting board-- a smiley face

        System.out.println("commands: help (h), next (n), current (c), multiple turns (t), end, revive cells (r), kill cells (k)");
        System.out.println("add a z (z), glider (g), onion rings (o), spaceship (s), phoenix (p)");
        labelA=1;
        label1=1;
        System.out.println();
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
            for (x=1;x<=arraySize;x++){ //prints board 
                if (present[x][y]==true){
                    System.out.print(alive);
                } else System.out.print(dead);
            }
            System.out.println();
        }

        while (running==true) {

            command=type.nextLine();
            switch (command.toLowerCase()) {
                case "next": 
                case "n":
                nextCommand++;
                if(nextCommand==1){
                    for (y=1;y<=arraySize;y++){
                        for (x=1;x<=arraySize;x++){
                            update(present[x][y]);
                        }
                    }

                    for (y=1;y<=arraySize;y++){
                        for (x=1;x<=arraySize;x++){

                            if (future[x][y]) { present[x][y]=true; }
                            else { present[x][y]=false; }
                        }
                    }

                }
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
                        update(present[x][y]);
                        if (present[x][y]==true){
                            System.out.print(alive);
                        } else System.out.print(dead);
                    }
                    System.out.println();
                }
                // turns the future array into the present array so it goes infinite turns
                for (y=1;y<=arraySize;y++){
                    for (x=1;x<=arraySize;x++){
                        if (present[x][y]) {past[x][y]=true;}
                        else { past[x][y]=false;}
                        if (future[x][y]) { present[x][y]=true; }
                        else { present[x][y]=false; }
                    }
                }
                break;
                case "multiple turns":
                case "t":
                int turns;
                System.out.println("how many turns to advance?");
                try {
                    nextCommand++;
                    if(nextCommand==1){
                        for (y=1;y<=arraySize;y++){
                            for (x=1;x<=arraySize;x++){
                                update(present[x][y]);
                            }
                        }

                        for (y=1;y<=arraySize;y++){
                            for (x=1;x<=arraySize;x++){

                                if (future[x][y]) { present[x][y]=true; }
                                else { present[x][y]=false; }
                            }
                        }

                    }
                    turns=type.nextInt();
                    for (int t=1;t<=turns;t++) { 
                        try {

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
                                    update(present[x][y]);
                                    if (present[x][y]==true){
                                        System.out.print(alive);
                                    } else System.out.print(dead);
                                }
                                System.out.println();
                            }
                            for (y=1;y<=arraySize;y++){ //turns new array into first array
                                for (x=1;x<=arraySize;x++){
                                    if (present[x][y]) {past[x][y]=true;}
                                    else { past[x][y]=false;}
                                    if (future[x][y]) { present[x][y]=true; }
                                    else { present[x][y]=false; }
                                }
                            }
                            Thread.sleep(200); //makes it wait 200ms before printing next board
                        } catch (Exception e){
                            System.out.println("error with timer");
                        };
                    }
                    System.out.println("finished");
                } catch (Exception e) {
                    System.out.println("error occurred. try another command.");
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
                        if (past[x][y]==true){
                            System.out.print(alive);
                        } else System.out.print(dead);
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
                try {
                    System.out.println("what column number?");
                    row=type.nextInt();
                    System.out.println("what row number?");
                    column=type.nextInt();
                    if (row>20|| column>20|| row<=0|| column<=0) { 
                        System.out.println("coordinate not available.");
                    } else {
                        System.out.println("coordinate [" + row + ", "+ column + "] changed to alive");
                        present[row][column]=true;
                        past[row][column]=true;
                        nextCommand=0;
                    }
                } catch (Exception e) {
                    System.out.println("error occurred. try again.");
                }
                command=type.nextLine();
                break;
                case "make dead":
                case "kill":
                case "k":
                //changes cells to dead
                try {
                    System.out.println("what column number?");
                    row=type.nextInt();
                    System.out.println("what row number?");
                    column=type.nextInt();
                    if (row>20|| column>20|| row<=0|| column<=0) { 
                        System.out.println("coordinate not available.");
                    } else {
                        System.out.println("coordinate [" + row + ", "+ column + "] changed to dead");
                        present[row][column]=false; 
                        past[row][column]=false;
                        nextCommand=0;
                    }
                } catch (Exception e) {
                    System.out.println("error occurred, try again.");
                }
                command=type.nextLine();
                break;
                case "glider":
                case "g":
                nextCommand=0;
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
                            System.out.print(alive);
                        } else System.out.print(dead);
                    }
                    System.out.println();
                }
                break;
                case "z":
                nextCommand=0;
                genNumber=1;
                for (y=1;y<=arraySize;y++){ 
                    for (x=1;x<=arraySize;x++){ //clears board
                        if (present[x][y]==true){
                            present[x][y]=false;
                        } 
                    }
                }
                //makes shape in alive cells
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
                            System.out.print(alive);
                        } else System.out.print(dead);
                    }
                    System.out.println();
                }
                break;
                case "onion rings":
                case "o":
                nextCommand=0;
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
                            System.out.print(alive);
                        } else System.out.print(dead);
                    }
                    System.out.println();
                }
                break;
                case "spaceship":
                case "s":
                nextCommand=0;
                genNumber=1;
                for (y=1;y<=arraySize;y++){ 
                    for (x=1;x<=arraySize;x++){ //clears board
                        if (present[x][y]==true){
                            present[x][y]=false;
                        } 
                    }
                }
                present[1][6]=true;
                present[1][8]=true;
                present[2][9]=true;
                present[3][9]=true;
                present[4][9]=true;
                present[5][9]=true;
                present[5][8]=true;
                present[5][7]=true;
                present[4][6]=true;

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
                            System.out.print(alive);
                        } else System.out.print(dead);
                    }
                    System.out.println();
                }
                break;
                case "phoenix":
                case "p":
                nextCommand=0;
                genNumber=1;
                for (y=1;y<=arraySize;y++){ 
                    for (x=1;x<=arraySize;x++){ //clears board
                        if (present[x][y]==true){
                            present[x][y]=false;
                        } 
                    }
                }

                present[10][7]=true;
                present[10][8]=true;
                present[12][9]=true;
                present[12][11]=true;
                present[13][11]=true;
                present[11][13]=true;
                present[9][13]=true;
                present[9][14]=true;
                present[7][12]=true;
                present[7][10]=true;
                present[6][10]=true;
                present[8][8]=true;

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
                            System.out.print(alive);
                        } else System.out.print(dead);
                    }
                    System.out.println();
                }

                break;
                case "help":
                case "h":
                System.out.println("What command do you need help with?");
                System.out.println("1: next");
                System.out.println("2: multiple turns");
                System.out.println("3: current");
                System.out.println("4: revive/kill");
                System.out.println("5: commands z, glider, onion rings, spaceship");
                System.out.println("6: end");
                String help=type.nextLine();
                switch(help) {
                    case "1":
                    System.out.println("next or n - it goes forward one generation");
                    break;
                    case "2": 
                    System.out.println("multiple turns or t - it goes forward as many turns as you want. limit: 2,147,483,647, however, it takes a very long time and gets extremely laggy by 100k generations.");
                    break;
                    case "3":
                    System.out.println("current or c - prints the current generation");
                    break;
                    case "4":
                    System.out.println("revive or r / kill or k - pick a row and a column and it either revives the cell or kills it depending on what command you use.");
                    break;
                    case "5":
                    System.out.println("z, glider or g, onion rings or o and spaceship or s - clears the board and then creates one of those shapes on the board.");
                    System.out.println(" -  glider and spaceships move across in a straight line");
                    System.out.println(" -  the z shape disappears completely after 46 generations.");
                    System.out.println(" -  the onion rings shape just looks cool.");
                    System.out.println(" -  the phoenix has every cell dies each generation, but never dies completely");
                    break;
                    case "6": System.out.println("end - ends the while loop and quits the game.");
                }

                break;
                default: System.out.println("try something else");
            }
        }

    } 
}