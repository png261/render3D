import java.awt.Color;

public class Cube extends Shape3D {
    public Cube(final double size, final Color color) {
        super();

        shapes.add(new Shape2D(new Matrix(4, 3, new double[] {
                0, 0, 0,
                size, 0, 0,
                size, size, 0,
                0, size, 0
        }), color));

        shapes.add(new Shape2D(new Matrix(4, 3, new double[] {
                size, 0, size,
                size, 0, 0,
                size, size, 0,
                size, size, size
        }), color));

        shapes.add(new Shape2D(new Matrix(4, 3, new double[] {
                0, 0, size,
                size, 0, size,
                size, size, size,
                0, size, size
        }), color));

        shapes.add(new Shape2D(new Matrix(4, 3, new double[] {
                0, size, size,
                size, size, size,
                size, size, 0,
                0, size, 0
        }), color));

        shapes.add(new Shape2D(new Matrix(4, 3, new double[] {
                0, 0, 0,
                0, 0, size,
                0, size, size,
                0, size, 0
        }), color));
    }
}
