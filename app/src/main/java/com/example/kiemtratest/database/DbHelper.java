package com.example.kiemtratest.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    // Biến final là hằng số
    private static final String DB_NAME = "DuAn";
    private static final int DB_VERSION = 1;

    //Khai báo các Bảng
    static final String CREATE_TABLE_THU_THU =
            "create table ThuThu (maTT TEXT PRIMARY KEY," +
                    "hoTen  TEXT NOT NULL, " +
                    "matKhau TEXT NOT NULL)";

    //
    static final String CREATE_TABLE_THANH_VIEN =
            "create table ThanhVien (" +
                    "maTV INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "hoTen TEXT NOT NULL, " +
                    "soDienThoai TEXT NOT NULL," +
                    "danhGia TEXT NOT NULL)";
    //Tạo hàm Constructor
    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //Tạo các table trong database
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Tao bang Thu Thu
        db.execSQL(CREATE_TABLE_THU_THU);
        //Tao bang Thanh vien
        db.execSQL(CREATE_TABLE_THANH_VIEN);

        //insert dữ liệu mẫu
        db.execSQL(Data_SQLite.INSERT_THU_THU);
        db.execSQL(Data_SQLite.INSERT_THANH_VIEN);

    }

    //gọi hàm onUpgrade khi cập nhật dữ liệu bảng
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableLoaiThuThu = "drop table if exists ThuThu";
        db.execSQL(dropTableLoaiThuThu);
        String dropTableLoaiThanhVien = "drop table if exists ThanhVien";
        db.execSQL(dropTableLoaiThanhVien);
        //tạo lại dữ liệu database
        onCreate(db);
    }
}
