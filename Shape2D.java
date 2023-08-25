import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

public class Shape2D {
    Matrix matrix;
    Color color;

    Shape2D(Matrix matrix, Color color) {
        this.matrix = matrix;
        this.color = color;
    }

    public void transform(Matrix transform) {
        matrix = matrix.multiply(transform);
    }

    public void zoom(double zoom) {
        transform(new Matrix(3, 3, new double[] {
                zoom, 0, 0,
                0, zoom, 0,
                0, 0, zoom
        }));
    }

    public void roateX(int angle) {
        transform(new Matrix(3, 3, new double[] {
                Math.cos(angle), 0, Math.sin(angle),
                0, 1, 0,
                -Math.sin(angle), 0, Math.cos(angle)
        }));
    }

    public void roateY(int angle) {
        transform(new Matrix(3, 3, new double[] {
                1, 0, 0,
                0, Math.cos(angle), Math.sin(angle),
                0, -Math.sin(angle), Math.cos(angle)
        }));
    }

    public void drawLine(Graphics2D g2) {
        g2.setColor(color);
        Path2D path = new Path2D.Double();
        path.moveTo(matrix.get(0, 0), matrix.get(0, 1));
        for (int y = 1; y < matrix.m(); ++y) {
            path.lineTo(matrix.get(y, 0), matrix.get(y, 1));
        }
        path.closePath();
        g2.draw(path);
    }
}
