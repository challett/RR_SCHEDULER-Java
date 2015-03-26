package rr_scheduler;

import java.util.Queue;

public class Generator implements Runnable{
	Queue queue;
	public Generator(Queue<Thread> q){
		this.queue = q;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	

}
