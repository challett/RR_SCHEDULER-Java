package rr_scheduler;

import java.awt.Label;

public class GrimReaper{
	Process currentThread; 
	Label dispLabel1;
	Label dispLabel2;
	ReadyQueue q;
	
	public GrimReaper(ReadyQueue queue , Label trash, Label reuse){
		this.dispLabel1 = trash;
		this.dispLabel2 = reuse;
		this.q = queue;
	}
	
	public void setThread(Process p){
		currentThread = p;
	}
	
	// Display process completion label
	public void reap() {
			dispLabel1.setText("Process:" + String.valueOf(currentThread.getId()) + " finished executing.");
	}
	
	// Display process reschedule label
	public void reuse() {
		currentThread.decrement();
		dispLabel2.setText("Process " + String.valueOf(currentThread.getId()) + " recycled into the queue with " + String.valueOf(currentThread.getTime()) + " tick remaining.");
		q.add(currentThread);
	}

}
