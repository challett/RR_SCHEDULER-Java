package rr_scheduler;

public class Process{

	private int runtime;
	private int id;
	
	public Process(int rt, int ident){
		this.runtime = rt;
		this.id = ident;
	}
	
	public synchronized void decrement(){
		runtime--;
	}
	
	// Get the process execution total time
	public synchronized int getTime(){
		return runtime;
	}
	
	// Get the unique process id
	public int getId(){
		return id;
	}
	
}
