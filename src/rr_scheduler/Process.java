package rr_scheduler;

public class Process{

	private int runtime;
	private int id;
	
	public Process(int rt, int ident){
		this.runtime = rt;
		this.id = ident;
	}
	
	public void decrement(){
		runtime--;
	}
	
	public int getTime(){
		return runtime;
	}
	
}
