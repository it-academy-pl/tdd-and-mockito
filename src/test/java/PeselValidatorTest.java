import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Asia on 09.03.2019.
 */
public class PeselValidatorTest {

    @Test
    public void testValidPesel(){
        PeselValidator pv = new PeselValidator();
        assertTrue (pv.validate("90090402925"));
    }

    @Test
    public void testToShort(){
        PeselValidator pv = new PeselValidator();
        assertFalse(pv.validate("0099999"));
        //assertThrows(NumberFormatException.class, ()->pv.validate("009999"));
    }

    @Test
    public void testMonthGreaterThan12(){
        PeselValidator pv = new PeselValidator();
        assertFalse(pv.validate("90320402925"));
        //assertThrows(NumberFormatException.class, ()->ps.validate("90320402925"));
    }

    //control number chech

}
