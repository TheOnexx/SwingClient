package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by (TheOne) on 28-Mar-18.
 */
public class ClientSocketListener implements Runnable {
    private ClientController clientController;
    private Socket socket;

    public ClientSocketListener(ClientController clientController) {
        this.clientController = clientController;
    }

    public void startEventLoop() {
        try {
            socket = new Socket("localhost", 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                while (br.ready()) {
                    clientController.handleClientEvent(br.readLine());
                }
                Thread.sleep(500);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            Thread.yield();
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
