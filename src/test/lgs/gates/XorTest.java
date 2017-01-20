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
public class XorTest {
    
    public XorTest() {
    }

    /**
     * Test of getResult method, of class Xor.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        Xor g = new Xor();
        testCombinations(g);  
        setFirstCombination(g);
        assertEquals(false, g.getResult(0));
        testCombinations(g);
        setSecondCombination(g);
        assertEquals(true, g.getResult(0));
        testCombinations(g);
        setThirdCombination(g);
        assertEquals(false, g.getResult(0));
        testCombinations(g);
        setFourthCombination(g);
        assertEquals(true, g.getResult(0));        
        testCombinations(g);
    }
    public void setFirstCombination(Xor g){
        g.getInputs().get(0).setData(false);
        g.getInputs().get(1).setData(false);
    }
    public void setSecondCombination(Xor g){
        g.getInputs().get(0).setData(false);
        g.getInputs().get(1).setData(true);
    }
    public void setThirdCombination(Xor g){
        g.getInputs().get(0).setData(true);
        g.getInputs().get(1).setData(true);        
    }
    public void setFourthCombination(Xor g){
        g.getInputs().get(0).setData(true);
        g.getInputs().get(1).setData(false);

    }
    public void testCombinations(Xor g){
        setFirstCombination(g);
        assertEquals(false, g.getResult(0));
        setSecondCombination(g);
        assertEquals(true, g.getResult(0));
        setThirdCombination(g);
        assertEquals(false, g.getResult(0));
        setFourthCombination(g);
        assertEquals(true, g.getResult(0));
    }
}
