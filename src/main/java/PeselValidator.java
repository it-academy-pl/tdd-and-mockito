import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;



/**
 * Created by Asia on 09.03.2019.
 */
public class PeselValidator { //9009 0 4 02925



    public boolean validate(String pesel) {

        if(!pesel.matches("([0-9]{11})")){
            return false;
        } else if (isValidDate(pesel.substring(0,6)) && isValidCheckSum(pesel)) {
            return true;
        } else {
            return false;
        }
    }


    private boolean isValidDate(String dateOfBirth) {
        boolean valid = true;
        try {
            DateTimeFormatter formatter = DateTimeFormat.forPattern("yyMMdd");
            DateTime dateTime = formatter.parseDateTime(dateOfBirth);
        } catch (Exception e) {
            valid = false;
        }
        return valid;
    }


    private boolean isValidCheckSum(String pesel){
        //todo
        return true;
    }

}
