package com.example.quanlysinhvien;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        sinhVienAdapter62 = new SinhVienAdapter(getApplicationContext(), sinhVienList62);
        lvSinhVien62.setAdapter(sinhVienAdapter62);

        //Set event for listview
        lvSinhVien62.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent62 = new Intent(MainActivity.this, FormSinhVienActivity.class);
            intent62.putExtra("sinhvien", sinhVienList62.get(i));
            startActivity(intent62);
        });

        //Set event for listview delete with dialog
        lvSinhVien62.setOnItemLongClickListener((adapterView, view, i, l) -> {
            AlertDialog.Builder builder62 = new AlertDialog.Builder(MainActivity.this);
            builder62.setTitle("Xác nhận xóa");
            builder62.setMessage("Bạn có chắc chắn muốn xóa sinh viên này không?");
            builder62.setPositiveButton("Có", (dialogInterface, i1) -> {
                SinhVien sinhVien62 = sinhVienList62.get(i);
                sinhVienDAO62.deleteSinhVien(sinhVien62.getMaSV62());
                sinhVienList62.remove(i);
                sinhVienAdapter62.notifyDataSetChanged();
            });
            builder62.setNegativeButton("Không", (dialogInterface, i12) -> dialogInterface.cancel());
            builder62.show();
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        sinhVienList62.clear();
        sinhVienList62.addAll(sinhVienDAO62.getAllSinhVien());
        sinhVienAdapter62.notifyDataSetChanged();
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