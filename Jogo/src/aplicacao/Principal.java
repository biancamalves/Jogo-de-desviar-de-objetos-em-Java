package aplicacao;
import javax.swing.*;
import tela.TelaInicial;

public class Principal {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            TelaInicial telaInicial = new TelaInicial();
            telaInicial.setVisible(true);

        });
    }
}
