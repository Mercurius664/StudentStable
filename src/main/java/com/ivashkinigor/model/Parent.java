package com.ivashkinigor.model;

import java.util.Objects;

public class Parent {
    private final String name;
    private final int earnings;

    public Parent(String name, int earnings) {
        this.name = name;
        this.earnings = earnings;
    }

    public String getName() {
        return name;
    }

    public int getEarnings() {
        return earnings;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Parent)) {
            return false;
        }
        Parent parent = (Parent) obj;
        return  name.equals(parent.getName()) &&
                earnings == parent.getEarnings();

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, earnings);
    }
}
