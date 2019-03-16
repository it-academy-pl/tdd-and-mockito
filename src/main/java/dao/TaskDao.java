package dao;

import model.Task;

public interface TaskDao {
    public Task getById(long id);

    public Task save(Task task) throws UnsupportedOperationException;
}
