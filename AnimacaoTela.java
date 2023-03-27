import javax.swing.JFrame;
import javax.swing.JPanel;

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
}
