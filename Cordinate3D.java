import java.awt.Color;

public class Cordinate3D extends Shape3D {
    public Cordinate3D(final double size, final Color color) {
        shapes.add(new Shape2D(new Matrix(2, 3, new double[] {
                size, 0, 0,
                0, 0, 0,
        }), color));

        shapes.add(new Shape2D(new Matrix(2, 3, new double[] {
                0, size, 0,
                0, 0, 0,
        }), color));

        shapes.add(new Shape2D(new Matrix(2, 3, new double[] {
                0, 0, size,
                0, 0, 0,
        }), color));
    }
}
