package com.example.academia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.academia.dao.GraduationDAO;
import com.example.academia.dao.MatriculationDAO;
import com.example.academia.dao.ModalityDAO;
import com.example.academia.dao.PlanDAO;
import com.example.academia.dao.StudentDAO;
import com.example.academia.model.Graduation;
import com.example.academia.model.Matriculation;
import com.example.academia.model.Modality;
import com.example.academia.model.Plan;
import com.example.academia.model.Student;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListingView extends AppCompatActivity {

    private Button btnMenu;
    private Button btnAdd;
    private ListView lv;
    private String type;
    private ArrayAdapter<String> arrayAdapter;
    private List<String> items;
    private List<Integer> itemsIds;
    private TextView name;
    private Integer idStudent;
    private Integer idModality;

    private void getContext() {
        this.lv = findViewById(R.id.lv);
        this.btnMenu = findViewById(R.id.btnMenu);
        this.btnAdd = findViewById(R.id.btnAdd);
        this.name = findViewById(R.id.name);

    }

    private void getType(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                this.type = null;
            } else {
                this.type = extras.getString("name");
                this.idStudent = extras.getInt("idStudent");
                this.idModality = extras.getInt("idModality");
            }
        } else {
            this.type = (String) savedInstanceState.getSerializable("name");
            this.idStudent = (Integer) savedInstanceState.getSerializable("idStudent");
            this.idModality = (Integer) savedInstanceState.getSerializable("idModality");
        }
    }

    private void addListToView() {
        this.arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
    }

    private void addToList(Integer id, String name) {
        this.items.add(name);
        this.itemsIds.add(id);
    }

    private void refreshStudentElements() {
        System.out.println("Refresh Students");
        this.name.setText("Alunos:");
        StudentDAO sdao = new StudentDAO();
        List<Student> students = sdao.selectAll();

        for(Student student : students) {
            addToList(student.getId(), student.getNome());
        }
        addListToView();

    }

    private void refreshModalityElements() {
        System.out.println("Refresh Modality");
        this.name.setText("Modalidades:");
        ModalityDAO sdao = new ModalityDAO();
        List<Modality> modalities = sdao.selectAll();

        for(Modality modality : modalities) {
            addToList(modality.getId(), modality.getNome());
        }

    }

    private void refreshMatriculationElements() {
        System.out.println("Refresh Matriculation");
        this.name.setText("Matriculas:");
        MatriculationDAO sdao = new MatriculationDAO();
        List<Matriculation> matriculations = sdao.selectByIdStudent(idStudent);

        for(Matriculation matriculation : matriculations) {
            addToList(matriculation.getId(), matriculation.getMain());
        }
        btnMenu.setText("Voltar");
    }

    private void refreshGraduationElements() {
        System.out.println("Refresh Graduation");
        this.name.setText("Graduacao:");
        GraduationDAO sdao = new GraduationDAO();
        List<Graduation> graduations = sdao.selectByIdModality(idModality);

        for(Graduation graduation : graduations) {
            addToList(graduation.getId(), graduation.getMain());
        }
        btnMenu.setText("Voltar");
    }

    private void refreshPlanElements() {
        System.out.println("Refresh Plans");
        this.name.setText("Planos:");
        PlanDAO sdao = new PlanDAO();
        List<Plan> plans = sdao.selectByIdModality(idModality);

        for(Plan plan : plans) {
            addToList(plan.getId(), plan.getMain());
        }
        btnMenu.setText("Voltar");
    }

    private void refreshElements() {
        this.items = new ArrayList<String>();
        this.itemsIds = new ArrayList<Integer>();
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

        addListToView();
        this.lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(ListingView.this, IndividualView.class);
                it.putExtra("name", type);
                it.putExtra("id", itemsIds.get(position));

                startActivity(it);
            }
        });

        this.lv.setAdapter(this.arrayAdapter);
    }

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        getType(savedInstanceState);

        getContext();
        System.out.println("TYPE " + this.type);
        this.btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it;
                if(type.equals("graduation") || type.equals("plan")) {
                    it = new Intent(ListingView.this, IndividualView.class);
                    it.putExtra("name", "modality");
                    it.putExtra("id", idModality);


                }
                else if(type.equals("matriculation")) {
                    it = new Intent(ListingView.this, IndividualView.class);
                    it.putExtra("name", "student");
                    it.putExtra("id", idStudent);

                }
                else {
                    it = new Intent(ListingView.this, Menu.class);
                }

                startActivity(it);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ListingView.this, InsertView.class);
                it.putExtra("name", type);
                if(idStudent != null) {
                    it.putExtra("idStudent", idStudent);
                }
                if(idModality != null) {
                    it.putExtra("idModality", idStudent);
                }
                startActivity(it);
            }
        });

        refreshElements();


    }
}