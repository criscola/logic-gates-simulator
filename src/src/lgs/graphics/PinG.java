/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.graphics;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author Cristiano Colangelo
 */
public abstract class PinG extends Graphics {

    public static final int WIDTH = 20;

    protected boolean not;
    protected Rectangle dot; 
    
    private boolean wired;
    
    public PinG() {
        wired = false;
    }
    
    public PinG(Point origin, Dimension size) {
        super(origin, size);
        wired = false;
    }

    public boolean isNot() {
        return not;
    }
    
    public Rectangle getDot() {
        return dot;
    }
    
    public boolean isWired() {
        return wired;
    }
    
    public void setWired(boolean wired) {
        this.wired = wired;
    }
    
}
