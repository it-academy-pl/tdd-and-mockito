package dao;

import model.PerformedTask;

public interface PerformedTaskDao {

    PerformedTask getById(long id);

    PerformedTask save(PerformedTask performedTask);

}
