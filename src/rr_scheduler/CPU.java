package rr_scheduler;


import java.awt.Label;

import concurrency.display.ThreadPanel;

public class CPU implements Runnable{
	ReadyQueue queue;
	Process currentThread;
	ThreadPanel display;
	Grimreaper grimreaper;
	Dispatcher dispatcher;
	Label servicetext;
	
	public CPU(ReadyQueue q, Grimreaper g, Dispatcher d, Label servicing){
		this.queue = q;
		this.grimreaper = g;
		this.dispatcher = d;
		this.servicetext = servicing;
	}
	
	public void setDisp(ThreadPanel disp){
		display = disp;
	}
	
	@Override
	public void run() {
		try {
			while(true){
				if (queue.peek() != null && queue.peek().getTime() > 0){ //executes if there is still runtime left
					currentThread = dispatcher.load(); //loads next process
					ThreadPanel.rotate(360);
					servicetext.setText("Process #" + String.valueOf(currentThread.getId()) + " executed for 1 tick");
					grimreaper.setThread(currentThread); //sets process to be run 
					if (currentThread.getTime() == 1) {
						grimreaper.reap(); 
					}else {
						grimreaper.reuse(); //recycles process
					}					
				}
			}
		} catch (InterruptedException e) {}
	}
	
}
