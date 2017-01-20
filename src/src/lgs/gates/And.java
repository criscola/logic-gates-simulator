/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.gates;

import java.util.LinkedList;
import lgs.model.*;

/**
 *
 * @author Diaspublic class And extends CircuitComponent {

 */
public class And extends CircuitComponent {

    public static final int DEFAULT_INPUT_COUNT = 2;   
    public static final boolean INPUT_MODIFIABLE = true;
    
    public And() {
        super(new LinkedList<>(), new Output());
        super.getOutput().setAttachedTo(this);
        for (int i = 0; i < DEFAULT_INPUT_COUNT; i++) {
            super.getInputs().add(new Input(this));
        }
    }

    @Override
    public boolean getResult() {
        boolean a = inputs.get(0).getData() && inputs.get(1).getData();
        return inputs.get(0).getData() && inputs.get(1).getData();
    }

    @Override
    public void setResults() {
        output.setData(getResult());
    }

}
