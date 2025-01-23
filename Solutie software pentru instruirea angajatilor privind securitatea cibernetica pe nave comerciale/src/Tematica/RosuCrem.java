package Tematica;

// Zona de import
import java.awt.Color;

public enum RosuCrem {
    CULOARE1(new Color(212, 94, 94)),
    CULOARE2(new Color(240, 128, 128)),
    CULOARE3(new Color (244, 151, 142)),
    CULOARE4(new Color(248, 173, 157)),
    CULOARE5(new Color(251, 196, 171)),
    CULOARE6(new Color(255, 218, 185));

    private final Color color;

    RosuCrem(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
