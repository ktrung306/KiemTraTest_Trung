package com.example.kiemtratest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class StatisticSoftwareErrorsActivity extends AppCompatActivity {
    PieChart pieChart;
    private ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_statistic_software_errors);
        pieChart = findViewById(R.id.pieChar);
        imgBack = findViewById(R.id.imgBack1);

        ArrayList<PieEntry> visitors = new ArrayList<>();
        visitors.add(new PieEntry(20, "Lỗi đồng bộ"));
        visitors.add(new PieEntry(30, "Lỗi tìm kiếm"));
        visitors.add(new PieEntry(10, "Lỗi hành ảnh "));
        visitors.add(new PieEntry(50, "Lỗi phát video"));

        PieDataSet pieDataSet = new PieDataSet(visitors, "Visitors");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Lỗi thường gặp");
        pieChart.animate();

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StatisticSoftwareErrorsActivity.this, MainActivity.class));
            }
        });
    }

}