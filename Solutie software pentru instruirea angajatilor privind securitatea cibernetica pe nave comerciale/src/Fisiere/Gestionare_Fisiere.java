package Fisiere;

//  Zona de import

import javax.swing.*;
import java.io.*;
import java.awt.*;

//  Importarea din pachetul Interfata

import Interfata.*;

public class Gestionare_Fisiere extends Component{
    //  Componente
    //  Constructor
    //  Metode
    public static void scriereFisier(File file, Fereastra_Text fereastra, CadrulPrincipal controller) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(fereastra.getZonaText().getText());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(controller, "Eroare la scrierea fișierului: " + e.getMessage(),
                    "Eroare", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void scriereFisier2(File file, Fereastra_DescriereAplicatie fereastra, CadrulPrincipal controller) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(fereastra.getZonaDescriere().getText());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(controller, "Eroare la scrierea fișierului: " + e.getMessage(),
                    "Eroare", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void citesteFisier(File file, Fereastra_Text fereastra, CadrulPrincipal controller) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            //  Stergerea textul din zonaText la incarcarea altui fisier
            fereastra.getZonaText().setText("");
            String linie;
            while ((linie = reader.readLine()) != null) {
                fereastra.adaugaText(linie);
            }
            fereastra.getZonaText().setCaretPosition(0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(controller, "Nu s-a putut incarca fisierul: " + e.getMessage(),
                    "Eroare", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void citesteFisier2(File file, Fereastra_DescriereAplicatie fereastra, CadrulPrincipal controller) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            //  Stergerea textul din zonaText la incarcarea altui fisier
            fereastra.getZonaDescriere().setText("");
            String linie;
            while ((linie = reader.readLine()) != null) {
                fereastra.adaugaText(linie);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(controller, "Nu s-a putut incarca fisierul: " + e.getMessage(),
                    "Eroare", JOptionPane.ERROR_MESSAGE);
        }
    }
}
