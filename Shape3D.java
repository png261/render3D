import java.awt.Graphics2D;
import java.util.ArrayList;

public class Shape3D implements Shape {
    protected ArrayList<Shape2D> shapes;

    public Shape3D() {
        shapes = new ArrayList<>();
    }

    @Override
    public void translate(final double x, final double y, final double z) {
        for (final Shape2D shape : shapes) {
            shape.translate(x, y, z);
        }
    };

    @Override
    public void transform(final Matrix transform) {
        for (final Shape2D shape : shapes) {
            shape.transform(transform);
        }
    }

    @Override
    public void zoom(final double zoom) {
        for (final Shape2D shape : shapes) {
            shape.zoom(zoom);
        }
    }

    @Override
    public void roateX(final double deg) {
        for (final Shape2D shape : shapes) {
            shape.roateX(deg);
        }
    }

    @Override
    public void roateY(final double deg) {
        for (final Shape2D shape : shapes) {
            shape.roateY(deg);
        }
    }

    @Override
    public void drawLine(final Graphics2D g2) {
        for (final Shape2D shape : shapes) {
            shape.drawLine(g2);
        }
    }

}
