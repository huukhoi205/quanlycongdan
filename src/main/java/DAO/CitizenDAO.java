package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Citizen;
import util.DatabaseConnection;

public class CitizenDAO {
    // Thêm mới công dân
    public boolean addCitizen(Citizen citizen) throws SQLException {
        String sql = "INSERT INTO CongDan (soCCCD, hoTen, tuoi, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, citizen.getSoCCCD());
            stmt.setString(2, citizen.getHoTen());
            stmt.setInt(3, citizen.getTuoi());
            stmt.setString(4, citizen.getEmail());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    // Lấy danh sách tất cả công dân
    public ArrayList<Citizen> getAllCitizens() throws SQLException {
        ArrayList<Citizen> citizens = new ArrayList<>();
        String sql = "SELECT * FROM CongDan";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Citizen citizen = new Citizen();
                citizen.setSoCCCD(rs.getString("soCCCD"));
                citizen.setHoTen(rs.getString("hoTen"));
                citizen.setTuoi(rs.getInt("tuoi"));
                citizen.setEmail(rs.getString("email"));
                citizens.add(citizen);
            }
        }
        return citizens;
    }
}