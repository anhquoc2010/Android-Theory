package com.example.quanlysinhvien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlysinhvien.R;
import com.example.quanlysinhvien.model.SinhVien;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {

    private List<SinhVien> sinhVienList62;
    private Context context62;

    public SinhVienAdapter(Context context62, List<SinhVien> sinhVienList62) {
        this.context62 = context62;
        this.sinhVienList62 = sinhVienList62;
    }

    @Override
    public int getCount() {
        return sinhVienList62.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder62;
        if (view == null) {
            viewHolder62 = new ViewHolder();
            //Convert resource layout to view
            LayoutInflater inflater62 = (LayoutInflater) context62.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater62.inflate(R.layout.layout_item, null);
            //Get view from layout
            viewHolder62.ivGender62 = view.findViewById(R.id.iv_gender62);
            viewHolder62.tvMaSV62 = view.findViewById(R.id.tv_msv62);
            viewHolder62.tvTenSV62 = view.findViewById(R.id.tv_name62);
            viewHolder62.tvSDT62 = view.findViewById(R.id.tv_phone62);
            viewHolder62.tvMail62 = view.findViewById(R.id.tv_mail62);
            view.setTag(viewHolder62);
        } else {
            viewHolder62 = (ViewHolder) view.getTag();
        }
        //Set value for view
        SinhVien sinhVien = sinhVienList62.get(i);
        if (sinhVien.getGioiTinh62() == 0) {
            viewHolder62.ivGender62.setImageResource(R.drawable.female);
        } else {
            viewHolder62.ivGender62.setImageResource(R.drawable.male);
        }
        viewHolder62.tvMaSV62.setText("Mã SV: " + sinhVien.getMaSV62());
        viewHolder62.tvTenSV62.setText("Họ tên: " + sinhVien.getTenSV62());
        viewHolder62.tvSDT62.setText("SĐT: " + sinhVien.getDienThoai62());
        viewHolder62.tvMail62.setText("Email: " + sinhVien.getEmail62());
        return view;
    }

    class ViewHolder {
        ImageView ivGender62;
        TextView tvMaSV62, tvTenSV62, tvSDT62, tvMail62;
    }
}
