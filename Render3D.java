import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Render3D extends JFrame {
    public class MyPanel extends JPanel {
        public void paintComponent(final Graphics g) {
            final Graphics2D g2 = (Graphics2D) g;

            g2.setColor(backgroundColor);
            g2.fillRect(0, 0, getWidth(), getHeight());

            g2.translate(getWidth() / 2, getHeight() / 2);
            shape3D.drawLine(g2);
        }
    }

    public class handleMouseWheel implements MouseWheelListener {
        @Override
        public void mouseWheelMoved(final MouseWheelEvent e) {
            shape3D.zoom(Math.abs(e.getWheelRotation() + ZOOM_SPEED));
            renderPanel.repaint();
        }
    }

    public class handleMouseMotion implements MouseMotionListener {
        @Override
        public void mouseDragged(final MouseEvent e) {
            final double roateX = Math.toRadians((mouseX - e.getX()) * ROATE_SPEED);
            final double roateY = Math.toRadians((mouseY - e.getY()) * ROATE_SPEED);

            shape3D.roateX(roateX);
            shape3D.roateY(roateY);
            renderPanel.repaint();
        }

        @Override
        public void mouseMoved(final MouseEvent e) {
        }

    }

    public class handleMouse implements MouseListener {
        @Override
        public void mouseClicked(final MouseEvent e) {
        }

        @Override
        public void mouseEntered(final MouseEvent e) {
        }

        @Override
        public void mouseExited(final MouseEvent e) {
        }

        @Override
        public void mousePressed(final MouseEvent e) {
            mouseX = e.getX();
            mouseY = e.getY();
        }

        @Override
        public void mouseReleased(final MouseEvent e) {
        }
    }

    public static void main(final String args[]) {
        new Render3D().run();
    }

    private final int SCREEN_WIDTH = 700;
    private final int SCREEN_HEIGHT = 700;
    private final double ZOOM_SPEED = 0.05;
    private final double ROATE_SPEED = 0.005;

    private final JPanel renderPanel;

    private final Color backgroundColor = Color.BLACK;

    private final Shape3D shape3D;

    private double mouseX = 0;
    private double mouseY = 0;

    Render3D() {
        final Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        shape3D = new Cube(100, Color.WHITE);

        renderPanel = new MyPanel();
        renderPanel.addMouseWheelListener(new handleMouseWheel());
        renderPanel.addMouseMotionListener(new handleMouseMotion());
        renderPanel.addMouseListener(new handleMouse());
        pane.add(renderPanel, BorderLayout.CENTER);
    }

    public void run() {
        pack();
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setVisible(true);
    }
}
