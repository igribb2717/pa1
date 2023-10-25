package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import product.ElectricTeethbrush;


class ElectricTeethbrushTest {

    @Test
    void testConstructor() {
        ElectricTeethbrush etb = new ElectricTeethbrush("Model 1", 3, true, false, true);
        assertEquals("Model 1", etb.getModel());
        assertEquals(3, etb.getHardness());
        assertTrue(etb.isPolished());
        assertTrue(etb.isUltrasonic());
        assertFalse(etb.isRechargeable());
        
    }
    @Test
    void testGettingCostForBasic() {
        ElectricTeethbrush etb2 = new ElectricTeethbrush("Model 2", 0, true, false, false);
        assertEquals(18.75, etb2.cost());
    }
    @Test
    void testGettingCostForRechargeable() {
        ElectricTeethbrush etb3 = new ElectricTeethbrush("Model 3", 0, true, true, false);
        assertEquals(38.75, etb3.cost());
    }
    @Test
    void testGettingCostForRechargeableUltrasonic() {
        ElectricTeethbrush etb4 = new ElectricTeethbrush("Model 4", 0, true, true, true);
        assertEquals(48.75, etb4.cost());
    }

}
