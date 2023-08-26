import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Render3D extends JFrame {
    public class MyPanel extends JPanel {
        public void paintComponent(final Graphics g) {
            final Graphics2D g2 = (Graphics2D) g;

            g2.setColor(backgroundColor);
            g2.fillRect(0, 0, getWidth(), getHeight());

            g2.translate(getWidth() / 2, getHeight() / 2);
            for (final Shape shape : shapes) {
                shape.drawLine(g2);
            }
        }
    }

    public class handleMouseWheel implements MouseWheelListener {
        @Override
        public void mouseWheelMoved(final MouseWheelEvent e) {
            for (final Shape shape : shapes) {
                shape.zoom(Math.abs(e.getWheelRotation() + ZOOM_SPEED));
            }
            renderPanel.repaint();
        }
    }

    public class handleMouseMotion implements MouseMotionListener {
        @Override
        public void mouseDragged(final MouseEvent e) {
            final double roateX = Math.toRadians((mouseX - e.getX()) * ROATE_SPEED);
            final double roateY = Math.toRadians((mouseY - e.getY()) * ROATE_SPEED);

            for (final Shape shape : shapes) {
                shape.roateX(roateX);
                shape.roateY(roateY);
            }
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

    private final int FRAME_WIDTH = 700;
    private final int FRAME_HEIGHT = 700;
    private final double ZOOM_SPEED = 0.05;
    private final double ROATE_SPEED = 0.005;

    private final JPanel renderPanel;

    private final Color backgroundColor = Color.BLACK;

    private final ArrayList<Shape> shapes;

    private double mouseX = 0;
    private double mouseY = 0;

    Render3D() {
        shapes = new ArrayList<>();
        final Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        final int COORD_SIZE = 400;
        shapes.add(new Shape2D(new Matrix(2, 3, new double[] {
                0, 0, 0,
                COORD_SIZE, 0, 0,
        }), Color.YELLOW));

        shapes.add(new Shape2D(new Matrix(2, 3, new double[] {
                0, 0, 0,
                0, COORD_SIZE, 0,
        }), Color.YELLOW));

        shapes.add(new Shape2D(new Matrix(2, 3, new double[] {
                0, 0, 0,
                0, 0, COORD_SIZE,
        }), Color.YELLOW));

        shapes.add(new Cube(100, Color.WHITE));
        shapes.add(new Pyramid(100, Color.WHITE));

        renderPanel = new MyPanel();
        renderPanel.addMouseWheelListener(new handleMouseWheel());
        renderPanel.addMouseMotionListener(new handleMouseMotion());
        renderPanel.addMouseListener(new handleMouse());
        pane.add(renderPanel, BorderLayout.CENTER);
    }

    public void run() {
        pack();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(true);
    }
}
