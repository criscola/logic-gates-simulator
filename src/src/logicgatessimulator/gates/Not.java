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
public class Not extends CircuitComponent{
    public Not() {
        super(new LinkedList<Pin>(), new LinkedList<Pin>());
        getInputs().add(new Pin(null, false));
    }
    
    @Override
    public boolean getResult(){
        return !inputs.get(0).getData();
    }
}
