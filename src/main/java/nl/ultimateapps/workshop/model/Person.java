package nl.ultimateapps.workshop.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Person {

    private String name;
    private LocalDate dob;
    private char gender;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
