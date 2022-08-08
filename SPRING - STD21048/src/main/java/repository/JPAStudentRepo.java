package repository;

import model.Student;

import java.util.List;

public interface JPAStudentRepo {
    List<Student> findAll();

    Student save(Student s);

  

    void deleteById(Long a);

    Object findById(Long id);
}
