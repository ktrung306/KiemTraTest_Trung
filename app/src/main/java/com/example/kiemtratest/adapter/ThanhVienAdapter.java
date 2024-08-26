package com.example.kiemtratest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kiemtratest.R;
import com.example.kiemtratest.ThanhVienActivity;
import com.example.kiemtratest.model.ThanhVien;


import java.util.ArrayList;

public class ThanhVienAdapter extends ArrayAdapter<ThanhVien> {
    //Khai báo
    private Context context;
    ThanhVienActivity thanhvien;
    private ArrayList<ThanhVien> lists;
    TextView tvMaTV, tvTenTV, tvSoDienThoai, tvDanhGia;

    //Tạo hàm constructor
    public ThanhVienAdapter(@NonNull Context context, ThanhVienActivity thanhvien, ArrayList<ThanhVien> lists) {
        super(context, 0, lists);
        this.context = context;
        this.thanhvien = thanhvien;
        this.lists = lists;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Khai báo
        View v = convertView;
        //Đk == null
        if(v == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //Lấy item thanh_vien_item
            v = inflater.inflate(R.layout.thanh_vien_item,null);
        }
        //Khai báo thành viên
        final ThanhVien item = lists.get(position);
        //Đk
        if(item != null) {
            tvMaTV = v.findViewById(R.id.tvMaTV);
            //hiển thị dữ liệu lên từng item
            tvMaTV.setText("STT: "+item.getMaTV());
            tvTenTV = v.findViewById(R.id.tvTenTV);
            tvTenTV.setText("Username: "+item.getHoTen());
            tvSoDienThoai = v.findViewById(R.id.tvSoDienThoai);
            tvSoDienThoai.setText("Phone: "+item.getSoDienThoai());
            tvDanhGia = v.findViewById(R.id.tvDanhGia);
            tvDanhGia.setText("Đánh giá phần mềm: "+item.getDanhGia());
        }
        return v;
    }
}
