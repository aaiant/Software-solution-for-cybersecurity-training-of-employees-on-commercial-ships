package Tematica;

// Zona de import
import java.awt.Color;

public enum AlbastruGri_CremInchis {
    CULOARE1(new Color(83, 88, 120)),
    CULOARE2(new Color(157, 128, 206)),
    CULOARE3(new Color(184, 216, 227)),
    CULOARE4(new Color(254, 225, 221)),
    CULOARE5(new Color(233, 194, 197)),
    CULOARE6(new Color(206, 160, 170));

    private final Color color;

    AlbastruGri_CremInchis(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
