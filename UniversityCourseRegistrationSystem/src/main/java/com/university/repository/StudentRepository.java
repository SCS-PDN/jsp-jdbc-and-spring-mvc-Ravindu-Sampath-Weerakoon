package com.university.repository;

import com.university.model.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class StudentRepository {
    public Student validate(String email, String password) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_db", "root", "");
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM students WHERE email=? AND password=?")) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt("student_id"), rs.getString("name"), email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
