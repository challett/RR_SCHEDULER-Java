package rr_scheduler;

import java.awt.Label;

public class Grimreaper{
	Process currentThread; 
	Label dispLabel1;
	Label dispLabel2;
	ReadyQueue q;
	
	public Grimreaper(ReadyQueue queue , Label trash, Label reuse){
		this.dispLabel1 = trash;
		this.dispLabel2 = reuse;
		this.q = queue;
	}
	/**
	 * Sets the current thread
	 * @param Process that is being reaped 
	 */
	public void setThread(Process p){
		currentThread = p;
	}
	/**
	 * Doesn't add the process back to the queue when it's done 
	 */
	public void reap() {
			dispLabel1.setText("Process:" + String.valueOf(currentThread.getId()) + " finished executing.");
	}
	/**
	 * Recycled process back in the queue
	 */
	public void reuse() {
		currentThread.decrement();
		dispLabel2.setText("Process " + String.valueOf(currentThread.getId()) + " recycled into the queue with " + String.valueOf(currentThread.getTime()) + " tick remaining.");
		q.add(currentThread);
	}

}
