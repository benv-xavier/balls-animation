
// Helper.java
package balls.animation.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

/**
 *
 * @author benvxavier
 */
public class Helper
{

    /**
     *
     * @des Obter as coordenas referentes ao centro de um objecto
     * @param posObjecto
     * @param dimensao
     * @return Point contendo as cordenas(x, y)
     */
    public static Point getCentro(Point posObjecto, Dimension dimensao)
    {
        return new Point(posObjecto.x + dimensao.width / 2,
                posObjecto.y + dimensao.height / 2);

    }

    /**
     * @des Preencher uma Shape
     * @param g2
     * @param color
     * @param shape
     */
    public static void fillShape(Graphics2D g2, Color color, Shape shape)
    {
        g2.setColor(color);
        g2.fill(shape);
    }

    /**
     * @des: Aumentar/Diminuir o tamanho de um objecto
     * @param g2
     * @param currentPoint
     * @param factor
     */
    public static void scale(Graphics2D g2, Point currentPoint, double factor)
    {
        g2.translate(currentPoint.x, currentPoint.y);
        g2.scale(1.0 / factor, 1.0 / factor);
        g2.translate(-currentPoint.x, -currentPoint.y);
    }

}