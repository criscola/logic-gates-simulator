/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.model;

import java.awt.Dimension;
import java.awt.Point;
/**
 *
 * @author Cristiano Colangelo
 */
public abstract class Gate extends Graphics {
    
    CircuitComponent gate;
    
    public Gate(CircuitComponent gate) {
        super(new Point(0, 0), new Dimension(0, 0));
        this.gate = gate;
        
    }
}
