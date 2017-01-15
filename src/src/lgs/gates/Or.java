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
public class Or extends CircuitComponent{
    public Or() {
        super(new LinkedList<>(), new LinkedList<>());
        getInputs().add(new Input(this));
        getInputs().add(new Input(this));
        getOutputs().add(new Output(this));
    }
    
    @Override
    public boolean getResult(){
        return inputs.get(0).getData() || inputs.get(1).getData();
    }
    public void setResults(){
        getOutputs().get(0).setData(getResult());
    }
    
}
