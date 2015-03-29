package rr_scheduler;

import java.awt.event.ActionEvent;
import java.util.Random;

import concurrency.display.ThreadPanel;

public class Generator implements Runnable{
	ReadyQueue queue;
	final int maxt = 5;
	final int mint = 1;
	int id = 0;
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
				ThreadPanel.rotate(10);
				Process nextThread;
				random_time = rn.nextInt(maxt-mint+1)+mint;
				nextThread = new Process(random_time, id);
				id++; //unique process id
				queue.add(nextThread);
				
				ActionEvent ae = new ActionEvent((Object)display.pause, ActionEvent.ACTION_PERFORMED, "");
				display.pause.dispatchEvent(ae);
			}
		}catch (InterruptedException e) {}
		
	}
	
	

}
