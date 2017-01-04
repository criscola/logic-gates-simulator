/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicgatessimulator.gates;

import java.util.LinkedList;
import logicgatessimulator.model.Pin;
import logicgatessimulator.model.CircuitComponent;

/**
 *
 * @author Dias
 */
public class Nand extends CircuitComponent{

    public Nand() {
        super(new LinkedList<>(), new LinkedList<>());
        getInputs().add(new Pin(null, false));
        getInputs().add(new Pin(null, false));
    }
    public boolean getResult(){
        return !(getInputs().get(0).getData() && getInputs().get(0).getData());
    }
}
