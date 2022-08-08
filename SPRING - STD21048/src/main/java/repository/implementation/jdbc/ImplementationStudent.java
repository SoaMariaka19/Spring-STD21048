package repository.implementation.jdbc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import model.Groups;
import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import repository.StudentRepository;
import repository.StudentSimpleRepo;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;
import java.util.Optional;

@Service
@Controller
@AllArgsConstructor
@Getter
@NoArgsConstructor

public class ImplementationStudent extends ConnectionDatabase implements StudentSimpleRepo{
    StudentRepository studentRepository;
    ConnectionDatabase conn = new ConnectionDatabase() {
        @Override
        public Student save() {
            return null;
        }

        @Override
        public Optional<Student> findById(Long id) {
            return Optional.empty();
        }

        @Override
        public String add(Student s) throws SQLException {
            return null;
        }

        @Override
        public Student updateNameById(Long id, String newName) {
            return null;
        }

        @Override
        public List<Student> findWhereNameLike(String query) {
            return null;
        }
    };
    StudentSimpleRepo studentSimpleRepo;

    public List<Student> findAll() throws SQLException {
        Statement stm = conn.getStatement();
        ResultSet rs;
        List<Student> studentList = new ArrayList<>();
        try {
            rs = stm.executeQuery("" +
                    "SELECT student.id,student.name,student.group_id,creation_date,groups.name AS name_groups " +
                    " FROM student " +
                    "INNER JOIN Groups " +
                    "ON group.id = student.group_id ");

            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");

                Long group_id = rs.getLong("id");
                String group_name = rs.getString("name_group");
                Date creationDate = rs.getDate("creation_date");
                studentList.add(new Student(id, name, new Groups(group_id, group_name, ((java.sql.Date) creationDate).toLocalDate())));

            }
            return studentList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Request failed");
        }
        return null;

    }

    @Override
    public Student save() {
        return null;
    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String add(Student s) throws SQLException {
        Statement stm = conn.getStatement();
        try{
            StudentRepository.save(s.getGroups());
            String choix = "INSERT INTO Student VALUES ("+s.getName()+","+s.getId()+","+s.getGroups().getId()+");";
            stm.executeUpdate(choix);
            System.out.println("Insert reussi");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Insert failed");
        }
        return null;
    }
    @Override
    public void deleteById(Long a) throws SQLException {
        Statement stm = conn.getStatement();
        String rep = "" +
                "DELETE FROM student WHERE student.id="+a+";";
        try{
            //StudentRepository.deleteById(a);
            stm.executeUpdate(rep);
            System.out.println("Delete reussi");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Student updateNameById(Long id, String newName){
        return null;
    }

    @Override
    public List<Student> findWhereNameLike(String query){
        return StudentSimpleRepo.findWhereNameLike(query);
    }
}
