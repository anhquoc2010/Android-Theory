package com.example.quanlysinhvien.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlysinhvien.database.DbHelper;
import com.example.quanlysinhvien.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {

    private DbHelper dbHelper;

    public SinhVienDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    //Lấy tất cả sinh viên
    public List<SinhVien> getAllSinhVien() {
        String sql = "SELECT * FROM SINHVIEN";
        List<SinhVien> sinhVienList62 = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
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
}
