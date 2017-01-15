/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.graphics.gates;

import lgs.graphics.CircuitComponentG;
import java.awt.Dimension;
import java.awt.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lgs.gates.And;
import lgs.graphics.PinG;
import lgs.model.Input;
import lgs.model.Pin;

/**
 *
 * @author Cristiano Colangelo
 */
public class AndG extends CircuitComponentG {

    public int width = 80;
    public int height = 100;

    public AndG(int x, int y) {
        super(new And());
        super.setOrigin(new Point(x, y));
        super.setSize(new Dimension(80, super.getComponent().getInputs().size() * 50));
    }

    @Override
    public void drawShape(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        // Disegno del simbolo europeo
        gc.strokeRect(super.getOrigin().x, super.getOrigin().y, super.getSize().width, super.getSize().height);

        for (int i = 0; i < super.getComponent().getInputs().size() * 2; i++) {
            if (i % 2 == 1) {
                super.getChildren().add(new PinG(new Input(super.getComponent()), super.getOrigin().x, height / (super.getComponent().getInputs().size() * 4) + super.getOrigin().y + height / (i + 1)));
            }
        }
        
        for (int i = 0; i < super.getChildren().size(); i++) {
            super.getChildren().get(i).drawShape(gc);
        }
    }
    
}
