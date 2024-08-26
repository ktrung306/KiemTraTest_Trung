package com.example.kiemtratest;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kiemtratest.adapter.ThanhVienAdapter;
import com.example.kiemtratest.dao.ThanhVienDAO;
import com.example.kiemtratest.model.ThanhVien;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ThanhVienActivity extends AppCompatActivity {
    //Khai báo
    ListView lvThanhVien;
    ArrayList<ThanhVien> list;
    private ImageView imgBack;
    static ThanhVienDAO dao;
    ThanhVienAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thanh_vien);

        dao = new ThanhVienDAO(this);
        lvThanhVien = findViewById(R.id.lvThanhVien);
        imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ThanhVienActivity.this, MainActivity.class));
            }
        });
        //Hiển thị dữ liệu lên ListView
        duLieu();
    }
    void duLieu() {
        //gán dữ liệu từ sql vào list
        list = (ArrayList<ThanhVien>) dao.getAll();
        //Khai báo adapter
        adapter = new ThanhVienAdapter(this, this, list);
        //hiển thi dữ liệu lên ListView
        lvThanhVien.setAdapter(adapter);
    }
}