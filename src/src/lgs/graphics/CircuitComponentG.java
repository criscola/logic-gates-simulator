/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.graphics;

import java.awt.Dimension;
import java.awt.Point;
import lgs.model.CircuitComponent;
/**
 *
 * @author Cristiano Colangelo
 */
public abstract class CircuitComponentG extends Graphics {
    
    private final CircuitComponent component;
    private final boolean isInputModifiable;
    
    public CircuitComponent getComponent() {
        return component;
    }
    
    public CircuitComponentG(CircuitComponent component, boolean isInputModifiable) {
        super(new Point(0, 0), new Dimension(0, 0));
        this.component = component;
        this.isInputModifiable = isInputModifiable;
    }
    
    public boolean isInputModifiable() {
        return isInputModifiable;
    }
}
