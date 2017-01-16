/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.graphics;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import lgs.model.Output;
import lgs.model.Pin;

/**
 *
 * @author Cristiano Colangelo
 */
public abstract class PinG extends Graphics {

    public static final int WIDTH = 20;

    protected boolean isNot;
    protected Rectangle dot;

    public PinG() {
        
    }
    
    public PinG(Point origin, Dimension size) {
        super(origin, size);
    }

    public boolean getIsNot() {
        return isNot;
    }
    
    public Rectangle getDot() {
        return dot;
    }
}
