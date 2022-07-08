package com.melnikov.board;

public class Board {
    private final String[][] board;

    public Board() {
        this.board = new String[][]{
                {"-", "-", "-"},
                {"-", "-", "-"},
                {"-", "-", "-"}
        };
    }

    public void drawOnBoard(int x, int y, String s){
        board[x][y] = s;
    }

    public void printBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j <= 1){
                    System.out.print(board[i][j] + "|");
                }
                else{
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
        }
    }

    public boolean isAccessibleCell(int a, int b){
        return board[a][b].equals("-");
    }

    public boolean checkWin(){
        return (checkFirstVert() || checkSecondVert() || checkThirdVert()
             || checkFirstHor() || checkSecondHor() || checkThirdHor()
             || checkDiagonal() || checkReversDiagonal());
    }

    private boolean checkFirstVert(){
        return (board[0][0].equals("X") && board[0][1].equals("X") && board[0][2].equals("X"))
                || (board[0][0].equals("O") && board[0][1].equals("O") && board[0][2].equals("O"));
    }

    private boolean checkSecondVert(){
        return (board[1][0].equals("X") && board[1][1].equals("X") && board[1][2].equals("X"))
                || (board[1][0].equals("O") && board[1][1].equals("O") && board[1][2].equals("O"));
    }

    private boolean checkThirdVert(){
        return (board[2][0].equals("X") && board[2][1].equals("X") && board[2][2].equals("X"))
                || (board[2][0].equals("O") && board[2][1].equals("O") && board[2][2].equals("O"));
    }

    private boolean checkFirstHor(){
        return (board[0][0].equals("X") && board[1][0].equals("X") && board[2][0].equals("X"))
                || (board[0][0].equals("O") && board[1][0].equals("O") && board[2][0].equals("O"));
    }

    private boolean checkSecondHor(){
        return (board[0][1].equals("X") && board[1][1].equals("X") && board[2][1].equals("X"))
                || (board[0][1].equals("O") && board[1][1].equals("O") && board[2][1].equals("O"));
    }

    private boolean checkThirdHor(){
        return (board[0][2].equals("X") && board[1][2].equals("X") && board[2][2].equals("X"))
                || (board[0][2].equals("O") && board[1][2].equals("O") && board[2][2].equals("O"));
    }

    private boolean checkDiagonal(){
        return (board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X"))
                || (board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O"));
    }

    private boolean checkReversDiagonal(){
        return (board[0][2].equals("X") && board[1][1].equals("X") && board[2][0].equals("X"))
                || (board[0][2].equals("O") && board[1][1].equals("O") && board[2][0].equals("O"));
    }
}
