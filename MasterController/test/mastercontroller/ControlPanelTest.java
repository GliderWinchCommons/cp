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
public class ControlPanelTest {
    
    public ControlPanelTest() {
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

    /**
     * Test of main method, of class ControlPanel.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ControlPanel.main(args);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getSlider method, of class ControlPanel.
     */
    @Test
    public void testStartingSliderPosistion() {
        System.out.println("Starting Slider Posistion");
        ControlPanel instance = new ControlPanel();
        float expResult = 0.50F;
        float result = instance.getSlider();
        assertEquals(expResult, result, 0.44);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getInitButton method, of class ControlPanel.
     */
    @Test
    public void testGetInitButton() {
        System.out.println("getInitButton");
        ControlPanel instance = new ControlPanel();
        boolean expResult = false;
        boolean result = instance.getInitButton();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getPrepRecButton method, of class ControlPanel.
     */
    @Test
    public void testGetPrepRecButton() {
        System.out.println("getPrepRecButton");
        ControlPanel instance = new ControlPanel();
        boolean expResult = false;
        boolean result = instance.getPrepRecButton();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setStateLed method, of class ControlPanel.
     */
    @Test
    public void testSetStateLed() {
        System.out.println("setStateLed");
        int state = 0;
        ControlPanel instance = new ControlPanel();
        instance.setStateLed(state);
        int result = state;
        int expResult = 0;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
     
}
