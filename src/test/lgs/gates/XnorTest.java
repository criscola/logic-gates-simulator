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
public class XnorTest {
    
    public XnorTest() {
    }

    /**
     * Test of getResult method, of class Xnor.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        Xnor g = new Xnor();
        testCombinations(g);  
        setFirstCombination(g);
        assertEquals(true, g.getResult(0));
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
    public void setFirstCombination(Xnor g){
        g.getInputs().get(0).setData(false);
        g.getInputs().get(1).setData(false);
    }
    public void setSecondCombination(Xnor g){
        g.getInputs().get(0).setData(false);
        g.getInputs().get(1).setData(true);
    }
    public void setThirdCombination(Xnor g){
        g.getInputs().get(0).setData(true);
        g.getInputs().get(1).setData(true);        
    }
    public void setFourthCombination(Xnor g){
        g.getInputs().get(0).setData(true);
        g.getInputs().get(1).setData(false);

    }
    public void testCombinations(Xnor g){
        setFirstCombination(g);
        assertEquals(true, g.getResult(0));
        setSecondCombination(g);
        assertEquals(false, g.getResult(0));
        setThirdCombination(g);
        assertEquals(true, g.getResult(0));
        setFourthCombination(g);
        assertEquals(false, g.getResult(0));
    }
}
