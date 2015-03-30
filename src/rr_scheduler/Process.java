package rr_scheduler;

public class Process{

	private int runtime;
	private int id;
	
	public Process(int rt, int ident){
		this.runtime = rt;
		this.id = ident;
	}
	/**
	 * Decrements runtime
	 */
	public synchronized void decrement(){
		runtime--;
	}
	/**
	 * Gets remaining runtime
	 * @return remaining runtime
	 */
	public synchronized int getTime(){
		return runtime;
	}
	/**
	 * Gets process ID
	 * @return Process ID
	 */
	public int getId(){
		return id;
	}
	
}
