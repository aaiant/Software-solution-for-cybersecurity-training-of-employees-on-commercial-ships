package Interfata;

//  Zona de import

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import lombok.*;

@Getter @Setter
public class Fereastra_ListaVirusi extends JPanel {
    //  Componente
    private JLabel virusi_malwareLabel, atacuriReteaLabel, atacuriSistemeNavigatieLabel,
    atacuriSistemeIndustrialeLabel, atacuriComunicatii_DateLabel, exploatareVulnerabilitatiLabel;

    private JButton schimbareButon;
    private ButtonGroup grupButoane;
    private JRadioButton virusiTraditionaliRadio, trojanRadio, ransomwareRadio, rootkitRadio,
            wormRadio, spywareRadio, adwareRadio, botnetRadio, atacuriDDoSRadio,
    MitMRadio, GPS_SpoofingRadio, manipulareAISRadio, phishing_spearPhishingRadio, dataBreachRadio,
    exploitsRadio, zeroDayAttacksRadio, malwareICS_specificRadio, stuxnet_like_attacksRadio;

    private starePanouListaVirusiListener listener;
    private Border exterior, interior;

    //  Constructor
    public Fereastra_ListaVirusi() {
        //  Initializarea componente
        exterior = BorderFactory.createTitledBorder("Panou teorie");
        interior = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        this.setBorder(BorderFactory.createCompoundBorder(exterior, interior));

        Dimension dimensiune = getPreferredSize();
        dimensiune.width = 860;
        this.setPreferredSize(dimensiune);

        virusi_malwareLabel = new JLabel("Viruși și Programe malițioase: ");
        atacuriReteaLabel = new JLabel("Atacuri de rețea: ");
        atacuriSistemeNavigatieLabel = new JLabel("Atacuri asupra sistemelor de navigație și control: ");
        atacuriSistemeIndustrialeLabel = new JLabel("Atacuri asupra sistemelor industriale: ");
        atacuriComunicatii_DateLabel = new JLabel("Atacuri asupra comunicațiilor și a datelor: ");
        exploatareVulnerabilitatiLabel = new JLabel("Exploatarea vulnerabilităților informatice și fizice: ");

        schimbareButon = new JButton("Schimbare Panou"); schimbareButon.setFocusPainted(false);
        //  Adaugare ActionListener
        schimbareButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.stare(false);
            }
        });

        grupButoane = new ButtonGroup();

        virusiTraditionaliRadio = new JRadioButton("Virus traditional");
        grupButoane.add(virusiTraditionaliRadio);
        trojanRadio = new JRadioButton("Calul Troian");
        grupButoane.add(trojanRadio);
        ransomwareRadio = new JRadioButton("Program de răscumpărare");
        grupButoane.add(ransomwareRadio);
        atacuriDDoSRadio = new JRadioButton("Atacuri DDoS");
        grupButoane.add(atacuriDDoSRadio);
        MitMRadio = new JRadioButton("Omul din mijloc");
        grupButoane.add(MitMRadio);
        GPS_SpoofingRadio = new JRadioButton("Înșelarea Sistemului de Poziționare Globală");
        grupButoane.add(GPS_SpoofingRadio);
        manipulareAISRadio = new JRadioButton("Manipularea Sistemului de Identificare Automată");
        grupButoane.add(manipulareAISRadio);
        phishing_spearPhishingRadio = new JRadioButton("Phishing si Phishing țintit");
        grupButoane.add(phishing_spearPhishingRadio);
        dataBreachRadio = new JRadioButton("Data Breach");
        grupButoane.add(dataBreachRadio);
        exploitsRadio = new JRadioButton("Exploits");
        grupButoane.add(exploitsRadio);
        zeroDayAttacksRadio = new JRadioButton("Atacuri Zero-Zi");
        grupButoane.add(zeroDayAttacksRadio);
        malwareICS_specificRadio = new JRadioButton("Atacuri specifice împotriva Sistemelor de Control Industrial");
        grupButoane.add(malwareICS_specificRadio);
        stuxnet_like_attacksRadio = new JRadioButton("Atacuri Stuxnet-Like");
        grupButoane.add(stuxnet_like_attacksRadio);
        rootkitRadio = new JRadioButton("Set de instrumente pentru accesul la nivel de administrator");
        grupButoane.add(rootkitRadio);
        wormRadio = new JRadioButton("Vierme");
        grupButoane.add(wormRadio);
        spywareRadio = new JRadioButton("Program de spionaj");
        grupButoane.add(spywareRadio);
        adwareRadio = new JRadioButton("Program de reclame");
        grupButoane.add(adwareRadio);
        botnetRadio = new JRadioButton("Rețea de dispozitive infectate");
        grupButoane.add(botnetRadio);

        //  Adauarea layout-ului
        realizareLayout();
    }

    //  Metode

    public void setStarePanouListaVirusiListener(starePanouListaVirusiListener listener) {
        this.listener = listener;
    }


    //  Realizarea layout-ului
    private void realizareLayout() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        Insets ins5 = new Insets(0, 0, 0, 5);
        Insets ins0 = new Insets(0, 0, 0, 0);
        final int FIRST_LINE_START = GridBagConstraints.FIRST_LINE_START;
        final int FIRST_LINE_END = GridBagConstraints.FIRST_LINE_END;
        final int LINE_START = GridBagConstraints.LINE_START;
        final int LINE_END = GridBagConstraints.LINE_END;

        //  Rand nou

        gc.weightx = 1; gc.weighty = 0.05; gc.fill = GridBagConstraints.NONE; gc.gridy = 0;

        gc.gridx = 0;
        gc.anchor = LINE_END;
        gc.insets = ins5;
        this.add(virusi_malwareLabel, gc);

        gc.gridx = 1;
        gc.anchor = LINE_START;
        gc.insets = ins0;
        this.add(trojanRadio, gc);

        //  Rand nou
        gc.weightx = 1; gc.weighty = 0.05; gc.gridy++;

        gc.gridx = 1;
        gc.anchor = FIRST_LINE_START;
        gc.insets = ins0;
        this.add(ransomwareRadio, gc);

        //  Rand nou
        gc.weightx = 1; gc.weighty = 0.05; gc.gridy++;

        gc.gridx = 1;
        gc.anchor = FIRST_LINE_START;
        gc.insets = ins0;
        this.add(rootkitRadio, gc);

        //  Rand nou
        gc.weightx = 1; gc.weighty = 0.05; gc.gridy++;

        gc.gridx = 1;
        gc.anchor = FIRST_LINE_START;
        gc.insets = ins0;
        this.add(wormRadio, gc);

        //  Rand nou
        gc.weightx = 1; gc.weighty = 0.05; gc.gridy++;

        gc.gridx = 1;
        gc.anchor = FIRST_LINE_START;
        gc.insets = ins0;
        this.add(spywareRadio, gc);

        //  Rand nou
        gc.weightx = 1; gc.weighty = 0.05; gc.gridy++;

        gc.gridx = 1;
        gc.anchor = FIRST_LINE_START;
        gc.insets = ins0;
        this.add(adwareRadio, gc);

        //  Rand nou
        gc.weightx = 1; gc.weighty = 1; gc.gridy++;

        gc.gridx = 1;
        gc.anchor = FIRST_LINE_START;
        gc.insets = ins0;
        this.add(botnetRadio, gc);

        //  Rand nou
        gc.weightx = 1; gc.weighty = 0.05; gc.gridy++;

        gc.gridx = 0;
        gc.anchor = LINE_END;
        gc.insets = ins5;
        this.add(atacuriReteaLabel, gc);

        gc.gridx = 1;
        gc.anchor = LINE_START;
        gc.insets = ins0;
        this.add(MitMRadio, gc);

        //  Rand nou
        gc.weightx = 1; gc.weighty = 0.05; gc.gridy++;

        gc.gridx = 0;
        gc.anchor = LINE_END;
        gc.insets = ins5;
        this.add(atacuriSistemeNavigatieLabel, gc);

        gc.gridx = 1;
        gc.anchor = LINE_START;
        gc.insets = ins0;
        this.add(GPS_SpoofingRadio, gc);

        //  Rand nou
        gc.weightx = 1; gc.weighty = 1; gc.gridy++;

        gc.gridx = 1;
        gc.anchor = FIRST_LINE_START;
        gc.insets = ins0;
        this.add(manipulareAISRadio, gc);

        //  Rand nou
        gc.weightx = 1; gc.weighty = 0.05; gc.gridy++;

        gc.gridx = 0;
        gc.anchor = LINE_END;
        gc.insets = ins5;
        this.add(atacuriSistemeIndustrialeLabel, gc);

        gc.gridx = 1;
        gc.anchor = LINE_START;
        gc.insets = ins0;
        this.add(malwareICS_specificRadio, gc);


        //  Rand nou
        gc.weightx = 1; gc.weighty = 1; gc.gridy++;

        gc.gridx = 0;
        gc.anchor = LINE_END;
        gc.insets = ins5;
        this.add(atacuriComunicatii_DateLabel, gc);

        gc.gridx = 1;
        gc.anchor = LINE_START;
        gc.insets = ins0;
        this.add(phishing_spearPhishingRadio, gc);


        //  Rand nou
        gc.weightx = 1; gc.weighty = 1; gc.gridy++;

        gc.gridx = 0;
        gc.anchor = LINE_END;
        gc.insets = ins5;
        this.add(exploatareVulnerabilitatiLabel, gc);


        gc.gridx = 1;
        gc.anchor = LINE_START;
        gc.insets = ins0;
        this.add(zeroDayAttacksRadio, gc);

        //  Rand nou
        gc.weightx = 1; gc.weighty = 1; gc.gridy++;

        gc.gridx = 1;
        gc.anchor = FIRST_LINE_START;
        gc.insets = ins5;
        this.add(schimbareButon, gc);
    }
}
