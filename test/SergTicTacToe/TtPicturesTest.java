/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SergTicTacToe;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Saloed
 */
public class TtPicturesTest {
    
    public TtPicturesTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetPath() throws IOException {
        System.out.println("getPath");
        TtPictures instance = new TtPictures();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getPath();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
