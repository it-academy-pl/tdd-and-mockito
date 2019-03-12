import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PeselValidatorTest {
    PeselValidator validator;

    @BeforeEach
    public void createValidator() {
        validator = new PeselValidator();
    }

    @Test
    public void testAValidPesel() {
        assertTrue(validator.validate("80080432467"));
    }

    @Test
    public void testPeselWithInvalidControlNumber() {
        assertFalse(validator.validate("80080432468"));
    }

    @Test
    public void testIfMaleGenderIsCorrect() {
        assertTrue(validator.validateWithGender("86072710476", PeselValidator.Gender.MALE));
    }
    @Test
    public void testIfFemaleGenderIsCorrect() {
        assertTrue(validator.validateWithGender("91041629985", PeselValidator.Gender.FEMALE));
    }

    //@Test(expected = NullPointerException.class) - this is old way of testing for exception in JUnit4
    @Test
    public void testForNumberFormatExceptionIfPeselIsExactly11CharactersLong() {
        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> validator.validate("910416299855"));
        assertTrue(exception.getMessage().contentEquals("Provided pesel is not 11 characters long"));
    }

    @Test
    public void testForNumberFormatExceptionIfAnySymbolIsNotADigit() {
        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> validator.validate("910e6299855"));
        assertTrue(exception.getMessage().contentEquals("All characters must be digits"));
    }

    /*
    You could add more verification here to check if month/day entered is correct
     */

}
