/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicgatessimulator.gates;

import java.util.LinkedList;
import logicgatessimulator.model.CircuitComponent;
import logicgatessimulator.model.Pin;

/**
 *
 * @author Dias
 */
public class Nor extends CircuitComponent{
    public Nor() {
        super(new LinkedList<>(), new LinkedList<>());
        getInputs().add(new Pin(null, false));
        getInputs().add(new Pin(null, false));
    }
    
    
    @Override
    public boolean getResult(){
        return !(inputs.get(0).getData() || inputs.get(1).getData());
    }
}
