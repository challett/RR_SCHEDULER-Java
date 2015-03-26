package rr_scheduler;

import java.util.Queue;

public class Processor implements Runnable{
	Queue queue;
	public Processor(Queue<Thread> q){
		this.queue = q;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
