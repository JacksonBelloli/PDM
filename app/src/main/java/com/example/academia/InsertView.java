package com.example.academia;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.academia.dao.DAO;
import com.example.academia.dao.GraduationDAO;
import com.example.academia.dao.MatriculationDAO;
import com.example.academia.dao.ModalityDAO;
import com.example.academia.dao.PlanDAO;
import com.example.academia.dao.StudentDAO;
import com.example.academia.model.Graduation;
import com.example.academia.model.Matriculation;
import com.example.academia.model.Modality;
import com.example.academia.model.Models;
import com.example.academia.model.Plan;
import com.example.academia.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertView extends AppCompatActivity {

    private Button btnStudents;
    private Button btnAdd;
    private ListView lv;
    private String type;
    private LinearLayout layoutList;
    private Models model;
    private DAO dao;
    private List<EditText> fields;
    private HashMap<String, Spinner> spinners;
    private Integer idStudent;
    private Integer idModality;
    private Spinner special;
    private Spinner spinnerPlan;
    private Spinner spinnerGraduation;

    private void getContext() {
        this.btnStudents = findViewById(R.id.btnStudents);
        this.layoutList = findViewById(R.id.layoutList);
        this.btnAdd = findViewById(R.id.btnAdd);

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

    private void insertStudent() {
        System.out.println("Insert Student");
        HashMap<String, String> elements = model.getFields();
        Student student = (Student) model;

        for(EditText et : fields) {
            student.setByKey(et.getHint().toString(), et.getText().toString());
        }

        for(Map.Entry<String, Spinner> pair : spinners.entrySet()) {
            String value = pair.getValue().getSelectedItem().toString();
            student.setByKey(pair.getKey(), value);
        }
        System.out.println(student.toString());
        model = student;
    }

    private void insertModality() {
        System.out.println("Insert modality");
        HashMap<String, String> elements = model.getFields();
        Modality modality = (Modality) model;

        for(EditText et : fields) {
            modality.setByKey(et.getHint().toString(), et.getText().toString());
        }

        model = modality;
    }

    private void insertGraduation() {
        System.out.println("Insert graduation");
        HashMap<String, String> elements = model.getFields();
        Graduation graduation = (Graduation) model;
        graduation.setIdModality(idModality);
        for(EditText et : fields) {
            graduation.setByKey(et.getHint().toString(), et.getText().toString());
        }

        graduation.setIdModality(idModality);

        model = graduation;
    }

    private void insertMatriculation() {
        System.out.println("Insert graduation");
        HashMap<String, String> elements = model.getFields();
        Matriculation matriculation = (Matriculation) model;
        matriculation.setIdModality(idModality);
        for(EditText et : fields) {
            matriculation.setByKey(et.getHint().toString(), et.getText().toString());
        }

        for(Map.Entry<String, Spinner> pair : spinners.entrySet()) {
            String value = pair.getValue().getSelectedItem().toString();
            matriculation.setByKey(pair.getKey(), value);
        }
        System.out.println(matriculation.toString());

        matriculation.setIdStudent(idStudent);
        /*String[] ss = special.getSelectedItem().toString().split("|");
        Integer idModality = Integer.parseInt(ss[0]);
        matriculation.setIdModality(idModality);*/
        String[] ss = spinnerGraduation.getSelectedItem().toString().split("|");
        Integer idGraduation = Integer.parseInt(ss[0]);
        matriculation.setIdGraduation(idGraduation);
        ss = spinnerPlan.getSelectedItem().toString().split("|");
        Integer idPlan = Integer.parseInt(ss[0]);
        matriculation.setIdPlan(idPlan);

        model = matriculation;
    }

    private void insertPlan() {
        System.out.println("Insert graduation");
        HashMap<String, String> elements = model.getFields();
        Plan plan = (Plan) model;
        plan.setIdModality(idModality);
        for(EditText et : fields) {
            plan.setByKey(et.getHint().toString(), et.getText().toString());
        }
        plan.setIdModality(idModality);

        model = plan;
    }

    private void objStudent() {
        this.dao = new StudentDAO();
        this.model = new Student();
    }

    private void objModality() {
        this.dao = new ModalityDAO();
        this.model = new Modality();
    }
    private void objMatriculation() {
        this.dao = new MatriculationDAO();
        this.model = new Matriculation();
    }
    private void objGraduation() {
        this.dao = new GraduationDAO();
        this.model = new Graduation();
    }
    private void objPlan() {
        this.dao = new PlanDAO();
        this.model = new Plan();
    }

    public void insertInTheModel() {
        switch(this.type) {
            case "student":
                insertStudent();
                break;
            case "modality":
                insertModality();
                break;
            case "matriculation":
                insertMatriculation();
                break;
            case "graduation":
                insertGraduation();
                break;
            case "plan":
                insertPlan();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.type);
        }
    }

    private void getObject() {
        switch(this.type) {
            case "student":
                objStudent();
                break;
            case "modality":
                objModality();
                break;
            case "matriculation":
                objMatriculation();
                break;
            case "graduation":
                objGraduation();
                break;
            case "plan":
                objPlan();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.type);
        }
    }

    private Integer getInputType(String type) {
        switch(type) {
            case "String":
                return InputType.TYPE_CLASS_TEXT;
            case "Date":
                return InputType.TYPE_CLASS_DATETIME;
            case "Integer":
                return InputType.TYPE_CLASS_NUMBER;
            case "Double":
                return InputType.TYPE_CLASS_NUMBER |  InputType.TYPE_NUMBER_FLAG_DECIMAL;
            case "Phone":
                return InputType.TYPE_CLASS_PHONE;
            default: return InputType.TYPE_CLASS_TEXT;
        }
    }

    private void updateValuesSpecialSpinners() {
        String[] ss = special.getSelectedItem().toString().split("|");
        Integer idModality = Integer.parseInt(ss[0]);
        List<String> elementsSpinner = new ArrayList<String>();

        PlanDAO pdao = new PlanDAO();
        List<Plan> plans = pdao.selectByIdModality(idModality);

        for(Plan plan : plans) {
            elementsSpinner.add(plan.getId()+"|"+plan.getNome());
        }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, elementsSpinner);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerPlan.setAdapter(adapter1);


        elementsSpinner = new ArrayList<String>();

        GraduationDAO gdao = new GraduationDAO();
        List<Graduation> graduations = gdao.selectByIdModality(idModality);

        for(Graduation graduation : graduations) {
            elementsSpinner.add(graduation.getId()+"|"+graduation.getNome());
        }
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, elementsSpinner);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerGraduation.setAdapter(adapter2);
    }

    private void addInputsOnLayout() {
        fields = new ArrayList<EditText>();
        spinners = new HashMap<String, Spinner>();
        HashMap<String, String> elements = model.getFields();
        for (Map.Entry<String,String> pair : elements.entrySet()) {

            if(pair.getValue().equals("Spinner")) {
                Spinner spinner = new Spinner(this);
                List<String> elementsSpinner;
                if(pair.getKey().equals("Sexo")) {
                    Student student = (Student) model;
                    elementsSpinner = student.spinnerSexo();
                }
                else if(pair.getKey().equals("modality")) {
                    elementsSpinner = new ArrayList<String>();
                    ModalityDAO mdao = new ModalityDAO();
                    List<Modality>  modalities = mdao.selectAll();
                    for(Modality modality : modalities) {
                        elementsSpinner.add(modality.getId() + "|" + modality.getNome());
                    }

                    spinner.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            updateValuesSpecialSpinners();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                    special = spinner;
                }
                else {
                    elementsSpinner = new ArrayList<String>();
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, elementsSpinner);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

                this.layoutList.addView(spinner);
                spinners.put(pair.getKey(), spinner);
                if(pair.getKey().equals("modality")) {
                    this.spinnerPlan = new Spinner(this);
                    this.spinnerGraduation = new Spinner(this);
                    this.layoutList.addView(spinnerPlan);
                    this.layoutList.addView(spinnerGraduation);
                    updateValuesSpecialSpinners();
                }
            }
            else {
                EditText et = new EditText(this);
                et.setText("");
                et.setTextSize(15);
                et.setHint(pair.getKey());
                et.setInputType(getInputType(pair.getValue()));

                fields.add(et);

                this.layoutList.addView(et);
            }

        }
    }

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_view);
        getType(savedInstanceState);
        getObject();
        getContext();

        this.btnStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(InsertView.this, ListingView.class);
                it.putExtra("name", type);
                startActivity(it);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it;
                insertInTheModel();
                if(type.equals("graduation") || type.equals("plan")) {
                    it = new Intent(InsertView.this, ListingView.class);
                    it.putExtra("id", idModality);


                }
                else if(type.equals("matriculation")) {
                    it = new Intent(InsertView.this, ListingView.class);
                    it.putExtra("id", idStudent);

                }
                else {
                    it = new Intent(InsertView.this, ListingView.class);
                }

                it.putExtra("name", type);
                startActivity(it);
            }
        });

        addInputsOnLayout();
    }
}
