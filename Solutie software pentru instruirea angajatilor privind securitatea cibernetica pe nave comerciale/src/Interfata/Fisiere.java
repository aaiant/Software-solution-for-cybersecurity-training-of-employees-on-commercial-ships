package Interfata;

//  Zona de import

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class Fisiere extends FileFilter{

    @Override
    public boolean accept(File fisier) {
        if (fisier.isDirectory()) {
            return true;
        }
        String denumire = fisier.getName();
        String extensie = Utilitati.getExtensieFisier(denumire);
        if(extensie == null)
            return false;
        if(extensie.equals("txt") || extensie.equals("anmb"))
            return true;
        return false;
    }

    @Override
    public String getDescription() {
        return "Documente txt (*txt) sau fisiere (*anmb)";
    }
}
