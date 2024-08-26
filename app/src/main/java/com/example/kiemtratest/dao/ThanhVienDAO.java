package com.example.kiemtratest.dao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.kiemtratest.database.DbHelper;
import com.example.kiemtratest.model.ThanhVien;

import java.util.ArrayList;
import java.util.List;

public class ThanhVienDAO {
    //Khai báo
    private SQLiteDatabase db;

    //Tạo hàm Constructor
    public ThanhVienDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //Hiển thị dữ liệu Thành viên
    @SuppressLint("Range")
    public List<ThanhVien> getData(String sql, String...selectionArgs) {
        List<ThanhVien> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql, selectionArgs);
        while (c.moveToNext()) {
            ThanhVien obj = new ThanhVien();
            obj.setMaTV(Integer.parseInt(c.getString(c.getColumnIndex("maTV"))));
            obj.setHoTen(c.getString(c.getColumnIndex("hoTen")));
            obj.setSoDienThoai(c.getString(c.getColumnIndex("soDienThoai")));
            obj.setDanhGia(c.getString(c.getColumnIndex("danhGia")));
            Log.i("//=======", obj.toString());
            list.add(obj);
        }
        return list;
    }
    //get tat ca dữ liệu
    public  List<ThanhVien> getAll() {
        String sql = "SELECT * FROM ThanhVien";
        return getData(sql);
    }
    //get dữ liệu theo id
    public  ThanhVien getID(String id) {
        String sql = "SELECT * FROM ThanhVien WHERE maTV=?";
        List<ThanhVien> list = getData(sql, id);
        return list.get(0);
    }
}
