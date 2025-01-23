package Interfata;

//  Zona de import

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fereastra_Butoane extends JPanel{
    //  Componente
    private Border exterior, interior;
    private JButton importButon, exportButon, teorieButon, stergereButon, inchidereButon;
    private starePanouTextListener listener;
    private starePanouListaVirusiListener listener2;

    //  Constructor
    public Fereastra_Butoane() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        exterior = BorderFactory.createTitledBorder("Meniul de control pentru zona dedicată textului");
        interior = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        this.setBorder(BorderFactory.createCompoundBorder(exterior, interior));

        //  Initializarea componentelor
        inchidereButon = new JButton("Închidere");
        importButon = new JButton("Import");
        exportButon = new JButton("Export");
        teorieButon = new JButton("Teorie");
        stergereButon = new JButton("Ștergere");
        this.add(importButon);
        this.add(exportButon);
        this.add(teorieButon);
        this.add(stergereButon);
        this.add(inchidereButon);

        //  Adaugare ActionListener
        inchidereButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getListener().stare(false);
            }
        });

        teorieButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getListener2().stare(true);
            }
        });
    }
    //  Zona de metode
    public void setStarePanouTextListener(starePanouTextListener listener) {
        this.listener = listener;
    }
    public void setStarePanouListaVirusiListener(starePanouListaVirusiListener listener2) {this.listener2 = listener2;}

    //  Gettere


    public Border getExterior() {
        return exterior;
    }

    public Border getInterior() {
        return interior;
    }

    public JButton getImportButon() {
        return importButon;
    }

    public JButton getExportButon() {
        return exportButon;
    }

    public JButton getTeorieButon() {
        return teorieButon;
    }

    public JButton getInchidereButon() {
        return inchidereButon;
    }
    public JButton getStergereButon() {return stergereButon;}

    public starePanouTextListener getListener() {
        return listener;
    }
    public starePanouListaVirusiListener getListener2() {return listener2;}
}
