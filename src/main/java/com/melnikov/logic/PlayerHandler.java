package com.melnikov.logic;

import com.melnikov.board.Board;

import java.util.Scanner;

public class PlayerHandler {
    private Board board;

    public PlayerHandler(Board board) {
        this.board = board;
    }

    public void makeMove(){
        System.out.println("Input coords(0-2 diapason): ");

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if(board.isAccessibleCell(a, b)){
            board.drawOnBoard(a, b, "X");
        }
        else{
            System.out.println("This cell is already used!");
            makeMove();
        }


    }
}
