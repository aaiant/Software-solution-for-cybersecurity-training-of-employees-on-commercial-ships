package Tematica;

// Zona de import
import java.awt.Color;

public enum VerdeDeschis_VerdeInchis {
    CULOARE1(new Color(233, 245, 219)),
    CULOARE2(new Color(207, 225, 185)),
    CULOARE3(new Color(181, 201, 154)),
    CULOARE4(new Color(151, 169, 124)),
    CULOARE5(new Color(135, 152, 106)),
    CULOARE6(new Color(113, 131, 85));

    private final Color color;

    VerdeDeschis_VerdeInchis(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
