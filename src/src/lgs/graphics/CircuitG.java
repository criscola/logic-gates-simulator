/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.graphics;

import java.util.LinkedList;
import lgs.model.Circuit;

/**
 *
 * @author Cristiano Colangelo
 */
public class CircuitG {
    
    public LinkedList<CircuitComponentG> components;    
    private final Circuit circuit;
   
    public CircuitG() {
        circuit = new Circuit();
        components = new LinkedList<>();
    }

    public Circuit getCircuit() {
        return circuit;
    }
}