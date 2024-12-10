package gamer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class ItemEspecial {
    private int x, y;
    private int largura , altura ;
    private Image imagemItemEspecial;

    public ItemEspecial(int x, int y) {
        this.x = x;
        this.y = y;
        largura= 30;
        altura=30;


        try {
            this.imagemItemEspecial = ImageIO.read(getClass().getResource("/imagens/imagemItemEspacial.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moverParaBaixo() {
        this.y += 3;
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

    public Image getImagemItemEspecial() {
        return imagemItemEspecial;
    }
}
