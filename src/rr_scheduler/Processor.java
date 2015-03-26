package rr_scheduler;


import concurrency.display.ThreadPanel;

public class Processor implements Runnable{
	ReadyQueue queue;
	Process currentThread;
	ThreadPanel display;
	Grimreaper grimreaper;
	
	public Processor(ReadyQueue q, Grimreaper g){
		this.queue = q;
		this.grimreaper = g; 
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
				}else if(queue.peek() != null && queue.peek().getTime() == 0){
					grimreaper.reap();
				}
			}
		} catch (InterruptedException e) {}
	}
	
}
