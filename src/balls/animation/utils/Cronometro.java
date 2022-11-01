
// Cronometro.java
package balls.animation.utils;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author benvxavier
 */
public class Cronometro extends TimerTask
{

    private final Timer timer;
    private int count;
    public static int currentSecond;

    public Cronometro()
    {
        timer = new Timer();
        count = 1;
        timer.schedule(this, 0, 1000);
    }

    // Resetar o cronômetro
    public void reset()
    {
        Cronometro.currentSecond = 1;
        this.count = 1;
    }

    @Override
    public void run()
    {
//        System.err.println("count" + count);
        count++;
        Cronometro.currentSecond = count;
    }

}
