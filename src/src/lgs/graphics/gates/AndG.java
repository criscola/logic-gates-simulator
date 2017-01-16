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
import lgs.graphics.InputG;
import lgs.graphics.OutputG;
import lgs.model.Input;
import lgs.model.Output;

/**
 *
 * @author Cristiano Colangelo
 */
public class AndG extends CircuitComponentG {

    int id = 0;

    public AndG(int x, int y) {
        super(new And());

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
        children.add(new OutputG(new Output(super.getComponent()), x + width, y + (height / 2)));
        //children.add(new PinG(new Input(super.getComponent(), x + width + PinG.WIDTH, y + (height / 2))));

    }

    @Override
    public void drawShape(GraphicsContext gc) {
        gc.setFill(Color.BLACK);

        // Disegno del simbolo europeo
        gc.strokeRect(super.getOrigin().x, super.getOrigin().y, super.getSize().width, super.getSize().height);

        drawChildren(gc);
    }

}
