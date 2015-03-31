package rr_scheduler;


import java.awt.Label;

import concurrency.display.ThreadPanel;

public class CPU implements Runnable{
	ReadyQueue queue;
	Process currentThread;
	ThreadPanel display;
	GrimReaper grimReaper;
	Dispatcher dispatcher;
	Label servicetext;
	
	public CPU(ReadyQueue q, GrimReaper g, Dispatcher d, Label servicing){
		this.queue = q;
		this.grimReaper = g;
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
				if (queue.peek() != null && queue.peek().getTime() > 0){  												// Executes if there is remaining runtime
					currentThread = dispatcher.load(); 																	// Loads next process
					ThreadPanel.rotate(360);
					servicetext.setText("Process #" + String.valueOf(currentThread.getId()) + " executed for 1 tick");
					grimReaper.setThread(currentThread); 																// Sets process to be run 
					if (currentThread.getTime() == 1) {
						grimReaper.reap(); 
					}else {
						grimReaper.reuse(); 																			// Reschedules process
					}					
				}
			}
		} catch (InterruptedException e) {}
	}
}
