package Tematica;

// Zona de import
import java.awt.Color;

public enum MovRosu {
    CULOARE1(new Color(66, 38, 128)),
    CULOARE2(new Color(52, 22, 113)),
    CULOARE3(new Color(40, 6, 89)),
    CULOARE4(new Color(102, 15, 86)),
    CULOARE5(new Color(174, 45, 104)),
    CULOARE6(new Color(245, 73, 82));

    private final Color color;

    MovRosu(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
