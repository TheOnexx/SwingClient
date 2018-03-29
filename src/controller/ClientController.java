package controller;

import model.ClientModel;
import view.CoreGUI;

/**
 * Created by (TheOne) on 28-Mar-18.
 */
public class ClientController {
    private ClientModel model;
    private CoreGUI view;
    private ClientSocketListener socketListener;
    private ClientSocketWriter socketWriter;

    public ClientController(CoreGUI view, ClientModel model) {
        this.model = model;
        this.view = view;
        initSocketListenerThread();
        initSocketWriter();

        testWriteInSocket();
    }

    private void testWriteInSocket() {
        socketWriter.writeInSocket("test server hello");
    }

    private void initSocketWriter() {
        socketWriter = new ClientSocketWriter(socketListener.getSocket());
    }

    private void initSocketListenerThread() {
        socketListener = new ClientSocketListener(this);
        socketListener.startEventLoop();

    }

    public void handleClientEvent(String event) {
        view.setMessage(event);
    }
}
