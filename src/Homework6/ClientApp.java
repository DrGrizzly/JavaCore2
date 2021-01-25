package Homework6;

import java.io.IOException;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {
        ChatClient myClient = new ChatClient("localhost", 9000);
        try {
            myClient.connect();
            Scanner input = new Scanner(System.in);
            String word = "";
            while (myClient.isConnect()) {
                myClient.sendMessage(input.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
