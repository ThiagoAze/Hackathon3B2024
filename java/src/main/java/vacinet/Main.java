package vacinet;

import vacinet.view.MenuForm;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var form = new MenuForm();
            form.setVisible(true);
        });
    }
}
