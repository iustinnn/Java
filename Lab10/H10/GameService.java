package org.example;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameService {
    List<Game> gameList = new ArrayList<>();
    List<Player>playerList=new ArrayList<>();

    public void createGame(String name, Socket socket) {
        Player player=new Player(socket,"FirstPlayer",1);
        playerList.add(player);
        Game game = new Game(name, socket);
        gameList.add(game);
    }

    public boolean joinGame(String name, Socket socket) {
        for (Game game : gameList) {
            if (game.name.equals(name)) {
                if (game.socket1 != null && game.socket2 != null) {
                    return false;
                } else {
                    Player player=new Player(socket,"SecondPlayer",2);
                    playerList.add(player);
                    game.socket2 = socket;
                    return true;
                }
            }
        }
        return false;
    }

}
