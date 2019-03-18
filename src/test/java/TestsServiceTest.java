import dao.TaskDao;
import dao.TaskFakeImpl;
import model.PerformedTask;
import model.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import service.TestsService;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestsServiceTest {

    @Mock
    TaskDao taskDaoMocked;
    @Spy
    TaskFakeImpl taskDaoToBeSpied = new TaskFakeImpl();

    // anonymous class - we create implementation 'on the fly'
    TaskDao fakeTaskDao = new TaskDao() {
        @Override
        public Task getById(long id) {
            if (id == 1L) {
                return new Task("some task to be solved", 100, 5);
            }
            throw new NoSuchElementException();
        }

        @Override
        public Task save(Task task) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    };

    //This is first test using fakeTaskDao (Mockito not needed at all)
    @Test
    public void checkIfTaskWasSolvedCorrectlyUsingFakeTaskDao() {
        //Arrange
        TestsService testsService = new TestsService(fakeTaskDao);
        //Act
        PerformedTask performedTask = testsService.submitTask(1L, 1L, 98);
        //Assert
        assertTrue(performedTask.isPassed());

        /**
         * While writing tests in the future I suggest to use AAA (Arrange Act Assert) format but without
         * writing any comments - just split each part by blank line: http://wiki.c2.com/?ArrangeActAssert
         */
    }

    //This is test which is doing the same as test above, but we describe its behaviour using Mockito's @Mock and
    //when/thenReturn syntax
    @Test
    public void checkIfTaskWasSolvedCorrectlyUsingMockito() {
        //TaskDao taskDaoMocked = mock(TaskDao.class); - this is an old-fashioned way of creating mock
        //usually we use @Mock annotation instead.
        when(taskDaoMocked.getById(1L)).thenReturn(new Task("some task to be solved", 100, 5));

        TestsService testsService = new TestsService(taskDaoMocked);

        PerformedTask performedTask = testsService.submitTask(1L, 1L, 98);

        /* verify if method was invoked - this is the thing I forgot to mention on exercise/lectures
            It enables us to check if a method was invoked and how many times
         */
        verify(taskDaoMocked, times(1)).getById(1);
        assertTrue(performedTask.isPassed());
    }

    //This using Spy in Mockito - see more at: https://www.baeldung.com/mockito-spy
    @Test
    public void checkIfTaskWasSolvedCorrectlyUsingMockitoSpy() {
        doReturn(new Task("some task to be solved", 100, 5))
                .when(taskDaoToBeSpied).getById(1L);
        TestsService testsService = new TestsService(taskDaoToBeSpied);

        PerformedTask performedTask = testsService.submitTask(1L, 1L, 98);

        assertTrue(performedTask.isPassed());
    }

    //TODO write test using @Mock which checks the case when Task was not solved correctly
}
