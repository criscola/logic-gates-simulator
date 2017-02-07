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

import java.awt.Rectangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author A4XX-COLCRI
 */
public class Button extends Graphics {

    private Image img;
    private Rectangle buttonArea;

    public Rectangle getButtonArea() {
        return buttonArea;
    }

    public Button(Image img, int x, int y) {
        this.img = img;
        buttonArea = new Rectangle(x, y, (int) img.getWidth(), (int) img.getHeight());
    }

    @Override
    public void drawShape(GraphicsContext gc) {
        gc.drawImage(img, buttonArea.x, buttonArea.y);
    }
}
