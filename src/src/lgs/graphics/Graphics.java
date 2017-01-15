package lgs.graphics;

import java.awt.Dimension;
import java.awt.Point;
import java.util.LinkedList;
import javafx.scene.canvas.GraphicsContext;
import lgs.model.Pin;

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

    private Point origin;
    private Dimension size;
    private LinkedList<Graphics> children;
    
    public Graphics(Point origin, Dimension size) {
        this.origin = origin;
        this.size = size;
        children = new LinkedList<>();
    }

    public Dimension getSize() {
        return size;
    }

    public Point getOrigin() {
        return origin;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }
    
    public LinkedList<Graphics> getChildren() {
        return children;
    }
    
    public abstract void drawShape(GraphicsContext gc);
}
