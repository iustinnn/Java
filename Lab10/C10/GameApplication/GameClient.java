package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    public static void main (String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        while(true) {
            try (
                    Socket socket = new Socket(serverAddress, PORT);
                    PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()))) {
                Scanner scan = new Scanner(System.in);
                String request = scan.nextLine();
                out.println(request);
                String response = in.readLine();
                System.out.println(response);
                if(response.equals("You disconnected!") || response.equals("Server stopped"))
                {
                    socket.close();
                    break;
                }
            } catch (UnknownHostException e) {
                System.err.println("No server listening... " + e);
            }
        }
    }
}
