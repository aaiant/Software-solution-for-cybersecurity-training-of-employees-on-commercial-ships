package Tematica;

// Zona de import
import java.awt.Color;

public enum AlbastruVerde {
    CULOARE1(new Color(33, 58, 87)),
    CULOARE2(new Color (11, 100, 119)),
    CULOARE3(new Color(20, 145, 155)),
    CULOARE4(new Color(10, 209, 200)),
    CULOARE5(new Color(69, 223, 177)),
    CULOARE6(new Color(128, 237, 153));

    private final Color color;

    AlbastruVerde(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
