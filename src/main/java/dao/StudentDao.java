package dao;

import model.Student;

public interface StudentDao {

    StudentDao getById(long id);

    StudentDao save(Student student);

}
