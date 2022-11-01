// Balls.java

package balls.animation;


import balls.animation.utils.Cronometro;
import balls.animation.utils.Helper;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;


/**
 *
 * @author benvxavier
 *
 */
public class Balls extends Component implements Runnable
{

    private double rotateVelocidade, translateMovimentoX;
    private int flagEsqDir;
    private AffineTransform afft;

    private final Cronometro cronometro;

    public Balls()
    {
        new Thread(this).start();
        cronometro = new Cronometro();
    }

    //Desenhando as bolas
    @Override
    public void paint(Graphics g)
    {
        super.paint(g); // Invocando o método paint da super class Component 

        Graphics2D g2 = (Graphics2D) g; // convertendo g para Graphic2D

        //Melhorar a qualidade da renderização dos gráficos
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //Obter o centro da janela
        Point centroJanela = Helper.getCentro(new Point(0, 0), this.getSize());

        //Movimentar toda animação da esquerda para direita
        AffineTransform aft0 = g2.getTransform();
        g2.translate(translateMovimentoX, 0);
        {
            //Desenhar BOLA AMARELA no centro da janela
            /*
              Ellipse2D bolaAmarela = new Ellipse2D.Double(centroJanela.x, centroJanela.y, 80, 80);
              g2.setColor(Color.YELLOW);
              g2.fill(bolaAmarela);
             */
            //
            /* 
              Resolvendo o problema da linha de código similar acima comentada, 
              adicionando alguns cálculos. Assim quando a janela for redimencionada a 
              bola amarela se mantiverá no centro da janela.
             */
            Ellipse2D bolaAmarela = new Ellipse2D.Double(centroJanela.x - 80 / 2,
                    centroJanela.y - 80 / 2, 60, 60);

            //scale
            afft = g2.getTransform();
            {
                switch (Cronometro.currentSecond)
                {
                    case 1:
                        Helper.scale(g2,
                                new Point((int) bolaAmarela.getX(), (int) bolaAmarela.getY()), 2.0);
                    case 2:
                        Helper.scale(g2,
                                new Point((int) bolaAmarela.getX(), (int) bolaAmarela.getY()), 1.0);
                }
            }
            Helper.fillShape(g2, Color.YELLOW, bolaAmarela);
            g2.setTransform(afft);

            //BOLA AZUL
            Ellipse2D bolaAzul = new Ellipse2D.Double(bolaAmarela.getX(),
                    bolaAmarela.getY() + 130, 40, 40);

            //rotate
            afft = g2.getTransform();
            {
                g2.rotate(Math.toRadians(rotateVelocidade - 1.0), bolaAmarela.getCenterX(),
                        bolaAmarela.getCenterY());
            }

            //scale
            afft = g2.getTransform();
            {
                switch (Cronometro.currentSecond)
                {
                    case 3:
                        Helper.scale(g2, new Point((int) bolaAzul.getX(),
                                (int) bolaAzul.getY()), 2.0);
                    case 4:
                        Helper.scale(g2, new Point((int) bolaAzul.getX(),
                                (int) bolaAzul.getY()), 1.0);
                }
            }
            Helper.fillShape(g2, Color.BLUE, bolaAzul);
            g2.setTransform(afft);

            //BOLA VERMELHA
            Ellipse2D bolaVermelha = new Ellipse2D.Double(bolaAzul.getX(),
                    bolaAzul.getY() + 60, 20, 20);

            //rotate
            afft = g2.getTransform();
            {
                g2.rotate(Math.toRadians(rotateVelocidade - 1.0), bolaAzul.getCenterX(),
                        bolaAzul.getCenterY());
            }

            //scale
            afft = g2.getTransform();
            {
                switch (Cronometro.currentSecond)
                {
                    case 5:
                        Helper.scale(g2, new Point((int) bolaVermelha.getX(),
                                (int) bolaVermelha.getY()), 2.0);
                    case 6:
                        Helper.scale(g2, new Point((int) bolaVermelha.getX(),
                                (int) bolaVermelha.getY()), 1.0);
                }
            }
            Helper.fillShape(g2, Color.RED, bolaVermelha);
            g2.setTransform(afft);

            // BOLA VERDE
            Ellipse2D bolaVerde = new Ellipse2D.Double(bolaVermelha.getX(),
                    bolaVermelha.getY() + 30, 10, 10);

            //rotate
            afft = g2.getTransform();
            {
                g2.rotate(Math.toRadians(rotateVelocidade - 1.0), bolaVermelha.getCenterX(),
                        bolaVermelha.getCenterY());
            }

            //scale
            afft = g2.getTransform();
            {
                switch (Cronometro.currentSecond)
                {
                    case 7:
                        Helper.scale(g2, new Point((int) bolaVerde.getX(),
                                (int) bolaVerde.getY()), 2.0);
                    case 8:
                        Helper.scale(g2, new Point((int) bolaVerde.getX(),
                                (int) bolaVerde.getY()), 1.0);
                }
            }
            Helper.fillShape(g2, Color.GREEN, bolaVerde);
        }
        g2.setTransform(aft0); // restaurar a tf anterior (at0)

        //Resetar o cronômetro
        if (Cronometro.currentSecond == 9)
        {
            cronometro.reset();
        }
    }

    //Movimentar toda animação da esquerda para direita
    public void MovimentoEsquerdaDireita()
    {
        if (flagEsqDir == 0)
        {
            this.translateMovimentoX--;
        }
        if (translateMovimentoX == -99.0)
        {
            flagEsqDir = 1;
        }
        if (flagEsqDir == 1)
        {
            this.translateMovimentoX++;
            if (translateMovimentoX == 90.0)
            {
                flagEsqDir = 0;
            }
        }
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                //update translate
                MovimentoEsquerdaDireita();

                //update rotate 
                rotateVelocidade++;

                Thread.sleep(1000 / 24);
                repaint();
            }
            catch (InterruptedException ex)
            {
                System.err.println("ocorreu um erro na thread");
            }
        }
    }
}
