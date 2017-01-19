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
package lgs.utils;

import java.awt.Dimension;
import java.awt.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author A4XX-COLCRI
 */
public final class GraphicElement {

    /**
     * The size in pixels of the not dot on logic gates
     */
    public static int NOTDOT_SIZE = 10;
    /**
     * The size in pixels of the clickable dot on logic gates
     */
    public static int DOT_SIZE = 20; 
    
    /**
     * Draws the not dot on a logic gate
     * @param origin
     * @param size
     * @param gc 
     */
    public static void drawNotDot(Point origin, Dimension size, GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        int tx = origin.x + size.width;
        int ty = origin.y + size.height / 2 - NOTDOT_SIZE / 2;
        gc.fillOval(tx, ty, NOTDOT_SIZE, NOTDOT_SIZE);
        gc.setFill(Color.BLACK);
        gc.strokeOval(tx, ty, NOTDOT_SIZE, NOTDOT_SIZE);
    }

}
