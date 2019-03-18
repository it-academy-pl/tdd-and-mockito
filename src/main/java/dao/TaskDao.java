package dao;

import model.Task;

public interface TaskDao {

    Task getById(long id);

    Task save(Task task) throws UnsupportedOperationException;

}
