/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.model;

import org.junit.Test;
import static org.junit.Assert.*;
import lgs.gates.And;
/**
 *
 * @author Dias
 */
public class OutputTest {
    
    public OutputTest() {
    }

    /**
     * Test of getData method, of class Output.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Output instance = new Output(null);
        assertEquals(false, instance.getData());
        instance.setData(true);
        assertEquals(true, instance.getData());
    }

    /**
     * Test of setData method, of class Output.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        Output instance = new Output(null);
        assertEquals(false, instance.getData());
        instance.setData(true);
        assertEquals(true, instance.getData());
        instance.setData(false);
        assertEquals(false, instance.getData());
    }

    /**
     * Test of changedPinInput method, of class Output.
     */
    @Test
    public void testChangedPinInput() {
        System.out.println("changedPinInput");
        Output instance = new Output(null);
        Input o = new Input(null);
        instance.addObserver(o);
        assertEquals(instance.getData(), o.getData());
        instance.setData(true);
        assertEquals(o.getData(), o.getData());
        instance.setData(false);
        assertEquals(instance.getData(), o.getData());
    }

    /**
     * Test of getAttachedTo method, of class Output.
     */
    @Test
    public void testGetAttachedTo() {
        System.out.println("getAttachedTo");
        Output instance = new Output(null);
        CircuitComponent expResult = new And();
        CircuitComponent result = instance.getAttachedTo();
        assertEquals(null, result);
        instance.setAttachedTo(expResult);
        result = instance.getAttachedTo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAttachedTo method, of class Output.
     */
    @Test
    public void testSetAttachedTo() {
        System.out.println("setAttachedTo");
        Output instance = new Output(null);
        CircuitComponent expResult = new And();
        CircuitComponent result = instance.getAttachedTo();
        assertEquals(null, result);
        instance.setAttachedTo(expResult);
        result = instance.getAttachedTo();
        assertEquals(expResult, result);
    }
    
}
