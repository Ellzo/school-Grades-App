package com.example.schoolgrades;

public class subject {
    private String name;
    private String grade;

    //Subject constructor
    public subject(String subjectName, String subjectGrade) {
        this.name = subjectName;
        this.grade = subjectGrade;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

}
