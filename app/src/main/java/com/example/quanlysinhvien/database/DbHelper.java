package com.example.quanlysinhvien.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, "QLSV.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlSVCreate62 = "CREATE TABLE SINHVIEN (MASV INTEGER PRIMARY KEY AUTOINCREMENT, HOTEN TEXT, GIOITINH INTEGER, DIENTHOAI TEXT, EMAIL TEXT)";
        sqLiteDatabase.execSQL(sqlSVCreate62);

        String sqlInsert62 = "INSERT INTO SINHVIEN (HOTEN, GIOITINH, DIENTHOAI, EMAIL) VALUES ('Lê Anh Quốc', 1, '2050531200262', '2050531200262@sv.ute.udn.vn')";
        String sqlInsert162 = "INSERT INTO SINHVIEN (HOTEN, GIOITINH, DIENTHOAI, EMAIL) VALUES ('Trần Thị Hường', 0, '2050531200262', '2050531200262@sv.ute.udn.vn')";
        String sqlInsert262 = "INSERT INTO SINHVIEN (HOTEN, GIOITINH, DIENTHOAI, EMAIL) VALUES ('Lê Văn Nâu', 1, '2050531200262', '2050531200262@sv.ute.udn.vn')";
        String sqlInsert362 = "INSERT INTO SINHVIEN (HOTEN, GIOITINH, DIENTHOAI, EMAIL) VALUES ('Nguyễn Thị Vàng', 0, '2050531200262', '2050531200262@sv.ute.udn.vn')";
        String sqlInsert462 = "INSERT INTO SINHVIEN (HOTEN, GIOITINH, DIENTHOAI, EMAIL) VALUES ('Vàng Văn Đỏ', 1, '2050531200262', '2050531200262@sv.ute.udn.vn')";
        sqLiteDatabase.execSQL(sqlInsert62);
        sqLiteDatabase.execSQL(sqlInsert162);
        sqLiteDatabase.execSQL(sqlInsert262);
        sqLiteDatabase.execSQL(sqlInsert362);
        sqLiteDatabase.execSQL(sqlInsert462);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
