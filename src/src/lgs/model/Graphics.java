package lgs.model;

import java.awt.Dimension;
import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dias
 */
public abstract class Graphics {

    protected Point origin;
    protected Dimension size;
    
    public Graphics(Point origin, Dimension size) {
        this.origin = origin;
        this.size = size;
    }

    public Dimension getSize() {
        return size;
    }

    public Point getOrigin() {
        return origin;
    }

    public void setDimension(Dimension size) {
        this.size = size;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }
    public abstract void drawShape();
}
