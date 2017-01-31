/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.gates;
import lgs.model.CircuitComponent;
import java.util.LinkedList;
import lgs.model.Input;
import lgs.model.Output;
import lgs.model.Pin;
/**
 *
 * @author Dias
 */
public class Clock extends CircuitComponent implements Runnable {
    /**
     * Flag per la thread, creata = true, non creata = false
     */
    private boolean flag = false;
    private Thread thread = null;
    private int sleep = 500;
    public Clock() {
        super(new LinkedList<Pin>(), new LinkedList<Pin>());
        getInputs().add(new Input(this));
        getOutputs().add(new Output(this));
    }

    @Override
    public void run() {
        while(getInputs().get(0).getData() != false){
            try{
                setResults();
                Thread.sleep(sleep);
            }
            catch(InterruptedException ex){}
            
        }
    }

    @Override
    public boolean getResult(int outputIndex) {
        if(outputIndex == 0 && getInputs().get(0).getData()){
            if(thread == null)
                return false;
            else
                return !getOutputs().get(0).getData();
        }
        return false;
    }

    @Override
    public void setResults() {
        if(getInputs().get(0).getData()){
            if(thread == null){
                this.thread = new Thread(this);
                this.thread.start();
            }
            for(int i = 0 ; i < getOutputs().size(); i++){
                getOutputs().get(i).setData(getResult(i));
            }

        }
        else
            thread = null;
    }
    
}
