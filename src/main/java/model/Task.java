package model;

import java.util.Objects;

public class Task {

    private long id;
    private String description;
    private double expectedResult;
    private double marginOfError;

    public Task(String description, double expectedResult, int marginOfError) {
        this.description = description;
        this.expectedResult = expectedResult;
        this.marginOfError = marginOfError;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(double expectedResult) {
        this.expectedResult = expectedResult;
    }

    public double getMarginOfError() {
        return marginOfError;
    }

    public void setMarginOfError(double marginOfError) {
        this.marginOfError = marginOfError;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Double.compare(task.expectedResult, expectedResult) == 0 &&
                Double.compare(task.marginOfError, marginOfError) == 0 &&
                Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, expectedResult, marginOfError);
    }

}
