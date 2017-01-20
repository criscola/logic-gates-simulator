/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.gates;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dias
 */
public class OrTest {
    
    public OrTest() {
    }

    /**
     * Test of getResult method, of class Or.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        Or g = new Or();
        testCombinations(g);  
        setFirstCombination(g);
        assertEquals(false, g.getResult(0));
        testCombinations(g);
        setSecondCombination(g);
        assertEquals(true, g.getResult(0));
        testCombinations(g);
        setThirdCombination(g);
        assertEquals(true, g.getResult(0));
        testCombinations(g);
        setFourthCombination(g);
        assertEquals(true, g.getResult(0));        
        testCombinations(g);
    }
    public void setFirstCombination(Or g){
        g.getInputs().get(0).setData(false);
        g.getInputs().get(1).setData(false);
    }
    public void setSecondCombination(Or g){
        g.getInputs().get(0).setData(false);
        g.getInputs().get(1).setData(true);
    }
    public void setThirdCombination(Or g){
        g.getInputs().get(0).setData(true);
        g.getInputs().get(1).setData(true);        
    }
    public void setFourthCombination(Or g){
        g.getInputs().get(0).setData(true);
        g.getInputs().get(1).setData(false);

    }
    public void testCombinations(Or g){
        setFirstCombination(g);
        assertEquals(false, g.getResult(0));
        setSecondCombination(g);
        assertEquals(true, g.getResult(0));
        setThirdCombination(g);
        assertEquals(true, g.getResult(0));
        setFourthCombination(g);
        assertEquals(true, g.getResult(0));
    }
    
}
