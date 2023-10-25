package testing;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import product.Teethbrush;

/**
 * Testing class for Teethbrush.
 * 
 * @author Ian Gribb, James Madison University
 * @version 1.0 - 10/21/2023 This work complies with the JMU Honor Code.
 * 
 * References and Acknowledgments: I received no outside help with this
 * programming assignment.
 */
class TeethbrushTest {
    
    /**
     * Testing the Constructor of Teethbrush.
     */
    @Test
    void testConstructor() {
        Teethbrush tb1 = new Teethbrush("Model 1", 5, true);
        assertEquals("Model 1", tb1.getModel());
        assertEquals(5, tb1.getHardness());
        assertTrue(tb1.isPolished());
    }
    
    /**
     * Test to see if we can properly change the inventory.
     */
    @Test
    void testChangeInventory() {
        Teethbrush tb2 = new Teethbrush("Model 2", 3, false);
        assertTrue(tb2.changeInventory(64));
        assertEquals(64, tb2.getInventory());
        
        Teethbrush tb3 = new Teethbrush("Model 3", 4, true);
        assertFalse(tb3.changeInventory(-42));
        
    }
    
    /**
     * Test retrieving the ultimate cost of a Teethbrush object.
     */
    @Test
    void testCostMethod() {
        Teethbrush tb4 = new Teethbrush("Model 4", 5, true);
        assertEquals(3.25, tb4.cost());
        
        Teethbrush tb5 = new Teethbrush("Model 5", 3, false);
        assertEquals(2.30, tb5.cost());
    }
    
    /**
     * Test retrieving the hardness of a Teethbrush Object.
     */
    @Test
    void testGetHardness() {
        Teethbrush tb6 = new Teethbrush("Model 6", 6, true);
        assertEquals(5, tb6.getHardness());
        
        Teethbrush tb7 = new Teethbrush("Model 7", -1, false);
        assertEquals(0, tb7.getHardness());
        
        Teethbrush tb8 = new Teethbrush("Model 8", 3, false);
        assertEquals(3, tb8.getHardness());
        
        
    }
    
    /**
     * Test setting the hardness of a Teethbrush object.
     */
    @Test
    void testSetHardness() {
        Teethbrush tb9 = new Teethbrush("Model 9", 4, false);
        tb9.setHardness(-432);
        assertEquals(0, tb9.getHardness());
    }
    
    /**
     * Test the ultimate shipping cost of an order.
     */
    @Test
    void testShippingCost() {
        Teethbrush tb10 = new Teethbrush("Model 10", 2, true);
        assertEquals(445.00, tb10.shippingCost(2000, true));
        
        Teethbrush tb11 = new Teethbrush("Model 11", 2, true);
        assertEquals(165.00, tb11.shippingCost(2000, false));
        
        Teethbrush tb12 = new Teethbrush("Model 12", 2, true);
        assertEquals(25.50, tb12.shippingCost(5, false));
        
        Teethbrush tb13 = new Teethbrush("Model 13", 2, true);
        tb13.changeInventory(12);
        assertEquals(29.0, tb13.shippingCost(40, false));
        
        Teethbrush tb14 = new Teethbrush("Model 14", 2, true);
        tb14.changeInventory(31);
        assertEquals(3.1, tb14.shippingCost(31, false));
    }
    @Test
    void testIsPolished() {
        Teethbrush tb15 = new Teethbrush("Model 15", 2, true);
        assertTrue(tb15.isPolished());
        
    }
    
    @Test
    void testGetHardnessExactBounds() {
        Teethbrush tb16 = new Teethbrush("Model 16", 0, true);
        assertEquals(0, tb16.getHardness());
        
        Teethbrush tb17 = new Teethbrush("Model 17", 5, false);
        assertEquals(5, tb17.getHardness());
    }
    
    @Test
    void testSetHardnessAboveLimit() {
        Teethbrush tb18 = new Teethbrush("Model 18", 4, false);
        tb18.setHardness(6);  
        assertEquals(5, tb18.getHardness());
    }
    
    @Test
    void testChangeInventoryToZero() {
        Teethbrush tb19 = new Teethbrush("Model 19", 3, false);
        tb19.changeInventory(5);  
        assertTrue(tb19.changeInventory(-5));  
        assertEquals(0, tb19.getInventory());
    }
    
    
    @Test
    void testGetHardnessBoundary() {
        Teethbrush tb20 = new Teethbrush("Model 20", -1, true);
        assertEquals(0, tb20.getHardness());
        
        Teethbrush tb21 = new Teethbrush("Model 21", 6, false);
        assertEquals(5, tb21.getHardness());
    }

    @Test
    void testShippingCostWithStocking() {
        Teethbrush tb22 = new Teethbrush("Model 22", 2, true);
        tb22.changeInventory(5);
        assertEquals(25.00 + (0.10 * 10), tb22.shippingCost(10, false));
    }

    @Test
    void testLargeOrderDiscount() {
        Teethbrush tb23 = new Teethbrush("Model 23", 2, true);
        tb23.changeInventory(3000);
        assertEquals((0.10 - (0.10 * 0.30)) * 2000, tb23.shippingCost(2000, false));
    }

    @Test
    void testShippingOverseasVsLocal() {
        Teethbrush tb24 = new Teethbrush("Model 24", 2, true);
        tb24.changeInventory(200);
        assertEquals(0.30 * 100, tb24.shippingCost(100, true));
        assertEquals(0.10 * 100, tb24.shippingCost(100, false));
    }


}
