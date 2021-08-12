package com.IvashkinIgor.model;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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



    public List<Student> filterByStudentName(String name){
        return studentArrayList.stream()
                .filter(x-> x.getStudentName().contains(name))
                .collect(Collectors.toList());
    }
    public void deleteByStudentName(String name){
        studentArrayList.removeAll(filterByStudentName(name));

    }

    public List<Student> filterByFatherName(String name){
        return studentArrayList.stream()
                .filter(x-> x.getFatherName().contains(name))
                .collect(Collectors.toList());
    }
    public void deleteByFatherName(String name){
        studentArrayList.removeAll(filterByFatherName(name));

    }

    public List<Student> filterByMotherName(String name){
        return studentArrayList.stream()
                .filter(x-> x.getMotherName().contains(name))
                .collect(Collectors.toList());
    }
    public void deleteByMotherName(String name){
        studentArrayList.removeAll(filterByMotherName(name));

    }

    public List<Student> filterByFatherEarningFrom(int earning){
        return studentArrayList.stream()
                .filter(x-> x.getFatherEarnings() >= earning)
                .collect(Collectors.toList());
    }

    public List<Student> filterByFatherEarningTo(int earning){
        return studentArrayList.stream()
                .filter(x-> x.getFatherEarnings() <= earning)
                .collect(Collectors.toList());
    }

    public List<Student> filterByFatherEarning(int earningFrom, int earningTo){
        return studentArrayList.stream()
                .filter(x-> x.getFatherEarnings() >= earningFrom)
                .filter(x-> x.getFatherEarnings() <= earningTo)
                .collect(Collectors.toList());
    }

    public void deleteByFatherEarningFrom(int earning){
        studentArrayList.removeAll(filterByFatherEarningFrom(earning));

    }
    public void deleteByFatherEarningTo(int earning){
        studentArrayList.removeAll(filterByFatherEarningTo(earning));

    }

    public void deleteByFatherEarning(int earningFrom, int earningTo){
        studentArrayList.removeAll(filterByFatherEarning(earningFrom,earningTo));

    }

    public List<Student> filterByMotherEarningFrom(int earning){
        return studentArrayList.stream()
                .filter(x-> x.getMotherEarnings() >= earning)
                .collect(Collectors.toList());
    }

    public List<Student> filterByMotherEarningTo(int earning){
        return studentArrayList.stream()
                .filter(x-> x.getMotherEarnings() <= earning)
                .collect(Collectors.toList());
    }

    public List<Student> filterByMotherEarning(int earningFrom, int earningTo){
        return studentArrayList.stream()
                .filter(x-> x.getMotherEarnings() >= earningFrom)
                .filter(x-> x.getMotherEarnings() <= earningTo)
                .collect(Collectors.toList());
    }

    public void deleteByFatherMotherFrom(int earning){
        studentArrayList.removeAll(filterByMotherEarningFrom(earning));

    }
    public void deleteByMotherEarningTo(int earning){
        studentArrayList.removeAll(filterByMotherEarningTo(earning));

    }

    public void deleteByMotherEarning(int earningFrom, int earningTo){
        studentArrayList.removeAll(filterByMotherEarning(earningFrom,earningTo));

    }

    public List<Student> filterByNumberOfBrother(int count){
        return studentArrayList.stream()
                .filter(x-> x.getNumberOfBrothers()== count)
                .collect(Collectors.toList());
    }

    public void deleteByNumberOfBrother(int count){
        studentArrayList.removeAll(filterByNumberOfBrother(count));

    }

    public List<Student> filterByNumberOfSister(int count){
        return studentArrayList.stream()
                .filter(x-> x.getNumberOfSisters()== count)
                .collect(Collectors.toList());
    }
    public void deleteByNumberOfSister(int count){
        studentArrayList.removeAll(filterByNumberOfSister(count));

    }

    public List<Student> filterByFatherAndMotherName(String fatherName, String motherName){
        return studentArrayList.stream()
                .filter(x-> x.getFatherName().contains(fatherName) && x.getMotherName().contains(motherName))
                .collect(Collectors.toList());
    }
    public void deleteByFatherAndMotherName(String fatherName, String motherName){
        studentArrayList.removeAll(filterByFatherAndMotherName(fatherName,motherName));
    }


    public List<Student> filterByBrothersAndSistersCount(int brotherCount, int sisterCount){
        return studentArrayList.stream()
                .filter(x-> x.getNumberOfBrothers() == brotherCount && x.getNumberOfSisters() == sisterCount)
                .collect(Collectors.toList());
    }

    public void deleteByBrothersAndSistersCount(int brothersCount, int sistersCount){
        studentArrayList.removeAll(filterByBrothersAndSistersCount(brothersCount,sistersCount));
    }




}
