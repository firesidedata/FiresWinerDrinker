import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;

@Script.Manifest(name="FiresWineDrinker", description="Takes wine jugs from bank and drinks them")
public class WineDrinker extends PollingScript<ClientContext> implements PaintListener{
	private List<Task> Tasklist= new ArrayList<Task>();
	public static int jugsdrunk=0;
	public static int profit=0;
    @Override
    public void start() {
    	Tasklist.addAll(Arrays.asList(new Banking(ctx), new Drink(ctx)));
    }

    @Override
    public void poll() {
        for(Task job: Tasklist)
        {
      	  if(job.activate())
      	  {
      		  job.execute();
        }
    }
    }
    private final Color color1 = new Color(204, 0, 0);

    private final Color color2 = new Color(0, 0, 0);

    private final BasicStroke stroke1 = new BasicStroke(1);

    private final Font font1 = new Font("Arial", 0, 17);
	public void repaint(Graphics g1) {
		
        Graphics2D g = (Graphics2D)g1;
        g.setColor(color1);
        g.fillRect(5, 4, 229, 130);
        g.setColor(color2);
        g.setStroke(stroke1);
        g.drawRect(5, 4, 229, 130);
        g.setFont(font1);
        g.drawString("Fires Winer Drinker ", 13, 26);
        g.drawString("Jugs Drank "+jugsdrunk, 13, 46);
        g.drawString("Profit "+profit, 13, 66);
        g.drawString("Jugs/h "+getPerHour(jugsdrunk), 13, 86);
        g.drawString("Profit/h "+getPerHour(profit), 13, 106);
        g.drawString("time: "+format(getRuntime()), 13, 126);
	}
	private String getPerHour(long arg)
	{
		return NumberFormat.getIntegerInstance().format(arg * 3600000D / (getRuntime()));
	}
	String format(long time) 
	{
		final int sec = (int) (time / 1000), h = sec / 3600, m = sec / 60 % 60, s = sec % 60;
		return (h < 10 ? "0" + h : h) + ":" + (m < 10 ? "0" + m : m) + ":"
				+ (s < 10 ? "0" + s : s);
	}
}

