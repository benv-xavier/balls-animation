
// Frame.java
package balls.animation.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author benvxavier
 */
public class Frame extends JFrame
{

    public Frame(String titulo, Component component, Dimension defaultDim, Color bgColor)
    {
        initFrame(titulo, component, defaultDim, bgColor);
    }

    private void initFrame(String titulo, Component component,
            Dimension defaultDim, Color bgColor)
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        setTitle(titulo);
        getContentPane().setBackground(bgColor);
        add(component);

        if (defaultDim == null)
        {
            setSize(dimension.width, dimension.height);
            setExtendedState(this.getExtendedState() | Frame.MAXIMIZED_BOTH);
        }
        else
        {
            setSize(defaultDim.width, defaultDim.height);
            setLocationRelativeTo(null);
            setResizable(false);
        }

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}