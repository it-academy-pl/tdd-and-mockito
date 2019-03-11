import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PeselValidatorTest {

    PeselValidator validator = new PeselValidator();

    // generated valid pesel: 03280735572

    @Test
    public void checkIfPeselCorrect(){
        String pesel = "03280735572";
        assertTrue(validator.validate(pesel));
    }

    @Test
    public void checkIfPeselCorrectWithGenderCheck(){
        String pesel = "03280735572";
        String gender = "male";
        assertTrue(validator.validate(pesel,gender));
    }

    @Test
    public void checkWhenLengthWrong() {
        //given pesel with 10 digits instead of 11
        String pesel = "0328073557";

        //when &then
        assertFalse(validator.validate(pesel));
    }


    @Test
    public void checkWhenFormatWrong(){
        //given
        String pesel = "a3280735572";

        //when & then
        assertFalse(validator.validate(pesel));
    }


    @Test
    public void checkWhenMonthWrong(){
        //given pesel with wrong month number
        String pesel = "03000735572";

        //when & then
        assertFalse(validator.validate(pesel));
    }


    @Test
    public void  checkWhenDayWrong(){
        //given pesel with wrong day number
        String pesel = "03223035572";

        //when & then
        assertFalse(validator.validate(pesel));
    }


    @Test
    public void checkWhenGenderWrong(){
        //given pesel with male gender digit
        String pesel = "03000735572";
        String gender = "female";

        //when & then
        assertFalse(validator.validate(pesel, gender));
    }


    @Test
    public void checkWhenLastDigitWrong(){
        //given pesel with last digit wrong
        String pesel = "03280735570";

        //when && then
        assertFalse(validator.validate(pesel));
    }
}