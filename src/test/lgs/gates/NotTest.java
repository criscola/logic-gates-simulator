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
public class NotTest {
    
    public NotTest() {
    }

    /**
     * Test of getResult method, of class Not.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        Not g = new Not();
        testCombinations(g);  
        setFirstCombination(g);
        assertEquals(true, g.getResult(0));
        testCombinations(g);
        setSecondCombination(g);
        assertEquals(false, g.getResult(0));
        testCombinations(g);
    }
    public void setFirstCombination(Not g){
        g.getInputs().get(0).setData(false);
    }
    public void setSecondCombination(Not g){
        g.getInputs().get(0).setData(true);
    }
    public void testCombinations(Not g){
        setFirstCombination(g);
        assertEquals(true, g.getResult(0));
        setSecondCombination(g);
        assertEquals(false, g.getResult(0));
    }
    
    
}
