/*
 * The MIT License
 *
 * Copyright 2017 A4XX-COLCRI.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package lgs.graphics;

import java.awt.Dimension;
import java.awt.Point;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 *
 * @author A4XX-COLCRI
 */
public class Selector extends Graphics {

    private CircuitComponentG component;

    public Selector(int x, int y, int width, int height, CircuitComponentG component) {
        super.setOrigin(new Point(x, y));
        super.setSize(new Dimension(width, height));
        //super.getChildren().add(new Button(new Image(getClass().getResourceAsStream("utils/Plus-48.png")), x + width, y));
        //super.getChildren().add(new Button(new Image(getClass().getResourceAsStream("utils/Minus-48.png")), x + width, y + 48));
        this.component = component;
    }

    public CircuitComponentG getComponent() {
        return component;
    }   
    
    @Override
    public void drawShape(GraphicsContext gc) {
        gc.setStroke(Color.BLUE);
        double t = gc.getLineWidth();
        gc.setLineWidth(2);
        gc.strokeRoundRect(super.getOrigin().x, super.getOrigin().y, super.getSize().width, super.getSize().height, 8, 2);
        gc.setLineWidth(t);
        gc.setStroke(Color.BLACK);
        //drawChildren(gc);
    }
}
