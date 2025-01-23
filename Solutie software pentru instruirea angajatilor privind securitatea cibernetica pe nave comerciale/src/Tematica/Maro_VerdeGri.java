package Tematica;

// Zona de import
import java.awt.Color;

public enum Maro_VerdeGri {
    CULOARE1(new Color(163, 99, 97)),
    CULOARE2(new Color(211, 162, 157)),
    CULOARE3(new Color(232, 178, 152)),
    CULOARE4(new Color(238, 204, 140)),
    CULOARE5(new Color(189, 209, 197)),
    CULOARE6(new Color(158, 171, 162));

    private final Color color;

    Maro_VerdeGri(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
