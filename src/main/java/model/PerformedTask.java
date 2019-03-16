package model;

public class PerformedTask {
    private long id;
    private long taskId;
    private long studentId;
    private double calculatedResult;
    private boolean passed;

    public PerformedTask(long taskId, long studentId, double calculatedResult, boolean passed) {
        this.taskId = taskId;
        this.studentId = studentId;
        this.calculatedResult = calculatedResult;
        this.passed = passed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public double getCalculatedResult() {
        return calculatedResult;
    }

    public void setCalculatedResult(double calculatedResult) {
        this.calculatedResult = calculatedResult;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
