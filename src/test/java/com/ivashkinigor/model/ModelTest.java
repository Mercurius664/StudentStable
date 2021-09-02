package com.ivashkinigor.model;

import com.ivashkinigor.main.MainDialogView;
import com.ivashkinigor.main.StudentTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ModelTest {

    private Model model;


    private List<Student> studentsData(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Taranayer",
                new Parent("Yre",9346),
                new Parent("Xalseilo",4303),
                2,
                3));

        studentList.add(new Student("Weeleie",
                new Parent("Tali",2936),
                new Parent("Kaneleliv",3807),
                5,
                2));

        studentList.add(new Student("Merolpyca",
                new Parent("Eraddiven",6464),
                new Parent("Incoron",7080),
                1,
                3));

        studentList.add(new Student("Qudralodw",
                new Parent("Minag",5808),
                new Parent("Ulree",5787),
                1,
                0));

        studentList.add(new Student("Cleemma",
                new Parent("Rarnam",2528),
                new Parent("Stilonk",1406),
                4,
                1));

        studentList.add(new Student("Hopalital",
                new Parent("Minag",8298),
                new Parent("Xanannga",1723),
                0,
                5));

        studentList.add(new Student("Ann",
                new Parent("Fiaranen",1318),
                new Parent("Lyesinde",4004),
                0,
                1));

        studentList.add(new Student("Cewia",
                new Parent("Lliali",2287),
                new Parent("Swer",8413),
                3,
                4));

        studentList.add(new Student("Cewia",
                new Parent("Nhwastor",7240),
                new Parent("Lataresdy",8610),
                2,
                0));

        studentList.add(new Student("Tevospri",
                new Parent("Pokanetys",1244),
                new Parent("Dera",2293),
                3,
                4));


        return studentList;
    }


    @BeforeEach
    public void initBeforeEach(){
        model = new StudentTable(new MainDialogView()).getStudentModel();
        model.getStudents().addAll(studentsData());
    }

    @Test
    public void filterByStudentNameTest(){

        List<Student> correctOutput = new ArrayList<>();
        correctOutput.add(new Student("Cewia",
                new Parent("Nhwastor",7240),
                new Parent("Lataresdy",8610),
                2,
                0));
        correctOutput.add(new Student("Cewia",
                new Parent("Lliali",2287),
                new Parent("Swer",8413),
                3,
                4));



        List<Student> result = model.filterByStudentName("Cewia");

        Assertions.assertTrue(correctOutput.containsAll(result));
        Assertions.assertTrue(result.containsAll(correctOutput));


    }

    @Test
    public void deleteByStudentNameTest(){
        List<Student> studentArrayList = model.getStudents();
        model.deleteByStudentName("Cewia");

        List<Student> correctOutput = new ArrayList<>();
        correctOutput.add(new Student("Taranayer",
                new Parent("Yre",9346),
                new Parent("Xalseilo",4303),
                2,
                3));

        correctOutput.add(new Student("Weeleie",
                new Parent("Tali",2936),
                new Parent("Kaneleliv",3807),
                5,
                2));

        correctOutput.add(new Student("Merolpyca",
                new Parent("Eraddiven",6464),
                new Parent("Incoron",7080),
                1,
                3));

        correctOutput.add(new Student("Qudralodw",
                new Parent("Minag",5808),
                new Parent("Ulree",5787),
                1,
                0));

        correctOutput.add(new Student("Cleemma",
                new Parent("Rarnam",2528),
                new Parent("Stilonk",1406),
                4,
                1));

        correctOutput.add(new Student("Hopalital",
                new Parent("Minag",8298),
                new Parent("Xanannga",1723),
                0,
                5));

        correctOutput.add(new Student("Ann",
                new Parent("Fiaranen",1318),
                new Parent("Lyesinde",4004),
                0,
                1));


        correctOutput.add(new Student("Tevospri",
                new Parent("Pokanetys",1244),
                new Parent("Dera",2293),
                3,
                4));

        Assertions.assertTrue(correctOutput.containsAll(studentArrayList));
        Assertions.assertTrue(studentArrayList.containsAll(correctOutput));
    }



    @Test
    public void filterByFatherNameTest(){
        List<Student> studentArrayList = model.filterByFatherName("Minag");

        List<Student> correctOutput = new ArrayList<>();
        correctOutput.add(new Student("Qudralodw",
                new Parent("Minag",5808),
                new Parent("Ulree",5787),
                1,
                0));
        correctOutput.add(new Student("Hopalital",
                new Parent("Minag",8298),
                new Parent("Xanannga",1723),
                0,
                5));


        Assertions.assertTrue(correctOutput.containsAll(studentArrayList));
        Assertions.assertTrue(studentArrayList.containsAll(correctOutput));
    }

    @Test
    public void deleteByFatherNameTest(){
        List<Student> studentArrayList = model.getStudents();
        model.deleteByFatherName("Minag");

        List<Student> correctOutput = new ArrayList<>();

        correctOutput.add(new Student("Taranayer",
                new Parent("Yre",9346),
                new Parent("Xalseilo",4303),
                2,
                3));

        correctOutput.add(new Student("Weeleie",
                new Parent("Tali",2936),
                new Parent("Kaneleliv",3807),
                5,
                2));

        correctOutput.add(new Student("Merolpyca",
                new Parent("Eraddiven",6464),
                new Parent("Incoron",7080),
                1,
                3));


        correctOutput.add(new Student("Cleemma",
                new Parent("Rarnam",2528),
                new Parent("Stilonk",1406),
                4,
                1));


        correctOutput.add(new Student("Ann",
                new Parent("Fiaranen",1318),
                new Parent("Lyesinde",4004),
                0,
                1));

        correctOutput.add(new Student("Cewia",
                new Parent("Lliali",2287),
                new Parent("Swer",8413),
                3,
                4));

        correctOutput.add(new Student("Cewia",
                new Parent("Nhwastor",7240),
                new Parent("Lataresdy",8610),
                2,
                0));

        correctOutput.add(new Student("Tevospri",
                new Parent("Pokanetys",1244),
                new Parent("Dera",2293),
                3,
                4));

        Assertions.assertTrue(correctOutput.containsAll(studentArrayList));
        Assertions.assertTrue(studentArrayList.containsAll(correctOutput));
    }



    @Test
    public void filterByMotherNameTest(){
        List<Student> studentArrayList = model.filterByMotherName("Xalseilo");

        List<Student> correctOutput = new ArrayList<>();
        correctOutput.add(new Student("Taranayer",
                new Parent("Yre",9346),
                new Parent("Xalseilo",4303),
                2,
                3));

        Assertions.assertTrue(correctOutput.containsAll(studentArrayList));
        Assertions.assertTrue(studentArrayList.containsAll(correctOutput));
    }

    @Test
    public void deleteByMotherNameTest(){
        List<Student> studentArrayList = model.getStudents();
        model.deleteByMotherName("Dera");

        List<Student> correctOutput = new ArrayList<>();

        correctOutput.add(new Student("Taranayer",
                new Parent("Yre",9346),
                new Parent("Xalseilo",4303),
                2,
                3));

        correctOutput.add(new Student("Weeleie",
                new Parent("Tali",2936),
                new Parent("Kaneleliv",3807),
                5,
                2));

        correctOutput.add(new Student("Merolpyca",
                new Parent("Eraddiven",6464),
                new Parent("Incoron",7080),
                1,
                3));

        correctOutput.add(new Student("Qudralodw",
                new Parent("Minag",5808),
                new Parent("Ulree",5787),
                1,
                0));

        correctOutput.add(new Student("Cleemma",
                new Parent("Rarnam",2528),
                new Parent("Stilonk",1406),
                4,
                1));

        correctOutput.add(new Student("Hopalital",
                new Parent("Minag",8298),
                new Parent("Xanannga",1723),
                0,
                5));

        correctOutput.add(new Student("Ann",
                new Parent("Fiaranen",1318),
                new Parent("Lyesinde",4004),
                0,
                1));

        correctOutput.add(new Student("Cewia",
                new Parent("Lliali",2287),
                new Parent("Swer",8413),
                3,
                4));

        correctOutput.add(new Student("Cewia",
                new Parent("Nhwastor",7240),
                new Parent("Lataresdy",8610),
                2,
                0));


        Assertions.assertTrue(correctOutput.containsAll(studentArrayList));
        Assertions.assertTrue(studentArrayList.containsAll(correctOutput));
    }



    @Test
    public void filterByFatherEarningTest(){
        List<Student> studentArrayList = model.filterByFatherEarning(5000,7000);

        List<Student> correctOutput = new ArrayList<>();
        correctOutput.add(new Student("Merolpyca",
                new Parent("Eraddiven",6464),
                new Parent("Incoron",7080),
                1,
                3));

        correctOutput.add(new Student("Qudralodw",
                new Parent("Minag",5808),
                new Parent("Ulree",5787),
                1,
                0));

        Assertions.assertTrue(correctOutput.containsAll(studentArrayList));
        Assertions.assertTrue(studentArrayList.containsAll(correctOutput));
    }

    @Test
    public void deleteByFatherEarningTest(){
        List<Student> studentArrayList = model.getStudents();
        model.deleteByFatherEarning(0,9000);

        List<Student> correctOutput = new ArrayList<>();
        correctOutput.add(new Student("Taranayer",
                new Parent("Yre",9346),
                new Parent("Xalseilo",4303),
                2,
                3));


        Assertions.assertTrue(correctOutput.containsAll(studentArrayList));
        Assertions.assertTrue(studentArrayList.containsAll(correctOutput));
    }



    @Test
    public void filterByMotherEarningTest(){
        List<Student> studentArrayList = model.filterByMotherEarning(1000,4000);

        List<Student> correctOutput = new ArrayList<>();

        correctOutput.add(new Student("Weeleie",
                new Parent("Tali",2936),
                new Parent("Kaneleliv",3807),
                5,
                2));
        correctOutput.add(new Student("Cleemma",
                new Parent("Rarnam",2528),
                new Parent("Stilonk",1406),
                4,
                1));
        correctOutput.add(new Student("Hopalital",
                new Parent("Minag",8298),
                new Parent("Xanannga",1723),
                0,
                5));
        correctOutput.add(new Student("Tevospri",
                new Parent("Pokanetys",1244),
                new Parent("Dera",2293),
                3,
                4));

        Assertions.assertTrue(correctOutput.containsAll(studentArrayList));
        Assertions.assertTrue(studentArrayList.containsAll(correctOutput));
    }

    @Test
    public void deleteByMotherEarningTest(){
        List<Student> studentArrayList = model.getStudents();
        model.deleteByMotherEarning(7000,10000);

        List<Student> correctOutput = new ArrayList<>();

        correctOutput.add(new Student("Taranayer",
                new Parent("Yre",9346),
                new Parent("Xalseilo",4303),
                2,
                3));

        correctOutput.add(new Student("Weeleie",
                new Parent("Tali",2936),
                new Parent("Kaneleliv",3807),
                5,
                2));


        correctOutput.add(new Student("Qudralodw",
                new Parent("Minag",5808),
                new Parent("Ulree",5787),
                1,
                0));

        correctOutput.add(new Student("Cleemma",
                new Parent("Rarnam",2528),
                new Parent("Stilonk",1406),
                4,
                1));

        correctOutput.add(new Student("Hopalital",
                new Parent("Minag",8298),
                new Parent("Xanannga",1723),
                0,
                5));

        correctOutput.add(new Student("Ann",
                new Parent("Fiaranen",1318),
                new Parent("Lyesinde",4004),
                0,
                1));

        correctOutput.add(new Student("Tevospri",
                new Parent("Pokanetys",1244),
                new Parent("Dera",2293),
                3,
                4));


        Assertions.assertTrue(correctOutput.containsAll(studentArrayList));
        Assertions.assertTrue(studentArrayList.containsAll(correctOutput));
    }



    @Test
    public void filterByParentEarningTest(){

        List<Student> fatherList = new ArrayList<>();
        fatherList.add(new Student("Taranayer",
                new Parent("Yre",9346),
                new Parent("Xalseilo",4303),
                2,
                3));

        fatherList.add(new Student("Weeleie",
                new Parent("Tali",2936),
                new Parent("Kaneleliv",3807),
                5,
                2));

        fatherList.add(new Student("Merolpyca",
                new Parent("Eraddiven",6464),
                new Parent("Incoron",7080),
                1,
                3));


        List<Student> motherList = new ArrayList<>();
        motherList.add(new Student("Weeleie",
                new Parent("Tali",2936),
                new Parent("Kaneleliv",3807),
                5,
                2));

        motherList.add(new Student("Merolpyca",
                new Parent("Eraddiven",6464),
                new Parent("Incoron",7080),
                1,
                3));

        motherList.add(new Student("Qudralodw",
                new Parent("Minag",5808),
                new Parent("Ulree",5787),
                1,
                0));

        List<Student> studentArrayList = model.filterByParentEarning(fatherList,motherList);

        List<Student> correctOutput = new ArrayList<>();
        correctOutput.add(new Student("Weeleie",
                new Parent("Tali",2936),
                new Parent("Kaneleliv",3807),
                5,
                2));

        correctOutput.add(new Student("Merolpyca",
                new Parent("Eraddiven",6464),
                new Parent("Incoron",7080),
                1,
                3));


        Assertions.assertTrue(correctOutput.containsAll(studentArrayList));
        Assertions.assertTrue(studentArrayList.containsAll(correctOutput));
    }



    @Test
    public void filterByNumberOfBrotherTest(){
        List<Student> studentArrayList = model.filterByNumberOfBrother(2);

        List<Student> correctOutput = new ArrayList<>();
        correctOutput.add(new Student("Taranayer",
                new Parent("Yre",9346),
                new Parent("Xalseilo",4303),
                2,
                3));
        correctOutput.add(new Student("Cewia",
                new Parent("Nhwastor",7240),
                new Parent("Lataresdy",8610),
                2,
                0));


        Assertions.assertTrue(correctOutput.containsAll(studentArrayList));
        Assertions.assertTrue(studentArrayList.containsAll(correctOutput));

    }

    @Test
    public void deleteByNumberOfBrotherTest(){
        List<Student> studentArrayList = model.getStudents();
        studentArrayList.addAll(studentsData());
        model.deleteByNumberOfBrother(2);
        model.deleteByNumberOfBrother(3);

        List<Student> correctOutput = new ArrayList<>();


        correctOutput.add(new Student("Weeleie",
                new Parent("Tali",2936),
                new Parent("Kaneleliv",3807),
                5,
                2));

        correctOutput.add(new Student("Merolpyca",
                new Parent("Eraddiven",6464),
                new Parent("Incoron",7080),
                1,
                3));

        correctOutput.add(new Student("Qudralodw",
                new Parent("Minag",5808),
                new Parent("Ulree",5787),
                1,
                0));

        correctOutput.add(new Student("Cleemma",
                new Parent("Rarnam",2528),
                new Parent("Stilonk",1406),
                4,
                1));

        correctOutput.add(new Student("Hopalital",
                new Parent("Minag",8298),
                new Parent("Xanannga",1723),
                0,
                5));

        correctOutput.add(new Student("Ann",
                new Parent("Fiaranen",1318),
                new Parent("Lyesinde",4004),
                0,
                1));




        Assertions.assertTrue(correctOutput.containsAll(studentArrayList));
        Assertions.assertTrue(studentArrayList.containsAll(correctOutput));
    }



    @Test
    public void filterByNumberOfSisterTest(){
        List<Student> studentArrayList = model.filterByNumberOfSister(3);

        List<Student> correctOutput = new ArrayList<>();
        correctOutput.add(new Student("Taranayer",
                new Parent("Yre",9346),
                new Parent("Xalseilo",4303),
                2,
                3));
        correctOutput.add(new Student("Merolpyca",
                new Parent("Eraddiven",6464),
                new Parent("Incoron",7080),
                1,
                3));


        Assertions.assertTrue(correctOutput.containsAll(studentArrayList));
        Assertions.assertTrue(studentArrayList.containsAll(correctOutput));
    }

    @Test
    public void deleteByNumberOfSisterTest(){
        List<Student> studentArrayList = model.getStudents();
        model.deleteByNumberOfSister(4);
        model.deleteByNumberOfSister(3);


        List<Student> correctOutput = new ArrayList<>();


        correctOutput.add(new Student("Weeleie",
                new Parent("Tali",2936),
                new Parent("Kaneleliv",3807),
                5,
                2));


        correctOutput.add(new Student("Qudralodw",
                new Parent("Minag",5808),
                new Parent("Ulree",5787),
                1,
                0));

        correctOutput.add(new Student("Cleemma",
                new Parent("Rarnam",2528),
                new Parent("Stilonk",1406),
                4,
                1));

        correctOutput.add(new Student("Hopalital",
                new Parent("Minag",8298),
                new Parent("Xanannga",1723),
                0,
                5));

        correctOutput.add(new Student("Ann",
                new Parent("Fiaranen",1318),
                new Parent("Lyesinde",4004),
                0,
                1));


        correctOutput.add(new Student("Cewia",
                new Parent("Nhwastor",7240),
                new Parent("Lataresdy",8610),
                2,
                0));


        Assertions.assertTrue(correctOutput.containsAll(studentArrayList));
        Assertions.assertTrue(studentArrayList.containsAll(correctOutput));
    }



    @Test
    public void filterByFatherAndMotherNameTest(){
        List<Student> studentArrayList = model.filterByFatherAndMotherName("Minag","Xanannga");
        List<Student> correctOutput = new ArrayList<>();
        correctOutput.add(new Student("Hopalital",
                new Parent("Minag",8298),
                new Parent("Xanannga",1723),
                0,
                5));

        Assertions.assertTrue(correctOutput.containsAll(studentArrayList));
        Assertions.assertTrue(studentArrayList.containsAll(correctOutput));
    }

    @Test
    public void deleteByFatherAndMotherNameTest(){
        List<Student> studentArrayList = model.getStudents();
        model.deleteByFatherAndMotherName("Minag","Xanannga");


        List<Student> correctOutput = new ArrayList<>();

        correctOutput.add(new Student("Taranayer",
                new Parent("Yre",9346),
                new Parent("Xalseilo",4303),
                2,
                3));

        correctOutput.add(new Student("Weeleie",
                new Parent("Tali",2936),
                new Parent("Kaneleliv",3807),
                5,
                2));

        correctOutput.add(new Student("Merolpyca",
                new Parent("Eraddiven",6464),
                new Parent("Incoron",7080),
                1,
                3));

        correctOutput.add(new Student("Qudralodw",
                new Parent("Minag",5808),
                new Parent("Ulree",5787),
                1,
                0));

        correctOutput.add(new Student("Cleemma",
                new Parent("Rarnam",2528),
                new Parent("Stilonk",1406),
                4,
                1));

        correctOutput.add(new Student("Ann",
                new Parent("Fiaranen",1318),
                new Parent("Lyesinde",4004),
                0,
                1));

        correctOutput.add(new Student("Cewia",
                new Parent("Lliali",2287),
                new Parent("Swer",8413),
                3,
                4));

        correctOutput.add(new Student("Cewia",
                new Parent("Nhwastor",7240),
                new Parent("Lataresdy",8610),
                2,
                0));

        correctOutput.add(new Student("Tevospri",
                new Parent("Pokanetys",1244),
                new Parent("Dera",2293),
                3,
                4));

        Assertions.assertTrue(correctOutput.containsAll(studentArrayList));
        Assertions.assertTrue(studentArrayList.containsAll(correctOutput));
    }



    @Test
    public void filterByBrothersAndSistersCountTest(){
        List<Student> studentArrayList = model.filterByBrothersAndSistersCount(1,0);

        List<Student> correctOutput = new ArrayList<>();

        correctOutput.add(new Student("Qudralodw",
                new Parent("Minag",5808),
                new Parent("Ulree",5787),
                1,
                0));


        Assertions.assertTrue(correctOutput.containsAll(studentArrayList));
        Assertions.assertTrue(studentArrayList.containsAll(correctOutput));
    }

    @Test
    public void deleteByBrothersAndSistersCountTest(){
        List<Student> studentArrayList = model.getStudents();

        model.deleteByBrothersAndSistersCount(2,3);
        model.deleteByBrothersAndSistersCount(5,2);
        model.deleteByBrothersAndSistersCount(1,3);
        model.deleteByBrothersAndSistersCount(1,0);
        model.deleteByBrothersAndSistersCount(4,1);


        List<Student> correctOutput = new ArrayList<>();


        correctOutput.add(new Student("Hopalital",
                new Parent("Minag",8298),
                new Parent("Xanannga",1723),
                0,
                5));

        correctOutput.add(new Student("Ann",
                new Parent("Fiaranen",1318),
                new Parent("Lyesinde",4004),
                0,
                1));

        correctOutput.add(new Student("Cewia",
                new Parent("Lliali",2287),
                new Parent("Swer",8413),
                3,
                4));

        correctOutput.add(new Student("Cewia",
                new Parent("Nhwastor",7240),
                new Parent("Lataresdy",8610),
                2,
                0));

        correctOutput.add(new Student("Tevospri",
                new Parent("Pokanetys",1244),
                new Parent("Dera",2293),
                3,
                4));


        Assertions.assertTrue(correctOutput.containsAll(studentArrayList));
        Assertions.assertTrue(studentArrayList.containsAll(correctOutput));
    }

}
