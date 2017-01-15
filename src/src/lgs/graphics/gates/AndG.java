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
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lgs.gates.And;
import lgs.graphics.Graphics;
import lgs.graphics.PinG;
import lgs.model.Input;

/**
 *
 * @author Cristiano Colangelo
 */
public class AndG extends CircuitComponentG {

    public AndG(int x, int y) {
        super(new And());
        super.setOrigin(new Point(x, y));
        super.setSize(new Dimension(80, super.getComponent().getInputs().size() * 50));
    }

    @Override
    public void drawShape(GraphicsContext gc) {
        LinkedList<Graphics> children = super.getChildren();
        int x = super.getOrigin().x;
        int y = super.getOrigin().y;
        int width = super.getSize().width;
        int height = super.getSize().height;
        int inputCount = super.getComponent().getInputs().size();
        
        System.out.println(inputCount);
        gc.setFill(Color.BLACK);

        // Disegno del simbolo europeo
        gc.strokeRect(super.getOrigin().x, super.getOrigin().y, super.getSize().width, super.getSize().height);

        // Disegno del rettangolo
        for (int i = 1; i <= inputCount; i++) {
            children.add(new PinG(new Input(super.getComponent()), x, y + (height / inputCount) * i - (height / inputCount) / 2));
        }
        
        for (int i = 0; i < super.getComponent().getInputs().size(); i++) {
            
        }
        children.add(new PinG(new Input(super.getComponent()), x + width + PinG.WIDTH, y + (height / 2)));
        //super.getChildren
        // Disegno degli inputs e outputs
        for (int i = 0; i < children.size(); i++) {
            children.get(i).drawShape(gc);
        }

        //System.gc();
    }

}
