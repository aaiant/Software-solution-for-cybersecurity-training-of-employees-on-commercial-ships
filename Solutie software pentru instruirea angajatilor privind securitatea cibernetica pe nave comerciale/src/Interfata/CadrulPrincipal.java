package Interfata;

//  Zona de import


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

//  Importarea culorilor realizate in pachetul Tematica

import Tematica.*;

//  Importarea claselor realizate in pachetul Fisiere

import Fisiere.*;

//  Importarea claselor realizate in pachetul SchimbareCulori

import SchimbareCulori.*;


public class CadrulPrincipal extends JFrame {
    //  Componente

    private JPanel multimeMeniuriWest, multimeMeniuriCenter, multimeMeniuriSouth;
    private Fereastra_ListaVirusi fereastraListaVirusi;
    private Fereastra_InformatiiGenerale fereastraInformatiiGenerale;
    private Fereastra_Text fereastraText;
    private Fereastra_Principala fereastraPrincipala;
    private Fereastra_DescriereAplicatie fereastraDescriereAplicatie;
    private Fereastra_Pericole_Recomandari fereastraPericoleRecomandari;
    private FereastraGoala fereastraGoala;
    private JMenu fisier, fereastra;
    private JCheckBoxMenuItem panouTeorieItem, panouInfoGeneralItem, panouTextItem, panouPagPrincipala, panouPericoleRecomandariItem,
    panouDescrieAppItem, ecranCompletItem, VPNItem, trackerItem, fingerPrintingItem, cloudBackUpItem,
            antiVirusItem, recomandariItem;
    private JRadioButtonMenuItem defaultItem, mov_rozItem, mov_galbenItem, mov_rosuItem, movInchis_cremItem, curcubeuItem, curcubeuInchisItem,
    crem_maroItem, alb_griInchisItem, alb_albastruItem, albastruGri_cremInchisItem, albastruInchis_albastruDeschisItem,
            albastru_verdeItem, maro_verdeGriItem, verdeDeschis_verdeInchisItem, verdeInchis_albastruGriItem;
    private ButtonGroup grupRadioButtonItem;
    private JFileChooser fereastraAlegereFisier;

    //  Constructor
    public CadrulPrincipal() {
        super("Soluție software pentru instruirea angajaților privind securitatea cibernetică pe nave comerciale");
        this.setMinimumSize(new Dimension(1400, 650));
        this.setSize(1500, 900);
        this.setResizable(true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setJMenuBar(realizareJMenuBar());

        //  Setarea logo-ului
        ImageIcon logo_anmb = new ImageIcon("Poze/Logo1.png");
        this.setIconImage(logo_anmb.getImage());

        //  Initializarea componentelor
        fereastraListaVirusi = new Fereastra_ListaVirusi();
        fereastraInformatiiGenerale = new Fereastra_InformatiiGenerale();
        fereastraText = new Fereastra_Text();
        fereastraPrincipala = new Fereastra_Principala();
        fereastraAlegereFisier = new JFileChooser();
        fereastraDescriereAplicatie = new Fereastra_DescriereAplicatie();
        fereastraPericoleRecomandari = new Fereastra_Pericole_Recomandari();
        fereastraGoala = new FereastraGoala();
        //  Initializarea CardLayout-uri
        //cardLayoutMultimeVest = new Ca

        //  Setarea lui JFileChooser
        fereastraAlegereFisier.addChoosableFileFilter(new Fisiere());

        //  Realizarea de CardLayout-uri
        multimeMeniuriWest = new JPanel(new CardLayout());
        multimeMeniuriWest.add(fereastraListaVirusi, "Fereastra Virusi si Malware");
        multimeMeniuriWest.add(fereastraInformatiiGenerale, "Fereastra Informatii Generale");

        multimeMeniuriCenter = new JPanel(new CardLayout());
        multimeMeniuriCenter.add(fereastraText, "Fereastra Text");
        multimeMeniuriCenter.add(fereastraPrincipala, "Fereastra Principala");

        multimeMeniuriSouth = new JPanel(new CardLayout());
        multimeMeniuriSouth.add(fereastraPericoleRecomandari, "Fereastra Pericole si Recomandari");
        multimeMeniuriSouth.add(fereastraDescriereAplicatie, "Fereastra Descriere Aplicatie");

        //  Adaugarea elementelor
        this.add(multimeMeniuriWest, BorderLayout.WEST);
        this.add(multimeMeniuriCenter, BorderLayout.CENTER);
        this.add(multimeMeniuriSouth, BorderLayout.SOUTH);
        this.add(fereastraGoala, BorderLayout.EAST);

        //  Adaugare ActionListener
        fereastraText.getFereastraButoane().setStarePanouTextListener(new starePanouTextListener() {
            @Override
            public void stare(boolean stareActuala) {
                if(!stareActuala) {
                    CardLayout card = (CardLayout) (getMultimeMeniuriCenter().getLayout());
                    card.show(getMultimeMeniuriCenter(), "Fereastra Principala");
                    getPanouTextItem().setSelected(false);
                    getPanouPagPrincipala().setSelected(true);
                    deselectareButoane();
                }
            }
        });

        fereastraText.getFereastraButoane().setStarePanouListaVirusiListener(new starePanouListaVirusiListener() {
            @Override
            public void stare(boolean stareActuala) {
                if(stareActuala) {
                    CardLayout card = (CardLayout) (getMultimeMeniuriWest().getLayout());
                    card.show(getMultimeMeniuriWest(), "Fereastra Virusi si Malware");
                    getPanouTeorieItem().setSelected(true);
                    getPanouInfoGeneralItem().setSelected(false);
                    CadrulPrincipal.this.setDimNoua(CadrulPrincipal.this, 1400, 750);
                }
            }
        });

        //  Este folosit pentru citire / import din cadrul Fereastra_Butoane
        fereastraText.getFereastraButoane().getImportButon().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rezultat = fereastraAlegereFisier.showOpenDialog(CadrulPrincipal.this);
                if(rezultat == JFileChooser.APPROVE_OPTION){
                    File fisierSelectat = fereastraAlegereFisier.getSelectedFile();
                    Gestionare_Fisiere.citesteFisier(fisierSelectat, getFereastraText(),
                            CadrulPrincipal.this);
                }
            }
        });

        //  Este folosit pentru scriere / export din cadrul Fereastra_Butoane
        fereastraText.getFereastraButoane().getExportButon().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rezultat = fereastraAlegereFisier.showSaveDialog(CadrulPrincipal.this);
                if(rezultat == JFileChooser.APPROVE_OPTION){
                    File fisierSelectat = fereastraAlegereFisier.getSelectedFile();
                    Gestionare_Fisiere.scriereFisier(fisierSelectat, getFereastraText(),
                            CadrulPrincipal.this);
                }
            }
        });

        //  Este folosit pentru a curata continutul zonei de text
        fereastraText.getFereastraButoane().getStergereButon().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rezultat = JOptionPane.showConfirmDialog(CadrulPrincipal.this,
                        "Doriți să ștergeți conținutul din zona dedicată textului?","Confirmare",
                        JOptionPane.YES_NO_OPTION);
                if(rezultat == JOptionPane.YES_OPTION)
                    fereastraText.getZonaText().setText("");
            }
        });

        fereastraListaVirusi.setStarePanouListaVirusiListener(new starePanouListaVirusiListener() {
            @Override
            public void stare(boolean stareActuala) {
                if(!stareActuala) {
                    CardLayout card = (CardLayout) (getMultimeMeniuriWest().getLayout());
                    card.show(getMultimeMeniuriWest(), "Fereastra Informatii Generale");
                    getPanouTeorieItem().setSelected(false);
                    getPanouInfoGeneralItem().setSelected(true);
                    CadrulPrincipal.this.setDimNoua(CadrulPrincipal.this, 1400, 650);
                }
            }
        });

        fereastraInformatiiGenerale.setStarePanouInfoGeneralListener(new starePanouInfoGeneralListener() {
            @Override
            public void stare(boolean stareActuala) {
                if(!stareActuala) {
                    CardLayout card = (CardLayout) (getMultimeMeniuriWest().getLayout());
                    card.show(getMultimeMeniuriWest(), "Fereastra Virusi si Malware");
                    getPanouTeorieItem().setSelected(true);
                    getPanouInfoGeneralItem().setSelected(false);
                    CadrulPrincipal.this.setDimNoua(CadrulPrincipal.this, 1400, 750);
                }
            }
        });

        fereastraInformatiiGenerale.setStarePanouTextListener(new starePanouTextListener() {
            @Override
            public void stare(boolean stareActuala) {
                if(stareActuala) {
                    CardLayout card = (CardLayout) (getMultimeMeniuriCenter().getLayout());
                    card.show(getMultimeMeniuriCenter(), "Fereastra Text");
                    getPanouTextItem().setSelected(true);
                    getPanouPagPrincipala().setSelected(false);
                }
            }
        });

        //  Incarcarea textului din DescriereaApp.anmb
        incarcareText_DescriereApp();

        //  Setarea temei curente
        incarcareTemaCurenta();

        //  Adaugarea ActionListener pentru JRadioButton din Panou Teorie
        realizareActionListenerPanouTeorie();

        //  Asigurarea ordinii vizualizarii cardurilor
        CardLayout card = (CardLayout) (multimeMeniuriWest.getLayout());
        card.show(multimeMeniuriWest, "Fereastra Informatii Generale");

        CardLayout card2 = (CardLayout) (multimeMeniuriCenter.getLayout());
        card2.show(multimeMeniuriCenter, "Fereastra Principala");

        CardLayout card3 = (CardLayout) (multimeMeniuriSouth.getLayout());
        card3.show(multimeMeniuriSouth, "Fereastra Descriere Aplicatie");

        this.pack();
        this.setVisible(true);
    }

    //  Zona de metode

    //  ActionListener pentru JRadioButton-urile din Panou Teorie
    private void realizareActionListenerPanouTeorie() {

        getFereastraListaVirusi().getTrojanRadio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File fisierSelectat = new File("Teorie/Calul troian.anmb");
                Gestionare_Fisiere.citesteFisier(fisierSelectat, getFereastraText(),
                        CadrulPrincipal.this);
                CardLayout card = (CardLayout) (multimeMeniuriCenter.getLayout());
                card.show(multimeMeniuriCenter, "Fereastra Text");
                getPanouTextItem().setSelected(true);
                getPanouPagPrincipala().setSelected(false);
            }
        });

        getFereastraListaVirusi().getRansomwareRadio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File fisierSelectat = new File("Teorie/Program de răscumpărare.anmb");
                Gestionare_Fisiere.citesteFisier(fisierSelectat, getFereastraText(),
                        CadrulPrincipal.this);
                CardLayout card = (CardLayout) (multimeMeniuriCenter.getLayout());
                card.show(multimeMeniuriCenter, "Fereastra Text");
                getPanouTextItem().setSelected(true);
                getPanouPagPrincipala().setSelected(false);
            }
        });

        getFereastraListaVirusi().getRootkitRadio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File fisierSelectat = new File("Teorie/Set de instrumente pentru accesul la nivel de administrator.anmb");
                Gestionare_Fisiere.citesteFisier(fisierSelectat, getFereastraText(),
                        CadrulPrincipal.this);
                CardLayout card = (CardLayout) (multimeMeniuriCenter.getLayout());
                card.show(multimeMeniuriCenter, "Fereastra Text");
                getPanouTextItem().setSelected(true);
                getPanouPagPrincipala().setSelected(false);
            }
        });

        getFereastraListaVirusi().getWormRadio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File fisierSelectat = new File("Teorie/Vierme.anmb");
                Gestionare_Fisiere.citesteFisier(fisierSelectat, getFereastraText(),
                        CadrulPrincipal.this);
                CardLayout card = (CardLayout) (multimeMeniuriCenter.getLayout());
                card.show(multimeMeniuriCenter, "Fereastra Text");
                getPanouTextItem().setSelected(true);
                getPanouPagPrincipala().setSelected(false);
            }
        });

        getFereastraListaVirusi().getAdwareRadio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File fisierSelectat = new File("Teorie/Program de reclame.anmb");
                Gestionare_Fisiere.citesteFisier(fisierSelectat, getFereastraText(),
                        CadrulPrincipal.this);
                CardLayout card = (CardLayout) (multimeMeniuriCenter.getLayout());
                card.show(multimeMeniuriCenter, "Fereastra Text");
                getPanouTextItem().setSelected(true);
                getPanouPagPrincipala().setSelected(false);
            }
        });

        getFereastraListaVirusi().getSpywareRadio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File fisierSelectat = new File("Teorie/Program de spionaj.anmb");
                Gestionare_Fisiere.citesteFisier(fisierSelectat, getFereastraText(),
                        CadrulPrincipal.this);
                CardLayout card = (CardLayout) (multimeMeniuriCenter.getLayout());
                card.show(multimeMeniuriCenter, "Fereastra Text");
                getPanouTextItem().setSelected(true);
                getPanouPagPrincipala().setSelected(false);
            }
        });

        getFereastraListaVirusi().getBotnetRadio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File fisierSelectat = new File("Teorie/Rețea de dispozitive infectate.anmb");
                Gestionare_Fisiere.citesteFisier(fisierSelectat, getFereastraText(),
                        CadrulPrincipal.this);
                CardLayout card = (CardLayout) (multimeMeniuriCenter.getLayout());
                card.show(multimeMeniuriCenter, "Fereastra Text");
                getPanouTextItem().setSelected(true);
                getPanouPagPrincipala().setSelected(false);
            }
        });

        getFereastraListaVirusi().getMitMRadio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File fisierSelectat = new File("Teorie/Omul din mijloc.anmb");
                Gestionare_Fisiere.citesteFisier(fisierSelectat, getFereastraText(),
                        CadrulPrincipal.this);
                CardLayout card = (CardLayout) (multimeMeniuriCenter.getLayout());
                card.show(multimeMeniuriCenter, "Fereastra Text");
                getPanouTextItem().setSelected(true);
                getPanouPagPrincipala().setSelected(false);
            }
        });

        getFereastraListaVirusi().getGPS_SpoofingRadio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File fisierSelectat = new File("Teorie/Înșelarea Sistemului de Poziționare Globală.anmb");
                Gestionare_Fisiere.citesteFisier(fisierSelectat, getFereastraText(),
                        CadrulPrincipal.this);
                CardLayout card = (CardLayout) (multimeMeniuriCenter.getLayout());
                card.show(multimeMeniuriCenter, "Fereastra Text");
                getPanouTextItem().setSelected(true);
                getPanouPagPrincipala().setSelected(false);
            }
        });

        getFereastraListaVirusi().getManipulareAISRadio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File fisierSelectat = new File("Teorie/Manipularea Sistemului de Identificare Automată.anmb");
                Gestionare_Fisiere.citesteFisier(fisierSelectat, getFereastraText(),
                        CadrulPrincipal.this);
                CardLayout card = (CardLayout) (multimeMeniuriCenter.getLayout());
                card.show(multimeMeniuriCenter, "Fereastra Text");
                getPanouTextItem().setSelected(true);
                getPanouPagPrincipala().setSelected(false);
            }
        });

        getFereastraListaVirusi().getPhishing_spearPhishingRadio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File fisierSelectat = new File("Teorie/Phishing si Phishing țintit.anmb");
                Gestionare_Fisiere.citesteFisier(fisierSelectat, getFereastraText(),
                        CadrulPrincipal.this);
                CardLayout card = (CardLayout) (multimeMeniuriCenter.getLayout());
                card.show(multimeMeniuriCenter, "Fereastra Text");
                getPanouTextItem().setSelected(true);
                getPanouPagPrincipala().setSelected(false);
            }
        });

        getFereastraListaVirusi().getZeroDayAttacksRadio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File fisierSelectat = new File("Teorie/Atacuri Zero-Zi.anmb");
                Gestionare_Fisiere.citesteFisier(fisierSelectat, getFereastraText(),
                        CadrulPrincipal.this);
                CardLayout card = (CardLayout) (multimeMeniuriCenter.getLayout());
                card.show(multimeMeniuriCenter, "Fereastra Text");
                getPanouTextItem().setSelected(true);
                getPanouPagPrincipala().setSelected(false);
            }
        });

        getFereastraListaVirusi().getMalwareICS_specificRadio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File fisierSelectat = new File("Teorie/Atacuri specifice împotriva Sistemelor de Control Industrial.anmb");
                Gestionare_Fisiere.citesteFisier(fisierSelectat, getFereastraText(),
                        CadrulPrincipal.this);
                CardLayout card = (CardLayout) (multimeMeniuriCenter.getLayout());
                card.show(multimeMeniuriCenter, "Fereastra Text");
                getPanouTextItem().setSelected(true);
                getPanouPagPrincipala().setSelected(false);
            }
        });

        //  Apelarea pentru fereastra de Pericole si Recomandari (activarea butoanelor din Sud)
        adaugareActionListener_fPericole();

    }

    //  Realizarea JMenuBar-ului

    private JMenuBar realizareJMenuBar(){
        JMenuBar meniuPrincipal = new JMenuBar();

        //  Realizarea de meniuri
        fisier = new JMenu("Fisier");
        fereastra = new JMenu("Fereastra");

        //  Realizarea de submeniuri
        JMenu vizibilitate = getVizibilitateMeniu();
        JMenu aspect = getAspectMeniu();

        //  Realizarea de item-uri
        JMenuItem importItem = new JMenuItem("Import");
        JMenuItem exportItem = new JMenuItem("Export");
        JMenuItem iesireItem = new JMenuItem("Ieșire");

        //  Realizarea ActionListener pentru item-uri
        importItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rezultat = fereastraAlegereFisier.showOpenDialog(CadrulPrincipal.this);
                if(rezultat == JFileChooser.APPROVE_OPTION){
                    File fisierSelectat = fereastraAlegereFisier.getSelectedFile();
                    Gestionare_Fisiere.citesteFisier(fisierSelectat, getFereastraText(),
                            CadrulPrincipal.this);
                    CardLayout card = (CardLayout) (multimeMeniuriCenter.getLayout());
                    card.show(multimeMeniuriCenter, "Fereastra Text");
                    getPanouTextItem().setSelected(true);
                    getPanouPagPrincipala().setSelected(false);
                }
            }
        });

        exportItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout card = (CardLayout) (multimeMeniuriCenter.getLayout());
                card.show(multimeMeniuriCenter, "Fereastra Text");
                getPanouTextItem().setSelected(true);
                getPanouPagPrincipala().setSelected(false);
                int rezultat = fereastraAlegereFisier.showSaveDialog(CadrulPrincipal.this);
                if(rezultat == JFileChooser.APPROVE_OPTION){
                    File fisierSelectat = fereastraAlegereFisier.getSelectedFile();
                    Gestionare_Fisiere.scriereFisier(fisierSelectat, getFereastraText(),
                            CadrulPrincipal.this);
                }
            }
        });

        iesireItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  Confirmare inainte de iesire
                int rezultat = JOptionPane.showConfirmDialog(CadrulPrincipal.this,
                        "Sunteți sigur că doriți să ieșiți din program?",
                        "Confirmare", JOptionPane.YES_NO_OPTION);
                if(rezultat == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });

        //  Adaugarea submeniurilor la meniurile principale
        fereastra.add(vizibilitate);
        fereastra.add(aspect);

        //  Adaugarea item-urilor la meniuri
        fisier.add(importItem);
        fisier.add(exportItem);
        fisier.addSeparator();
        fisier.add(iesireItem);

        //  Adaugarea meniurilor in bara principala
        meniuPrincipal.add(fisier);
        meniuPrincipal.add(fereastra);

        return meniuPrincipal;
    }

    //  Realizarea de submeniuri
    private JMenu getVizibilitateMeniu() {
        JMenu vizibilitate = new JMenu("Vizibilitate");

        //  Realizarea item-urilor
        panouTeorieItem = new JCheckBoxMenuItem("Panou Teorie");
        panouInfoGeneralItem = new JCheckBoxMenuItem("Panou Informații Generale");
        panouTextItem = new JCheckBoxMenuItem("Panou Text");
        panouPagPrincipala = new JCheckBoxMenuItem("Panou Principal");
        panouDescrieAppItem = new JCheckBoxMenuItem("Panou Descriere");
        panouPericoleRecomandariItem = new JCheckBoxMenuItem("Panou Pericole și Recomandări");

        ecranCompletItem = new JCheckBoxMenuItem("Ecran complet");

        VPNItem = new JCheckBoxMenuItem("Rețea privată virtuală");
        trackerItem = new JCheckBoxMenuItem("Atacuri prin urmărirea activităților de pe internet");
        fingerPrintingItem = new JCheckBoxMenuItem("Amprentare digitală");
        cloudBackUpItem = new JCheckBoxMenuItem("Copii de rezervă în cloud");
        antiVirusItem = new JCheckBoxMenuItem("AntiVirus");
        recomandariItem = new JCheckBoxMenuItem("Recomandari");

        //  Setarea vizibilitatilor pentru fiecare item
        panouTeorieItem.setSelected(false);
        panouInfoGeneralItem.setSelected(true);
        panouTextItem.setSelected(false);
        panouPagPrincipala.setSelected(true);
        panouDescrieAppItem.setSelected(true);
        panouPericoleRecomandariItem.setSelected(false);
        ecranCompletItem.setSelected(false);

        //  Setare ActionListener
        panouTeorieItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout card = (CardLayout) (getMultimeMeniuriWest().getLayout());
                card.show(getMultimeMeniuriWest(), "Fereastra Virusi si Malware");
                getPanouTeorieItem().setSelected(true);
                getPanouInfoGeneralItem().setSelected(false);
                CadrulPrincipal.this.setDimNoua(CadrulPrincipal.this, 1400, 750);
            }
        });

        panouInfoGeneralItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout card = (CardLayout) (getMultimeMeniuriWest().getLayout());
                card.show(getMultimeMeniuriWest(), "Fereastra Informatii Generale");
                getPanouTeorieItem().setSelected(false);
                getPanouInfoGeneralItem().setSelected(true);
                if(!ecranCompletItem.isSelected())
                    CadrulPrincipal.this.setDimNoua(CadrulPrincipal.this, 1400, 650);
                else
                    ecranComplet(CadrulPrincipal.this);
            }
        });

        panouTextItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout card = (CardLayout) (getMultimeMeniuriCenter().getLayout());
                card.show(getMultimeMeniuriCenter(), "Fereastra Text");
                getPanouTextItem().setSelected(true);
                getPanouPagPrincipala().setSelected(false);
            }
        });

        panouPagPrincipala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout card = (CardLayout) (getMultimeMeniuriCenter().getLayout());
                card.show(getMultimeMeniuriCenter(), "Fereastra Principala");
                getPanouTextItem().setSelected(false);
                getPanouPagPrincipala().setSelected(true);
            }
        });

        panouDescrieAppItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File fisierSelectat = new File(String.format("Descriere_App/%s.anmb", "DescriereaApp"));
                Gestionare_Fisiere.citesteFisier2(fisierSelectat, getFereastraDescriereAplicatie(),
                        CadrulPrincipal.this);

                CardLayout card = (CardLayout) (getMultimeMeniuriSouth().getLayout());
                card.show(getMultimeMeniuriSouth(), "Fereastra Descriere Aplicatie");
                getPanouDescrieAppItem().setSelected(true);
                getPanouPericoleRecomandariItem().setSelected(false);
                if(!ecranCompletItem.isSelected())
                    setDimNoua(CadrulPrincipal.this, 1400, 650);
                else
                    ecranComplet(CadrulPrincipal.this);
                updatePreferredSize(getMultimeMeniuriSouth(), new Dimension(1400, 250));
            }
        });

        panouPericoleRecomandariItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout card = (CardLayout) (getMultimeMeniuriSouth().getLayout());
                card.show(getMultimeMeniuriSouth(), "Fereastra Pericole si Recomandari");
                getPanouDescrieAppItem().setSelected(false);
                getPanouPericoleRecomandariItem().setSelected(true);
                if(!ecranCompletItem.isSelected())
                    setDimNoua(CadrulPrincipal.this, 1400, 750);
                else
                    ecranComplet(CadrulPrincipal.this);
                updatePreferredSize(getMultimeMeniuriSouth(), new Dimension(1400, 50));
            }
        });

        // Separator

        ecranCompletItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ecranCompletItem.isSelected())
                    ecranComplet(CadrulPrincipal.this);
                else {
                    CardLayout card = (CardLayout) (getMultimeMeniuriWest().getLayout());
                    card.show(getMultimeMeniuriWest(), "Fereastra Informatii Generale");
                    CardLayout card2 = (CardLayout) (getMultimeMeniuriSouth().getLayout());
                    card2.show(getMultimeMeniuriSouth(), "Fereastra Descriere Aplicatie");
                    getPanouTeorieItem().setSelected(false);
                    getPanouInfoGeneralItem().setSelected(true);
                    getPanouDescrieAppItem().setSelected(true);
                    getPanouPericoleRecomandariItem().setSelected(false);
                    setDimNoua(CadrulPrincipal.this, 1400, 650);
                    updatePreferredSize(getMultimeMeniuriSouth(), new Dimension(1400, 250));
                }
            }
        });

        //  Separator

        setareActionListenerJCheckBoxItem();

        //  Adaugarea item-urilor
        vizibilitate.add(panouTeorieItem);
        vizibilitate.add(panouInfoGeneralItem);
        vizibilitate.add(panouTextItem);
        vizibilitate.add(panouPagPrincipala);
        vizibilitate.add(panouDescrieAppItem);
        vizibilitate.add(panouPericoleRecomandariItem);
        vizibilitate.addSeparator();
        vizibilitate.add(ecranCompletItem);
        vizibilitate.addSeparator();
        vizibilitate.add(VPNItem);
        vizibilitate.add(trackerItem);
        vizibilitate.add(fingerPrintingItem);
        vizibilitate.add(cloudBackUpItem);
        vizibilitate.add(antiVirusItem);

        return vizibilitate;
    }

    private void updatePreferredSize(JPanel panou, Dimension dimensiune) {
        panou.setPreferredSize(dimensiune);
        panou.revalidate();
        panou.repaint();

    }

    private JMenu getAspectMeniu() {
        JMenu aspect = new JMenu("Aspect");
        grupRadioButtonItem = new ButtonGroup();

        //  Realizarea item-urilor
        defaultItem = new JRadioButtonMenuItem("Modul implicit");
        grupRadioButtonItem.add(defaultItem);
        defaultItem.setSelected(true);

        mov_rozItem = new JRadioButtonMenuItem("Mov - Roz");
        grupRadioButtonItem.add(mov_rozItem);

        mov_galbenItem = new JRadioButtonMenuItem("Mov - Galben");
        grupRadioButtonItem.add(mov_galbenItem);

        mov_rosuItem = new JRadioButtonMenuItem("Mov - Roșu");
        grupRadioButtonItem.add(mov_rosuItem);

        movInchis_cremItem = new JRadioButtonMenuItem("Mov Închis - Crem");
        grupRadioButtonItem.add(movInchis_cremItem);

        curcubeuItem = new JRadioButtonMenuItem("Curcubeu");
        grupRadioButtonItem.add(curcubeuItem);

        curcubeuInchisItem = new JRadioButtonMenuItem("Curcubeu Închis");
        grupRadioButtonItem.add(curcubeuInchisItem);

        crem_maroItem = new JRadioButtonMenuItem("Crem - Maro");
        grupRadioButtonItem.add(crem_maroItem);

        alb_griInchisItem = new JRadioButtonMenuItem("Alb - Gri Închis");
        grupRadioButtonItem.add(alb_griInchisItem);

        alb_albastruItem = new JRadioButtonMenuItem("Alb - Albastru");
        grupRadioButtonItem.add(alb_albastruItem);

        albastruGri_cremInchisItem = new JRadioButtonMenuItem("Albastru Gri - Crem Închis");
        grupRadioButtonItem.add(albastruGri_cremInchisItem);

        albastruInchis_albastruDeschisItem = new JRadioButtonMenuItem("Albastru Închis - Albastru Deschis");
        grupRadioButtonItem.add(albastruInchis_albastruDeschisItem);

        albastru_verdeItem = new JRadioButtonMenuItem("Albastru - Verde");
        grupRadioButtonItem.add(albastru_verdeItem);

        maro_verdeGriItem = new JRadioButtonMenuItem("Maro - Verde Gri");
        grupRadioButtonItem.add(maro_verdeGriItem);

        verdeDeschis_verdeInchisItem = new JRadioButtonMenuItem("Verde Deschis - Verde Întunecat");
        grupRadioButtonItem.add(verdeDeschis_verdeInchisItem);

        verdeInchis_albastruGriItem =new JRadioButtonMenuItem("Verde Închis - Albastru Gri");
        grupRadioButtonItem.add(verdeInchis_albastruGriItem);

        //  Adaugarea de ActionListener
        setareActionListenerJRadioItems();

        //  Adaugarea item-urilor la submeniu
        aspect.add(defaultItem);
        aspect.add(mov_rozItem);
        aspect.add(mov_galbenItem);
        aspect.add(mov_rosuItem);
        aspect.add(movInchis_cremItem);
        aspect.add(curcubeuItem);
        aspect.add(curcubeuInchisItem);
        aspect.add(crem_maroItem);
        aspect.add(alb_griInchisItem);
        aspect.add(alb_albastruItem);
        aspect.add(albastruGri_cremInchisItem);
        aspect.add(albastruInchis_albastruDeschisItem);
        aspect.add(albastru_verdeItem);
        aspect.add(maro_verdeGriItem);
        aspect.add(verdeDeschis_verdeInchisItem);
        aspect.add(verdeInchis_albastruGriItem);

        return aspect;
    }

    private void setareActionListenerJRadioItems() {
        getDefaultItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestionare_Culori.schimbareaCulorilor(CadrulPrincipal.this, getFereastraInformatiiGenerale(),
                        Culori_Generale.CULOARE3.getColor(), getFereastraListaVirusi(), Culori_Generale.CULOARE3.getColor(),
                        getFereastraText(), Culori_Generale.CULOARE3.getColor(), getFisier(), getFereastra(), Culori_Generale.CULOARE2.getColor(),
                        Culori_Generale.CULOARE3.getColor(), getFereastraDescriereAplicatie(), Culori_Generale.CULOARE3.getColor(),
                        getFereastraPericoleRecomandari(), Culori_Generale.CULOARE2.getColor(), getFereastraGoala(),  Culori_Generale.CULOARE3.getColor());
            }
        });

        getMov_rozItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestionare_Culori.schimbareaCulorilor(CadrulPrincipal.this, getFereastraInformatiiGenerale(),
                        MovRoz.CULOARE1.getColor(), getFereastraListaVirusi(), MovRoz.CULOARE1.getColor(),
                        getFereastraText(), MovRoz.CULOARE2.getColor(), getFisier(), getFereastra(), Culori_Generale.CULOARE2.getColor(),
                        MovRoz.CULOARE3.getColor(), getFereastraDescriereAplicatie(), MovRoz.CULOARE4.getColor(),
                        getFereastraPericoleRecomandari(), Culori_Generale.CULOARE2.getColor(), getFereastraGoala(),  MovRoz.CULOARE6.getColor());
            }
        });

        getMov_galbenItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestionare_Culori.schimbareaCulorilor(CadrulPrincipal.this, getFereastraInformatiiGenerale(),
                        MovGalben.CULOARE1.getColor(), getFereastraListaVirusi(), MovGalben.CULOARE1.getColor(),
                        getFereastraText(), MovGalben.CULOARE2.getColor(), getFisier(), getFereastra(), Culori_Generale.CULOARE1.getColor(),
                        MovGalben.CULOARE3.getColor(), getFereastraDescriereAplicatie(), MovGalben.CULOARE4.getColor(),
                        getFereastraPericoleRecomandari(), Culori_Generale.CULOARE1.getColor(), getFereastraGoala(),  MovGalben.CULOARE6.getColor());
            }
        });

        getMov_rosuItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestionare_Culori.schimbareaCulorilor(CadrulPrincipal.this, getFereastraInformatiiGenerale(),
                        MovRosu.CULOARE1.getColor(), getFereastraListaVirusi(), MovRosu.CULOARE1.getColor(),
                        getFereastraText(), MovRosu.CULOARE2.getColor(), getFisier(), getFereastra(), Culori_Generale.CULOARE1.getColor(),
                        MovRosu.CULOARE3.getColor(), getFereastraDescriereAplicatie(), MovRosu.CULOARE4.getColor(),
                        getFereastraPericoleRecomandari(), Culori_Generale.CULOARE1.getColor(), getFereastraGoala(),  MovRosu.CULOARE6.getColor());
            }
        });

        getMovInchis_cremItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestionare_Culori.schimbareaCulorilor(CadrulPrincipal.this, getFereastraInformatiiGenerale(),
                        MovInchis_Crem.CULOARE1.getColor(), getFereastraListaVirusi(), MovInchis_Crem.CULOARE1.getColor(),
                        getFereastraText(), MovInchis_Crem.CULOARE2.getColor(), getFisier(), getFereastra(), Culori_Generale.CULOARE1.getColor(),
                        MovInchis_Crem.CULOARE3.getColor(), getFereastraDescriereAplicatie(), MovInchis_Crem.CULOARE4.getColor(),
                        getFereastraPericoleRecomandari(), Culori_Generale.CULOARE1.getColor(), getFereastraGoala(),  MovInchis_Crem.CULOARE6.getColor());
            }
        });

        getCurcubeuItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestionare_Culori.schimbareaCulorilor(CadrulPrincipal.this, getFereastraInformatiiGenerale(),
                        Curcubeu.CULOARE1.getColor(), getFereastraListaVirusi(), Curcubeu.CULOARE1.getColor(),
                        getFereastraText(), Curcubeu.CULOARE2.getColor(), getFisier(), getFereastra(), Culori_Generale.CULOARE1.getColor(),
                        Curcubeu.CULOARE3.getColor(), getFereastraDescriereAplicatie(), Curcubeu.CULOARE4.getColor(),
                        getFereastraPericoleRecomandari(), Culori_Generale.CULOARE2.getColor(), getFereastraGoala(),  Curcubeu.CULOARE6.getColor());
            }
        });

        getCurcubeuInchisItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestionare_Culori.schimbareaCulorilor(CadrulPrincipal.this, getFereastraInformatiiGenerale(),
                        CurcubeuInchis.CULOARE1.getColor(), getFereastraListaVirusi(), CurcubeuInchis.CULOARE1.getColor(),
                        getFereastraText(), CurcubeuInchis.CULOARE2.getColor(), getFisier(), getFereastra(), Culori_Generale.CULOARE1.getColor(),
                        CurcubeuInchis.CULOARE3.getColor(), getFereastraDescriereAplicatie(), CurcubeuInchis.CULOARE4.getColor(),
                        getFereastraPericoleRecomandari(), Culori_Generale.CULOARE2.getColor(), getFereastraGoala(),  CurcubeuInchis.CULOARE6.getColor());
            }
        });

        getCrem_maroItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestionare_Culori.schimbareaCulorilor(CadrulPrincipal.this, getFereastraInformatiiGenerale(),
                        CremMaro.CULOARE1.getColor(), getFereastraListaVirusi(), CremMaro.CULOARE1.getColor(),
                        getFereastraText(), CremMaro.CULOARE2.getColor(), getFisier(), getFereastra(), Culori_Generale.CULOARE2.getColor(),
                        CremMaro.CULOARE3.getColor(), getFereastraDescriereAplicatie(), CremMaro.CULOARE4.getColor(),
                        getFereastraPericoleRecomandari(), Culori_Generale.CULOARE2.getColor(), getFereastraGoala(),  CremMaro.CULOARE6.getColor());
            }
        });

        getAlb_griInchisItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestionare_Culori.schimbareaCulorilor(CadrulPrincipal.this, getFereastraInformatiiGenerale(),
                        Alb_GriInchis.CULOARE1.getColor(), getFereastraListaVirusi(), Alb_GriInchis.CULOARE1.getColor(),
                        getFereastraText(), Alb_GriInchis.CULOARE2.getColor(), getFisier(), getFereastra(), Culori_Generale.CULOARE2.getColor(),
                        Alb_GriInchis.CULOARE3.getColor(), getFereastraDescriereAplicatie(), Alb_GriInchis.CULOARE4.getColor(),
                        getFereastraPericoleRecomandari(), Culori_Generale.CULOARE2.getColor(), getFereastraGoala(),  Alb_GriInchis.CULOARE6.getColor());
            }
        });

        getAlb_albastruItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestionare_Culori.schimbareaCulorilor(CadrulPrincipal.this, getFereastraInformatiiGenerale(),
                        AlbAlbastru.CULOARE1.getColor(), getFereastraListaVirusi(), AlbAlbastru.CULOARE1.getColor(),
                        getFereastraText(), AlbAlbastru.CULOARE2.getColor(), getFisier(), getFereastra(), Culori_Generale.CULOARE2.getColor(),
                        AlbAlbastru.CULOARE3.getColor(), getFereastraDescriereAplicatie(), AlbAlbastru.CULOARE4.getColor(),
                        getFereastraPericoleRecomandari(), Culori_Generale.CULOARE2.getColor(), getFereastraGoala(),  AlbAlbastru.CULOARE6.getColor());
            }
        });

        getAlbastruGri_cremInchisItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestionare_Culori.schimbareaCulorilor(CadrulPrincipal.this, getFereastraInformatiiGenerale(),
                        AlbastruGri_CremInchis.CULOARE1.getColor(), getFereastraListaVirusi(), AlbastruGri_CremInchis.CULOARE1.getColor(),
                        getFereastraText(), AlbastruGri_CremInchis.CULOARE2.getColor(), getFisier(), getFereastra(), Culori_Generale.CULOARE1.getColor(),
                        AlbastruGri_CremInchis.CULOARE3.getColor(), getFereastraDescriereAplicatie(), AlbastruGri_CremInchis.CULOARE4.getColor(),
                        getFereastraPericoleRecomandari(), Culori_Generale.CULOARE2.getColor(), getFereastraGoala(),  AlbastruGri_CremInchis.CULOARE6.getColor());
            }
        });

        getAlbastruInchis_albastruDeschisItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestionare_Culori.schimbareaCulorilor(CadrulPrincipal.this, getFereastraInformatiiGenerale(),
                        AlbastruInchis_AlbastruDeschis.CULOARE1.getColor(), getFereastraListaVirusi(), AlbastruInchis_AlbastruDeschis.CULOARE1.getColor(),
                        getFereastraText(), AlbastruInchis_AlbastruDeschis.CULOARE2.getColor(), getFisier(), getFereastra(), Culori_Generale.CULOARE1.getColor(),
                        AlbastruInchis_AlbastruDeschis.CULOARE3.getColor(), getFereastraDescriereAplicatie(), AlbastruInchis_AlbastruDeschis.CULOARE4.getColor(),
                        getFereastraPericoleRecomandari(), Culori_Generale.CULOARE1.getColor(), getFereastraGoala(),  AlbastruInchis_AlbastruDeschis.CULOARE6.getColor());
            }
        });

        getAlbastru_verdeItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestionare_Culori.schimbareaCulorilor(CadrulPrincipal.this, getFereastraInformatiiGenerale(),
                        AlbastruVerde.CULOARE1.getColor(), getFereastraListaVirusi(), AlbastruVerde.CULOARE1.getColor(),
                        getFereastraText(), AlbastruVerde.CULOARE2.getColor(), getFisier(), getFereastra(), Culori_Generale.CULOARE1.getColor(),
                        AlbastruVerde.CULOARE3.getColor(), getFereastraDescriereAplicatie(), AlbastruVerde.CULOARE4.getColor(),
                        getFereastraPericoleRecomandari(), Culori_Generale.CULOARE2.getColor(), getFereastraGoala(),  AlbastruVerde.CULOARE6.getColor());
            }
        });

        getMaro_verdeGriItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestionare_Culori.schimbareaCulorilor(CadrulPrincipal.this, getFereastraInformatiiGenerale(),
                        Maro_VerdeGri.CULOARE1.getColor(), getFereastraListaVirusi(), Maro_VerdeGri.CULOARE1.getColor(),
                        getFereastraText(), Maro_VerdeGri.CULOARE2.getColor(), getFisier(), getFereastra(), Culori_Generale.CULOARE1.getColor(),
                        Maro_VerdeGri.CULOARE3.getColor(), getFereastraDescriereAplicatie(), Maro_VerdeGri.CULOARE4.getColor(),
                        getFereastraPericoleRecomandari(), Culori_Generale.CULOARE2.getColor(), getFereastraGoala(),  Maro_VerdeGri.CULOARE6.getColor());
            }
        });

        getVerdeDeschis_verdeInchisItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestionare_Culori.schimbareaCulorilor(CadrulPrincipal.this, getFereastraInformatiiGenerale(),
                        VerdeDeschis_VerdeInchis.CULOARE1.getColor(), getFereastraListaVirusi(), VerdeDeschis_VerdeInchis.CULOARE1.getColor(),
                        getFereastraText(), VerdeDeschis_VerdeInchis.CULOARE2.getColor(), getFisier(), getFereastra(), Culori_Generale.CULOARE2.getColor(),
                        VerdeDeschis_VerdeInchis.CULOARE3.getColor(), getFereastraDescriereAplicatie(), VerdeDeschis_VerdeInchis.CULOARE4.getColor(),
                        getFereastraPericoleRecomandari(), Culori_Generale.CULOARE2.getColor(), getFereastraGoala(),  VerdeDeschis_VerdeInchis.CULOARE6.getColor());
            }
        });

        getVerdeInchis_albastruGriItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestionare_Culori.schimbareaCulorilor(CadrulPrincipal.this, getFereastraInformatiiGenerale(),
                        VerdeInchis_AlbastruGri.CULOARE1.getColor(), getFereastraListaVirusi(), VerdeInchis_AlbastruGri.CULOARE1.getColor(),
                        getFereastraText(), VerdeInchis_AlbastruGri.CULOARE2.getColor(), getFisier(), getFereastra(), Culori_Generale.CULOARE2.getColor(),
                        VerdeInchis_AlbastruGri.CULOARE3.getColor(), getFereastraDescriereAplicatie(), VerdeInchis_AlbastruGri.CULOARE4.getColor(),
                        getFereastraPericoleRecomandari(), Culori_Generale.CULOARE2.getColor(), getFereastraGoala(),  VerdeInchis_AlbastruGri.CULOARE6.getColor());
            }
        });
    }

    //  Pt. vizualizare
    private void deselectareButoane() {
        getVPNItem().setSelected(false);
        getTrackerItem().setSelected(false);
        getFingerPrintingItem().setSelected(false);
        getCloudBackUpItem().setSelected(false);
        getAntiVirusItem().setSelected(false);
        getRecomandariItem().setSelected(false);

        getFereastraPericoleRecomandari().getVPNCheck().setSelected(false);
        getFereastraPericoleRecomandari().getTrackerCheck().setSelected(false);
        getFereastraPericoleRecomandari().getFingerPrintingCheck().setSelected(false);
        getFereastraPericoleRecomandari().getCloudBackupCheck().setSelected(false);
        getFereastraPericoleRecomandari().getAntiVirusCheck().setSelected(false);
        getFereastraPericoleRecomandari().getRecomandariCheck().setSelected(false);

    }

    //  Ajuta fct. de mai jos sa realizeze sincronizarea cu pagina de pericole si recomandari + JMenuBar

    private void selectie(boolean vpn, boolean tracker, boolean fingerPrinting, boolean cloudBackUp,
                          boolean antivirus, boolean recomandari, String numeFisier) {
    //  Zona de JMenu

        getVPNItem().setSelected(vpn);
        getTrackerItem().setSelected(tracker);
        getFingerPrintingItem().setSelected(fingerPrinting);
        getCloudBackUpItem().setSelected(cloudBackUp);
        getAntiVirusItem().setSelected(antivirus);
        getRecomandariItem().setSelected(recomandari);

        //  Zona de CheckBox-uri

        fereastraPericoleRecomandari.getVPNCheck().setSelected(vpn);
        fereastraPericoleRecomandari.getTrackerCheck().setSelected(tracker);
        fereastraPericoleRecomandari.getFingerPrintingCheck().setSelected(fingerPrinting);
        fereastraPericoleRecomandari.getCloudBackupCheck().setSelected(cloudBackUp);
        fereastraPericoleRecomandari.getAntiVirusCheck().setSelected(antivirus);
        fereastraPericoleRecomandari.getRecomandariCheck().setSelected(recomandari);

        getPanouPericoleRecomandariItem().setSelected(true);
        getPanouDescrieAppItem().setSelected(false);


        File fisierSelectat = new File(String.format("Pericole_Si_Recomandari/%s.anmb", numeFisier));
        Gestionare_Fisiere.citesteFisier(fisierSelectat, getFereastraText(),
                CadrulPrincipal.this);

        CardLayout card = (CardLayout) (getMultimeMeniuriCenter().getLayout());
        card.show(getMultimeMeniuriCenter(), "Fereastra Text");
        getPanouTextItem().setSelected(true);
        getPanouPagPrincipala().setSelected(false);

        CardLayout card2 = (CardLayout) (getMultimeMeniuriSouth().getLayout());
        card2.show(getMultimeMeniuriSouth(), "Fereastra Pericole si Recomandari");
        getPanouTextItem().setSelected(true);
        getPanouPagPrincipala().setSelected(false);
    }
    private void setareActionListenerJCheckBoxItem() {
        //  Pt. VPN
        getVPNItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectie(true, false, false, false, false, false,
                        "Rețeaua privată virtuală");
                if(!ecranCompletItem.isSelected())
                    setDimNoua(CadrulPrincipal.this, 1400, 750);
                else
                    ecranComplet(CadrulPrincipal.this);
                updatePreferredSize(getMultimeMeniuriSouth(), new Dimension(1400, 50));
            }
        });

        //  Pt. Tracker
        getTrackerItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectie(false, true, false, false, false, false,
                        "Atacuri prin urmărirea activităților de pe internet");
                if(!ecranCompletItem.isSelected())
                    setDimNoua(CadrulPrincipal.this, 1400, 750);
                else
                    ecranComplet(CadrulPrincipal.this);
                updatePreferredSize(getMultimeMeniuriSouth(), new Dimension(1400, 50));
            }
        });

        //  Pt. FingerPrinting
        getFingerPrintingItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectie(false, false, true, false, false, false,
                        "Amprentare digitală");
                if(!ecranCompletItem.isSelected())
                    setDimNoua(CadrulPrincipal.this, 1400, 750);
                else
                    ecranComplet(CadrulPrincipal.this);
                updatePreferredSize(getMultimeMeniuriSouth(), new Dimension(1400, 50));
            }
        });

        //  Pt. Cloud Back-Up
        getCloudBackUpItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectie(false, false, false, true, false, false,
                        "Copii de rezervă în cloud");
                if(!ecranCompletItem.isSelected())
                    setDimNoua(CadrulPrincipal.this, 1400, 750);
                else
                    ecranComplet(CadrulPrincipal.this);
                updatePreferredSize(getMultimeMeniuriSouth(), new Dimension(1400, 50));
            }
        });

        //  Pt. AntiVirus
        getAntiVirusItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectie(false, false, false, false, true, false,
                        "AntiVirus");
                if(!ecranCompletItem.isSelected())
                    setDimNoua(CadrulPrincipal.this, 1400, 750);
                else
                    ecranComplet(CadrulPrincipal.this);
                updatePreferredSize(getMultimeMeniuriSouth(), new Dimension(1400, 50));
            }
        });
    }

    //  Adaugare ActionListener pentru fereastra Pericole si Recomandari
    private void adaugareActionListener_fPericole() {

        getFereastraPericoleRecomandari().getVPNCheck().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectie(true, false, false, false, false, false,
                        "Rețeaua privată virtuală");
            }
        });

        getFereastraPericoleRecomandari().getTrackerCheck().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectie(false, true, false, false, false, false,
                        "Atacuri prin urmărirea activităților de pe internet");
            }
        });

        getFereastraPericoleRecomandari().getFingerPrintingCheck().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectie(false, false, true, false, false, false,
                        "Amprentare digitală");
            }
        });

        getFereastraPericoleRecomandari().getCloudBackupCheck().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectie(false, false, false, true, false, false,
                        "Copii de rezervă în cloud");
            }
        });

        getFereastraPericoleRecomandari().getAntiVirusCheck().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectie(false, false, false, false, true, false,
                        "AntiVirus");
            }
        });
    }

    //  Zona de Gettere

    public JMenu getFisier() {
        return fisier;
    }

    public JMenu getFereastra() {
        return fereastra;
    }

    public JCheckBoxMenuItem getPanouTeorieItem() {return panouTeorieItem;}
    public JCheckBoxMenuItem getPanouInfoGeneralItem() {return panouInfoGeneralItem;}
    public JCheckBoxMenuItem getPanouTextItem() {return panouTextItem;}
    public JCheckBoxMenuItem getPanouPagPrincipala() {return panouPagPrincipala;}

    //


    public JCheckBoxMenuItem getVPNItem() {
        return VPNItem;
    }

    public JCheckBoxMenuItem getTrackerItem() {
        return trackerItem;
    }

    public JCheckBoxMenuItem getFingerPrintingItem() {
        return fingerPrintingItem;
    }

    public JCheckBoxMenuItem getCloudBackUpItem() {
        return cloudBackUpItem;
    }

    public JCheckBoxMenuItem getAntiVirusItem() {
        return antiVirusItem;
    }

    public JCheckBoxMenuItem getRecomandariItem() {
        return recomandariItem;
    }

    //
    public JPanel getMultimeMeniuriWest() {return multimeMeniuriWest;}
    public JPanel getMultimeMeniuriCenter() {return multimeMeniuriCenter;}
    public JPanel getMultimeMeniuriSouth() {return multimeMeniuriSouth;}

    public JRadioButtonMenuItem getDefaultItem() {
        return defaultItem;
    }

    public JRadioButtonMenuItem getMov_rozItem() {
        return mov_rozItem;
    }

    public JRadioButtonMenuItem getMov_galbenItem() {
        return mov_galbenItem;
    }

    public JRadioButtonMenuItem getMov_rosuItem() {
        return mov_rosuItem;
    }

    public JRadioButtonMenuItem getMovInchis_cremItem() {
        return movInchis_cremItem;
    }

    public JRadioButtonMenuItem getCurcubeuItem() {
        return curcubeuItem;
    }

    public JRadioButtonMenuItem getCurcubeuInchisItem() {
        return curcubeuInchisItem;
    }

    public JRadioButtonMenuItem getCrem_maroItem() {
        return crem_maroItem;
    }

    public JRadioButtonMenuItem getAlb_griInchisItem() {
        return alb_griInchisItem;
    }

    public JRadioButtonMenuItem getAlb_albastruItem() {
        return alb_albastruItem;
    }

    public JRadioButtonMenuItem getAlbastruGri_cremInchisItem() {
        return albastruGri_cremInchisItem;
    }

    public JRadioButtonMenuItem getAlbastruInchis_albastruDeschisItem() {
        return albastruInchis_albastruDeschisItem;
    }

    public JRadioButtonMenuItem getAlbastru_verdeItem() {
        return albastru_verdeItem;
    }

    public JRadioButtonMenuItem getMaro_verdeGriItem() {
        return maro_verdeGriItem;
    }

    public JRadioButtonMenuItem getVerdeDeschis_verdeInchisItem() {
        return verdeDeschis_verdeInchisItem;
    }

    public JRadioButtonMenuItem getVerdeInchis_albastruGriItem() {
        return verdeInchis_albastruGriItem;
    }

    public Fereastra_ListaVirusi getFereastraListaVirusi() {
        return fereastraListaVirusi;
    }

    public Fereastra_InformatiiGenerale getFereastraInformatiiGenerale() {
        return fereastraInformatiiGenerale;
    }

    public Fereastra_Text getFereastraText() {
        return fereastraText;
    }

    public Fereastra_Principala getFereastraPrincipala() {
        return fereastraPrincipala;
    }

    public JFileChooser getFereastraAlegereFisier() {
        return fereastraAlegereFisier;
    }

    public JCheckBoxMenuItem getPanouDescrieAppItem() {
        return panouDescrieAppItem;
    }

    public JCheckBoxMenuItem getPanouPericoleRecomandariItem() {
        return panouPericoleRecomandariItem;
    }

    public Fereastra_DescriereAplicatie getFereastraDescriereAplicatie() {
        return fereastraDescriereAplicatie;
    }

    public Fereastra_Pericole_Recomandari getFereastraPericoleRecomandari() {
        return fereastraPericoleRecomandari;
    }

    public FereastraGoala getFereastraGoala() {return  fereastraGoala;}

    public void setDimNoua(JFrame cadru, int lungime, int inaltime) {
        if (!ecranCompletItem.isSelected()) {
            cadru.setExtendedState(JFrame.NORMAL);
            cadru.setMinimumSize(null);
            cadru.setSize(lungime, inaltime);
            cadru.setMinimumSize(new Dimension(lungime, inaltime));
        }

        cadru.revalidate();
        cadru.repaint();
    }

    private void ecranComplet(JFrame cadru) {
        if (ecranCompletItem.isSelected()) {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gd = ge.getDefaultScreenDevice();
            DisplayMode dm = gd.getDisplayMode();

            // Setează fereastra la dimensiunea ecranului
            cadru.setBounds(0, 0, dm.getWidth(), dm.getHeight() - 50);

            // Revalidează și repictează toate componentele
            cadru.revalidate();
            cadru.repaint();
        }
    }

    private void incarcareText_DescriereApp() {
        File fisierSelectat = new File(String.format("Descriere_App/%s.anmb", "DescriereaApp"));
        Gestionare_Fisiere.citesteFisier2(fisierSelectat, getFereastraDescriereAplicatie(),
                CadrulPrincipal.this);
        //  Setarea pozitiei cursorului
        getFereastraDescriereAplicatie().getZonaDescriere().setCaretPosition(0);
    }
    private void incarcareTemaCurenta() {
        Gestionare_Culori.schimbareaCulorilor(CadrulPrincipal.this, getFereastraInformatiiGenerale(),
                Culori_Generale.CULOARE3.getColor(), getFereastraListaVirusi(), Culori_Generale.CULOARE3.getColor(),
                getFereastraText(), Culori_Generale.CULOARE3.getColor(), getFisier(), getFereastra(), Culori_Generale.CULOARE2.getColor(),
                Culori_Generale.CULOARE3.getColor(), getFereastraDescriereAplicatie(), Culori_Generale.CULOARE3.getColor(),
                getFereastraPericoleRecomandari(), Culori_Generale.CULOARE2.getColor(), getFereastraGoala(),  Culori_Generale.CULOARE3.getColor());
    }
}
