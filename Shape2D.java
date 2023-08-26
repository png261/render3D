import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

public class Shape2D {
    protected Matrix matrix;
    protected Color color;

    Shape2D(final Matrix matrix) {
        this(matrix, Color.WHITE);
    }

    Shape2D(final Matrix matrix, final Color color) {
        this.matrix = matrix;
        this.color = color;
    }

    public void transform(final Matrix transform) {
        matrix = matrix.multiply(transform);
    }

    public void zoom(final double zoom) {
        transform(new Matrix(3, 3, new double[] {
                zoom, 0, 0,
                0, zoom, 0,
                0, 0, zoom
        }));
    }

    public void roateX(final double radian) {
        transform(new Matrix(3, 3, new double[] {
                Math.cos(radian), 0, -Math.sin(radian),
                0, 1, 0,
                Math.sin(radian), 0, Math.cos(radian)
        }));
    }

    public void roateY(final double radian) {
        transform(new Matrix(3, 3, new double[] {
                1, 0, 0,
                0, Math.cos(radian), Math.sin(radian),
                0, -Math.sin(radian), Math.cos(radian)
        }));
    }

    public void drawLine(final Graphics2D g2) {
        g2.setColor(color);
        final Path2D path = new Path2D.Double();
        path.moveTo(matrix.get(0, 0), matrix.get(0, 1));
        for (int y = 1; y < matrix.m(); ++y) {
            path.lineTo(matrix.get(y, 0), matrix.get(y, 1));
        }
        path.closePath();
        g2.draw(path);
    }
}
