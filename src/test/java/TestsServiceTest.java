import dao.TaskDao;
import model.Task;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class TestsServiceTest {

    TaskDao fakeTaskDao = new TaskDao() {
        @Override
        public Task getById(long id) {
            if (id==1L) {
                return new Task("some task to be solved", 100, 5);
            }
            throw new NoSuchElementException();
        }

        @Override
        public Task save(Task task) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    };

}
