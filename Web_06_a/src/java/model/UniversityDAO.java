package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.DbUtils;

/**
 * DAO xử lý các thao tác dữ liệu cho bảng tblUniversity
 */
public class UniversityDAO {

    public UniversityDAO() {
    }

    /**
     * Tìm kiếm chính xác (Dùng cho ID)
     */
    public ArrayList<UniversityDTO> searchByColum(String column, String value) {
        ArrayList<UniversityDTO> result = new ArrayList<>();
        try {
            Connection conn = DbUtils.getConnection();
            String sql = "SELECT * FROM tblUniversity WHERE " + column + "=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, value);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UniversityDTO u = new UniversityDTO(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("shortName"), // Sửa lỗi chính tả cột
                    rs.getString("description"),
                    rs.getInt("foundedYear"),
                    rs.getString("address"),
                    rs.getString("city"),
                    rs.getString("region"),
                    rs.getString("type"),
                    rs.getInt("totalStudents"),
                    rs.getInt("totalFaculties"),
                    rs.getBoolean("isDraft")
                );
                result.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Tìm kiếm tương đối (Dùng cho Name, giúp hiển thị dữ liệu ngay cả khi gõ 1 phần tên)
     */
    public ArrayList<UniversityDTO> filterByColum(String column, String value) {
        ArrayList<UniversityDTO> result = new ArrayList<>();
        try {
            Connection conn = DbUtils.getConnection();
            // Sử dụng LIKE để tìm kiếm tương đối
            String sql = "SELECT * FROM tblUniversity WHERE " + column + " LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            // Thêm dấu % để tìm kiếm chứa chuỗi (contains)
            ps.setString(1, "%" + value + "%");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UniversityDTO u = new UniversityDTO(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("shortName"),
                    rs.getString("description"),
                    rs.getInt("foundedYear"),
                    rs.getString("address"),
                    rs.getString("city"),
                    rs.getString("region"),
                    rs.getString("type"),
                    rs.getInt("totalStudents"),
                    rs.getInt("totalFaculties"),
                    rs.getBoolean("isDraft")
                );
                result.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // --- Các hàm tiện ích gọi từ Controller ---

    public ArrayList<UniversityDTO> searchByID(String ID) {
        return searchByColum("id", ID);
    }

    /**
     * Cập nhật: Luôn dùng filter để tìm theo tên cho linh hoạt
     */
    public ArrayList<UniversityDTO> searchByName(String name) {
        return filterByColum("name", name);
    }

    public ArrayList<UniversityDTO> filterByName(String name) {
        return filterByColum("name", name);
    }
}