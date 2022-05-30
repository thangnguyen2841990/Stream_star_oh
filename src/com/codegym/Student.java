package com.codegym;

import java.util.List;

public class Student {
    public String name;
    public boolean isMale; // true - male or false female
    public int age;
    public int score;
    public List<String> subjects;
    public Student(String name, boolean isMale, int age, int score, List<String> subjects) {
        this.name = name;
        this.isMale = isMale;
        this.age = age;
        this.score = score;
        this.subjects = subjects;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Sinh viên{" +
                "tên='" + name + '\'' +
                ", giới tính=" + isMale +
                ", tuổi=" + age +
                ", điểm=" + score +
                '}';
    }
}
