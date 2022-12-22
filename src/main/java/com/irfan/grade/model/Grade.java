package com.irfan.grade.model;

public enum Grade {
    A("A", 85, 100),
    B("B", 76, 84),
    C("C", 61, 75),
    D("D", 46, 60),
    E("E", 0, 45);

    String grade;
    int gradeMin;
    int gradeMax;

    Grade(String grade, int gradeMin, int gradeMax) {
        this.grade = grade;
        this.gradeMin = gradeMin;
        this.gradeMax = gradeMax;
    }

    public String getGrade() {
        return grade;
    }

    public int getGradeMin() {
        return gradeMin;
    }

    public int getGradeMax() {
        return gradeMax;
    }

    public static Grade getGrade(Double score) {
        for (Grade g : values()) {
            if (score >= g.getGradeMin() && score <= g.getGradeMax()) {
                return g;
            }
        }

        return null;
    }
}

