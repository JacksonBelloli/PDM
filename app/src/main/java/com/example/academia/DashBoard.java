package com.example.academia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DashBoard extends AppCompatActivity {

    private TextView nStudents;
    private TextView nModalities;
    private TextView nPayments;
    private Button btnMenu;

    /**
     * Get elements from XML
     */
    private void getContext() {
        this.nStudents = findViewById(R.id.nStudents);
        this.nModalities = findViewById(R.id.nModalities);
        this.nPayments = findViewById(R.id.nPayments);
        this.btnMenu = findViewById(R.id.btnMenu);
    }

    private void refreshValues() {

        Integer students = 12;
        this.nStudents.setText(students.toString());
        Integer modalities = 17;
        this.nModalities.setText(modalities.toString());
        //TODO FORMAT
        Double payment = 14.32;
        this.nPayments.setText(payment.toString());

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        getContext();
        refreshValues();

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(DashBoard.this, Menu.class);
                startActivity(it);
            }
        });

        return;
    }

}
