/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.model;

import java.util.LinkedList;

/**
 *
 * @author Dias
 */
public class Circuit {
    private LinkedList<CircuitComponent> components;
    private LinkedList<Output> inputs;

    public Circuit() {
        this(new LinkedList<>(), new LinkedList<>());
    }

    public Circuit(LinkedList<CircuitComponent> components, LinkedList<Output> inputs) {
        this.components = components;
        this.inputs = inputs;
    }

    public void setInputs(LinkedList<Output> inputs) {
        this.inputs = inputs;
    }

    public LinkedList<CircuitComponent> getComponents() {
        return components;
    }

    public LinkedList<Output> getInputs() {
        return inputs;
    }

    public void setComponents(LinkedList<CircuitComponent> components) {
        this.components = components;
    }
    
    public void addCircuitComponent(CircuitComponent component){
        getComponents().add(component); 
    }
    public void addInput(Pin input){
        this.inputs.add((Output)input);
        
    }
    /**
     * Method to attach an output to an input, when the former changes, the latter changes too. It can be seen as a broadcast
     * @param output The pin which needs to notify its change
     * @param input The Pin which needs to observe the observable object
     */
    public void attachInput(Pin output, Pin input){
        ((Output)output).addObserver((Input)input);
        ((Output)output).changedPinInput();
    }
    /**
     * Method to deattach an output from an input, the latter will no longer change when the former changes
     * @param output The output that needs to be deattached
     * @param input The input that needs to be deattached
     */
    public void deattachInput(Pin output, Pin input){
        ((Output)output).deleteObserver((Input)input);
    }
}
