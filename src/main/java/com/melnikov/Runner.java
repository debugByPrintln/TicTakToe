package com.melnikov;

import com.melnikov.board.Board;
import com.melnikov.logic.Bot;
import com.melnikov.logic.PlayerHandler;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        //Set up board
        Board board = new Board();

        //Set up playerHandler
        PlayerHandler playerHandler = new PlayerHandler(board);
        //Set up bot
        Bot bot = new Bot(board);

        //Choosing, who is going to start
        System.out.println("Who is gonna start? You/Bot (1/2)");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        //Showing board before game starts
        board.printBoard();

        //If player starts first
        if (i == 1){
            while (true) {
                //Waiting for player to make a move
                playerHandler.makeMove();
                //Showing the board
                board.printBoard();
                //If there is a combination for the win
                if (board.checkWin()){
                    //Telling that player has won and breaking the cycle
                    System.out.println("You win!");
                    break;
                }

                //Imitating that bot is thinking
                Thread.sleep(500);
                //Gently asking bot to make a move
                bot.makeMove();
                //Showing the board
                board.printBoard();
                //If there is a combination for the win
                if (board.checkWin()){
                    //Telling that bot has won and breaking the cycle
                    System.out.println("Bot wins!");
                    break;
                }
            }
        }

        //If bot starts first
        else if(i == 2){
            while(true){
                //Imitating that bot is thinking
                Thread.sleep(500);
                //Gently asking bot to make a move
                bot.makeMove();
                //Showing the board
                board.printBoard();
                //If there is a combination for the win
                if (board.checkWin()){
                    //Telling that bot has won and breaking the cycle
                    System.out.println("Bot wins!");
                    break;
                }

                //Waiting for player to make a move
                playerHandler.makeMove();
                //Showing the board
                board.printBoard();
                //If there is a combination for the win
                if (board.checkWin()){
                    //Telling that player has won and breaking the cycle
                    System.out.println("You win!");
                    break;
                }
            }
        }

    }
}
