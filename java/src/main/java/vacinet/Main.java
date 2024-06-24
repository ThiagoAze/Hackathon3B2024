package vacinet;

import vacinet.model.Vacina;
import vacinet.view.*;

import javax.swing.*;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var form = new MenuForm();
            /*
            VacinaForm form = null;
            try {
                form = new VacinaForm();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

             */
            form.setVisible(true);
        });
    }
}