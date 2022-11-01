/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package balls.animation;

import balls.animation.utils.Frame;
import java.awt.Color;

/**
 *
 * @author benvxavier
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
       new Frame("Balls Animation", new Balls(), null, new Color(0, 0, 0, 20));
    }
    
}
