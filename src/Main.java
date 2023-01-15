import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner UserInput = new Scanner(System.in);
        char table[][] = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        char Player1 = 'X';
        char Player2 = 'O';

        System.out.println("Welcome to the tic tac toe game, do you want to play with me y/n? (BTW I'm the computer)");
        char Userinput = UserInput.next().charAt(0);

        if (Userinput == 'y') {
            // print game
            printGame(table);


            while (true) {



                while(true){
                    //player 1
                    System.out.println("Where do you like to play? (1-9)");
                    int usercoice = UserInput.nextInt();

                    if (ValidMove(table, usercoice)) {
                    SetPosstion(table, usercoice, Player1);
                    break; }
                    else {
                    System.out.println(usercoice+ " Its not a valid move");
                    } }

                if (FinishGame(table, Player1,Player2)) {
                    break;
                }

               while (true){
                   // player 2
                   Random rand = new Random();
                   int ComputerTurn = rand.nextInt(9) + 1;
                   if (ValidMove(table, ComputerTurn)) {
                       System.out.println("Computer chose " + ComputerTurn);
                       SetPosstion(table, ComputerTurn, Player2);
                       break;
                       }
                   }

                if (FinishGame(table, Player1,Player2)) {
                    break;
                }

            }
        }

        else {
            System.out.println("See you next time");
        }


    }



    public static void printGame(char[][] table) {
        for (char[] row : table) {
            for (char c : row) {
                System.out.print((char) c + "|");
            }
            System.out.println(" \n-+-+-+");
        }
    }

    public static void SetPosstion(char[][] table, int position, char player) {
        int UserChoice = position;
        // User choice
        if (UserChoice == 1) {
            table[0][0] = player;
            printGame(table);
        } else if (UserChoice == 2) {
            table[0][1] = player;
            printGame(table);
        } else if (UserChoice == 3) {
            table[0][2] = player;
            printGame(table);
        } else if (UserChoice == 4) {
            table[1][0] = player;
            printGame(table);
        } else if (UserChoice == 5) {
            table[1][1] = player;
            printGame(table);
        } else if (UserChoice == 6) {
            table[1][2] = player;
            printGame(table);
        } else if (UserChoice == 7) {
            table[2][0] = player;
            printGame(table);
        } else if (UserChoice == 8) {
            table[2][1] = player;
            printGame(table);
        } else if (UserChoice == 9) {
            table[2][2] = player;
            printGame(table);
        }

    }

    public static boolean ValidMove(char[][] board, int position) {
        if(position==1){
            return board[0][0] == ' ' ;
        }
        else if (position==2) {
            return board[0][1] == ' '; }

        else if (position==3) {
            return board[0][2] == ' ';}

        else if(position==4) {
            return board[1][0] == ' '; }

        else if (position==5) {
            return board[1][1] == ' '; }

        else if (position==6){
            return board[1][2] == ' ' ; }

        else if (position==7){
            return (board[2][0] == ' ');}

        else if (position==8){
            return (board[2][1] == ' ');}

        else if (position==9){
            return (board[2][2] == ' ');}
        else
            return false;
    }

    public static boolean checkwinner(char table [][], char player){
        if (    (table[0][0] == player && table [0][1] == player && table [0][2] == player) ||
                (table[1][0] == player && table [1][1] == player && table [1][2] == player) ||
                (table[2][0] == player && table [2][1] == player && table [2][2] == player) ||
                (table[0][0] == player && table [1][0] == player && table [2][0] == player) ||
                (table[0][1] == player && table [1][1] == player && table [2][1] == player) ||
                (table[0][2] == player && table [1][2] == player && table [2][2] == player) ||
                (table[0][0] == player && table [1][1] == player && table [2][2] == player) ||
                (table[0][2] == player && table [1][1] == player && table [2][0] == player) ) {
            return true;
        }
        return false;
    }

    public static boolean FinishGame(char[][] table, char Player1 , char Player2) {

        if (checkwinner(table, Player1)) {
            System.out.println("you win :)");
            return true;
        }

        if (checkwinner(table, Player2)) {
            System.out.println("Computer wins :(");
            return true;
        }

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == ' ') {
                    return false;
                }
            }
        }
        System.out.println("Its a draw....");
        return true;
    }

}