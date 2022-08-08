package repository.implementation.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.Student;
import org.springframework.stereotype.Service;
import repository.JPAStudentRepo;

import java.util.List;

@Service
@AllArgsConstructor
@Getter
public class JPAStudentsImplementation {
    private JPAStudentRepo repoJPA;
    public List<Student> getRepoJPA(){
        return repoJPA.findAll();
    }
    public Student add(Student s){
        return repoJPA.save(s);
    }
    public void deleteById(Long a){
        repoJPA.deleteById(a);
    }

    public Student updateNameById(Long id,String newName){
        Student str = new Student();

        repoJPA.save(new Student(newName));
        return str;
    }

}
