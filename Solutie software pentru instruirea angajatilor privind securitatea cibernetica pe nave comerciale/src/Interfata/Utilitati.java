package Interfata;

public class Utilitati {
    public static String getExtensieFisier(String denumire) {
        int index = denumire.lastIndexOf(".");
        if(index == -1)
            return null;
        if(index == denumire.length() - 1)
            return null;
        return denumire.substring(index+1);
    }
}