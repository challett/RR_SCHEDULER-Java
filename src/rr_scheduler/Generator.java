package rr_scheduler;

import java.awt.event.ActionEvent;
import java.util.Random;

import concurrency.display.ThreadPanel;

public class Generator implements Runnable{
	ReadyQueue queue;
	final int maxt = 5; 																					// For runtime of processes, random number between 1-5 ticks
	final int mint = 1;
	int id = 0;																								// Unique process ID
	int random_time;
	ThreadPanel display;
	Random rn = new Random();
	
	public Generator(ReadyQueue q){
		this.queue = q;
	}
	
	public void setDisp(ThreadPanel disp){
		display = disp;
	}
	
	@Override
	public void run() {
		try{
			while(true){
				ThreadPanel.rotate(10); 																	// Generator ThreadPanel turns 10 deg for each process generated
				Process nextThread;
				random_time = rn.nextInt(maxt-mint+1)+mint; 												// Process runtime, 1-5 ticks
				nextThread = new Process(random_time, id); 													// Next process ready to run 
				id++; 																						// Unique process id
				queue.add(nextThread);  																	// Adds next process to queue
				
				ActionEvent ae = new ActionEvent((Object)display.pause, ActionEvent.ACTION_PERFORMED, "");
				display.pause.dispatchEvent(ae);
			}
		}catch (InterruptedException e) {}	
	}
}
