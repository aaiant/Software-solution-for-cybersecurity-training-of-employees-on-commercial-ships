package Tematica;

// Zona de import
import java.awt.Color;

public enum CurcubeuInchis {
    CULOARE1(new Color(38, 70, 83)),
    CULOARE2(new Color(40, 114, 113)),
    CULOARE3(new Color(42, 157, 143)),
    CULOARE4(new Color(233, 196, 106)),
    CULOARE5(new Color(244, 162, 97)),
    CULOARE6(new Color(231, 111, 81));

    private final Color color;

    CurcubeuInchis(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
