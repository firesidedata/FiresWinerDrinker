import org.powerbot.script.Condition;
import org.powerbot.script.Locatable;
import org.powerbot.script.rt6.ClientContext;


public class Banking extends Task<ClientContext> {
    Locatable closebank=ctx.bank.nearest();
    int jugofwineid=1993;
	public Banking(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.backpack.select().id(jugofwineid).count()==0;
	}

	@Override
	public void execute() {
	
      if(ctx.bank.inViewport())
      {
    	 ctx.bank.open();
    	 ctx.bank.depositInventory();
    	 ctx.bank.withdraw(jugofwineid,28);
    	 ctx.bank.close();
      }
      else
      {
          while(!ctx.bank.inViewport())
          {
    	  ctx.movement.step(closebank);
    	  Condition.sleep(5000);
    	  }
      }
      }
}
