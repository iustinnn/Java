package org.example;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    List<Player> playerList=new ArrayList<>();
    public void addPlayer(Player player){
        playerList.add(player);
    }

}
