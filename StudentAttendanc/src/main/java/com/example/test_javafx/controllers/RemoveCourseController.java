package com.example.test_javafx.controllers;

import com.example.test_javafx.Navigation;
import com.example.test_javafx.models.Course;
import com.example.test_javafx.models.DataModel;
import com.example.test_javafx.models.MyAlert;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
public class RemoveCourseController {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField courseName;
    private static final Navigation navigation = new Navigation();
    private static final DataModel model = new DataModel();
    public void onRemove() {
        Course courseRemoved = null;
        boolean removed = false;
        for (Course course : model.getCourses()) {
            if (course.getSubject().equals(courseName.getText())) {
                removed = true;
                courseRemoved = course;
            }
        }
        if (removed) {
            model.removeCourse(courseRemoved);
            MyAlert.informationAlert("The course has been removed successfully", "Done", "Course removed: " + courseRemoved.getSubject());
        }
        else {
            MyAlert.errorAlert("The course dose not exist", "Error", null);
        }
    }
    public void onBack() {
        navigation.navigateTo(rootPane, navigation.SYSTEM_MANGER_FXML);
    }
}
