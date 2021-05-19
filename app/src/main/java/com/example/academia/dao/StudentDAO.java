package com.example.academia.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.academia.model.Models;
import com.example.academia.model.Student;

public class StudentDAO extends DAO {

    public List<Student> selectAll() {
        List<Student> students = new ArrayList<Student>();

        for(Integer i=0;i<100;i++) {
            Student student = new Student();
            student.setId(i);
            student.setNome("Roger " + i.toString());
            students.add(student);
        }


        return students;
    }

    public Student selectById(Integer id) {
        Student student = new Student();
        student.setId(id);
        student.setNome("Roger " + id.toString());

        return student;
    }

    @Override
    public boolean insert(Models model) {
        Student student = (Student) model;
        return true;
    }

}
