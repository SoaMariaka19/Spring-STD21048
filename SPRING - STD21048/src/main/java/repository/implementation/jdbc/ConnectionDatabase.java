package repository.implementation.jdbc;

import model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public abstract class ConnectionDatabase {
    Connection connection;

    public ConnectionDatabase(){
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/school","postgres","soamariaka19");
            System.out.println("Connexion reussi");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement() throws SQLException {
        return (Statement) connection.createStatement();
    }

    public abstract Student save();

    public abstract Optional<Student> findById(Long id);

    public abstract String add(Student s) throws SQLException;

    public abstract Student updateNameById(Long id, String newName);

    public abstract List<Student> findWhereNameLike(String query);
}
