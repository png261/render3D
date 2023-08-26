import java.awt.Graphics2D;

public interface Shape {
    public void translate(final double x, final double y, final double z);

    public void transform(final Matrix transform);

    public void zoom(final double zoom);

    public void roateX(final double deg);

    public void roateY(final double deg);

    public void drawLine(final Graphics2D g2);

}
