package com.example.quanlysinhvien.model;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private int MaSV62;
    private String TenSV62;
    private int GioiTinh62;
    private String DienThoai62;
    private String Email62;

    public SinhVien() {
    }

public SinhVien(String tenSV62, int gioiTinh62, String dienThoai62, String email62) {
        TenSV62 = tenSV62;
        GioiTinh62 = gioiTinh62;
        DienThoai62 = dienThoai62;
        Email62 = email62;
    }

    public SinhVien(int maSV62, String tenSV62, int gioiTinh62, String dienThoai62, String email62) {
        MaSV62 = maSV62;
        TenSV62 = tenSV62;
        GioiTinh62 = gioiTinh62;
        DienThoai62 = dienThoai62;
        Email62 = email62;
    }

    public int getMaSV62() {
        return MaSV62;
    }

    public void setMaSV62(int maSV62) {
        MaSV62 = maSV62;
    }

    public String getTenSV62() {
        return TenSV62;
    }

    public void setTenSV62(String tenSV62) {
        TenSV62 = tenSV62;
    }

    public int getGioiTinh62() {
        return GioiTinh62;
    }

    public void setGioiTinh62(int gioiTinh62) {
        GioiTinh62 = gioiTinh62;
    }

    public String getDienThoai62() {
        return DienThoai62;
    }

    public void setDienThoai62(String dienThoai62) {
        DienThoai62 = dienThoai62;
    }

    public String getEmail62() {
        return Email62;
    }

    public void setEmail62(String email62) {
        Email62 = email62;
    }
}
