package kr.hnu.ice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO {
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/mywebdb?useUnicode=true&characterEncoding=utf8";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static final String DB_DRIVER = "org.mariadb.jdbc.Driver";

    public Connection connect() throws SQLException, ClassNotFoundException {
        if (DB_DRIVER != null && !DB_DRIVER.isEmpty()) {
            Class.forName(DB_DRIVER);
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void addNews(News news) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO news (title, img, content) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, news.getTitle());
            ps.setString(2, news.getImg());
            ps.setString(3, news.getContent());
            ps.executeUpdate();
        }
    }

    public List<News> getAll() throws SQLException, ClassNotFoundException {
        List<News> list = new ArrayList<>();
        String sql = "SELECT aid, title, img, DATE_FORMAT(date, '%Y-%m-%d %H:%i:%s') AS cdate, content FROM news ORDER BY aid DESC";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                News news = new News();
                news.setAid(rs.getInt("aid"));
                news.setTitle(rs.getString("title"));
                news.setImg(rs.getString("img"));
                news.setDate(rs.getString("cdate"));
                news.setContent(rs.getString("content"));
                list.add(news);
            }
        }
        return list;
    }

    public News getNews(int aid) throws SQLException, ClassNotFoundException {
        String sql = "SELECT aid, title, img, DATE_FORMAT(date, '%Y-%m-%d %H:%i:%s') AS cdate, content FROM news WHERE aid = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, aid);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    News news = new News();
                    news.setAid(rs.getInt("aid"));
                    news.setTitle(rs.getString("title"));
                    news.setImg(rs.getString("img"));
                    news.setDate(rs.getString("cdate"));
                    news.setContent(rs.getString("content"));
                    return news;
                }
            }
        }
        return null;
    }

    public void delNews(int aid) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM news WHERE aid = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, aid);
            int affected = ps.executeUpdate();
            if (affected == 0) {
                throw new SQLException("No rows deleted for aid: " + aid);
            }
        }
    }

    public void updateNews(News news) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE news SET title = ?, img = ?, content = ? WHERE aid = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, news.getTitle());
            ps.setString(2, news.getImg());
            ps.setString(3, news.getContent());
            ps.setInt(4, news.getAid());
            int affected = ps.executeUpdate();
            if (affected == 0) {
                throw new SQLException("No rows updated for aid: " + news.getAid());
            }
        }
    }
}
