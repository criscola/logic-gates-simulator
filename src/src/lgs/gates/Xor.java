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
import lgs.model.Pin;

/**
 *
 * @author Dias
 */
public class Xor extends CircuitComponent{
    public Xor() {
        super(new LinkedList<>(), new LinkedList<>());
        getInputs().add(new Input(this));
        getInputs().add(new Input(this));
        getOutputs().add(new Output(this));
        setResults();
    }
    
    @Override
    public boolean getResult(int outputIndex){
        if(outputIndex == 0){
            return inputs.get(0).getData() ^ inputs.get(1).getData();
        }
        return false;
    }
    @Override
    public void setResults(){
        for(int i = 0; i < getOutputs().size(); i++)
            getOutputs().get(i).setData(getResult(i));
    }
    
}
