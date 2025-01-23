package Interfata;

//  Zona de import

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fereastra_Pericole_Recomandari extends JPanel {
    //  Componente
    private JCheckBox VPNCheck, trackerCheck, antiVirusCheck, fingerPrintingCheck, cloudBackupCheck, recomandariCheck;
    private JButton inchidereButon;
    private ButtonGroup grupCheckBox;

    //  Constructor
    public Fereastra_Pericole_Recomandari() {
        Dimension dimensiune = getPreferredSize();
        dimensiune.height = 50;
        this.setPreferredSize(dimensiune);
        this.setBorder(BorderFactory.createEtchedBorder());
        //  Initializare componente
        grupCheckBox = new ButtonGroup();

        VPNCheck = new JCheckBox("Rețea privată virtuală");
        trackerCheck = new JCheckBox("Atacuri prin urmărirea activităților de pe internet");
        fingerPrintingCheck = new JCheckBox("Amprentare digitală");
        cloudBackupCheck = new JCheckBox("Copii de rezervă în cloud");
        antiVirusCheck = new JCheckBox("AntiVirus");
        recomandariCheck = new JCheckBox("Recomandari");



        realizareLayout();
    }

    //  Metode

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
        gc.weightx = 1; gc.weighty = 1; gc.fill = GridBagConstraints.NONE; gc.gridy = 0;

        gc.gridx = 0;
        gc.anchor = LINE_END;
        gc.insets = ins5;
        this.add(VPNCheck, gc);


        //  Rand nou
        gc.weightx = 1;

        gc.gridx++;
        gc.anchor = LINE_END;
        gc.insets = ins5;
        this.add(trackerCheck, gc);

        //  Rand nou

        gc.weightx = 1;

        gc.gridx++;
        gc.anchor = LINE_END;
        gc.insets = ins5;
        this.add(fingerPrintingCheck, gc);

        //  Rand nou

        gc.weightx = 1;

        gc.gridx++;
        gc.anchor = LINE_END;
        gc.insets = ins5;
        this.add(cloudBackupCheck, gc);

        //  Rand nou

        gc.weightx = 1;

        gc.gridx++;
        gc.anchor = LINE_END;
        gc.insets = ins5;
        this.add(antiVirusCheck, gc);


    }

    //  Getters


    public JCheckBox getVPNCheck() {
        return VPNCheck;
    }

    public JCheckBox getTrackerCheck() {
        return trackerCheck;
    }

    public JCheckBox getAntiVirusCheck() {
        return antiVirusCheck;
    }

    public JCheckBox getFingerPrintingCheck() {
        return fingerPrintingCheck;
    }

    public JCheckBox getCloudBackupCheck() {
        return cloudBackupCheck;
    }

    public JCheckBox getRecomandariCheck() {
        return recomandariCheck;
    }
}
