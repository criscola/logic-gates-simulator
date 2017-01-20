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
public class NorTest {
    
    public NorTest() {
    }

    /**
     * Test of getResult method, of class Nor.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        Nor g = new Nor();
        assertEquals(false, g.getResult(-1));
        testCombinations(g);  
        setFirstCombination(g);
        assertEquals(true, g.getResult(0));
        testCombinations(g);
        setSecondCombination(g);
        assertEquals(false, g.getResult(0));
        testCombinations(g);
        setThirdCombination(g);
        assertEquals(false, g.getResult(0));
        testCombinations(g);
        setFourthCombination(g);
        assertEquals(false, g.getResult(0));        
        testCombinations(g);
    }
    public void testCombinations(Nor g){
        setFirstCombination(g);
        assertEquals(true, g.getResult(0));
        setSecondCombination(g);
        assertEquals(false, g.getResult(0));
        setThirdCombination(g);
        assertEquals(false, g.getResult(0));
        setFourthCombination(g);
        assertEquals(false, g.getResult(0));
        assertEquals(false, g.getResult(-1));
    }
    public void setFirstCombination(Nor g){
        g.getInputs().get(0).setData(false);
        g.getInputs().get(1).setData(false);
    }
    public void setSecondCombination(Nor g){
        g.getInputs().get(0).setData(false);
        g.getInputs().get(1).setData(true);
    }
    public void setThirdCombination(Nor g){
        g.getInputs().get(0).setData(true);
        g.getInputs().get(1).setData(true);        
    }
    public void setFourthCombination(Nor g){
        g.getInputs().get(0).setData(true);
        g.getInputs().get(1).setData(false);

    }
}
