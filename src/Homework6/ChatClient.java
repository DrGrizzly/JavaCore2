package Homework6;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatClient {
    private final String SERVER_ADDR;
    private final int SERVER_PORT;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean isConnect;

    public boolean isConnect() {
        return isConnect;
    }

    public ChatClient(String address, int port) {
        this.SERVER_ADDR = address;
        this.SERVER_PORT = port;
    }

    public void connect() throws IOException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        if (!socket.isConnected())
            return;
        isConnect =true;
        getMessage();
    }

    private void getMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (socket.isConnected()) System.out.println("Подключились к серверу");
                    while (socket.isConnected()) {
                        String strFromServer = in.readUTF();
                        if ("/end".equalsIgnoreCase(strFromServer)) {
                            System.out.println("Завершение работы клиента");
                            closeConnection();
                            break;
                        }
                        System.out.println("Server: " + strFromServer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void sendMessage(String msg) throws IOException {
        if (!socket.isConnected()) //если нет подключения то выходим
            return;
        ChatApi.Message msgToSend = new ChatApi.Message();
        msgToSend.setMessage(msg);
        out.writeUTF(new Gson().toJson(msgToSend));
        if ("/end".equalsIgnoreCase(msg)) {
            System.out.println("Принята команда завершения Клиента");
            closeConnection();
        }
    }

    public void closeConnection() {
        isConnect = false;
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

}
