/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.graphics;

import java.awt.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Cristiano Colangelo
 */
public class WireG {
    
    Point p1;
    Point p2;
    InputG input;
    OutputG output;
    
    public WireG() {
        
    }
    
    public WireG(Point p1, Point p2, InputG input, OutputG output) {
        this.p1 = p1;
        this.p2 = p2;
        this.input = input;
        this.output = output;
    }
    
    public WireG(int x1, int y1, int x2, int y2, InputG input, OutputG output) {
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
        this.input = input;
        this.output = output;
    }
    
    public void drawShape(GraphicsContext gc) {
        if (output.getComponent().getData()) {
                gc.setStroke(Color.RED);
        } else {
            gc.setStroke(Color.BLACK);
        }
        gc.strokeLine(p1.x, p1.y, p2.x, p2.y);
        System.out.println(output.getComponent().getData());
        gc.setStroke(Color.BLACK);
    }
}
