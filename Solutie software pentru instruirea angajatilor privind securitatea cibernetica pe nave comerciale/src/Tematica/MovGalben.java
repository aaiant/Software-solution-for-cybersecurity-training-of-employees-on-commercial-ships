package Tematica;

// Zona de import
import java.awt.Color;

public enum MovGalben {
    CULOARE1(new Color(83, 68, 169)),
    CULOARE2(new Color(122, 81, 151)),
    CULOARE3(new Color(187, 80, 152)),
    CULOARE4(new Color(244, 127, 107)),
    CULOARE5(new Color(255, 179, 43)),
    CULOARE6(new Color(245, 198, 60));

    private final Color color;

    MovGalben(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
