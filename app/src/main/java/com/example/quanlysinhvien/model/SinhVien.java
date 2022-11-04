package com.example.quanlysinhvien.model;

public class SinhVien {
    private int MaSV62;
    private String TenSV62;
    private int GioiTinh62;
    private String DienThoai62;
    private String Email62;

    public SinhVien() {
    }

    public SinhVien(String TenSV62, int GioiTinh62, String DienThoai62, String Email62) {
        TenSV62 = TenSV62;
        GioiTinh62 = GioiTinh62;
        DienThoai62 = DienThoai62;
        Email62 = Email62;
    }

    public SinhVien(int MaSV62, String TenSV62, int GioiTinh62, String DienThoai62, String Email62) {
        MaSV62 = MaSV62;
        TenSV62 = TenSV62;
        GioiTinh62 = GioiTinh62;
        DienThoai62 = DienThoai62;
        Email62 = Email62;
    }

    public int getMaSV62() {
        return MaSV62;
    }

    public void setMaSV62(int MaSV62) {
        MaSV62 = MaSV62;
    }

    public String getTenSV62() {
        return TenSV62;
    }

    public void setTenSV62(String TenSV62) {
        TenSV62 = TenSV62;
    }

    public int getGioiTinh62() {
        return GioiTinh62;
    }

    public void setGioiTinh62(int GioiTinh62) {
        GioiTinh62 = GioiTinh62;
    }

    public String getDienThoai62() {
        return DienThoai62;
    }

    public void setDienThoai62(String DienThoai62) {
        DienThoai62 = DienThoai62;
    }

    public String getEmail62() {
        return Email62;
    }

    public void setEmail62(String Email62) {
        Email62 = Email62;
    }
}
