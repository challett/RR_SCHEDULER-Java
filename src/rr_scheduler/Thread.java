package rr_scheduler;

public class Thread{

	private int runtime;
	
	public Thread(int rt){
		this.runtime = rt;
	}
	
	public void run(){
		runtime--;
	}
	
	public int getTime(){
		return runtime;
	}
	
}
