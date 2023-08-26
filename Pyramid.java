import java.awt.Color;

public class Pyramid extends Shape3D {
    public Pyramid(final double size, final Color color) {
        super();

        shapes.add(new Shape2D(new Matrix(3, 3, new double[] {
                0, 0, 0,
                size, 0, 0,
                size / 2, size, size / 2
        }), color));

        shapes.add(new Shape2D(new Matrix(3, 3, new double[] {
                size, 0, 0,
                size, 0, size,
                size / 2, size, size / 2
        }), color));

        shapes.add(new Shape2D(new Matrix(3, 3, new double[] {
                size, 0, size,
                0, 0, size,
                size / 2, size, size / 2
        }), color));

        shapes.add(new Shape2D(new Matrix(3, 3, new double[] {
                0, 0, size,
                0, 0, 0,
                size / 2, size, size / 2
        }), color));
    }
}
