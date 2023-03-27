import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class AnimacaoTela extends JFrame{
    private JPanel janela;
    private int fps = 1000 / 20;
    private int ct;
    private boolean anima = true;

    public void iniciaAnimacao() {
        long prxAtualizacao = 0;

        while (anima) {
            if (System.currentTimeMillis() >= prxAtualizacao) {
                ct++;
                janela.repaint();

                prxAtualizacao = System.currentTimeMillis() + fps;

                if (ct == 100) {
                    anima = false;
                }

            }
        }
    }

    public AnimacaoTela() {
        janela = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
            // Limpando os desenhos anteriores
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, janela.getWidth(),
            janela.getHeight());
            g.setColor(Color.BLUE);
            g.drawLine(0, 240 + ct, 640, 240 + ct);
            g.drawRect(10, 25 + ct, 20, 20);
            g.drawOval(30 + ct, 20, 40, 30);
            g.setColor(Color.YELLOW);
            g.drawLine(320 - ct, 0, 320 - ct, 480);
            g.fillRect(110, 125, 120 - ct, 120 - ct);
            g.fillOval(230, 220, 240 + ct, 230);
            g.setColor(Color.RED);
            g.drawString("Eu seria um ótimo Score! " + ct, 5, 10);
        }

        };
        getContentPane().add(janela);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);
        janela.repaint();
    }
    public static void main(String[] args) {
        AnimacaoTela anima = new AnimacaoTela();
        anima.iniciaAnimacao();
    }
}
