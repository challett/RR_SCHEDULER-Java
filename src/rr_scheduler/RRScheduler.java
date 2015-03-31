package rr_scheduler;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Label;
import java.util.AbstractQueue;
import java.util.Queue;

import concurrency.display.ThreadPanel;

public class RRScheduler extends Applet {
	CPU cPU;
	ReadyQueue queue = new ReadyQueue();
	GrimReaper grimReaper;
	Dispatcher dispatcher;
	Generator generator;
	ThreadPanel processorPanel = new ThreadPanel("CPU" , Color.BLUE);
	ThreadPanel generatorPanel = new ThreadPanel("Generator" , Color.BLUE); 
	
	
    public void init() {
    	
    	// Applet Labels
    	Label GeneratorMsg = new Label();	
    	Label DispatcherMsg = new Label();
    	Label CpuMsg = new Label();
    	Label ReaperMsg1 = new Label();
    	Label ReaperMsg2 = new Label();
    	
    	// Initializes instances of grimreaper and dispatcher 
    	grimReaper = new GrimReaper(queue, ReaperMsg1, ReaperMsg2);
    	dispatcher = new Dispatcher(queue , DispatcherMsg);
    	
    	// Initializes up CPU
    	cPU = new CPU(queue , grimReaper, dispatcher, CpuMsg);
    	cPU.setDisp(processorPanel);

    	// Initializes generator
    	generator = new Generator(queue);
    	generator.setDisp(generatorPanel);
    	
    	
    	DispatcherMsg.setText("Dispatcher: Process # loaded into CPU.");
    	CpuMsg.setText("CPU: Process # executed for x second(s).");
    	ReaperMsg1.setText("Reaper: Process # finished executing.");
    	ReaperMsg2.setText("Reaper: Process # rescheduled into queue with x cycle(s) remaining.");
    	
    	// Adds above labels and panels to Applet
    	add(processorPanel);
    	add(generatorPanel);
    	add(GeneratorMsg);
    	add(DispatcherMsg);
    	add(CpuMsg);
    	add(ReaperMsg1);
    	add(ReaperMsg2);
        	
    }

    public void start() {
    		processorPanel.start(cPU);
    		generatorPanel.start(generator);
    }

    public void stop() {
    }
}
