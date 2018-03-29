package controller;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by (TheOne) on 28-Mar-18.
 */
public class ClientSocketWriter {
    Socket socket;
    public ClientSocketWriter(Socket socket) {
        this.socket = socket;
    }
    public void writeInSocket(String event) {
        SwingUtilities.invokeLater(
                () -> sendMessage(event)
        );
    }

    private void sendMessage(String event) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(event + "\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
