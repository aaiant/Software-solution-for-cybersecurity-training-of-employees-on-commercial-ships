package SchimbareCulori;

//  Zona de import

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

//  Importarea claselor realizate in pachetul Interfata

import Interfata.*;
import Tematica.*;

public class Gestionare_Culori extends Component{
    //  Componente
    //  Constructor
    //  Metode
    public static void setareBKGJRadio_FereastraListaVirusi(Fereastra_ListaVirusi fereastra, Color culoare) {
        fereastra.getVirusiTraditionaliRadio().setBackground(culoare);
        fereastra.getTrojanRadio().setBackground(culoare);
        fereastra.getRansomwareRadio().setBackground(culoare);
        fereastra.getRootkitRadio().setBackground(culoare);
        fereastra.getWormRadio().setBackground(culoare);
        fereastra.getSpywareRadio().setBackground(culoare);
        fereastra.getAdwareRadio().setBackground(culoare);
        fereastra.getBotnetRadio().setBackground(culoare);
        fereastra.getAtacuriDDoSRadio().setBackground(culoare);
        fereastra.getMitMRadio().setBackground(culoare);
        fereastra.getGPS_SpoofingRadio().setBackground(culoare);
        fereastra.getManipulareAISRadio().setBackground(culoare);
        fereastra.getPhishing_spearPhishingRadio().setBackground(culoare);
        fereastra.getDataBreachRadio().setBackground(culoare);
        fereastra.getExploitsRadio().setBackground(culoare);
        fereastra.getZeroDayAttacksRadio().setBackground(culoare);
        fereastra.getMalwareICS_specificRadio().setBackground(culoare);
        fereastra.getStuxnet_like_attacksRadio().setBackground(culoare);
    }

    public static void setBKG_FereastraGoala(FereastraGoala fereastra, Color culoare) {
        fereastra.setBackground(culoare);
    }

    public void setBKG_Fereastra_DescriereApp(Color culoare) {

    }

    public static void setareBKGJCheckBox_Fereastra_PericoleRecomandari(Fereastra_Pericole_Recomandari fereastra, Color culoare) {
        fereastra.getVPNCheck().setBackground(culoare);
        fereastra.getTrackerCheck().setBackground(culoare);
        fereastra.getAntiVirusCheck().setBackground(culoare);
        fereastra.getFingerPrintingCheck().setBackground(culoare);
        fereastra.getCloudBackupCheck().setBackground(culoare);
        fereastra.getRecomandariCheck().setBackground(culoare);
    }

    public static void setFGTextBorder_Fereastra_InfoGeneral(Fereastra_InformatiiGenerale fereastra, Color culoare) {
        Border exterior = fereastra.getExterior();
        if (exterior instanceof TitledBorder) {
            TitledBorder titledBorder = (TitledBorder) exterior;
            titledBorder.setTitleColor(culoare);
            fereastra.revalidate();
            fereastra.repaint();
        }
    }

    public static void setFGTextBorder_Fereastra_ListaVirusi(Fereastra_ListaVirusi fereastra, Color culoare) {
        Border exterior = fereastra.getExterior();
        if (exterior instanceof TitledBorder) {
            TitledBorder titledBorder = (TitledBorder) exterior;
            titledBorder.setTitleColor(culoare);
            fereastra.revalidate();
            fereastra.repaint();
        }
    }

    public static void setFGTextBorder_Fereastra_Butoane(Fereastra_Text fereastra, Color culoare) {
        Border exterior = fereastra.getFereastraButoane().getExterior();
        if (exterior instanceof TitledBorder) {
            TitledBorder titledBorder = (TitledBorder) exterior;
            titledBorder.setTitleColor(culoare);
            fereastra.revalidate();
            fereastra.repaint();
        }
    }

    public static void setFGText_Fereastra_PericoleRecomandari_DescriereApp(Fereastra_Pericole_Recomandari fereastra, Fereastra_DescriereAplicatie fereastra2,
                                                                            Color culoare) {
        fereastra.getVPNCheck().setForeground(culoare);
        fereastra.getTrackerCheck().setForeground(culoare);
        fereastra.getAntiVirusCheck().setForeground(culoare);
        fereastra.getFingerPrintingCheck().setForeground(culoare);
        fereastra.getCloudBackupCheck().setForeground(culoare);
        fereastra.getRecomandariCheck().setForeground(culoare);
        fereastra2.getZonaDescriere().setForeground(culoare);
        fereastra2.setForeground(culoare);
        fereastra2.getTitlu().setForeground(culoare);
    }

    public static void setFGText_Fereastra_InfoGeneral(Fereastra_InformatiiGenerale fereastra, Color culoare) {
        fereastra.getTitluLabel().setForeground(culoare);
        fereastra.getTitluGeneralLabel().setForeground(culoare);
        fereastra.getStudentLabel().setForeground(culoare);
        fereastra.getNumeStudentLabel().setForeground(culoare);
        fereastra.getCoordonatorLabel().setForeground(culoare);
        fereastra.getNumeCoordonatorLabel().setForeground(culoare);
        fereastra.getFacultateLabel().setForeground(culoare);
        fereastra.getSpecializareLabel().setForeground(culoare);
        fereastra.getDenFacultateLabel().setForeground(culoare);
        fereastra.getDenSpecializareLabel().setForeground(culoare);
        fereastra.getAnLabel().setForeground(culoare);
        fereastra.getDenAnLabel().setForeground(culoare);
        fereastra.getGrupaLabel().setForeground(culoare);
        fereastra.getDenGrupaLabel().setForeground(culoare);
        fereastra.getSubgrupaLabel().setForeground(culoare);
        fereastra.getDenSubgrupaLabel().setForeground(culoare);
    }

    private static void setFGText_Fereastra_ListaVirusi(Fereastra_ListaVirusi fereastra, Color culoare) {
        fereastra.getVirusi_malwareLabel().setForeground(culoare);
        fereastra.getAtacuriReteaLabel().setForeground(culoare);
        fereastra.getAtacuriSistemeNavigatieLabel().setForeground(culoare);
        fereastra.getAtacuriSistemeIndustrialeLabel().setForeground(culoare);
        fereastra.getAtacuriComunicatii_DateLabel().setForeground(culoare);
        fereastra.getExploatareVulnerabilitatiLabel().setForeground(culoare);

        fereastra.getVirusiTraditionaliRadio().setForeground(culoare);
        fereastra.getTrojanRadio().setForeground(culoare);
        fereastra.getRansomwareRadio().setForeground(culoare);
        fereastra.getRootkitRadio().setForeground(culoare);
        fereastra.getWormRadio().setForeground(culoare);
        fereastra.getSpywareRadio().setForeground(culoare);
        fereastra.getAdwareRadio().setForeground(culoare);
        fereastra.getBotnetRadio().setForeground(culoare);
        fereastra.getAtacuriDDoSRadio().setForeground(culoare);
        fereastra.getMitMRadio().setForeground(culoare);
        fereastra.getGPS_SpoofingRadio().setForeground(culoare);
        fereastra.getManipulareAISRadio().setForeground(culoare);
        fereastra.getPhishing_spearPhishingRadio().setForeground(culoare);
        fereastra.getDataBreachRadio().setForeground(culoare);
        fereastra.getExploitsRadio().setForeground(culoare);
        fereastra.getZeroDayAttacksRadio().setForeground(culoare);
        fereastra.getMalwareICS_specificRadio().setForeground(culoare);
        fereastra.getStuxnet_like_attacksRadio().setForeground(culoare);
    }

    public static void setFGText_JMenuBar(JMenu meniu1, JMenu meniu2, Color culoare) {
        meniu1.setForeground(culoare);
        meniu2.setForeground(culoare);
    }

    public static void setBG_Fereastra_PericoleRecomandari_DescriereApp_JCheckBox(Fereastra_DescriereAplicatie fereastra1,
            Fereastra_Pericole_Recomandari fereastra2, Color culoare) {
        setareBKGJCheckBox_Fereastra_PericoleRecomandari(fereastra2, culoare);
        fereastra1.getZonaDescriere().setBackground(culoare);
        fereastra1.getPanouScroll().getViewport().setBackground(culoare);
        fereastra1.setBackground(culoare);
        fereastra2.setBackground(culoare);
    }

    public static void setFG_Text(JMenu fisierMeniu, JMenu fereastraMeniu, Fereastra_InformatiiGenerale fInfo, Fereastra_ListaVirusi fVirusi,
                           Fereastra_Text fText, Color culoare) {
        setFGText_JMenuBar(fisierMeniu, fereastraMeniu, culoare);
        setFGText_Fereastra_InfoGeneral(fInfo, culoare);
        setFGText_Fereastra_ListaVirusi(fVirusi, culoare);
        setFGTextBorder_Fereastra_InfoGeneral(fInfo, culoare);
        setFGTextBorder_Fereastra_Butoane(fText, culoare);
        setFGTextBorder_Fereastra_ListaVirusi(fVirusi, culoare);
    }

    public static void setBKG_JMenuBar(CadrulPrincipal controller, Color culoare) {
        controller.getJMenuBar().setBackground(culoare);
    }

    public static void schimbareaCulorilor(CadrulPrincipal fCadruPrincipal, Fereastra_InformatiiGenerale fInfo, Color culoare_fInfo, Fereastra_ListaVirusi fVirusi,
                                    Color culoare_fVirusi,
                                     Fereastra_Text fText, Color culoare_JMB, JMenu fisierMenu, JMenu fereastraMenu, Color culoare_JMenu,
                                    Color culoare_fButoane, Fereastra_DescriereAplicatie fApp, Color culoare_fApp,
                                    Fereastra_Pericole_Recomandari fPericol, Color culoare_fPericol, FereastraGoala fGoala, Color culoare_fGoala) {
        fInfo.setBackground(culoare_fInfo);
        fVirusi.setBackground(culoare_fVirusi);
        setareBKGJRadio_FereastraListaVirusi(fVirusi, culoare_fVirusi);
        setBKG_JMenuBar(fCadruPrincipal, culoare_JMB);
        setFG_Text(fisierMenu, fereastraMenu, fInfo, fVirusi, fText, culoare_JMenu);
        fText.getFereastraButoane().setBackground(culoare_fButoane);
        setBG_Fereastra_PericoleRecomandari_DescriereApp_JCheckBox(fApp, fPericol, culoare_fApp);
        setFGText_Fereastra_PericoleRecomandari_DescriereApp(fPericol,  fApp, culoare_fPericol);
        setBKG_FereastraGoala(fGoala, culoare_fGoala);
    }
}
