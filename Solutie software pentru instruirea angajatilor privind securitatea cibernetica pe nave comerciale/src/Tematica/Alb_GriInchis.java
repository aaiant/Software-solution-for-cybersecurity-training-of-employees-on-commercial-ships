package Tematica;

// Zona de import
import java.awt.Color;

public enum Alb_GriInchis {
    CULOARE1(new Color(255, 255, 247)),
    CULOARE2(new Color(251, 251, 235)),
    CULOARE3(new Color(226, 226, 212)),
    CULOARE4(new Color(201, 201, 188)),
    CULOARE5(new Color(181, 181, 169)),
    CULOARE6(new Color(163, 163, 152));

    private final Color color;

    Alb_GriInchis(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
