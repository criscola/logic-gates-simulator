/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.model;
import java.util.Observable;
/**
 *
 * @author Dias
 */
public class Output extends Observable implements Pin {
    
    private boolean data = false;
    private CircuitComponent attachedTo;
    private Input inputComponent;
    
    public Output() {
        
    }
    
    public Output(CircuitComponent attachedTo) {
        this.attachedTo = attachedTo;
        inputComponent = null;
    }
    
    public void changedPinInput() {
        setChanged();
        notifyObservers(this);
    }

    public Input getInputComponent() {
        return inputComponent;
    }

    public void setInputComponent(Input inputComponent) {
        this.inputComponent = inputComponent;
    }
    
    @Override
    public boolean getData() {
        return data;
    }
    
    @Override
    public void setData(boolean data) {
        if (getData() != data){
            this.data = data;
            setChanged();
            notifyObservers(this);
        }
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
