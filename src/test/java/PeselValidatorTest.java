import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PeselValidatorTest {

    PeselValidator validator = new PeselValidator();

    // generated valid pesel: 03280735572

    @Test
    public void checkWhenLengthWrong() {
        //given pesel with 10 digits instead of 11
        String pesel = "0328073557";

        //when &then
        assertFalse(validator.isLengthCorrect(pesel));
    }

    @Test
    public void checkWhenLengthCorrect() {
        //given pesel with correct length
        String pesel = "03280735572";

        //when &then
        assertTrue(validator.isLengthCorrect(pesel));
    }

    @Test
    public void checkWhenFormatWrong(){
        //given
        String pesel = "a3280735572";

        //when & then
        assertFalse(validator.isFormatCorrect(pesel));
    }

    @Test
    public void checkWhenFormatCorrect(){
        //given
        String pesel = "03280735572";

        //when & then
        assertTrue(validator.isFormatCorrect(pesel));
    }

    @Test
    public void checkWhenMonthWrong(){
        //given pesel with wrong month number
        String pesel = "03000735572";

        //when & then
        assertFalse(validator.isMonthCorrect(pesel));
    }

    @Test
    public void checkWhenMonthCorrect(){
        //given
        String pesel = "03280735572";

        //when & then
        assertTrue(validator.isMonthCorrect(pesel));
    }

    @Test
    public void  checkWhenDayWrong(){
        //given pesel with wrong day number
        String pesel = "03223035572";

        //when & then
        assertFalse(validator.isDayCorrect(pesel));
    }

    @Test
    public void  checkWhenDayCorrect(){
        //given
        String pesel = "03280735572";

        //when & then
        assertTrue(validator.isDayCorrect(pesel));
    }

    @Test
    public void checkWhenGenderWrong(){
        //given pesel with male gender digit
        String pesel = "03000735572";
        String gender = "female";

        //when & then
        String genderFromPesel = validator.whatGender(pesel, gender);
        assertFalse(gender.equals(genderFromPesel));
    }

    @Test
    public void checkWhenGenderCorrect(){
        //given pesel with male gender digit
        String pesel = "03000735572";
        String gender = "male";

        //when & then
        String genderFromPesel = validator.whatGender(pesel, gender);
        assertTrue(gender.equals(genderFromPesel));
    }

    @Test
    public void checkWhenLastDigitWrong(){
        //given pesel with last digit wrong
        String pesel = "03280735570";

        //when && then
        assertFalse(validator.isControlDigitCorrect(pesel));
    }

    @Test
    public void checkWhenLastDigitCorrect(){
        //given
        String pesel = "03280735572";

        //when && then
        assertTrue(validator.isControlDigitCorrect(pesel));
    }

}