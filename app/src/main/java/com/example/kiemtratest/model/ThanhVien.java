package com.example.kiemtratest.model;

public class ThanhVien {
    private  int maTV;
    private  String hoTen;
    private String soDienThoai;
    private String danhGia;

    public ThanhVien() {
    }

    public ThanhVien(int maTV, String hoTen, String soDienThoai, String danhGia) {
        this.maTV = maTV;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.danhGia = danhGia;
    }

    public int getMaTV() {
        return maTV;
    }

    public void setMaTV(int maTV) {
        this.maTV = maTV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    @Override
    public String toString() {
        return "ThanhVien{" +
                "maTV=" + maTV +
                ", hoTen='" + hoTen + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", danhGia='" + danhGia + '\'' +
                '}';
    }
}
