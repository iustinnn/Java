package org.example;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Game {
   public Board board=null;
    public String name;
    public Socket socket1=null;
    public Socket socket2=null;
    public List<Player> players=new ArrayList<>();
    public int currentPlayerIndex=0;
    public boolean gameOver=false;

    public Game(String name, Socket socket) {
        this.name=name;
        this.socket1=socket;
        this.currentPlayerIndex = 0;
        this.gameOver = false;
        this.board=new Board(15);
    }




    public boolean isGameOver() {
        return gameOver;
    }
/*
    public void playMove(int row, int col) {
        if (gameOver) {
            throw new IllegalStateException("The game is over");
        }
        Player currentPlayer = getCurrentPlayer();
        board.makeMove(row, col, currentPlayer.getStone());
        if (board.hasFiveInARow(currentPlayer.getStone())) {
            gameOver = true;
            currentPlayer.setWon();
        } else if (board.isFull()) {
            gameOver = true;
        } else {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    */
}
