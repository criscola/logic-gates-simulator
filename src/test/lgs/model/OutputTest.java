/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.model;

import org.junit.Test;
import static org.junit.Assert.*;

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
        Output instance = null;
        boolean expResult = false;
        boolean result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData method, of class Output.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        boolean data = false;
        Output instance = null;
        instance.setData(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changedPinInput method, of class Output.
     */
    @Test
    public void testChangedPinInput() {
        System.out.println("changedPinInput");
        Output instance = null;
        instance.changedPinInput();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAttachedTo method, of class Output.
     */
    @Test
    public void testGetAttachedTo() {
        System.out.println("getAttachedTo");
        Output instance = null;
        CircuitComponent expResult = null;
        CircuitComponent result = instance.getAttachedTo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAttachedTo method, of class Output.
     */
    @Test
    public void testSetAttachedTo() {
        System.out.println("setAttachedTo");
        CircuitComponent attachedTo = null;
        Output instance = null;
        instance.setAttachedTo(attachedTo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
