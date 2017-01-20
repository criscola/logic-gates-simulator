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
public class NandTest {
    
    public NandTest() {
    }

    /**
     * Test of getResult method, of class Nand.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        Nand g = new Nand();
        testCombinations(g);  
        setFirstCombination(g);
        assertEquals(true, g.getResult(0));
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
    public void testCombinations(Nand g){
        setFirstCombination(g);
        assertEquals(true, g.getResult(0));
        setSecondCombination(g);
        assertEquals(true, g.getResult(0));
        setThirdCombination(g);
        assertEquals(false, g.getResult(0));
        setFourthCombination(g);
        assertEquals(true, g.getResult(0));
    }
    public void setFirstCombination(Nand g){
        g.getInputs().get(0).setData(false);
        g.getInputs().get(1).setData(false);
    }
    public void setSecondCombination(Nand g){
        g.getInputs().get(0).setData(false);
        g.getInputs().get(1).setData(true);
    }
    public void setThirdCombination(Nand g){
        g.getInputs().get(0).setData(true);
        g.getInputs().get(1).setData(true);        
    }
    public void setFourthCombination(Nand g){
        g.getInputs().get(0).setData(true);
        g.getInputs().get(1).setData(false);

    }
    
}
