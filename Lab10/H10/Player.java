package org.example;

import java.net.Socket;

public class Player {
    private String name;
    private int time;
    public Socket socket;
    public int id;
    public boolean connected = false;

    public Player(Socket socket, String name,Integer id) {
        this.name = name;
        this.socket = socket;
        this.id=id;
        this.connected = true;
    }


}