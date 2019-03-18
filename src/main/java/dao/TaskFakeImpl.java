package dao;

import model.Task;

public class TaskFakeImpl implements TaskDao {

    @Override
    public Task getById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Task save(Task task) {
        throw new UnsupportedOperationException();
    }

}