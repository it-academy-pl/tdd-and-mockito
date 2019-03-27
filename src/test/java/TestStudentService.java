import dao.StudentDao;
import exception.InvalidPeselException;
import exception.PeselExistsException;
import model.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestStudentService {
    @Mock
    StudentDao studentDaoMock;

    @Test
    public void checkIfPeselExists(){
        when(studentDaoMock.getById(1L)).thenReturn(new Student("Janusz","Grażynowy","9392834123"));
        StudentService studentService = new StudentService(studentDaoMock);
        PeselExistsException thrown =
                assertThrows(PeselExistsException.class,
                        () -> studentService.addPesel(1L,"95032263558"));

        /**
         * While writing tests in the future I suggest to use AAA (Arrange Act Assert) format but without
         * writing any comments - just split each part by blank line: http://wiki.c2.com/?ArrangeActAssert
         */
    }
    @Test
    public void checkIfPeselIsValid(){
        when(studentDaoMock.getById(1L)).thenReturn(new Student("Janusz","Grażynowy",""));
        StudentService studentService = new StudentService(studentDaoMock);
        InvalidPeselException thrown =
                assertThrows(InvalidPeselException.class,
                        () -> studentService.addPesel(1L,"03289735572"));

        /**
         * While writing tests in the future I suggest to use AAA (Arrange Act Assert) format but without
         * writing any comments - just split each part by blank line: http://wiki.c2.com/?ArrangeActAssert
         */
    }
}
