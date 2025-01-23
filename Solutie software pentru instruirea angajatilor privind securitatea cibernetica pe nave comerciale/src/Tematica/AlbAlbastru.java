package Tematica;

// Zona de import
import java.awt.Color;

public enum AlbAlbastru {
    CULOARE1(new Color(240, 243, 250)),
    CULOARE2(new Color(213, 222, 239)),
    CULOARE3(new Color(177, 201, 239)),
    CULOARE4(new Color(138, 174, 224)),
    CULOARE5(new Color(99, 142, 203)),
    CULOARE6(new Color(57, 88, 134));

    private final Color color;

    AlbAlbastru(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
