package com.example.academia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.academia.dao.DAO;
import com.example.academia.dao.GraduationDAO;
import com.example.academia.dao.MatriculationDAO;
import com.example.academia.dao.ModalityDAO;
import com.example.academia.dao.PlanDAO;
import com.example.academia.dao.StudentDAO;
import com.example.academia.model.Models;
import com.example.academia.model.Plan;
import com.example.academia.model.Student;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndividualView extends AppCompatActivity {

    private Integer id;
    private Button btnStudents;
    private LinearLayout layoutList;
    private String type;
    private Models model;
    private Button btnPlans;
    private Button btnMatriculation;
    private Button btnGraduation;

    private void getContext() {
        this.layoutList = findViewById(R.id.layoutList);
        this.btnStudents = findViewById(R.id.btnStudents);
    }

    private void getType(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                this.type = null;
            } else {
                this.type = extras.getString("name");
                this.id = extras.getInt("id");
            }
        } else {
            this.type = (String) savedInstanceState.getSerializable("name");
            this.id = (Integer) savedInstanceState.getSerializable("id");
        }
    }


    private void refreshStudentElements() {
        System.out.println("update ind Students");

        StudentDAO sdao = new StudentDAO();
        model = sdao.selectById(id);

        btnMatriculation = new Button(this);
        btnMatriculation.setText("Matriculas");
        btnMatriculation.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        btnMatriculation.setTextColor(getResources().getColor(R.color.colorWhite));
        btnMatriculation.setTextSize(20);
        btnMatriculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(IndividualView.this, ListingView.class);
                it.putExtra("name", "matriculation");
                it.putExtra("idStudent", id);
                startActivity(it);
            }
        });
        layoutList.addView(btnMatriculation);

    }

    private void refreshModalityElements() {
        System.out.println("update ind Students");

        ModalityDAO sdao = new ModalityDAO();
        model = sdao.selectById(id);
        btnPlans = new Button(this);
        btnPlans.setText("Planos");
        btnPlans.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        btnPlans.setTextColor(getResources().getColor(R.color.colorWhite));
        btnPlans.setTextSize(20);
        btnPlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(IndividualView.this, ListingView.class);
                it.putExtra("name", "plan");
                it.putExtra("idModality", id);
                startActivity(it);
            }
        });
        layoutList.addView(btnPlans);

        btnGraduation = new Button(this);
        btnGraduation.setText("Graduações");
        btnGraduation.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        btnGraduation.setTextColor(getResources().getColor(R.color.colorWhite));
        btnGraduation.setTextSize(20);
        btnGraduation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(IndividualView.this, ListingView.class);
                it.putExtra("name", "graduation");
                it.putExtra("idModality", id);
                startActivity(it);
            }
        });
        layoutList.addView(btnGraduation);

    }

    private void refreshMatriculationElements() {
        System.out.println("update ind Students");

        MatriculationDAO sdao = new MatriculationDAO();
        model = sdao.selectById(id);

    }

    private void refreshGraduationElements() {
        System.out.println("update ind Students");

        GraduationDAO sdao = new GraduationDAO();
        model = sdao.selectById(id);


    }

    private void refreshPlanElements() {
        System.out.println("update ind Students");

        PlanDAO sdao = new PlanDAO();
        model = sdao.selectById(id);

    }

    private void addElementsOnLayout() {
        HashMap<String, String> elements = model.getElements();
        TextView main = new TextView(this);
        main.setTextSize(30);
        main.setText(model.getMain());
        this.layoutList.addView(main);
        for (Map.Entry<String,String> pair : elements.entrySet()) {
            pair.getKey();
            TextView tv = new TextView(this);
            tv.setTextSize(25);
            String value = pair.getValue();

            if(value == null) {
                value = "";
            }

            String s = pair.getKey() + ": " + value;
            tv.setText(s);

            this.layoutList.addView(tv);
        }
    }

    private void refreshElements() {
        System.out.println(this.type);
        if(this.type == null) {
            getContext();
        }
        switch(this.type) {
            case "student":
                refreshStudentElements();
                break;
            case "modality":
                refreshModalityElements();
                break;
            case "matriculation":
                refreshMatriculationElements();
                break;
            case "graduation":
                refreshGraduationElements();
                break;
            case "plan":
                refreshPlanElements();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.type);
        }

        addElementsOnLayout();
    }

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.individual_view);
        getType(savedInstanceState);
        getContext();

        this.btnStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(IndividualView.this, ListingView.class);
                it.putExtra("name", type);
                startActivity(it);
            }
        });

        refreshElements();
    }
}
