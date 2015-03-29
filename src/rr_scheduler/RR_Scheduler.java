package rr_scheduler;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractQueue;
import java.util.Queue;

import concurrency.display.ThreadPanel;

public class RR_Scheduler extends Applet {
	Processor processor;
	ReadyQueue queue = new ReadyQueue();
	Grimreaper grimReaper = new Grimreaper(queue);
	Generator generator;
	ThreadPanel processorPanel = new ThreadPanel("Processor" , Color.BLUE);
	ThreadPanel generatorPanel = new ThreadPanel("Generator" , Color.BLUE);
	
	
	
    public void init() {
        	processor = new Processor(queue , grimReaper);
        	processor.setDisp(processorPanel);
        	grimReaper = new Grimreaper(queue);
        	generator = new Generator(queue);
        	generator.setDisp(generatorPanel);
        	add(processorPanel);
        	add(generatorPanel);
    }

    public void start() {
    		processorPanel.start(processor);
    		generatorPanel.start(generator);
    }

    public void stop() {
    	
    }

}
