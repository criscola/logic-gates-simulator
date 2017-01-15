/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.graphics;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lgs.model.Pin;

/**
 *
 * @author Cristiano Colangelo
 */
public class PinG extends Graphics {

    public static final int WIDTH = 20;
    
    private boolean isNot;
    private Pin component;
    private Rectangle clickableArea;
    
    public PinG() {
        
    }
    
    public PinG(Pin component, int x, int y) {
        super(new Point(x, y), new Dimension(20, 1));
        this.component = component;
        isNot = false;
        clickableArea = new Rectangle(x - 10, y - 10, 20, 20);
    }

    public PinG(Pin component, int x, int y, boolean isNot) {
        super(new Point(x, y), new Dimension(20, 1));
        this.component = component;
        this.isNot = isNot;
        clickableArea = new Rectangle(x - 10, y - 10, 20, 20);
    }

    public Pin getComponent() {
        return component;
    }
    
    public Rectangle getClickableArea() {
        return clickableArea;
    }
    
    @Override
    public void drawShape(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.strokeLine(super.getOrigin().x, super.getOrigin().y, super.getOrigin().x - super.getSize().width, super.getOrigin().y);
    }

}
