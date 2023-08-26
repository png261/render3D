import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Render3D extends JFrame {
    class MyPanel extends JPanel {
        public MyPanel() {
            addMouseWheelListener(new handleMouseWheel());
            addMouseMotionListener(new handleMouseMotion());
            addMouseListener(new handleMouse());
            addKeyListener(new handleKey());
            setFocusable(true);
        }

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

    class handleKey implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                spaceKeyPressed = true;
            } else {
                double roateX = 0;
                double roateY = 0;
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    roateX = -0.05;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    roateX = 0.05;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    roateY = 0.05;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    roateY = -0.05;
                }

                for (final Shape shape : shapes) {
                    shape.roateX(roateX);
                    shape.roateY(roateY);
                }
                renderPanel.repaint();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                spaceKeyPressed = false;
            }
        }
    }

    class handleMouseWheel implements MouseWheelListener {
        @Override
        public void mouseWheelMoved(final MouseWheelEvent e) {
            if (!e.isControlDown()) {
                for (final Shape shape : shapes) {
                    shape.roateY(e.getWheelRotation() * 0.05);
                }
            } else {
                for (final Shape shape : shapes) {
                    shape.zoom(Math.abs(e.getWheelRotation() + ZOOM_SPEED));
                }
            }

            renderPanel.repaint();
        }
    }

    class handleMouseMotion implements MouseMotionListener {
        @Override
        public void mouseDragged(final MouseEvent e) {
            if (spaceKeyPressed) {
                for (final Shape shape : shapes) {
                    shape.translate((e.getX() - mouseX) / 50, 0, 0);
                    shape.translate(0, (e.getY() - mouseY) / 50, 0);
                }
            } else {
                final double roateX = Math.toRadians((mouseX - e.getX()) * ROATE_SPEED);
                final double roateY = Math.toRadians((mouseY - e.getY()) * ROATE_SPEED);

                for (final Shape shape : shapes) {
                    shape.roateX(roateX);
                    shape.roateY(roateY);
                }
            }
            renderPanel.repaint();
        }

        @Override
        public void mouseMoved(final MouseEvent e) {
        }

    }

    class handleMouse implements MouseListener {
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

    private final int FRAME_WIDTH = 1280;
    private final int FRAME_HEIGHT = 768;
    private final double ZOOM_SPEED = 0.05;
    private final double ROATE_SPEED = 0.005;

    private final JPanel renderPanel;

    private final Color backgroundColor = Color.BLACK;

    private final ArrayList<Shape> shapes;

    private double mouseX = 0;
    private double mouseY = 0;

    private boolean spaceKeyPressed = false;

    Render3D() {
        shapes = new ArrayList<>();
        final Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        final Cube cube = new Cube(100, Color.WHITE);
        final Pyramid pyramid = new Pyramid(100, Color.WHITE);
        cube.translate(100, 100, 0);
        pyramid.translate(100, 0, 0);

        shapes.add(new Cordinate3D(400, Color.YELLOW));
        shapes.add(cube);
        shapes.add(pyramid);

        renderPanel = new MyPanel();
        pane.add(renderPanel, BorderLayout.CENTER);
    }

    public void run() {
        pack();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(true);
    }
}
