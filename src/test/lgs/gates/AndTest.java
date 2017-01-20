/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.gates;

import org.junit.Test;
import static org.junit.Assert.*;
import lgs.model.CircuitComponent;
/**
 *
 * @author Dias
 */
public class AndTest {
    
    public AndTest() {
    }

    /**
     * Test of getResult method, of class And.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        And g = new And();
        testCombinations(g);  
        setFirstCombination(g);
        assertEquals(false, g.getResult(0));
        testCombinations(g);
        setSecondCombination(g);
        assertEquals(false, g.getResult(0));
        testCombinations(g);
        setThirdCombination(g);
        assertEquals(true, g.getResult(0));
        testCombinations(g);
        setFourthCombination(g);
        assertEquals(false, g.getResult(0));        
        testCombinations(g);
    }
    public void testCombinations(And g){
        setFirstCombination(g);
        assertEquals(false, g.getResult(0));
        setSecondCombination(g);
        assertEquals(false, g.getResult(0));
        setThirdCombination(g);
        assertEquals(true, g.getResult(0));
        setFourthCombination(g);
        assertEquals(false, g.getResult(0));
    }
    public void setFirstCombination(And g){
        g.getInputs().get(0).setData(false);
        g.getInputs().get(1).setData(false);
    }
    public void setSecondCombination(And g){
        g.getInputs().get(0).setData(false);
        g.getInputs().get(1).setData(true);
    }
    public void setThirdCombination(And g){
        g.getInputs().get(0).setData(true);
        g.getInputs().get(1).setData(true);        
    }
    public void setFourthCombination(And g){
        g.getInputs().get(0).setData(true);
        g.getInputs().get(1).setData(false);

    }
    
}
