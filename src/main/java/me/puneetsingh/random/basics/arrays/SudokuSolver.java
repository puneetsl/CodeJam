package me.puneetsingh.random.basics.arrays;


import java.util.*;

public class SudokuSolver {
    /*
    TODO:Have to Optimize this code
     */
    public static void solveSudoku(char[][] board) {
        sure(board);
        ArrayList<Position> position = new ArrayList<>();
        for (int i = 0; i < 9; i++) {//record the board status
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    position.add(new Position(i, j));
            }
        }
        guess(board, position);

    }

    private static void guess(char[][] board, ArrayList<Position> position) {
        helpGuess(0, board, position);

    }

    private static boolean helpGuess(int i, char[][] board, ArrayList<Position> position) {

        if (i >= position.size())
            return true;
        HashSet<Integer> hs = getPossibles(board, position.get(i).i, position.get(i).j);
        if (hs.size() == 0)
            return false;
        for (Integer h : hs) {
            board[position.get(i).i][position.get(i).j] = (char) (h + '0');
            if (!helpGuess(i + 1, board, position)) {
                board[position.get(i).i][position.get(i).j] = '.';
            } else
                break;

        }
        Position last = position.get(position.size() - 1);
        return board[last.i][last.j] != '.';
    }

    private static void sure(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    helpSure(board, i, j);
                    break;
                }
            }
        }
    }


    public static void helpSure(char[][] board, int i, int j) {
        if (board[i][j] != '.')
            return;
        HashSet<Integer> hs = getPossibles(board, i, j);

        if (hs.size() == 1) {

            board[i][j] = (char) (hs.iterator().next() + '0');
            for (int k = 0; k < 9; k++) {
                if (k != j)
                    helpSure(board, i, k);
                if (k != i)
                    helpSure(board, k, j);
            }
            int box = getBox(i, j);
            int si = (box / 3) * 3;
            int sj = (box % 3) * 3;

            for (int x = si; x < si + 3; x++) {
                for (int y = sj; y < sj + 3; y++) {
                    if (x == i && y == j)
                        continue;
                    helpSure(board, x, y);
                }
            }

        }


    }

    private static boolean valid(char[][] board) {
        for (char[] aBoard : board) {
            for (int j = 0; j < aBoard.length; j++) {
                if (aBoard[j] == '.') {
                    return false;

                }
            }
        }
        return true;
    }

    private static HashSet<Integer> getPossibles(char[][] board, int i, int j) {
        HashSet<Integer> hs = getSet();
        for (int k = 0; k < 9; k++) {
            hs.remove(board[i][k] - '0');
            hs.remove(board[k][j] - '0');
        }
        int box = getBox(i, j);
        int si = (box / 3) * 3;
        int sj = (box % 3) * 3;

        for (int x = si; x < si + 3; x++) {
            for (int y = sj; y < sj + 3; y++) {
                hs.remove(board[x][y] - '0');
            }
        }
        return hs;
    }

    private static int getBox(int i, int j) {
        return (i / 3) * 3 + (j / 3);
    }


    public static HashSet<Integer> getSet() {
        HashSet<Integer> hs = new HashSet<>(9);
        for (int i = 1; i < 10; i++) {
            hs.add(i);
        }
        return hs;
    }

    public static void main(String[] args) {
        String[] boardStr = {
                "..9748...",
                "7........",
                ".2.1.9...",
                "..7...24.",
                ".64.1.59.",
                ".98...3..",
                "...8.3.2.",
                "........6",
                "...2759.."};
//        String[] boardStr = {
//                "8........",
//                "..36.....",
//                ".7..9.2..",
//                ".5...7...",
//                "....457..",
//                "...1...3.",
//                "..1....68",
//                "..85...1.",
//                ".9....4.."};
        char[][] board = new char[9][];
        int i = 0;
        for (String s : boardStr) {
            board[i] = s.toCharArray();
            i++;
        }
        for (char[] b : board) {
            System.out.println(Arrays.toString(b));
        }
        System.out.println();
        long startTime = System.nanoTime();
        solveSudoku(board);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println("Time to run: " + duration);
        for (char[] b : board) {
            System.out.println(Arrays.toString(b));
        }
    }
}

class Position {
    int i;
    int j;

    public Position(int i, int j) {
        this.i = i;
        this.j = j;
    }
}