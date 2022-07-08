package com.melnikov.logic;

import com.melnikov.board.Board;

public class Bot {
    Board board;

    public Bot(Board board) {
        this.board = board;
    }

    public void makeMove(){
        int a = randomInt(0, 2);
        int b = randomInt(0, 2);

        if(board.isAccessibleCell(a, b)){
            System.out.println("Bot makes move!");
            board.drawOnBoard(a, b, "O");
        }
        else {
            makeMove();
        }
    }

    public static int randomInt(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
