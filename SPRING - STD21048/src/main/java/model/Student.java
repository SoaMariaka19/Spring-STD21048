package model;

import lombok.*;
import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
//@Table(name = "student")
public class Student  {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column (name = "name")
    private String name;

    public Student(String name, Groups groups){
        this.name = name;
        this.groups = groups ;
    }

    public Student(String name){
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "groups_id")
    private Groups groups;

    public Long getId(Long id){
        return id;
    }

}
