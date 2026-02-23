package model;

import utils.DbUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PatientDAO {

    public boolean insertPatient(int userId, String name, String phone, String address) {

        String sql = "INSERT INTO Patients(user_id, name, phone, address) VALUES (?, ?, ?, ?)";

        try (Connection conn = DbUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, address);

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}