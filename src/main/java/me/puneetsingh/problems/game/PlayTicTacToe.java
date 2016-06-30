package me.puneetsingh.problems.game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PlayTicTacToe {
    /**
     * This tic tac toe is designed to never lose :D
     */
    static int losses =0;
    private static void printTTT(char[][] board)
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" "+board[i][j]+" ");
                if(j < board[i].length-1)
                    System.out.print("|");
            }
            if(i < board.length-1)
            System.out.println("\n-----------");
        }
        System.out.println();
    }
    private static short checkStatus(char[][] board)
    {
        //Just for 3X3
        /*
            0 - No decision yet
            1 - X winner
            2 - O winner
            3 - Draw
         */
        int XH=0,OH=0;
        int XV=0,OV=0;
        int XC=0,OC=0;
        int SP=0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]=='X')
                    XH++;
                if(board[i][j]=='O')
                    OH++;
                if(board[j][i]=='X')
                    XV++;
                if(board[j][i]=='O')
                    OV++;
                if(board[j][i]==' ')
                    SP++;
            }
            if(XH==3) return 1;
            if(OH==3) return 2;
            if(XV==3) return 1;
            if(OV==3) return 2;
            XH=0;OH=0;
            XV=0;OV=0;
        }
        for (int i = 0; i < board.length; i++) {
            if(board[i][i]=='X')
                XC++;
            if(board[i][i]=='O')
                OC++;
        }
        if(XC==3) return 1;
        if(OC==3) return 2;
        XC=0;OC=0;
        for (int i = 0; i < board.length; i++) {
            if(board[i][board.length-i-1]=='X')
                XC++;
            if(board[i][board.length-i-1]=='O')
                OC++;
        }
        if(XC==3) return 1;
        if(OC==3) return 2;
        if(SP>0)
            return 0;
        else
            return 3;
    }
    private static ArrayList<Move> getMoveList(char[][] board)
    {
        ArrayList<Move> toFill = new ArrayList<>(9);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]==' ')
                    toFill.add(new Move(i, j));
            }
        }
        return toFill;
    }
    private static Move getNextBestMove(char[][] board)
    {
        Move m = new Move(-1, -1);
        int minLoss = Integer.MAX_VALUE;
        ArrayList<Move> toFill = getMoveList(board);
        for (Move nm : toFill) {
            int tmpLoss = getPossibleWaysToLose(board,  nm, 'X');
            losses =0;
            //System.out.println(tmpLoss+":"+nm);
            if(minLoss > tmpLoss)
            {
                m = nm;
                minLoss = tmpLoss;
            }
        }
        /*

         */
        return m;

    }

    private static int getPossibleWaysToLose(char[][] board, Move nm, char curPlayer) {
        board[nm.i][nm.j] = curPlayer;
        //printTTT(board);
        ArrayList<Move> toFill = getMoveList(board);

        if(checkStatus(board)==2)
            losses++;
        for (Move t: toFill) {
            if(curPlayer == 'X')
                getPossibleWaysToLose(board, t, 'O');
            if(curPlayer == 'O')
                getPossibleWaysToLose(board, t, 'X');
        }
        board[nm.i][nm.j] = ' ';
        return losses;
    }

    public static void main(String[] args) {
        /**
         * Computer X, Human O
         */
        boolean c = (new Random()).nextBoolean();
        char[][] board = {
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '}};

        if(c)
        {
            System.out.println("I have the first move sucker...");
            while(checkStatus(board)==0) {

                Move m = getNextBestMove(board);
                board[m.i][m.j] = 'X';
                printTTT(board);
                if(checkStatus(board)!=0) break;
                m = getHumanMove(board);
                board[m.i][m.j] = 'O';
                printTTT(board);
//                pressEnter();
                System.out.println("My move...");
            }
        }
        else {
            System.out.println("Your move hooman...");
            while(checkStatus(board)==0) {
                Move m = getHumanMove(board);
                board[m.i][m.j] = 'O';
                printTTT(board);
                System.out.println("My move...");
                if(checkStatus(board)!=0) break;
                m = getNextBestMove(board);
                board[m.i][m.j] = 'X';
                printTTT(board);
//                pressEnter();
            }

        }
        int status = checkStatus(board);
        switch (status)
        {
            case 1:
                System.out.println("Ha! I won Sucker!! I rule");
                break;
            case 2:
                System.out.println("Okay! you definitely cheated!");
                break;
            case 3:
                System.out.println("A draw this time saved your A**, but you can never win!");
        }

    }

    private static void pressEnter() {
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private static Move getHumanMove(char[][] board) {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter i and j positions(space separated): ");
        int i = reader.nextInt();
        int j = reader.nextInt();

        if((i>2||j>2) || board[i][j]==' ') {
            return new Move(i, j);
        }
        else
            return getHumanMove(board);
    }

    static class Move{
        int i;
        int j;

        public Move(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "["+String.valueOf(i)+","+String.valueOf(j)+"]";
        }
    }
}
