package Tematica;

// Zona de import
import java.awt.Color;

public enum MovInchis_Crem {
    CULOARE1(new Color(25, 0, 25)),
    CULOARE2(new Color(43, 18, 76)),
    CULOARE3(new Color(82, 43, 91)),
    CULOARE4(new Color(133, 79, 108)),
    CULOARE5(new Color(223, 182, 178)),
    CULOARE6(new Color(251, 228, 216));

    private final Color color;

    MovInchis_Crem(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
