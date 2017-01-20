/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.model;
import java.util.Observer;
import java.util.Observable;
/**
 *
 * @author Dias
 */
public class Input implements Observer, Pin{
    private boolean data = false;
    private CircuitComponent attachedTo;
    
    @Override
    public void update(Observable o, Object arg) {
        Output output = (Output) o;
        setData(output.getData());
    }
    
    public Input(CircuitComponent attachedTo) {
        this.attachedTo = attachedTo;
    }

    public void setData(boolean data) {
        if(data != getData()){
            this.data = data;
            if(this.attachedTo != null) {
                attachedTo.setResults();
            }
        }
    }
    
    public boolean getData(){
        return data;
    }

    @Override
    public CircuitComponent getAttachedTo() {
        return this.attachedTo;
    }

    @Override
    public void setAttachedTo(CircuitComponent attachedTo) {
        this.attachedTo = attachedTo;
    }
    
}
