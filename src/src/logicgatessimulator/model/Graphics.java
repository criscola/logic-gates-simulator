package logicgatessimulator.model;


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
    protected Point end;

    public Graphics(Point origin, Point end) {
        this.origin = origin;
        this.end = end;
    }

    public Point getEnd() {
        return end;
    }

    public Point getOrigin() {
        return origin;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }
    
}
