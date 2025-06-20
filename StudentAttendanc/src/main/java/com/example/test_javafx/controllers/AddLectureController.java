package com.example.test_javafx.controllers;

import com.example.test_javafx.Navigation;
import com.example.test_javafx.models.Course;
import com.example.test_javafx.models.DataModel;
import com.example.test_javafx.models.Lecture;
import com.example.test_javafx.models.MyAlert;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddLectureController {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField lectureName;
    @FXML
    private TextField lecturePlace;
    private static final Navigation navigation = new Navigation();
    private static final DataModel model = new DataModel();
    public void onAdd() {
        Course course = model.getRegisteredCourse();
        if (isValid() && course.getLectureByName(lectureName.getText()) == null) {
            course.addLectures(new Lecture(lectureName.getText(), lecturePlace.getText(), course));
            LectureAttendanceController.setLecture(lectureName.getText());
            MyAlert.informationAlert("The currentLecture has been added successfully", "Done", null);
            navigation.navigateTo(rootPane, navigation.LECTURE_ATTENDANCE_FXML);
        }
        else if (isValid()){
            MyAlert.errorAlert("Lecture already exist!", "Error", null);
        }
        else {
            MyAlert.errorAlert("All fields must be entered!", "Error", null);
        }
    }
    public void onBack() {
        navigation.navigateTo(rootPane, navigation.TEACHER_ASSISTANT_FXML);
    }
    private boolean isValid() {
        return !lectureName.getText().isEmpty()
                && !lecturePlace.getText().isEmpty();
    }
}
