package dao;

import model.PerformedTask;
import model.Task;

public interface PerformedTaskDao {
    public PerformedTask getById(long id);
    public PerformedTask save(PerformedTask performedTask);
}
