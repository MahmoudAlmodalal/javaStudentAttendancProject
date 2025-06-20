package com.example.test_javafx.models;
import java.io.Serializable;
import java.util.ArrayList;

public class SystemManger extends User implements Serializable {
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<TeacherAssistant> teacherAssistants = new ArrayList<>();

    public SystemManger() {
    }

    public SystemManger(String userName, String password) {
        super(userName, password);
    }

    public SystemManger(String name, String gender, String address, String userName, String password, ArrayList<Course> courses, ArrayList<TeacherAssistant> teacherAssistants) {
        super(name, gender, address, userName, password);
        this.courses = courses;
        this.teacherAssistants = teacherAssistants;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public ArrayList<TeacherAssistant> getTeacherAssistants() {
        return teacherAssistants;
    }

    public void setTeacherAssistants(ArrayList<TeacherAssistant> teacherAssistants) {
        this.teacherAssistants = teacherAssistants;
    }

    public void addTeacherAssistant(TeacherAssistant teacherAssistant) {
        teacherAssistants.add(teacherAssistant);
    }
    @Override
    public String toString() {
        return "SystemManger{" +
                "name=" + getName() +
                "gender=" + getGender() +
                "address=" + getAddress() +
                "userName=" + getUserName() +
                "password=" + getPassword() +
                '}';
    }
}

