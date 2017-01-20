package lgs.model;


import java.util.LinkedList;
import lgs.gates.*;
import lgs.model.CircuitComponent;
import lgs.model.Pin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dias
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Output output1 = new Output(null);
        Output output2 = new Output(null);
        
        /*CircuitComponent and1 = new And();
        CircuitComponent and2 = new And();
        CircuitComponent xor1 = new Xor();
        output1.addObserver((Input)and1.getInputs().get(0));
        output1.addObserver((Input)and1.getInputs().get(1));
        output2.addObserver((Input)and2.getInputs().get(0));
        output2.addObserver((Input)and2.getInputs().get(1));
        ((Output)and1.getOutputs().get(0)).addObserver((Input)(xor1.getInputs()).get(0));
        ((Output)and2.getOutputs().get(0)).addObserver((Input)xor1.getInputs().get(1));
        output1.setData(true);
        output2.setData(false);
        System.out.println(xor1.getOutputs().get(0).getData());
        */
        /*
        Output r = new Output(null);
        Output s = new Output(null);
        CircuitComponent a = new Nor();
        CircuitComponent b = new Nor();
        r.addObserver((Input)a.getInputs().get(0));
        s.addObserver((Input)b.getInputs().get(1));
        ((Output)b.getOutputs().get(0)).addObserver((Input)a.getInputs().get(0));
        ((Output)a.getOutputs().get(0)).addObserver((Input)b.getInputs().get(0));
        r.setData(true);
        s.setData(false);
        System.out.println(a.getOutputs().get(0).getData());
        System.out.println(b.getOutputs().get(0).getData());*/
        
        /*Output a = new Output(null);
        Output b = new Output(null);
        Output[] outputs = {new Output(null), new Output(null), new Output(null), new Output(null)};
        outputs[0].setData(true);
        outputs[1].setData(true);
        CircuitComponent nor1 = new And();
        CircuitComponent nor2 = new Nor();
        CircuitComponent xnor1 = new Or();
        Circuit circuit = new Circuit();
        for(int i = 0; i < outputs.length; i++)
            circuit.addInput(outputs[i]);
        circuit.addCircuitComponent(nor1);
        circuit.addCircuitComponent(nor2);
        circuit.addCircuitComponent(xnor1);
        circuit.attachInput(outputs[0], (Input)nor1.getInputs().get(0));
        circuit.attachInput(outputs[1], (Input)nor1.getInputs().get(1));
        circuit.attachInput(outputs[2], (Input)nor2.getInputs().get(0));
        circuit.attachInput(outputs[3], (Input)nor2.getInputs().get(1));
        circuit.attachInput(nor1.getOutputs().get(0),xnor1.getInputs().get(0));
        circuit.attachInput(nor2.getOutputs().get(0),xnor1.getInputs().get(1));
        
        System.out.println(xnor1.getOutputs().get(0).getData());
        outputs[0].setData(true);
        outputs[1].setData(true);
        System.out.println(xnor1.getOutputs().get(0).getData());
        CircuitComponent not = new Not();
        System.out.println(not.getOutputs().get(0).getData());*/
        
        
        CircuitComponent and1 = new And();
        CircuitComponent and2 = new And();
        CircuitComponent xor1 = new Xor();
        Circuit circuit = new Circuit();
        circuit.addCircuitComponent(and1);
        circuit.addCircuitComponent(and2);
        circuit.addCircuitComponent(xor1);
        circuit.attachInput(and1.getOutputs().get(0), xor1.getInputs().get(0));
        circuit.attachInput(and2.getOutputs().get(0), xor1.getInputs().get(1));
        and1.getInputs().get(0).setData(false);
        and1.getInputs().get(1).setData(false);
        System.out.println(xor1.getOutputs().get(0).getData());
        
    }
    
    
}
