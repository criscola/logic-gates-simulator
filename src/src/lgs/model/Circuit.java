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
        components = new LinkedList<>();
        inputs = new LinkedList<>();
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
     * Metodo per attaccare l'output ad un input, quando questo cambia, cambieranno anche gli input attaccati ad esso
     * @param output L'output da cui andare a prendere il dato questo dovra essere un Pin di tipo Output
     * @param input L'input a cui dare il dato, questo dovra essere un Pin di tipo Input
     */
    public void attachInput(Pin output, Pin input){
        ((Output)output).addObserver((Input)input);
        ((Output)output).changedPinInput();
    }
    /**
     * Metodo per staccare l'output da un input, i due non saranno piu collegati
     * @param output Il Pin da cui viene scollegato l'input
     * @param input Il Pin che viene scollegato
     */
    public void deattachInput(Pin output, Pin input){
        ((Output)output).deleteObserver((Input)input);
        ((Output)output).changedPinInput();
    }
}
