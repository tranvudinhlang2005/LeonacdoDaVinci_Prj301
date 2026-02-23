package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import utils.DbUtils;

public class UserDAO {

    public int insertUser(String userName, String email, String password) {
        String sql = "INSERT INTO Users(user_name,email,password_hash,role,is_active) VALUES (?,?,?,?,?)";

        try (Connection conn = DbUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, userName);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, "patient");
            ps.setBoolean(5, true);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // trả về user_id
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}