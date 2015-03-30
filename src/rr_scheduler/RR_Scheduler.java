package rr_scheduler;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Label;
import java.util.AbstractQueue;
import java.util.Queue;

import concurrency.display.ThreadPanel;

public class RR_Scheduler extends Applet {
    CPU cPU;
    ReadyQueue queue = new ReadyQueue();
    Grimreaper grimReaper;
    Dispatcher dispatcher;
    Generator generator;
    ThreadPanel processorPanel = new ThreadPanel("Processor" , Color.BLUE);
    ThreadPanel generatorPanel = new ThreadPanel("Generator" , Color.BLUE); 
    
    
    public void init() {
        
        //labels
        Label GeneratorMsg = new Label();   
        Label DispatcherMsg = new Label();
        Label CpuMsg = new Label();
        Label ReaperMsg1 = new Label();
        Label ReaperMsg2 = new Label();
        
        //Sets up instances of grimreaper and dispatcher 
        grimReaper = new Grimreaper(queue, ReaperMsg1, ReaperMsg2);
        dispatcher = new Dispatcher(queue , DispatcherMsg);
        
        //Sets up CPU
        cPU = new CPU(queue , grimReaper, dispatcher, CpuMsg);
        cPU.setDisp(processorPanel);

        //Sets up generator
        generator = new Generator(queue);
        generator.setDisp(generatorPanel);
        
        
        DispatcherMsg.setText("Dispatcher: Process # loaded into CPU.");
        CpuMsg.setText("CPU: Process # executed for x second(s).");
        ReaperMsg1.setText("Reaper: Process # finished executing.");
        ReaperMsg2.setText("Reaper: Process # recycled into ready queue with x second(s) reamining.");
        
        
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
