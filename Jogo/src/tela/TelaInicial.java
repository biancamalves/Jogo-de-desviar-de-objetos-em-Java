package tela;

import javax.swing.*;

    public class TelaInicial extends JFrame {
        private JTextField campoNome;
        private JButton botaoIniciar;

        public TelaInicial() {
            configurarJanela();
            configurarComponentes();
        }

        private void configurarJanela() {
            setTitle("User Nick");
            setSize(400, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(null);
        }

        private void configurarComponentes() {
            JLabel labelNome = new JLabel("Digite seu nome:");
            labelNome.setBounds(50, 40, 120, 30);
            add(labelNome);

            campoNome = new JTextField();
            campoNome.setBounds(160, 40, 180, 30);
            add(campoNome);

            botaoIniciar = new JButton("Iniciar");
            botaoIniciar.setBounds(150, 100, 100, 40);
            botaoIniciar.addActionListener(e -> iniciarJogo());
            add(botaoIniciar);
        }

        private void iniciarJogo() {
            String nomeJogador = campoNome.getText().trim();
            if (nomeJogador.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, insira seu nome.");
            } else {
                JFrame janela = new JFrame("Jogo de Desviar Objetos - " + nomeJogador);
                PainelJogo painelJogo = new PainelJogo(nomeJogador);
                janela.add(painelJogo);
                janela.setSize(1920, 1080);
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela.setLocationRelativeTo(null);
                janela.setVisible(true);
                dispose();
            }
        }
    }
