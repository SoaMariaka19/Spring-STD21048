package repository;

import model.Groups;
import model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

    static void save(Groups groups) {
    }
}
