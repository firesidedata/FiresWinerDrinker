import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;



public class Drink extends Task<ClientContext> {
     int jugofwineid=1993;
	public Drink(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.backpack.select().id(jugofwineid).count()>0 && ctx.players.local().animation()==-1;
	}

	@Override
	public void execute() {
			
			for(Item item : ctx.backpack.select().id(jugofwineid)) 
			{
			    if(item.interact("Drink")) 
			    {
			    	WineDrinker.jugsdrunk++;
			    	WineDrinker.profit+=251;
			        Condition.sleep(1500);
			    }
			}
			}
      
	}

