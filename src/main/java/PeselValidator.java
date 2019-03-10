
public class PeselValidator {


    public boolean validate(String pesel) {

        if (!checkPeselLength(pesel)) {
            return false;
        }

        if (!checkPeselType(pesel)) {
            return false;
        }

        if (!checkPeselDay(pesel)) {
            return false;
        }

        if (!checkPeselMonth(pesel)) {
            return false;
        }

        if (!checkPeselLastNumber(pesel)) {
            return false;
        }


        return true;
    }


    private boolean checkPeselLength(String pesel) {

        if (pesel.length() != 11) {
            throw new NumberFormatException();

        } else {
            return true;
        }
    }

    private boolean checkPeselType(String pesel) {
        String firstHalfPeselStr = pesel.substring(0, 5);
        String secondHalfPeselStr = pesel.substring(5, 11);

        try {
            int firstHalfPesel = Integer.valueOf(firstHalfPeselStr);
            int secondHalfPesel = Integer.valueOf(secondHalfPeselStr);

        }catch (NumberFormatException e) {
            System.out.println("Incorrect type.");
        }

        return true;
    }


    private boolean checkPeselDay(String pesel) {
        String peselDay = pesel.substring(4, 6);
        int peselDayOfMonth = Integer.valueOf(peselDay);

        if (peselDayOfMonth > 12) {
            return false;
        }

        return true;
    }

    private boolean checkPeselMonth(String pesel) {
        String stringPeselMonth = pesel.substring(2, 4);
        String stringPeselYear = pesel.substring(0, 2);

        int intPeselMonth = Integer.valueOf(stringPeselMonth);
        int intPeselYear = Integer.valueOf(stringPeselYear);


        if (intPeselMonth > 12 && intPeselMonth < 21) {
            return false;

        }else if (intPeselMonth > 32 && intPeselMonth < 41) {
            return false;

        }else if (intPeselMonth > 52 && intPeselMonth < 61) {
            return false;

        }else if (intPeselMonth > 71 && intPeselMonth < 81) {
            return false;

        }else if (intPeselMonth > 92) {
            return false;

        }else

            return true;
    }

    private boolean checkPeselLastNumber(String pesel) {
        String firstNumberStr = pesel.substring(0, 1);
        String secondNumberStr = pesel.substring(1, 2);
        String thirdNumberStr = pesel.substring(2, 3);
        String fourthNumberStr = pesel.substring(3, 4);
        String fifthNumberStr = pesel.substring(4, 5);
        String sixthNumberStr = pesel.substring(5, 6);
        String seventhNumberStr = pesel.substring(6, 7);
        String eighthNumberStr = pesel.substring(7, 8);
        String ninethNumberStr = pesel.substring(8, 9);
        String tenthNumberStr = pesel.substring(9, 10);
        String eleventhNumberStr = pesel.substring(10, 11);

        int firstNumber = Integer.valueOf(firstNumberStr);
        int secondNumber = Integer.valueOf(secondNumberStr);
        int thirdNumber = Integer.valueOf(thirdNumberStr);
        int fourthNumber = Integer.valueOf(fourthNumberStr);
        int fifthNumber = Integer.valueOf(fifthNumberStr);
        int sixthNumber = Integer.valueOf(sixthNumberStr);
        int seventhNumber = Integer.valueOf(seventhNumberStr);
        int eighthNumber = Integer.valueOf(eighthNumberStr);
        int ninethNumber = Integer.valueOf(ninethNumberStr);
        int tenthNumber = Integer.valueOf(tenthNumberStr);
        int eleventhNumber = Integer.valueOf(eleventhNumberStr);

        if ((firstNumber + (secondNumber * 3) + (thirdNumber * 7) + (fourthNumber * 9) + fifthNumber + (sixthNumber * 3) + (seventhNumber * 7) + (eighthNumber * 9) + ninethNumber + (tenthNumber * 3 ) + eleventhNumber) % 10 != 0) {
            return false;
        }

        return true;
    }


}
