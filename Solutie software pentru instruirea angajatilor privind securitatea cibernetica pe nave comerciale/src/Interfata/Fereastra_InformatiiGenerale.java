package Interfata;

//  Zona de import

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lombok.*;

@Getter @Setter
public class Fereastra_InformatiiGenerale extends JPanel {
    //  Componente

    private Border exterior, interior;

    private JLabel titluLabel, titluGeneralLabel, studentLabel, numeStudentLabel, coordonatorLabel,
            numeCoordonatorLabel, facultateLabel, specializareLabel, denFacultateLabel,
            denSpecializareLabel, anLabel, denAnLabel, grupaLabel, denGrupaLabel, subgrupaLabel,
            denSubgrupaLabel;

    private JButton schimbareButon, panouTextButon;
    private starePanouInfoGeneralListener listener;
    private starePanouTextListener listener2;

    //  Constructor
    public Fereastra_InformatiiGenerale() {
        Dimension dimensiune = getPreferredSize();
        dimensiune.width = 860;
        this.setPreferredSize(dimensiune);

        exterior = BorderFactory.createTitledBorder("Informații generale");
        interior = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        this.setBorder(BorderFactory.createCompoundBorder(exterior, interior));

        titluLabel = new JLabel("Soluție software pentru instruirea angajaților privind securitatea cibernetică pe nave comerciale");
        titluGeneralLabel = new JLabel("Licență, sesiunea din toamnă");
        studentLabel = new JLabel("Absolvent: ");
        numeStudentLabel = new JLabel("Antohi Andi-Ionel");
        coordonatorLabel = new JLabel("Coordonator: ");
        numeCoordonatorLabel = new JLabel("Conf.univ.Dr. Băutu Andrei");
        facultateLabel = new JLabel("Facultate: ");
        denFacultateLabel = new JLabel("Facultatea de Navigație și Management Naval");
        specializareLabel = new JLabel("Specializare: ");
        denSpecializareLabel = new JLabel("NTMF - Navigație și Transport Maritim și Fluvial");
        anLabel = new JLabel("Anul: ");
        denAnLabel = new JLabel("4");
        grupaLabel = new JLabel("Grupa: ");
        denGrupaLabel = new JLabel("411C");
        subgrupaLabel = new JLabel("Subgrupa: ");
        denSubgrupaLabel = new JLabel("4111C");

        schimbareButon = new JButton("Schimbare Panou"); schimbareButon.setFocusPainted(false);
        panouTextButon = new JButton("Panou Text"); panouTextButon.setFocusPainted(false);

        //  Adaugare ActionListener
        schimbareButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fereastra_InformatiiGenerale.this.listener.stare(false);
            }
        });

        panouTextButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getListener2().stare(true);
            }
        });

        //  Realizarea layout-ului
        setareLayout();
    }

    //  Zona de metode

    //  Settere

    public void setStarePanouInfoGeneralListener(starePanouInfoGeneralListener listener){
        this.listener = listener;
    }

    public void setStarePanouTextListener(starePanouTextListener listener) {
        this.listener2 = listener;
    }

    public void setareLayout() {
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

        gc.gridx = 1;
        gc.anchor = FIRST_LINE_START;
        gc.insets = ins5;
        this.add(titluLabel, gc);

        //  Rand nou

        gc.weightx = 1; gc.weighty = 1; gc.gridy++;

        gc.gridx = 1;
        gc.anchor = FIRST_LINE_START;
        gc.insets = new Insets(2, 150, 0, 0);
        this.add(titluGeneralLabel, gc);

        //  Rand nou

        gc.weightx = 1; gc.weighty = 1; gc.gridy++;

        gc.gridx = 0;
        gc.anchor = LINE_END;
        gc.insets = ins5;
        this.add(studentLabel, gc);

        gc.gridx = 1;
        gc.anchor = LINE_START;
        gc.insets = ins0;
        this.add(numeStudentLabel, gc);

        //  Rand nou

        gc.weightx = 1; gc.weighty = 1; gc.gridy++;

        gc.gridx = 0;
        gc.anchor = LINE_END;
        gc.insets = ins5;
        this.add(studentLabel, gc);

        gc.gridx = 1;
        gc.anchor = LINE_START;
        gc.insets = ins0;
        this.add(numeStudentLabel, gc);

        //  Rand nou

        gc.weightx = 1; gc.weighty = 1; gc.gridy++;

        gc.gridx = 0;
        gc.anchor = LINE_END;
        gc.insets = ins5;
        this.add(coordonatorLabel, gc);

        gc.gridx = 1;
        gc.anchor = LINE_START;
        gc.insets = ins0;
        this.add(numeCoordonatorLabel, gc);

        //  Rand nou

        gc.weightx = 1; gc.weighty = 1; gc.gridy++;

        gc.gridx = 0;
        gc.anchor = LINE_END;
        gc.insets = ins5;
        this.add(facultateLabel, gc);

        gc.gridx = 1;
        gc.anchor = LINE_START;
        gc.insets = ins0;
        this.add(denFacultateLabel, gc);

        //  Rand nou

        gc.weightx = 1; gc.weighty = 1; gc.gridy++;

        gc.gridx = 0;
        gc.anchor = LINE_END;
        gc.insets = ins5;
        this.add(specializareLabel, gc);

        gc.gridx = 1;
        gc.anchor = LINE_START;
        gc.insets = ins0;
        this.add(denSpecializareLabel, gc);

        //  Rand nou

        gc.weightx = 1; gc.weighty = 1; gc.gridy++;

        gc.gridx = 0;
        gc.anchor = LINE_END;
        gc.insets = ins5;
        this.add(anLabel, gc);

        gc.gridx = 1;
        gc.anchor = LINE_START;
        gc.insets = ins0;
        this.add(denAnLabel, gc);

        //  Rand nou

        gc.weightx = 1; gc.weighty = 1; gc.gridy++;

        gc.gridx = 0;
        gc.anchor = LINE_END;
        gc.insets = ins5;
        this.add(grupaLabel, gc);

        gc.gridx = 1;
        gc.anchor = LINE_START;
        gc.insets = ins0;
        this.add(denGrupaLabel, gc);

        //  Rand nou

        gc.weightx = 1; gc.weighty = 1; gc.gridy++;

        gc.gridx = 0;
        gc.anchor = LINE_END;
        gc.insets = ins5;
        this.add(subgrupaLabel, gc);

        gc.gridx = 1;
        gc.anchor = LINE_START;
        gc.insets = ins0;
        this.add(denSubgrupaLabel, gc);

        //  Rand nou

        gc.weightx = 1; gc.weighty = 1; gc.gridy++;

        gc.gridx = 0;
        gc.anchor = FIRST_LINE_END;
        gc.insets = ins5;
        this.add(panouTextButon, gc);

        gc.gridx = 1;
        gc.anchor = FIRST_LINE_START;
        gc.insets = ins0;
        this.add(schimbareButon, gc);
    }
}
