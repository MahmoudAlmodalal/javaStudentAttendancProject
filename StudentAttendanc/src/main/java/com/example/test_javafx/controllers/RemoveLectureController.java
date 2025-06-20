package com.example.test_javafx.controllers;

import com.example.test_javafx.Navigation;
import com.example.test_javafx.models.Course;
import com.example.test_javafx.models.DataModel;
import com.example.test_javafx.models.Lecture;
import com.example.test_javafx.models.MyAlert;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RemoveLectureController {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField lectureName;
    private static final Navigation navigation = new Navigation();
    private static final DataModel model = new DataModel();

    public void onRemove() {
        Course course = model.getRegisteredCourse();
        Lecture removedLecture = null;
        boolean removed = false;
        for (Lecture lecture : course.getLectures()) {
            if (lecture.getName().equals(lectureName.getText())) {
                removed = true;
                removedLecture = lecture;
                break;
            }
        }
        if (removed) {
            course.removeLecture(removedLecture);
            MyAlert.informationAlert("The currentLecture has been successfully deleted", "Done", null);
        }
        else {
            MyAlert.errorAlert("Lecture dose not exists ", "Error", null);
        }
    }
    public void onBack() {
        navigation.navigateTo(rootPane, navigation.TEACHER_ASSISTANT_FXML);
    }
}
