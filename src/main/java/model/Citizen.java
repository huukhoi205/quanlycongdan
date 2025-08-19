package model;

public class Citizen {
    private String soCCCD;
    private String hoTen;
    private int tuoi;
    private String email;

    // Getters
    public String getSoCCCD() { return soCCCD; }
    public String getHoTen() { return hoTen; }
    public int getTuoi() { return tuoi; }
    public String getEmail() { return email; }

    // Setters
    public void setSoCCCD(String soCCCD) { this.soCCCD = soCCCD; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public void setTuoi(int tuoi) { this.tuoi = tuoi; }
    public void setEmail(String email) { this.email = email; }
}