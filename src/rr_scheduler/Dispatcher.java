package rr_scheduler;

import java.awt.Label;

public class Dispatcher{
	ReadyQueue queue;
	Label msg;
	
	public Dispatcher(ReadyQueue q , Label dispMsg){
		this.queue = q;
		this.msg = dispMsg;
	}
	
	// Remove process queue
	public Process load() {
		Process toLoad = queue.remove();
		msg.setText("Process " + String.valueOf(toLoad.getId()) + " loaded into CPU.");
		
		return toLoad;
	}
} 