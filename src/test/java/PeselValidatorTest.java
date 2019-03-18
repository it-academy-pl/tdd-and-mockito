import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PeselValidatorTest {

    private  PeselValidator validator = new PeselValidator();

    @Test
    public void testValidadPesel() {

       assertTrue(validator.validate("59010396898"));

    }

    @Test
    public void testPeselWhichIsTooShort() {

        assertThrows(NumberFormatException.class, () -> validator.validate("5901039689"));

    }


    @Test
    public void testPeselWithWrongMonth() {
        assertFalse(validator.validate("59130396898"));
    }


    @Test
    public void testPeselWithCorrectLastNumber() {

        assertTrue(validator.validate("59010396898"));
    }


    @Test
    public void testPeselWithWrongLastNumber() {

        assertFalse(validator.validate("59010396897"));
    }


    @Test
    public void testPeselWithoutLeter() {

        assertTrue(validator.validate("59010396898"));
    }

    @Test
    public void testPeselWithLeter() {

        assertFalse(validator.validate("L9017296898"));
    }


}
