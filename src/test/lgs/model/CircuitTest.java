/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.model;

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dias
 */
public class CircuitTest {
    
    public CircuitTest() {
    }

    /**
     * Test of setInputs method, of class Circuit.
     */
    @Test
    public void testSetInputs() {
        System.out.println("setInputs");
        LinkedList<Output> inputs = null;
        Circuit instance = new Circuit();
        instance.setInputs(inputs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComponents method, of class Circuit.
     */
    @Test
    public void testGetComponents() {
        System.out.println("getComponents");
        Circuit instance = new Circuit();
        LinkedList<CircuitComponent> expResult = null;
        LinkedList<CircuitComponent> result = instance.getComponents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInputs method, of class Circuit.
     */
    @Test
    public void testGetInputs() {
        System.out.println("getInputs");
        Circuit instance = new Circuit();
        LinkedList<Output> expResult = null;
        LinkedList<Output> result = instance.getInputs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComponents method, of class Circuit.
     */
    @Test
    public void testSetComponents() {
        System.out.println("setComponents");
        LinkedList<CircuitComponent> components = null;
        Circuit instance = new Circuit();
        instance.setComponents(components);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCircuitComponent method, of class Circuit.
     */
    @Test
    public void testAddCircuitComponent() {
        System.out.println("addCircuitComponent");
        CircuitComponent component = null;
        Circuit instance = new Circuit();
        instance.addCircuitComponent(component);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addInput method, of class Circuit.
     */
    @Test
    public void testAddInput() {
        System.out.println("addInput");
        Pin input = null;
        Circuit instance = new Circuit();
        instance.addInput(input);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of attachInput method, of class Circuit.
     */
    @Test
    public void testAttachInput() {
        System.out.println("attachInput");
        Pin output = null;
        Pin input = null;
        Circuit instance = new Circuit();
        instance.attachInput(output, input);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deattachInput method, of class Circuit.
     */
    @Test
    public void testDeattachInput() {
        System.out.println("deattachInput");
        Pin output = null;
        Pin input = null;
        Circuit instance = new Circuit();
        instance.deattachInput(output, input);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
