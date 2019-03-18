package service;

import exception.PeselExistsException;
import model.Student;

public class StudentService {

    public Student addPesel(long studentId, String pesel) throws PeselExistsException {
        return null;
        //TODO add implementation of this method, the logic will be the following
        //1. get student by Id (create StudentDao in order to do that, similar to TaskDao and PerformedTaskDao)
        //2. if pesel exists for this student (not null) then throw new PeselExistsException();
        //3. else check if pesel passed as a parameter is valid (using our Pesel Validator)
        //4. if pesel is not valid then throw InvalidPeselException
        //5. if pesel is valid then return Student object

        //use any test technique you like to test this class, make sure that tes coverage is close to 100%
        //JUnit assertThrows() method might be useful

    }
}
