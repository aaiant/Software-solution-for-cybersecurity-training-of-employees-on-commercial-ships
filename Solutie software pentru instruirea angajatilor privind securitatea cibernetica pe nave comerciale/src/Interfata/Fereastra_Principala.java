package Interfata;

//  Zona de import

import Tematica.Culori_Generale;

import javax.swing.*;
import java.awt.*;

public class Fereastra_Principala extends JPanel{
    //  Componente

    public Fereastra_Principala() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        this.setBackground(Culori_Generale.CULOARE1.getColor());

        //  Crearea imaginii
        ImageIcon logo_anmb = new ImageIcon("Poze/Logo5.png");
        JLabel poza = new JLabel(logo_anmb);
        this.add(poza, BorderLayout.CENTER);
    }
}
