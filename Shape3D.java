import java.awt.Graphics2D;
import java.util.ArrayList;

public class Shape3D implements Shape {
    protected ArrayList<Shape2D> shapes;

    public Shape3D() {
        shapes = new ArrayList<>();
    }

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
    public void roateX(final double radian) {
        for (final Shape2D shape : shapes) {
            shape.roateX(radian);
        }
    }

    @Override
    public void roateY(final double radian) {
        for (final Shape2D shape : shapes) {
            shape.roateY(radian);
        }
    }

    @Override
    public void drawLine(final Graphics2D g2) {
        for (final Shape2D shape : shapes) {
            shape.drawLine(g2);
        }
    }

}
