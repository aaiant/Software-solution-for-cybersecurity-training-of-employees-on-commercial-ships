package Tematica;

// Zona de import
import java.awt.Color;

public enum AlbastruInchis_AlbastruDeschis {
    CULOARE1(new Color(3, 32, 48)),
    CULOARE2(new Color(2, 43, 66)),
    CULOARE3(new Color(0, 53, 84)),
    CULOARE4(new Color(0, 77, 116)),
    CULOARE5(new Color(0, 100, 148)),
    CULOARE6(new Color(0, 109, 164));

    private final Color color;

    AlbastruInchis_AlbastruDeschis(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
