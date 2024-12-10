package gamer;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Objeto {
    private int x, y;
    private int largura, altura ;
    private Image imagemObjeto;

    public Objeto(int x, int y) {
        this.x = x;
        this.y = y;
        largura=100;
        altura=100;


        try {
            this.imagemObjeto = ImageIO.read(getClass().getResource("/imagens/imagemObjeto1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moverParaBaixo(int velocidadeDoObjeto) {
        this.y += velocidadeDoObjeto;
    }

    public Rectangle getArea() {
        return new Rectangle(x, y, largura, altura);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public Image getImagemObjeto() {
        return imagemObjeto;
    }
}


