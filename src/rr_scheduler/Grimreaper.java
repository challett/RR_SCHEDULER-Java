package rr_scheduler;

public class Grimreaper{
	ReadyQueue queue;
	
	public Grimreaper(ReadyQueue q){
		this.queue = q;
	}
	
	public void reap() {
			queue.remove();
	}

}
