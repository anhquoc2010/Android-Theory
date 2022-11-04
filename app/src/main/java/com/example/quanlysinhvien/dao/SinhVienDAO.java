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
        String sql = "SELECT * FROM SinhVien";
        List<SinhVien> sinhVienList62 = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            SinhVien sinhVien62 = new SinhVien();
            sinhVien62.setMaSV62(cursor.getInt(0));
            sinhVien62.setTenSV62(cursor.getString(1));
            sinhVien62.setGioiTinh62(cursor.getInt(2));
            sinhVien62.setDienThoai62(cursor.getString(3));
            sinhVien62.setEmail62(cursor.getString(4));
            sinhVienList62.add(sinhVien62);
            cursor.moveToNext();
        }
        cursor.close();
        return sinhVienList62;
    }
}
