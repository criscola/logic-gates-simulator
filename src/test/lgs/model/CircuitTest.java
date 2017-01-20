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
        assertEquals(null, instance.getInputs());
        inputs = new LinkedList<>();
        instance.setInputs(inputs);
        assertEquals(inputs, instance.getInputs());
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
        LinkedList<Output> inputs = null;
        Circuit instance = new Circuit();
        instance.setInputs(inputs);
        assertEquals(null, instance.getInputs());
        inputs = new LinkedList<>();
        instance.setInputs(inputs);
        assertEquals(inputs, instance.getInputs());
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
        assertEquals(null, instance.getInputs().get(0));
        Input input2 = new Input(null);
        instance.addInput(input2);
        assertEquals(input2, instance.getInputs().get(1));
    }

    /**
     * Test of attachInput method, of class Circuit.
     */
    @Test
    public void testAttachInput() {
        System.out.println("attachInput");
        Pin output = new Output(null);
        Pin input = new Input(null);
        Circuit instance = new Circuit();
        instance.attachInput(output, input);
        output.setData(true);
        assertEquals(output.getData(), input.getData());
    }

    /**
     * Test of deattachInput method, of class Circuit.
     */
    @Test
    public void testDeattachInput() {
        System.out.println("deattachInput");
        Pin output = new Output(null);
        Pin input = new Input(null);
        Circuit instance = new Circuit();
        instance.attachInput(output, input);
        output.setData(true);
        assertEquals(output.getData(), input.getData());
        instance.deattachInput(output, input);
        output.setData(false);
        assertEquals(!output.getData(), input.getData());
    }
    
}
