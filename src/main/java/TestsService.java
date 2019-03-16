import dao.TaskDao;
import model.PerformedTask;
import model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestsService {
    final Logger logger = LoggerFactory.getLogger(Calculator.class);

    private TaskDao taskDao;

    // We set here generic interface TaskDao, but we can pass/inject
    // here any subclass of TaskDao. This is also called dependency injection
    // "Dependendiwhatsit?" - There is good article on that :)
    // https://www.jamesshore.com/Blog/Dependency-Injection-Demystified.html
    // which explains why it is handy in isolating classes in context of unit testing
    public TestsService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }


    public PerformedTask submitTask(long studentId, long taskId, double calculatedResult) {
        logger.info("Submitting task for studentId {} taskId {} and calculated result {}", studentId, taskId, calculatedResult);
        Task task = taskDao.getById(taskId);
        boolean isPassed = calculateIfResultIsCorrect(task.getExpectedResult(), calculatedResult, task.getMarginOfError());
        //TODO(instead of just returning object here, we have to save it to the database)
        return new PerformedTask(taskId, studentId, calculatedResult, isPassed);
    }

    private boolean calculateIfResultIsCorrect(double expectedResult, double calculatedResult, double marginOfError) {
        double min = expectedResult - (expectedResult * (marginOfError / 100));
        double max = expectedResult + (expectedResult * (marginOfError / 100));
        return calculatedResult < max && calculatedResult > min;
    }
}
