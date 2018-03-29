import controller.ClientController;
import view.CoreGUI;
import model.ClientModel;

import javax.swing.*;

/**
 * Created by (TheOne) on 28-Mar-18.
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> new ClientController(
                            new CoreGUI().initGUI(),
                            new ClientModel()
                )
        );
    }
}
