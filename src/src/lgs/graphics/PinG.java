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

    public static final int WIDTH = 30;

    protected boolean selected;
    protected Rectangle dot;
    
    private boolean wired;
    
    public PinG() {
        wired = false;
        selected = false;
    }
    
    public PinG(Point origin, Dimension size) {
        super(origin, size);
        wired = false;
        selected = false;
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
    
    public boolean isSelected() {
        return selected;
    }
    
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
}
