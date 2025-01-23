package Interfata;

// Zona de import
import javax.swing.*;
import java.awt.*;

public class Fereastra_DescriereAplicatie extends JPanel {
    // Componente
    private JLabel titlu;
    private JTextArea zonaDescriere;
    private JScrollPane panouScroll;

    // Constructor
    public Fereastra_DescriereAplicatie() {
        Dimension dimensiune = getPreferredSize();
        dimensiune.height = 250;
        this.setPreferredSize(dimensiune);
        this.setLayout(new BorderLayout());

        titlu = new JLabel("Descrierea aplicației", SwingConstants.CENTER);
        titlu.setBorder(null);

        zonaDescriere = new JTextArea();
        zonaDescriere.setEditable(false);
        zonaDescriere.setLineWrap(true);
        zonaDescriere.setWrapStyleWord(true);

        // Setăm marginile pentru JTextArea
        zonaDescriere.setMargin(new Insets(10, 10, 10, 10)); // Padding: top, left, bottom, right

        zonaDescriere.addMouseWheelListener(e -> {
            JScrollBar vertical = panouScroll.getVerticalScrollBar();
            int valoare = vertical.getValue();
            int cantitate = e.getWheelRotation() * 10;
            vertical.setValue(valoare + cantitate);
        });

        panouScroll = new JScrollPane(zonaDescriere);
        panouScroll.getViewport().setBackground(Color.GREEN);
        panouScroll.setBorder(null);

        this.add(titlu, BorderLayout.NORTH);
        this.add(panouScroll, BorderLayout.CENTER);
    }

    // Gettere
    public JTextArea getZonaDescriere() {
        return zonaDescriere;
    }

    public JScrollPane getPanouScroll() {
        return panouScroll;
    }

    public JLabel getTitlu() {
        return titlu;
    }

    // Metode
    public void adaugaText(String text) {
        zonaDescriere.append(String.format("%s\n", text));
    }
}
