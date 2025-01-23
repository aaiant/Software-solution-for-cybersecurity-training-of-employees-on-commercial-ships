package Interfata;

//  Zona de import

import javax.swing.*;

public class Aplicatie {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadrulPrincipal();
            }
        });
    }
}
