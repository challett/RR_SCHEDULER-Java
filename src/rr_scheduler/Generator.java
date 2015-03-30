package rr_scheduler;

import java.awt.event.ActionEvent;
import java.util.Random;

import concurrency.display.ThreadPanel;
/**
 * 
 * @author Nick
 *
 */

public class Generator implements Runnable{
	ReadyQueue queue;
	final int maxt = 5; //for runtime of processes, random number between 1-5 ticks
	final int mint = 1;
	int id = 0;			//unique process ID
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
				ThreadPanel.rotate(10); //generator ThreadPanel turns 10 deg for each process scheduled in the queue
				Process nextThread;
				random_time = rn.nextInt(maxt-mint+1)+mint; //process runtime, 1-5 ticks
				nextThread = new Process(random_time, id); //next process ready to run 
				id++; //unique process id
				queue.add(nextThread);  //adds next process to queue
				
				ActionEvent ae = new ActionEvent((Object)display.pause, ActionEvent.ACTION_PERFORMED, "");
				display.pause.dispatchEvent(ae);
			}
		}catch (InterruptedException e) {}
		
	}
	
	

}
