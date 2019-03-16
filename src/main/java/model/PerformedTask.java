package model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerformedTask that = (PerformedTask) o;
        return taskId == that.taskId &&
                studentId == that.studentId &&
                Double.compare(that.calculatedResult, calculatedResult) == 0 &&
                passed == that.passed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, studentId, calculatedResult, passed);
    }
}
