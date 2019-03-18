import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PeselValidator {

    public boolean validate(String pesel) {
        return isLengthCorrect(pesel)
                && isFormatCorrect(pesel)
                && isMonthCorrect(pesel)
                && isDayCorrect(pesel)
                && isControlDigitCorrect(pesel);
    }

    // method validateWithGender copied from rb_pesel branch
    public boolean validateWithGender(String pesel, Gender gender) {
        if(!validate(pesel)) return false;
        if(gender.equals(Gender.MALE)) {
            return Character.getNumericValue(pesel.charAt(9))%2!=0;
        }
        else if(gender.equals(Gender.FEMALE)) {
            return Character.getNumericValue(pesel.charAt(9))%2==0;
        } else {
            throw new RuntimeException("unknown gender");
        }
    }

    public enum Gender {
        MALE, FEMALE
    }

    private boolean isLengthCorrect(String pesel) {
        return pesel.length() == 11;
    }

    private boolean isMonthCorrect(String pesel) {
        int monthNumber = Integer.valueOf(pesel.substring(2, 4));

        if (monthNumber > 0 && monthNumber < 13) {
            return true;
        } else if (monthNumber > 20 && monthNumber < 33) {
            return true;
        } else if (monthNumber > 40 && monthNumber < 53) {
            return true;
        } else if (monthNumber > 60 && monthNumber < 73) {
            return true;
        } else if (monthNumber > 80 && monthNumber < 93) {
            return true;
        }
            return false;
    }

    //checking if day number is correct assuming that February has always 29 days.
    private boolean isDayCorrect(String pesel) {
        int dayNumber = Integer.valueOf(pesel.substring(4, 6));
        int monthNumber = Integer.valueOf(pesel.substring(2, 4));
        int maxDaysInMonth;
        List<Integer> peselMonths29 = getValidPeselMonthNumbers(Arrays.asList(2));
        List<Integer> peselMonths30 = getValidPeselMonthNumbers(Arrays.asList(4, 6, 9, 11));
        List<Integer> peselMonths31 = getValidPeselMonthNumbers(Arrays.asList(1, 3, 5, 7, 8, 10, 12));

        if (peselMonths29.stream().anyMatch(month -> month == monthNumber)) {
            maxDaysInMonth = 29;
        } else if (peselMonths30.stream().anyMatch(month -> month == monthNumber)) {
            maxDaysInMonth = 30;
        } else if (peselMonths31.stream().anyMatch(month -> month == monthNumber)) {
            maxDaysInMonth = 31;
        } else {
            return false;
        }

        return dayNumber > 0 && dayNumber <= maxDaysInMonth;
    }

    private List<Integer> getValidPeselMonthNumbers(List<Integer> months) {
        List<Integer> peselMonths = new ArrayList<>();

        months.forEach(month -> {
            peselMonths.add(month);
            peselMonths.add(month+20);
            peselMonths.add(month+40);
            peselMonths.add(month+60);
            peselMonths.add(month+80);
        });

        return peselMonths;
    }

    private boolean isFormatCorrect(String pesel) {
        try {
            Long.valueOf(pesel);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isControlDigitCorrect(String pesel) {
        int givenControlDigit = Character.getNumericValue(pesel.charAt(10));
        int[] formulaMultipliers = {9, 7, 3, 1, 9, 7, 3, 1, 9, 7}; // formula: (9×a + 7×b + 3×c + 1×d + 9×e + 7×f + 3×g + 1×h + 9×i + 7×j)%10
        int calculatedControlDigit = 0;

        for (int i = 0; i < formulaMultipliers.length; i++) {
            calculatedControlDigit += Character.getNumericValue(pesel.charAt(i)) * formulaMultipliers[i];
            if (i == formulaMultipliers.length - 1) {
                calculatedControlDigit %= 10;
            }
        }

        return givenControlDigit == calculatedControlDigit ;
    }

}