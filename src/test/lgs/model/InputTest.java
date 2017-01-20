/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.model;

import java.util.Observable;
import org.junit.Test;
import static org.junit.Assert.*;
import lgs.gates.And;
/**
 *
 * @author Dias
 */
public class InputTest {
    
    public InputTest() {
    }

    /**
     * Test of update method, of class Input.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Output o = new Output(null);
        Input instance = new Input(null);
        o.addObserver(instance);
        assertEquals(o.getData(), instance.getData());
        o.setData(true);
        assertEquals(o.getData(), instance.getData());
        o.setData(false);
        assertEquals(o.getData(), instance.getData());
    }

    /**
     * Test of setData method, of class Input.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        Input instance = new Input(null);
        assertEquals(false, instance.getData());
        instance.setData(true);
        assertEquals(true, instance.getData());
        instance.setData(false);
        assertEquals(false, instance.getData());
    }

    /**
     * Test of getData method, of class Input.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Input instance = new Input(null);
        assertEquals(false, instance.getData());
        instance.setData(true);
        assertEquals(true, instance.getData());
    }

    /**
     * Test of getAttachedTo method, of class Input.
     */
    @Test
    public void testGetAttachedTo() {
        System.out.println("getAttachedTo");
        Input instance = new Input(null);
        CircuitComponent expResult = new And();
        CircuitComponent result = instance.getAttachedTo();
        assertEquals(null, result);
        instance.setAttachedTo(expResult);
        result = instance.getAttachedTo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAttachedTo method, of class Input.
     */
    @Test
    public void testSetAttachedTo() {
        System.out.println("setAttachedTo");
        Input instance = new Input(null);
        CircuitComponent expResult = new And();
        CircuitComponent result = instance.getAttachedTo();
        assertEquals(null, result);
        instance.setAttachedTo(expResult);
        result = instance.getAttachedTo();
        assertEquals(expResult, result);
    }
    
}
