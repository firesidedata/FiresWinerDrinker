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
		for(int i=0;i<28;i++)
		{ 
			ctx.backpack.id(jugofwineid).poll().click(); 
			Item wine = ctx.backpack.select().id(jugofwineid).poll();
			if(wine.interact("Drink"))
			{
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
			}
			}
      
	}

}