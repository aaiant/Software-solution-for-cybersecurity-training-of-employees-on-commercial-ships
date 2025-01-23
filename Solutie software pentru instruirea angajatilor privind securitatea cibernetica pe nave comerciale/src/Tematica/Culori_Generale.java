package Tematica;

// Zona de import
import java.awt.Color;

public enum Culori_Generale {
    CULOARE1(new Color(255, 255, 255)),
    CULOARE2(new Color(0, 0, 0)),
    CULOARE3(new Color(238, 238, 238));

    private final Color color;

    Culori_Generale(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
