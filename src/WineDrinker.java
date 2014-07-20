import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;

@Script.Manifest(name="FiresWineDrinker", description="Takes wine jugs from bank and drinks them")
public class WineDrinker extends PollingScript<ClientContext> {
	private List<Task> Tasklist= new ArrayList<Task>();
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
}

 