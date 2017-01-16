/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.gates;

import java.util.LinkedList;
import lgs.model.CircuitComponent;
import lgs.model.Input;
import lgs.model.Output;

/**
 *
 * @author Dias
 */
public class Nand extends CircuitComponent{

    public Nand() {
        super(new LinkedList<>(), new Output());
        /*
        getInputs().add(new Input(this));
        getInputs().add(new Input(this));
        getOutputs().add(new Output(this));
        */
    }
    public boolean getResult(){
        return !(getInputs().get(0).getData() && getInputs().get(0).getData());
    }
    public void setResults(){
        output.setData(getResult());
    }
}
