package logicgatessimulator.model;


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
    protected LinkedList<Pin> inputs;
    protected LinkedList<Pin> outputs;

    protected CircuitComponent(LinkedList<Pin> inputs, LinkedList<Pin> outputs) {
        this.inputs = inputs;
        this.outputs = outputs;
    }
    
    public LinkedList<Pin> getInputs() {
        return inputs;
    }

    public void setInputs(LinkedList<Pin> inputs) {
        this.inputs = inputs;
    }

    public void setOutputs(LinkedList<Pin> outputs) {
        this.outputs = outputs;
    }

    public LinkedList<Pin> getOutputs() {
        return outputs;
    }
    public boolean getResult(){
        return false;
    } 
}
