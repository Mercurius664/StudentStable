package com.IvashkinIgor.model;

import java.util.ArrayList;

public class Model {
    private ArrayList<Student> studentArrayList;
    private ArrayList<Student> studentArrayListForFind;
    private Model() {
        studentArrayList = new ArrayList<Student>();
        studentArrayListForFind = new ArrayList<Student>();
    }

    private static Model model;


    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public ArrayList<Student> getStudentArrayListForFind() {
        return studentArrayListForFind;
    }

    public static Model getInstance(){
        if (model == null){
            model = new Model();
        }
        return model;
    }



}
