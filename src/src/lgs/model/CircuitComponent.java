package lgs.model;


import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dias
 */
public abstract class CircuitComponent {
    
    protected LinkedList<Input> inputs;
    protected Output output;

    protected CircuitComponent(LinkedList<Input> inputs, Output output) {
        this.inputs = inputs;
        this.output = output;
    }
    
    public LinkedList<Input> getInputs() {
        return inputs;
    }

    public void setInputs(LinkedList<Input> inputs) {
        this.inputs = inputs;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public Output getOutput() {
        return output;
    }
    
    public abstract boolean getResult();
    
    public abstract void setResults();
}
