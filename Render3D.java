import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Render3D extends JFrame {
    public class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, getWidth(), getHeight());

            g2.translate(getWidth() / 2, getHeight() / 2);
            shape3D.drawLine(g2);
        }
    }

    public class handleMouseWheel implements MouseWheelListener {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            shape3D.zoom(e.getWheelRotation() * 0.5);
            renderPanel.repaint();
        }
    }

    public class handleMouseMotion implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {
            double yi = 180.0 / renderPanel.getHeight();
            double xi = 180.0 / renderPanel.getWidth();
            shape3D.roateX((int) ((e.getX() - mouseX) * xi));
            shape3D.roateY(-(int) ((e.getY() - mouseY) * yi));
            renderPanel.repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

    }

    public class handleMouse implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            mouseX = e.getX();
            mouseY = e.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }
    }

    public static void main(String args[]) {
        new Render3D().run();
    }

    private int SCREEN_WIDTH = 700;

    private int SCREEN_HEIGHT = 700;

    private JPanel renderPanel;

    private Shape3D shape3D;

    private double mouseX = 0;
    private double mouseY = 0;

    Render3D() {
        Container pane = getContentPane();
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
