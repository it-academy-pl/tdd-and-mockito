import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// generated male valid pesel: 03280735572
// generated female valid pesel: 87051788242

public class PeselValidatorTest {

    PeselValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new PeselValidator();
    }

    @Test
    public void checkIfPeselCorrect() {
        assertTrue(validator.validate("03280735572"));
    }

    @Test
    public void testIfMaleGenderIsCorrect() {
        assertTrue(validator.validateWithGender("03280735572", PeselValidator.Gender.MALE));
    }

    @Test
    public void testIfFemaleGenderIsCorrect() {
        assertTrue(validator.validateWithGender("87051788242", PeselValidator.Gender.FEMALE));
    }

    @Test
    public void isDataCorrect() {
        assertFalse(validator.isDateCorrect("87234788242")); // Data zła
        assertTrue(validator.isDateCorrect("87431788242"));  // Data prawidłowa
    }
    @Test
    public void checkIfLengthWrong() {
        assertFalse(validator.validate("0328073557"));
    }

    @Test
    public void checkIfFormatWrong() {
        assertFalse(validator.validate("a3280735572"));
    }

    @Test
    public void checkIfMonthWrong() {
        assertFalse(validator.validate("03000735572"));
    }

    @Test
    public void checkIfDayWrong() {
        assertFalse(validator.validate("03223035572"));
    }

    @Test
    public void checkIfLastDigitWrong() {
        assertFalse(validator.validate("03280735570"));
    }

    @Test
    public void checkPeselWith30DaysInMonth() {
        assertTrue(validator.validate(null));
    }



}