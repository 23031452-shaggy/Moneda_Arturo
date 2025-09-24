import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EspiralAnimacion extends JPanel implements ActionListener {

    // Punto original en coordenadas homogéneas
    private double[] punto = {3, 2, 1};
    private double[] p_actual = {3, 2, 1};

    // Trayectoria
    private java.util.List<Double> trayectoriaX = new java.util.ArrayList<>();
    private java.util.List<Double> trayectoriaY = new java.util.ArrayList<>();

    private Timer timer;

    public EspiralAnimacion() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(600, 600));
        timer = new Timer(20, this); // 20 ms entre frames
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();
        Graphics2D g2 = (Graphics2D) g;

        // Ejes
        g2.setColor(Color.LIGHT_GRAY);
        g2.drawLine(0, h / 2, w, h / 2);
        g2.drawLine(w / 2, 0, w / 2, h);

        // Escala gráfica
        double escala = 10.0;

        // Punto original (rojo)
        int x0 = (int) (w / 2 + punto[0] * escala);
        int y0 = (int) (h / 2 - punto[1] * escala);
        g2.setColor(Color.RED);
        g2.fillOval(x0 - 5, y0 - 5, 10, 10);

        // Trayectoria (azul)
        g2.setColor(Color.BLUE);
        for (int i = 1; i < trayectoriaX.size(); i++) {
            int x1 = (int) (w / 2 + trayectoriaX.get(i - 1) * escala);
            int y1 = (int) (h / 2 - trayectoriaY.get(i - 1) * escala);
            int x2 = (int) (w / 2 + trayectoriaX.get(i) * escala);
            int y2 = (int) (h / 2 - trayectoriaY.get(i) * escala);
            g2.drawLine(x1, y1, x2, y2);
        }

        // Punto en movimiento (verde)
        int xA = (int) (w / 2 + p_actual[0] * escala);
        int yA = (int) (h / 2 - p_actual[1] * escala);
        g2.setColor(Color.GREEN);
        g2.fillOval(xA - 6, yA - 6, 12, 12);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Ángulo fijo por paso
        double ang = Math.PI / 30;
        double cosT = Math.cos(ang);
        double sinT = Math.sin(ang);

        // Matriz de rotación
        double[][] R = {
                {cosT, -sinT, 0},
                {sinT,  cosT, 0},
                {0,     0,    1}
        };

        // Matriz de escalamiento
        double s = 1.004;
        double[][] S = {
                {s, 0, 0},
                {0, s, 0},
                {0, 0, 1}
        };

        // Multiplicar: p_actual = S * R * p_actual
        p_actual = multiplicar(S, multiplicar(R, p_actual));

        // Guardar trayectoria
        trayectoriaX.add(p_actual[0]);
        trayectoriaY.add(p_actual[1]);

        repaint();
    }

    private double[] multiplicar(double[][] M, double[] v) {
        double[] r = new double[3];
        for (int i = 0; i < 3; i++) {
            r[i] = M[i][0] * v[0] + M[i][1] * v[1] + M[i][2] * v[2];
        }
        return r;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animación en espiral con rotación + escalamiento");
        EspiralAnimacion panel = new EspiralAnimacion();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
