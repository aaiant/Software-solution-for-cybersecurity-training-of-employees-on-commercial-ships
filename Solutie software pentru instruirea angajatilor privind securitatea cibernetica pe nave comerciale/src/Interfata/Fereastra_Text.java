package Interfata;

// Zona de import
import javax.swing.*;
import java.awt.*;

public class Fereastra_Text extends JPanel {
    // Componente
    private JTextArea zonaText;
    private Fereastra_Butoane fereastraButoane;

    // Constructor
    public Fereastra_Text() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEtchedBorder());

        // Initializarea componentelor
        zonaText = new JTextArea();
        zonaText.setLineWrap(true);
        zonaText.setWrapStyleWord(true);

        // Adăugăm padding în interiorul JTextArea
        zonaText.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(zonaText);
        scrollPane.setBorder(null);
        fereastraButoane = new Fereastra_Butoane();

        // Adăugăm JScrollPane la JPanel
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(fereastraButoane, BorderLayout.SOUTH);
    }

    // Zona de metode
    public JTextArea getZonaText() {
        return zonaText;
    }

    public Fereastra_Butoane getFereastraButoane() {
        return this.fereastraButoane;
    }

    public void adaugaText(String text) {
        getZonaText().append(String.format("%s\n", text));
    }
}
