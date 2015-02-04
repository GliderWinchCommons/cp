/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastercontroller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jwhite9
 */
public class MasterControllerTest {
    
    public MasterControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    //ControlPanel cp = new ControlPanel();
    /**
     * Test of main method, of class MasterController.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        MasterController.main(args);
        // TODO review the generated test code and remove the default call to fail.
        
    }
//    @Test
//    public void testStartingSliderPosistion() {
//        System.out.println("Initial Elasped Ticks Values");
//        MasterController instance = new MasterController();
//        String[] args = null;
//        MasterController.main(args);
//        int expResult = -1;
//        int result = instance.elaspedTics;
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }

    
}
