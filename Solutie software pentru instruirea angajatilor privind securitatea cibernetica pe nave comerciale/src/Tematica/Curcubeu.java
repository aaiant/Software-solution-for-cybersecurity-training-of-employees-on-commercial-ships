package Tematica;

// Zona de import
import java.awt.Color;

public enum Curcubeu {
    CULOARE1(new Color(239, 71, 111)),
    CULOARE2(new Color(247, 140, 107)),
    CULOARE3(new Color(255, 209, 102)),
    CULOARE4(new Color(6, 214, 160)),
    CULOARE5(new Color(17, 138, 178)),
    CULOARE6(new Color(7, 59, 76));

    private final Color color;

    Curcubeu(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
