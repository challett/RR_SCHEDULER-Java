package rr_scheduler;

import java.util.Queue;

public class Grimreaper implements Runnable{
	Queue queue;
	
	public Grimreaper(Queue<Thread> q){
		this.queue = q;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
