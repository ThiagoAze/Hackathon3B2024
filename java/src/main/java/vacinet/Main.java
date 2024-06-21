package vacinet;

import vacinet.view.AgenteView;
import vacinet.view.MenuForm;

import javax.swing.*;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            //var form = new MenuForm();
            AgenteView form = null;
            try {
                form = new AgenteView();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            form.setVisible(true);
        });
    }
}
