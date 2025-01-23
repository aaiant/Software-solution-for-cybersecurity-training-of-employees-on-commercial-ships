package Tematica;

// Zona de import
import java.awt.Color;

public enum MovRoz {
    CULOARE1(new Color(244, 231, 251)),
    CULOARE2(new Color(243, 220, 220)),
    CULOARE3(new Color(245, 188, 186)),
    CULOARE4(new Color(227, 170, 221)),
    CULOARE5(new Color(200, 168, 233)),
    CULOARE6(new Color(195, 199, 243));

    private final Color color;

    MovRoz(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
