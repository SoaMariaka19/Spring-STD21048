package repository;

import model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentSimpleRepo {
     List<Student> findAll() throws SQLException;//select *

     String add(Student s) throws SQLException;

     void deleteById(Long a) throws SQLException;

     Student updateNameById(Long id,String newName);

     @Query(value = "SELECT * FROM student WHERE student.name LIKE %(:id)%")
     static List<Student> findWhereNameLike(String query) {
          return null;
     }
}
