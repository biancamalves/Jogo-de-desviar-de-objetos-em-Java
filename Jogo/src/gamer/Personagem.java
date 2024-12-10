package gamer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Personagem {
    private int x, y;
    private int largura , altura ;
    private Image imagemPersonagem;

    public Personagem(int x, int y) {
        this.x = x;
        this.y = y;
        this.largura = 150;
        this.altura = 200;


        try {
            this.imagemPersonagem = ImageIO.read(getClass().getResource("/imagens/imagemPersonagem1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moverEsquerda() {
        this.x-=15;
        if (x<0){
            this.x+=15;
        }
    }

    public void moverDireita(int larguraTela) {
        this.x+=15;
        if (x+largura>larguraTela){
            this.x=larguraTela-largura;
        }

    }

    public void moverCima(){
        this.y-=15;
        if (y<0){
            this.y+=15;
        }
    }

    public void moverBaixo(int alturaTela){
        this.y+=15;
        if (y+altura>alturaTela){
            this.y=alturaTela-altura;
        }
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

    public Image getImagemPersonagem() {
        return imagemPersonagem;
    }
}
