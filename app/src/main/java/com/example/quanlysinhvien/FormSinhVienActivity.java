package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.quanlysinhvien.dao.SinhVienDAO;
import com.example.quanlysinhvien.databinding.ActivityFormSinhVienBinding;
import com.example.quanlysinhvien.model.SinhVien;

public class FormSinhVienActivity extends AppCompatActivity {

    private ActivityFormSinhVienBinding binding62;
    private SinhVienDAO sinhVienDAO62;
    private int gender62 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding62 = ActivityFormSinhVienBinding.inflate(getLayoutInflater());
        setContentView(binding62.getRoot());

        Intent intent62 = getIntent();
        SinhVien sinhVien62 = (SinhVien) intent62.getSerializableExtra("sinhvien");
        if (sinhVien62 != null) {
            binding62.btnAdd62.setText(getString(R.string.update));
            binding62.btnAdd62.setTag("update");
            binding62.etName62.setText(sinhVien62.getTenSV62());
            binding62.etMail62.setText(sinhVien62.getEmail62());
            binding62.etPhone62.setText(sinhVien62.getDienThoai62());
            if (sinhVien62.getGioiTinh62() == 1) {
                binding62.rgGender62.check(R.id.rb_male62);
                gender62 = 1;
            } else {
                binding62.rgGender62.check(R.id.rb_female62);
                gender62 = 0;
            }
        }

        sinhVienDAO62 = new SinhVienDAO(FormSinhVienActivity.this);

        binding62.rgGender62.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.rb_male62) {
                gender62 = 1;
            } else {
                gender62 = 0;
            }
        });

        binding62.btnAdd62.setOnClickListener(view -> {
            if (binding62.btnAdd62.getTag() == "update" && sinhVien62 != null) {
                sinhVien62.setTenSV62(binding62.etName62.getText().toString());
                sinhVien62.setEmail62(binding62.etMail62.getText().toString());
                sinhVien62.setDienThoai62(binding62.etPhone62.getText().toString());
                sinhVien62.setGioiTinh62(gender62);
                sinhVienDAO62.updateSinhVien(sinhVien62);
                finish();
            } else {
                String name62 = binding62.etName62.getText().toString();
                String phone62 = binding62.etPhone62.getText().toString();
                String email62 = binding62.etMail62.getText().toString();

                sinhVienDAO62.insertSinhVien(new SinhVien(name62, gender62, phone62, email62));

                binding62.etName62.setText("");
                binding62.etPhone62.setText("");
                binding62.etMail62.setText("");
            }
        });

        binding62.btnOut62.setOnClickListener(v -> finish());
    }
}