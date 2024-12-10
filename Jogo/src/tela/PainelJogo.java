package tela;
import gamer.Personagem;
import gamer.Objeto;
import gamer.ItemEspecial;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.Random;

    public class PainelJogo extends JPanel implements ActionListener {
        private Personagem personagem;
        private Timer temporizador;
        private ArrayList<Objeto> objetos;
        private ArrayList<ItemEspecial> itensEspeciais;
        private Random aleatorio;
        private int pontuacao;
        private Image imagemFundo;

        private String nomeJogador;
        private int proximaPontuacao=50;
        private int velocidadeDoObjeto=5;

        public PainelJogo(String nomeJogador) {
            this.nomeJogador = nomeJogador;
            this.personagem = new Personagem(880,790);
            this.objetos = new ArrayList<>();
            this.itensEspeciais = new ArrayList<>();
            this.aleatorio = new Random();
            this.pontuacao = 0;

            try {
                this.imagemFundo = ImageIO.read(getClass().getResource("/imagens/FundoJogo.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            temporizador = new Timer(30, this);
            temporizador.start();
            setFocusable(true);

            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_LEFT -> personagem.moverEsquerda();
                        case KeyEvent.VK_RIGHT -> personagem.moverDireita(getWidth());
                        case KeyEvent.VK_DOWN -> personagem.moverBaixo(getHeight());
                        case KeyEvent.VK_UP -> personagem.moverCima();
                    }
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (imagemFundo != null) {
                g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
            }

            g.drawImage(personagem.getImagemPersonagem(), personagem.getX(), personagem.getY(), personagem.getLargura(), personagem.getAltura(), this);

            for (Objeto objeto : objetos) {
                g.drawImage(objeto.getImagemObjeto(), objeto.getX(), objeto.getY(), objeto.getLargura(), objeto.getAltura(), this);
            }

            for (ItemEspecial item : itensEspeciais) {
                g.drawImage(item.getImagemItemEspecial(), item.getX(), item.getY(), item.getLargura(), item.getAltura(), this);
            }

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Jogador: " + nomeJogador, 10, 25);
            g.drawString("Pontuação: " + pontuacao, 10, 50);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            atualizarObjetos();
            atualizarItensEspeciais();
            verificarColisoes();
            repaint();
        }

        private void atualizarObjetos() {
            if (pontuacao>50 && pontuacao>=proximaPontuacao){
                velocidadeDoObjeto++;
                proximaPontuacao+=50;
            }

            if (aleatorio.nextInt(100) < 2) {
                objetos.add(new Objeto(aleatorio.nextInt(getWidth()), 0));
            } for (int i = 0; i < objetos.size(); i++) {
                Objeto objeto = objetos.get(i);
                objeto.moverParaBaixo(velocidadeDoObjeto);
                if (objeto.getY() > getHeight()) {
                    objetos.remove(i);
                    i--;

                }
            }

        }

        private void atualizarItensEspeciais() {
            if (aleatorio.nextInt(200) < 2) {
                int x = aleatorio.nextInt(getWidth() - 50);
                itensEspeciais.add(new ItemEspecial(x, 0));
            }

            for (int i = 0; i < itensEspeciais.size(); i++) {
                ItemEspecial item = itensEspeciais.get(i);
                item.moverParaBaixo();
                if (item.getY() > getHeight()) {
                    itensEspeciais.remove(i);
                    i--;
                }
            }
        }

        private void verificarColisoes() {
            for (int i = 0; i < objetos.size(); i++) {
                Objeto objeto = objetos.get(i);
                if (personagem.getArea().intersects(objeto.getArea())) {
                    JOptionPane.showMessageDialog(this, "Você foi atingido! Fim de jogo!");
                    System.exit(0);
                }
            }


            for (int i = 0; i < itensEspeciais.size(); i++) {
                ItemEspecial item = itensEspeciais.get(i);
                if (personagem.getArea().intersects(item.getArea())) {
                    pontuacao += 10;
                    itensEspeciais.remove(i);
                    i--;

                }

            }

        }
    }
