package rr_scheduler;

import java.util.AbstractQueue;
import java.util.Queue;

import concurrency.display.ThreadPanel;

public class Processor implements Runnable{
	ReadyQueue queue;
	Process currentThread;
	ThreadPanel display;
	
	public Processor(ReadyQueue q){
		this.queue = q;
	}
	
	public void setDisp(ThreadPanel disp){
		display = disp;
	}

	@Override
	public void run() {
		try {
			while(true){
				if (queue.peek() != null && queue.peek().getTime() > 0){
					currentThread = queue.remove();
					ThreadPanel.rotate(360);
					currentThread.decrement();
					queue.add(currentThread);
				}
			}
		} catch (InterruptedException e) {}
		// TODO Auto-generated method stub
	}
	
}
