package com.example.test_javafx.controllers;

import com.example.test_javafx.Navigation;
import com.example.test_javafx.models.DataModel;
import com.example.test_javafx.models.MyAlert;
import com.example.test_javafx.models.TeacherAssistant;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
public class RemoveTeacherAssistantController {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField name;
    private static final Navigation navigation = new Navigation();
    private static final DataModel model = new DataModel();
    public void onRemove() {
        TeacherAssistant teacherAssistantRemoved = null;
        boolean removed = false;
        for (TeacherAssistant teacherAssistant : model.getTeacherAssistants()) {
            if (teacherAssistant.getName().equals(name.getText())) {
                teacherAssistantRemoved = teacherAssistant;
                removed = true;
                break;
            }
        }
        if (removed) {
            model.removeTeacherAssistant(teacherAssistantRemoved);
            MyAlert.informationAlert("The teacherAssistant has been removed successfully", "Done", "TeacherAssistant removed: " + name.getText());
        }
        else {
            MyAlert.errorAlert("The teacherAssistant dose not exist", "Error", null);
        }
    }
    public void onBack() {
        navigation.navigateTo(rootPane, navigation.SYSTEM_MANGER_FXML);
    }
}
