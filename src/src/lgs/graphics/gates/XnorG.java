/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.graphics.gates;

import lgs.graphics.CircuitComponentG;
import java.awt.Dimension;
import java.awt.Point;
import java.util.LinkedList;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import lgs.gates.Xnor;
import lgs.graphics.Graphics;
import lgs.graphics.InputG;
import lgs.graphics.OutputG;
import lgs.utils.GraphicElement;

/**
 *
 * @author Cristiano Colangelo
 */
public class XnorG extends CircuitComponentG {

    public XnorG(int x, int y) {
        super(new Xnor());

        super.setOrigin(new Point(x, y));
        super.setSize(new Dimension(80, super.getComponent().getInputs().size() * 50));

        // Metodi di convenienza
        LinkedList<Graphics> children = super.getChildren();
        int width = super.getSize().width;
        int height = super.getSize().height;
        int inputCount = super.getComponent().getInputs().size();

        // Istanza degli inputs
        int c = 0;
        for (int i = 1; i <= inputCount; i++) {
            children.add(new InputG(super.getComponent().getInputs().get(c), x, y + (height / inputCount) * i - (height / inputCount) / 2));
            c++;
        }

        // Istanza degll'output
        children.add(new OutputG(super.getComponent().getOutput(), x + width, y + (height / 2)));

    }

    @Override
    public void drawShape(GraphicsContext gc) {     
        // Disegno del rettangolo
        gc.setFill(Color.WHITE);
        gc.fillRect(super.getOrigin().x, super.getOrigin().y, super.getSize().width, super.getSize().height);
        gc.setFill(Color.BLACK);
        gc.strokeRect(super.getOrigin().x, super.getOrigin().y, super.getSize().width, super.getSize().height);
        // Disegno del simbolo nel rettangolo
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.setFont(new Font("Arial", 32));
        gc.fillText("=1", super.getOrigin().x + (super.getSize().width / 2), super.getOrigin().y + (super.getSize().height / 2), 100);
        
        drawChildren(gc);
        
        // Disegna il puntino del negato sull'output
        GraphicElement.drawNotDot(super.getOrigin(), super.getSize(), gc);
    }

}