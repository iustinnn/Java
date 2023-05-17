package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

class ClientThread extends Thread {
    private Socket socket = null;
    public PlayerService playerService;
    public GameService gameService;
    private Timer timer = new Timer();

    public ClientThread(Socket socket, PlayerService playerService, GameService gameService) {
        this.socket = socket;
        this.gameService = gameService;
        this.playerService = playerService;

    }

    public void run() {
        try {//buffered reader
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String request = in.readLine();
                System.out.println(request);
                if (request.equals("exit")) {
                    System.out.println("disconnected");
                    out.println("You disconnected!");
                    out.flush();
                    socket.close();
                } else if (request.startsWith("create game ")) {
                    String rest = request.substring(12);
                    gameService.createGame(rest, socket);
                    out.println("Game named " + rest + " created");
                    out.flush();
                } else if (request.startsWith("join game ")) {
                    String rest = request.substring(10);
                    Boolean value = gameService.joinGame(rest, socket);
                    if (value == true) {
                        out.println("You just joined the game");
                        out.flush();
                    } else {
                        out.println("There are already 2 players.");
                        out.flush();
                    }
                } else if (request.startsWith("submit move")) {
                    String mesaj="";
                  //  System.out.println(socket.getPort());
                    String rest = request.substring(11);
                    String[] numbers = rest.trim().split("\\s+");
                    int firstNumber = Integer.parseInt(numbers[0]);
                    int secondNumber = Integer.parseInt(numbers[1]);
                    System.out.println(firstNumber);
                    System.out.println(secondNumber);
                    if (gameService.gameList.isEmpty()) {
                        System.out.println("No active game found.");
                        return;
                    }
                    int turn = gameService.gameList.get(0).currentPlayerIndex;
                    if (turn == 0) { // It's the first player's turn
                        for (Player player : gameService.playerList) {
                            if (socket == player.socket && player.id == 1) { // If the player is the first player
                                Boolean correctMove = gameService.gameList.get(0).board.isValidMove(firstNumber, secondNumber);
                                if (correctMove == true) {
                                    gameService.gameList.get(0).board.makeMove(firstNumber, secondNumber, 1);
                                    gameService.gameList.get(0).currentPlayerIndex = 1;
                                    Boolean winner=gameService.gameList.get(0).board.hasWinner(1);
                                    if(winner==true){
                                        mesaj="You won!";
                                    }
                                    else{
                                        mesaj="Move made";
                                    }
                                } else {
                                    mesaj="Invalid move.";
                                }
                                break;
                            } else if (socket == player.socket && player.id == 2) {
                              mesaj="It's not your turn.";
                            }
                        }
                    } else if (turn == 1) {
                        for (Player player : gameService.playerList) {
                            if (socket == player.socket && player.id == 2) {
                                Boolean correctMove = gameService.gameList.get(0).board.isValidMove(firstNumber, secondNumber);
                                if (correctMove == true) {
                                    gameService.gameList.get(0).board.makeMove(firstNumber, secondNumber, 2);
                                    gameService.gameList.get(0).currentPlayerIndex = 0;
                                    mesaj="Move made";
                                    Boolean winner=gameService.gameList.get(0).board.hasWinner(2);
                                    if(winner==true){
                                        mesaj="You won!";
                                    }
                                } else {
                                    mesaj="Invalid move.";
                                }
                                break;
                            } else if (socket == player.socket && player.id == 1) { // If the player is the first player
                                mesaj="It's not your turn.";
                                System.out.println("It's not your turn.");
                            }
                        }
                    }
                    timer.cancel();
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            System.out.println("Timer done!There's a winner");
                        }
                    }, 5000);


                    out.println(mesaj);
                    out.flush();
                }
                else {
                    String raspuns = "Not a command";
                  // System.out.println(request);
                    out.println(raspuns);
                    out.flush();
                }
            }


        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        }
    }
}
