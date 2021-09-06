package com.ivashkinigor.student.model;


import java.util.Objects;

public class Student {
    private final String name;
    private final Parent father;
    private final Parent mother;
    private final int numberOfBrothers;
    private final int numberOfSisters;

    public Student(String name, Parent father, Parent mother, int numberOfBrothers, int numberOfSisters) {
        this.name = name;
        this.father = father;
        this.mother = mother;
        this.numberOfBrothers = numberOfBrothers;
        this.numberOfSisters = numberOfSisters;
    }
    public String getName() {
        return name;
    }



    public int getNumberOfSisters() {
        return numberOfSisters;
    }

    public int getNumberOfBrothers() {
        return numberOfBrothers;
    }

    public Parent getFather() {
        return father;
    }

    public Parent getMother() {
        return mother;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Student)) {
            return false;
        }
        Student student = (Student) obj;
        return this.name.equals(student.name) &&
                this.father.equals(student.father) &&
                this.mother.equals(student.mother) &&
                this.numberOfBrothers == student.numberOfBrothers &&
                this.numberOfSisters == student.numberOfSisters;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, father, mother, numberOfBrothers, numberOfSisters);
    }


}
