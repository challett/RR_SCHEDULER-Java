package rr_scheduler;

import java.util.AbstractQueue;
import java.util.Queue;

public class Grimreaper implements Runnable{
	ReadyQueue queue;
	Process currentThread;
	
	public Grimreaper(ReadyQueue q){
		this.queue = q;
	}
	
	@Override
	public void run() {
		while(true){
			currentThread = queue.peekLast(); //looks at tail
			if (currentThread.getTime() == 0 && currentThread != null){
				queue.remove(currentThread);  //remove tail
			}
		}
	}

}
