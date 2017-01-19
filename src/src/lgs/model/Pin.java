package lgs.model;

import javafx.scene.shape.Circle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dias
 */
public interface Pin {
    //public Circle area;
    public boolean getData();
    public void setData(boolean data);
    public CircuitComponent getAttachedTo();
    public void setAttachedTo(CircuitComponent attachedTo);
}