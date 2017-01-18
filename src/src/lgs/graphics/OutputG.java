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

import java.awt.Point;
import java.awt.Dimension;
import java.awt.Rectangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lgs.model.Output;

/**
 *
 * @author A4XX-COLCRI
 */
public class OutputG extends PinG {

    private Output component;

    public OutputG() {

    }

    public OutputG(Output component, int x, int y) {
        super(new Point(x + PinG.WIDTH, y), new Dimension(20, 1));
        super.not = false;
        super.dot = new Rectangle(x - 10 + PinG.WIDTH , y - 10, 20, 20);
        this.component = component;
    }

    public OutputG(Output component, int x, int y, boolean isNot) {
        super(new Point(x, y), new Dimension(20, 1));
        super.not = isNot;
        super.dot = new Rectangle(x - 10 - PinG.WIDTH, y - 10, 20, 20);
        this.component = component;
    }

    public Output getComponent() {
        return component;
    }

    @Override
    public void drawShape(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.strokeLine(super.getOrigin().x, super.getOrigin().y, super.getOrigin().x - super.getSize().width, super.getOrigin().y);
        if (getComponent().getData() == true) {
            gc.setFill(Color.RED);
        } else {
            gc.setFill(Color.BLACK);
        }
        if (super.selected) {
            gc.fillOval(super.dot.x - 5, super.dot.y - 5, super.dot.width + 10, super.dot.height + 10);
        }
        gc.fillOval(super.dot.x, dot.y, dot.width, dot.height);
    }
}
