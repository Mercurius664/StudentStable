package com.ivashkinigor.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private ArrayList<Student> studentArrayList;
    private ArrayList<Student> studentArrayListForFind;
    public Model() {
        studentArrayList = new ArrayList<Student>();
        studentArrayListForFind = new ArrayList<Student>();
    }

    public ArrayList<Student> getStudents() {
        return studentArrayList;
    }

    public ArrayList<Student> getStudentArrayListForFind() {
        return studentArrayListForFind;
    }

    public List<Student> filterByStudentName(String name){
        return studentArrayList.stream()
                .filter(x-> x.getName().contains(name))
                .collect(Collectors.toList());
    }
    public void deleteByStudentName(String name){
        studentArrayList.removeAll(filterByStudentName(name));

    }

    public List<Student> filterByFatherName(String name){
        return studentArrayList.stream()
                .filter(x-> x.getFather().getName().contains(name))
                .collect(Collectors.toList());
    }
    public void deleteByFatherName(String name){
        studentArrayList.removeAll(filterByFatherName(name));

    }

    public List<Student> filterByMotherName(String name){
        return studentArrayList.stream()
                .filter(x-> x.getMother().getName().contains(name))
                .collect(Collectors.toList());
    }
    public void deleteByMotherName(String name){
        studentArrayList.removeAll(filterByMotherName(name));

    }


    public List<Student> filterByFatherEarning(int earningFrom, int earningTo){
        return studentArrayList.stream()
                .filter(x-> x.getFather().getEarnings() >= earningFrom)
                .filter(x-> x.getFather().getEarnings() <= earningTo)
                .collect(Collectors.toList());
    }
    public void deleteByFatherEarning(int earningFrom, int earningTo){
        studentArrayList.removeAll(filterByFatherEarning(earningFrom,earningTo));

    }
    public List<Student> filterByMotherEarning(int earningFrom, int earningTo){
        return studentArrayList.stream()
                .filter(x-> x.getMother().getEarnings() >= earningFrom)
                .filter(x-> x.getMother().getEarnings() <= earningTo)
                .collect(Collectors.toList());
    }
    public void deleteByMotherEarning(int earningFrom, int earningTo){
        studentArrayList.removeAll(filterByMotherEarning(earningFrom,earningTo));

    }

    public List<Student> filterByParentEarning(List<Student> fatherList, List<Student> motherList){
        return fatherList.stream()
                .filter(motherList::contains)
                .collect(Collectors.toList());
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
                .filter(x-> x.getFather().getName().contains(fatherName) && x.getMother().getName().contains(motherName))
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
