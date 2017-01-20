/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgs.gates;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Dias
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({lgs.gates.NotTest.class, lgs.gates.OrTest.class, lgs.gates.NandTest.class, lgs.gates.NorTest.class, lgs.gates.XnorTest.class, lgs.gates.XorTest.class, lgs.gates.AndTest.class})
public class GatesSuite {
    
}
