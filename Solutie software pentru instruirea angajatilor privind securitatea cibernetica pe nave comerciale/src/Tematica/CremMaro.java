package Tematica;

// Zona de import
import java.awt.Color;

public enum CremMaro {
    CULOARE1(new Color(237, 224, 212)),
    CULOARE2(new Color(230, 204, 178)),
    CULOARE3(new Color(221, 184, 146)),
    CULOARE4(new Color(208, 137, 104)),
    CULOARE5(new Color(127, 85, 57)),
    CULOARE6(new Color(156, 102, 68));

    private final Color color;

    CremMaro(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
