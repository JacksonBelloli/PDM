package com.example.academia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    private Button btnDashboard;
    private Button btnStudents;
    private Button btnMatriculation;
    private Button btnGraduation;
    private Button btnPlans;
    private Button btnModality;


    private void getContext() {
        this.btnDashboard = findViewById(R.id.btnDashboard);
        this.btnStudents = findViewById(R.id.btnStudents);
        this.btnMatriculation = findViewById(R.id.btnMatriculation);
        this.btnGraduation = findViewById(R.id.btnGraduation);
        this.btnPlans = findViewById(R.id.btnPlans);
        this.btnModality = findViewById(R.id.btnModality);
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        getContext();

        btnDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Menu.this, DashBoard.class);
                startActivity(it);
            }
        });

        btnStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Menu.this, ListingView.class);
                it.putExtra("name", "student");
                startActivity(it);
            }
        });

        btnMatriculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Menu.this, ListingView.class);
                it.putExtra("name", "matriculation");
                startActivity(it);
            }
        });
        btnGraduation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Menu.this, ListingView.class);
                it.putExtra("name", "graduation");
                startActivity(it);
            }
        });
        btnPlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Menu.this, ListingView.class);
                it.putExtra("name", "plan");
                startActivity(it);
            }
        });
        btnModality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Menu.this, ListingView.class);
                it.putExtra("name", "modality");
                startActivity(it);
            }
        });
    }

}
