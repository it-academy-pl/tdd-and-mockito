import dao.TaskDao;
import model.PerformedTask;
import model.Task;

public class TestsService {

    private TaskDao taskDao;

    public TestsService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public PerformedTask submitTask(long studentId, long taskId, double calculatedResult) {
        Task task = taskDao.getById(taskId);
        boolean isPassed = calculateIfResultIsCorrect(task.getExpectedResult(), calculatedResult, task.getMarginOfError());
        //TODO(instead of just returning object here, we have to save it to the database)
        return new PerformedTask(taskId, studentId, calculatedResult, isPassed);
    }

    private boolean calculateIfResultIsCorrect(double expectedResult, double calculatedResult, int marginOfError) {
        double min = expectedResult-(expectedResult*(marginOfError/100));
        double max = expectedResult+(expectedResult*(marginOfError/100));
        if(calculatedResult<max && calculatedResult>min) {
            return true;
        } else {
            return false;
        }
    }
}
