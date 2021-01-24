package Homework6;

import java.io.IOException;
import java.util.Scanner;

public class ServerApp {

    public static void main(String[] args) {
        ChatServer myServer = new ChatServer(9000);
        try {
            myServer.startServer();
            Scanner input = new Scanner(System.in);
            while (myServer.isOnline()){
                if (input.hasNext()){
                    myServer.sendMessage(input.nextLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
