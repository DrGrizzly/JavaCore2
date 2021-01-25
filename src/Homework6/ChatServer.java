package Homework6;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    final int SERVER_PORT;

    private Socket socket;
    private ServerSocket serverSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean isOnline = false;

    public boolean isOnline() {
        return isOnline;
    }

    public ChatServer(int port){
        this.SERVER_PORT = port;
    }

    public void startServer() throws IOException {
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            if (!socket.isConnected())
                return;
            System.out.println("Клиент подключился");
            isOnline = true;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Добро пожаловать");
            getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() {
        isOnline = false;
        try {
            if (in != null) in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (out != null) out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public void getMessage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (socket.isConnected()) {
                        Homework6.ChatApi.Message msg = new Gson().fromJson(in.readUTF(), Homework6.ChatApi.Message.class);
                        if ("/end".equalsIgnoreCase(msg.getMessage())) {
                            System.out.println("Клиент завершил свою работу");
                            stopServer();
                            break;
                        }
                        System.out.println("Client: " + msg.getMessage());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void sendMessage(String msg) {
        try {
            if (socket != null && socket.isConnected()) {
                out.writeUTF(msg);
                if ("/end".equalsIgnoreCase(msg)) {
                    System.out.println("Принята команда завершения Сервера");
                    stopServer();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
