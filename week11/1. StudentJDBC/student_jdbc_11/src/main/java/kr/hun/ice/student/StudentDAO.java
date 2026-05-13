package kr.hun.ice.student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection conn;
    private PreparedStatement pstat;
    private static final String TABLE_NAME = "student1";

    // Configure DB connection here (change values in one place)
    public static final String DB_URL = "jdbc:mariadb://localhost:3306/mywebdb2";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "";
    public static final String DB_DRIVER = "org.mariadb.jdbc.Driver";

    public void connect(String url, String user, String pass) throws SQLException, ClassNotFoundException {
        Class.forName(DB_DRIVER);
        conn = DriverManager.getConnection(url, user, pass);
    }

    /**
     * Connect using DAO's built-in DB_* constants. Change those constants above to reconfigure.
     */
    public void connect() throws SQLException, ClassNotFoundException {
        if (DB_DRIVER != null && !DB_DRIVER.isEmpty()) {
            Class.forName(DB_DRIVER);
        }
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void close() {
        try {
            if (pstat != null) pstat.close();
        } catch (SQLException ignored) {
        }
        try {
            if (conn != null) conn.close();
        } catch (SQLException ignored) {
        }
    }

    public void insert(Student student) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + " (name, univ, birthdate, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getUniv());
            ps.setString(3, student.getBirthdate());
            ps.setString(4, student.getEmail());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    student.setId(rs.getInt(1));
                }
            }
        }
    }

    public List<Student> getAll() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT id, name, univ, birthdate, email FROM " + TABLE_NAME + " ORDER BY id DESC";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setUniv(rs.getString("univ"));
                s.setBirthdate(rs.getString("birthdate"));
                s.setEmail(rs.getString("email"));
                list.add(s);
            }
        }
        return list;
    }

    public Student getById(int id) throws SQLException {
        String sql = "SELECT id, name, univ, birthdate, email FROM " + TABLE_NAME + " WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Student s = new Student();
                    s.setId(rs.getInt("id"));
                    s.setName(rs.getString("name"));
                    s.setUniv(rs.getString("univ"));
                    s.setBirthdate(rs.getString("birthdate"));
                    s.setEmail(rs.getString("email"));
                    return s;
                }
            }
        }
        return null;
    }

    public void update(Student student) throws SQLException {
        String sql = "UPDATE " + TABLE_NAME + " SET name = ?, univ = ?, birthdate = ?, email = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getUniv());
            ps.setString(3, student.getBirthdate());
            ps.setString(4, student.getEmail());
            ps.setInt(5, student.getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
