import java.awt.Graphics2D;
import java.util.ArrayList;

public class Shape3D {
    protected ArrayList<Shape2D> shapes;

    public Shape3D() {
        shapes = new ArrayList<>();
    }

    public void transform(Matrix transform) {
        for (Shape2D shape : shapes) {
            shape.transform(transform);
        }
    }

    public void zoom(double zoom) {
        for (Shape2D shape : shapes) {
            shape.zoom(zoom);
        }
    }

    public void roateX(int angle) {
        for (Shape2D shape : shapes) {
            shape.roateX(angle);
        }
    }

    public void roateY(int angle) {
        for (Shape2D shape : shapes) {
            shape.roateY(angle);
        }
    }

    public void drawLine(Graphics2D g2) {
        for (Shape2D shape : shapes) {
            shape.drawLine(g2);
        }
    }

}
