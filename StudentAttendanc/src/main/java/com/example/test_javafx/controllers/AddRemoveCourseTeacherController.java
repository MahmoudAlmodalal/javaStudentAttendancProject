package com.example.test_javafx.controllers;

import com.example.test_javafx.Navigation;
import com.example.test_javafx.models.Course;
import com.example.test_javafx.models.DataModel;
import com.example.test_javafx.models.MyAlert;
import com.example.test_javafx.models.TeacherAssistant;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddRemoveCourseTeacherController {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField teacherAssistantName;
    @FXML
    private TextField courseName;
    private static final Navigation navigation = new Navigation();
    private static final DataModel model = new DataModel();
    public void onAdd() {
        Course course = model.getCourseByName(courseName.getText());
        TeacherAssistant teacherAssistant = model.getTeacherAssistantByName(teacherAssistantName.getText());
        if (course != null && teacherAssistant.getCourseByName(courseName.getText()) == null) {
            teacherAssistant.addCourse(course);
            MyAlert.informationAlert("The course has been added successfully", "Done", null);
        }
        else {
            MyAlert.errorAlert("Course not found", "Error", null);
        }
    }

    public void onRemove() {
        Course course = model.getCourseByName(courseName.getText());
        TeacherAssistant teacherAssistant = model.getTeacherAssistantByName(teacherAssistantName.getText());
        if (course != null && teacherAssistant.getCourseByName(courseName.getText()) != null) {
            teacherAssistant.removeCourse(course);
            MyAlert.informationAlert("The course has been removed successfully", "Done", null);
        }
        else {
            MyAlert.errorAlert("Course not found", "Error", null);
        }
    }
    public void onBack() {
        navigation.navigateTo(rootPane, navigation.SYSTEM_MANGER_FXML);
    }
}
