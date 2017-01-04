package logicgatessimulator.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dias
 */
public class Pin {
    protected Wire attachedTo;
    protected boolean data;
    protected CircuitComponent circuitReference;
    
    public Pin(Wire attachedTo, boolean data, CircuitComponent circuitReference) {
        this.attachedTo = attachedTo;
        this.data = data;
        this.circuitReference = circuitReference;
    }

    public Wire getAttachedTo() {
        return attachedTo;
    }

    public void setAttachedTo(Wire attachedTo) {
        this.attachedTo = attachedTo;
    }

    public void setData(boolean data) {
        this.data = data;
    }
    public boolean getData(){
        return this.data;
    }
    
    
}
