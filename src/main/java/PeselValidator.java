public class PeselValidator {
    public boolean validate(String pesel) {

        if(pesel.length()!=11) {
            throw new NumberFormatException("Provided pesel is not 11 characters long");
        }
        int[] weights = {9, 7, 3, 1, 9, 7, 3, 1, 9, 7};
        int sum = 0;
        for(int i = 0; pesel.length()-1>i; i++) {
            if(Character.isDigit(pesel.charAt(i))) {
                sum += weights[i] * Character.getNumericValue(pesel.charAt(i));
            } else {
                throw new NumberFormatException("All characters must be digits");
            }
        }
        return sum % 10 == Character.getNumericValue(pesel.charAt(10));
    }
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
}
