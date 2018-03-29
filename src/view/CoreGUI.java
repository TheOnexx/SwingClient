package view;

import controller.ClientController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by (TheOne) on 28-Mar-18.
 */
public class CoreGUI {
    private JFrame frame;
    private JTextArea messagesField;
    private JTextField inputTextField;
    private JButton sendButton = new JButton("Send");

    public CoreGUI initGUI() {

        frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initView();
       // frame.getContentPane().setLayout(layout);
        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        return this;
    }

    private void initView() {
        messagesField = new JTextArea(20, 50);
        messagesField.setEditable(false);
        messagesField.setLineWrap(true);
        frame.add(new JScrollPane(messagesField), BorderLayout.CENTER);

        Box box = Box.createHorizontalBox();
        frame.add(box, BorderLayout.SOUTH);
        inputTextField = new JTextField();
        sendButton = new JButton("Send");
        box.add(inputTextField);
        box.add(sendButton);
    }

    public void setMessage(String event) {
        messagesField.setText(event);
    }
}
