public class PeselValidator {


    public boolean isLengthCorrect(String pesel) {

        if (pesel.length() == 11) return true;
        else return false;
    }


    public boolean isMonthCorrect(String pesel) {

        int monthNumber = Integer.valueOf(pesel.substring(2,4));

        if (monthNumber > 0 && monthNumber < 13) return true;
        if (monthNumber > 20 && monthNumber < 33) return true;
        if (monthNumber > 40 && monthNumber < 53) return true;
        if (monthNumber > 60 && monthNumber < 73) return true;
        if (monthNumber > 80 && monthNumber < 93) return true;
        else return false;
    }


    public String whatGender(String pesel, String gender) {

        char genderDigit = pesel.charAt(9);

        if (genderDigit == 0
                || genderDigit == 2
                || genderDigit == 4
                || genderDigit == 6
                || genderDigit == 8) return "female";
        else return "male";
    }


    //checking if day number is correct assuming that February has always 29 days.
    public boolean isDayCorrect(String pesel) {

        int dayNumber = Integer.valueOf(pesel.substring(4,6));
        int monthNumber = Integer.valueOf(pesel.substring(2,4));
        int maxDaysInMonth = 0;

        int[] monthsWith31Days = {
                1,3,5,7,8,10,12,
                21,23,25,28,30,32,
                41,43,45,48,50,52,
                61,63,65,68,70,72,
                81,83,85,88,90,92};

        int[] monthsWith30Days = {
                4,6,9,11,
                24,26,29,31,
                44,46,49,51,
                64,66,69,71,
                84,86,89,91};

        int[] monthsWith29Days = {2,22,42,62,82};

        if (contains(monthsWith29Days,monthNumber)) maxDaysInMonth = 29;
        else if (contains(monthsWith30Days,monthNumber)) maxDaysInMonth = 30;
        else if (contains(monthsWith31Days,monthNumber)) maxDaysInMonth = 31;
        else return false;

        if (dayNumber > 0 && dayNumber <= maxDaysInMonth) return true;
        else    return false;
    }


    // methotd checking if array contains certain number
    public static boolean contains(final int[] array, final int v) {

        for(int i : array) {
            if (i == v) return true;
        }
        return false;
    }


    public boolean isFormatCorrect(String pesel) {
        try{
            long peselInteger = Long.valueOf(pesel);
            return true;
        } catch(NumberFormatException e){
            return false;

        }
    }


    public boolean isControlDigitCorrect(String pesel){

        int first = Integer.valueOf(pesel.substring(0,1));
        int second = Integer.valueOf(pesel.substring(1,2));
        int third = Integer.valueOf(pesel.substring(2,3));
        int fourth = Integer.valueOf(pesel.substring(3,4));
        int fifth = Integer.valueOf(pesel.substring(4,5));
        int sixth = Integer.valueOf(pesel.substring(5,6));
        int seventh = Integer.valueOf(pesel.substring(6,7));
        int eighth = Integer.valueOf(pesel.substring(7,8));
        int nineth = Integer.valueOf(pesel.substring(8,9));
        int tenth = Integer.valueOf(pesel.substring(9,10));
        int eleventh = Integer.valueOf(pesel.substring(10,11));

        int givenControlDigit = eleventh;
        int calculatedControlDigit = (
                (first * 9) + (second * 7) + (third * 3) + (fourth * 1)
                        + (fifth * 9) + (sixth * 7) + (seventh * 3) + (eighth * 1)
                        + (nineth * 9) + (tenth * 7 ) ) % 10;

        if (givenControlDigit == calculatedControlDigit) return true;
        else return false;
    }
}