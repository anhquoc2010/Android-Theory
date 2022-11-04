package com.example.quanlysinhvien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.quanlysinhvien.adapter.SinhVienAdapter;
import com.example.quanlysinhvien.dao.SinhVienDAO;
import com.example.quanlysinhvien.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvSinhVien62;
    private List<SinhVien> sinhVienList62;
    private SinhVienAdapter sinhVienAdapter62;
    private SinhVienDAO sinhVienDAO62;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get view from layout
        lvSinhVien62 = findViewById(R.id.lv_sinhvien62);

        //Get data from database
        sinhVienList62 = new ArrayList<>();
        sinhVienDAO62 = new SinhVienDAO(MainActivity.this);
        sinhVienList62 = sinhVienDAO62.getAllSinhVien();

        //Set adapter for listview
        sinhVienAdapter62 = new SinhVienAdapter(MainActivity.this, sinhVienList62);
        lvSinhVien62.setAdapter(sinhVienAdapter62);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id62 = item.getItemId();
        if (id62 == R.id.menu_them) {
            Intent intent62 = new Intent(MainActivity.this, FormSinhVienActivity.class);
            startActivity(intent62);
        }
        if (id62 == R.id.menu_thoat) {
            finish();
        }
        return true;
    }
}