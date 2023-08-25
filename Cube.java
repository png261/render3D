import java.awt.Color;

public class Cube extends Shape3D {
    public Cube(double size, Color color) {
        super();

        shapes.add(new Shape2D(new Matrix(4, 3, new double[] {
                0, 0, 0,
                1, 0, 0,
                1, 1, 0,
                0, 1, 0
        }), color));

        shapes.add(new Shape2D(new Matrix(4, 3, new double[] {
                1, 0, 1,
                1, 0, 0,
                1, 1, 0,
                1, 1, 1
        }), color));

        shapes.add(new Shape2D(new Matrix(4, 3, new double[] {
                0, 0, 1,
                1, 0, 1,
                1, 1, 1,
                0, 1, 1
        }), color));

        shapes.add(new Shape2D(new Matrix(4, 3, new double[] {
                0, 1, 1,
                1, 1, 1,
                1, 1, 0,
                0, 1, 0
        }), color));

        shapes.add(new Shape2D(new Matrix(4, 3, new double[] {
                0, 0, 0,
                0, 0, 1,
                0, 1, 1,
                0, 1, 0
        }), color));

        shapes.add(new Shape2D(new Matrix(4, 3, new double[] {
                0, 0, 0,
                1, 0, 0,
                1, 0, 1,
                0, 0, 1
        }), color));

        zoom(size);
    }
}
