package Tematica;

// Zona de import
import java.awt.Color;

public enum VerdeInchis_AlbastruGri {
    CULOARE1(new Color(145, 172, 154)),
    CULOARE2(new Color(169, 195, 182)),
    CULOARE3(new Color(206, 223, 223)),
    CULOARE4(new Color(183, 209, 211)),
    CULOARE5(new Color(166, 195, 206)),
    CULOARE6(new Color(143, 184, 202));

    private final Color color;

    VerdeInchis_AlbastruGri(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
