package com.example.quanlysinhvien.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlysinhvien.database.DbHelper;
import com.example.quanlysinhvien.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {

    private DbHelper dbHelper62;

    public SinhVienDAO(Context context) {
        dbHelper62 = new DbHelper(context);
    }

    //Lấy tất cả sinh viên
    public List<SinhVien> getAllSinhVien() {
        String sql62 = "SELECT * FROM SINHVIEN";
        List<SinhVien> sinhVienList62 = new ArrayList<>();
        SQLiteDatabase db62 = dbHelper62.getReadableDatabase();
        Cursor cursor = db62.rawQuery(sql62, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int masv62 = cursor.getInt(0);
            String hoten62 = cursor.getString(1);
            int gioitinh62 = cursor.getInt(2);
            String dienthoai62 = cursor.getString(3);
            String email62 = cursor.getString(4);
            SinhVien sinhVien62 = new SinhVien(masv62, hoten62, gioitinh62, dienthoai62, email62);
            sinhVienList62.add(sinhVien62);
            cursor.moveToNext();
        }
        cursor.close();
        return sinhVienList62;
    }
    
    //Thêm sinh viên
    public void insertSinhVien(SinhVien sinhVien62) {
        //C1: Dùng SQLiteStatement
//        SQLiteDatabase db62 = dbHelper62.getWritableDatabase();
//        String sqlInsert62 = "INSERT INTO SINHVIEN (HOTEN, GIOITINH, DIENTHOAI, EMAIL) VALUES ('" + sinhVien62.getTenSV62() + "', " + sinhVien62.getGioiTinh62() + ", '" + sinhVien62.getDienThoai62() + "', '" + sinhVien62.getEmail62() + "')";
//        db62.execSQL(sqlInsert62);

        //C2: Dùng SQLiteQueryBuilder
//        SQLiteDatabase db62 = dbHelper62.getWritableDatabase();
//        String sqlInsert62 = "INSERT INTO SINHVIEN (HOTEN, GIOITINH, DIENTHOAI, EMAIL) VALUES (?, ?, ?, ?)";
//        db62.execSQL(sqlInsert62, new String[]{sinhVien62.getTenSV62(), String.valueOf(sinhVien62.getGioiTinh62()), sinhVien62.getDienThoai62(), sinhVien62.getEmail62()});

        //C3: Dùng ContentValues
        SQLiteDatabase db62 = dbHelper62.getWritableDatabase();

        ContentValues values62 = new ContentValues();
        values62.put("HOTEN", sinhVien62.getTenSV62());
        values62.put("GIOITINH", sinhVien62.getGioiTinh62());
        values62.put("DIENTHOAI", sinhVien62.getDienThoai62());
        values62.put("EMAIL", sinhVien62.getEmail62());

        db62.insert("SINHVIEN", null, values62);
    }

    //Cập nhật sinh viên
    public void updateSinhVien(SinhVien sinhVien62) {
        SQLiteDatabase db62 = dbHelper62.getWritableDatabase();

        ContentValues values62 = new ContentValues();
        values62.put("HOTEN", sinhVien62.getTenSV62());
        values62.put("EMAIL", sinhVien62.getEmail62());
        values62.put("DIENTHOAI", sinhVien62.getDienThoai62());
        values62.put("GIOITINH", sinhVien62.getGioiTinh62());

        db62.update("SINHVIEN", values62, "MASV = ?", new String[]{String.valueOf(sinhVien62.getMaSV62())});
    }

    //Xóa sinh viên
    public void deleteSinhVien(int maSV62) {
        SQLiteDatabase db62 = dbHelper62.getWritableDatabase();
        db62.delete("SINHVIEN", "MASV = ?", new String[]{String.valueOf(maSV62)});
    }

    //Lấy mã sinh viên lớn nhất
    public int getMaxMaSV() {
        String sql62 = "SELECT MAX(MASV) FROM SINHVIEN";
        SQLiteDatabase db62 = dbHelper62.getReadableDatabase();
        Cursor cursor = db62.rawQuery(sql62, null);
        cursor.moveToFirst();
        int maxMaSV62 = cursor.getInt(0);
        cursor.close();
        return maxMaSV62;
    }
}
