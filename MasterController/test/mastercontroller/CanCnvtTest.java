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
public class CanCnvtTest {
    
    public CanCnvtTest() {
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
     * Test of convert_msgtobin method, of class CanCnvt.
     */
    @Test
    public void testConvert_msgtobin() {
        System.out.println("convert_msgtobin");
        String msg0 = "";
        String msg1 = "0000000000001001";
        String msg2 = "00000000000010010000000000001001";
        CanCnvt instance = new CanCnvt();
        int expResult0 = -1;
        int expResult1 = -5;
        int expResult2 = -2;
        int result0 = instance.convert_msgtobin(msg0);
        int result1 = instance.convert_msgtobin(msg1);
        int result2 = instance.convert_msgtobin(msg2);
        assertEquals(expResult0, result0);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of get_long method, of class CanCnvt.
     */
    @Test
    public void testGet_long() {
        System.out.println("get_long");
        CanCnvt instance = new CanCnvt();
        long expResult = 0L;
        long result = instance.get_long();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_int method, of class CanCnvt.
     */
    @Test
    public void testGet_int() {
        System.out.println("get_int");
        int offset = 0;
        CanCnvt instance = new CanCnvt();
        int expResult = 0;
        int result = instance.get_int(offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of get_ints method, of class CanCnvt.
     */
    @Test
    public void testGet_ints() {
        System.out.println("get_ints");
        int offset = 0;
        int numb = 0;
        CanCnvt instance = new CanCnvt();
        int[] expResult = null;
        int[] result = instance.get_ints(offset, numb);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_uint method, of class CanCnvt.
     */
    @Test
    public void testGet_uint() {
        System.out.println("get_uint");
        int offset = 0;
        CanCnvt instance = new CanCnvt();
        long expResult = 0L;
        long result = instance.get_uint(offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_short method, of class CanCnvt.
     */
    @Test
    public void testGet_short() {
        System.out.println("get_short");
        int offset = 0;
        CanCnvt instance = new CanCnvt();
        short expResult = 0;
        short result = instance.get_short(offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_shorts method, of class CanCnvt.
     */
    @Test
    public void testGet_shorts() {
        System.out.println("get_shorts");
        int offset = 0;
        int numb = 0;
        CanCnvt instance = new CanCnvt();
        short[] expResult = null;
        short[] result = instance.get_shorts(offset, numb);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_ushort method, of class CanCnvt.
     */
    @Test
    public void testGet_ushort() {
        System.out.println("get_ushort");
        int offset = 0;
        CanCnvt instance = new CanCnvt();
        int expResult = 0;
        int result = instance.get_ushort(offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_ushorts method, of class CanCnvt.
     */
    @Test
    public void testGet_ushorts() {
        System.out.println("get_ushorts");
        int offset = 0;
        int numb = 0;
        CanCnvt instance = new CanCnvt();
        int[] expResult = null;
        int[] result = instance.get_ushorts(offset, numb);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_byte method, of class CanCnvt.
     */
    @Test
    public void testGet_byte() {
        System.out.println("get_byte");
        int offset = 0;
        CanCnvt instance = new CanCnvt();
        byte expResult = 0;
        byte result = instance.get_byte(offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_bytes method, of class CanCnvt.
     */
    @Test
    public void testGet_bytes() {
        System.out.println("get_bytes");
        int offset = 0;
        int numb = 0;
        CanCnvt instance = new CanCnvt();
        byte[] expResult = null;
        byte[] result = instance.get_bytes(offset, numb);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_ubyte method, of class CanCnvt.
     */
    @Test
    public void testGet_ubyte() {
        System.out.println("get_ubyte");
        int offset = 0;
        CanCnvt instance = new CanCnvt();
        short expResult = 0;
        short result = instance.get_ubyte(offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_ubytes method, of class CanCnvt.
     */
    @Test
    public void testGet_ubytes() {
        System.out.println("get_ubytes");
        int offset = 0;
        int numb = 0;
        CanCnvt instance = new CanCnvt();
        short[] expResult = null;
        short[] result = instance.get_ubytes(offset, numb);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get_uints method, of class CanCnvt.
     */
    @Test
    public void testGet_uints() {
        System.out.println("get_uints");
        int offset = 0;
        int numb = 0;
        CanCnvt instance = new CanCnvt();
        long[] expResult = null;
        long[] result = instance.get_uints(offset, numb);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of msg_prep method, of class CanCnvt.
     */
    @Test
    public void testMsg_prep() {
        System.out.println("msg_prep");
        CanCnvt instance = new CanCnvt();
        String result = instance.msg_prep();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of set_int method, of class CanCnvt.
     */
    @Test
    public void testSet_int() {
        System.out.println("set_int");
        int n = 0;
        int offset = 0;
        CanCnvt instance = new CanCnvt();
        int expResult = 0;
        int result = instance.set_int(n, offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of set_ints method, of class CanCnvt.
     */
    @Test
    public void testSet_ints() {
        System.out.println("set_ints");
        int[] ns = null;
        int offset = 0;
        CanCnvt instance = new CanCnvt();
        int expResult = 0;
        int result = instance.set_ints(ns, offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set_long method, of class CanCnvt.
     */
    @Test
    public void testSet_long() {
        System.out.println("set_long");
        long lng = 0L;
        CanCnvt instance = new CanCnvt();
        int expResult = 0;
        int result = instance.set_long(lng);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set_short method, of class CanCnvt.
     */
    @Test
    public void testSet_short() {
        System.out.println("set_short");
        int n = 0;
        int offset = 0;
        CanCnvt instance = new CanCnvt();
        int expResult = 0;
        int result = instance.set_short(n, offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set_shorts method, of class CanCnvt.
     */
    @Test
    public void testSet_shorts() {
        System.out.println("set_shorts");
        int[] ns = null;
        int offset = 0;
        CanCnvt instance = new CanCnvt();
        int expResult = 0;
        int result = instance.set_shorts(ns, offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set_byte method, of class CanCnvt.
     */
    @Test
    public void testSet_byte() {
        System.out.println("set_byte");
        int n = 0;
        int offset = 0;
        CanCnvt instance = new CanCnvt();
        int expResult = 0;
        int result = instance.set_byte(n, offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of set_bytes method, of class CanCnvt.
     */
    @Test
    public void testSet_bytes() {
        System.out.println("set_bytes");
        int[] ns = null;
        int offset = 0;
        CanCnvt instance = new CanCnvt();
        int expResult = 0;
        int result = instance.set_bytes(ns, offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valerr method, of class CanCnvt.
     */
    @Test
    public void testValerr() {
        System.out.println("valerr");
        CanCnvt instance = new CanCnvt();
        instance.valerr();

        // TODO review the generated test code and remove the default call to fail.
        ;
    }
    
}
