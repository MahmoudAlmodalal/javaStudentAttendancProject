package com.example.test_javafx.controllers;

import com.example.test_javafx.Navigation;
import com.example.test_javafx.models.DataModel;
import com.example.test_javafx.models.MyAlert;
import com.example.test_javafx.models.SystemManger;
import com.example.test_javafx.models.TeacherAssistant;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class StartController {

    @FXML
    private AnchorPane rootPane;
    @FXML
     private TextField userName;
    @FXML
     private PasswordField password;
    private static final Navigation navigation = new Navigation();
    private static final DataModel model = new DataModel();

    public void onLogin() {
        boolean found = false;
        SystemManger systemManger = model.getSystemManger();
        if (systemManger.getUserName() != null
                && systemManger.getPassword() != null
                && systemManger.getUserName().equals(userName.getText())
                && systemManger.getPassword().equals(password.getText())) {
            navigation.navigateTo(rootPane, navigation.SYSTEM_MANGER_FXML);
            found = true;
        } else {
            for (TeacherAssistant teacherAssistants : model.getTeacherAssistants()) {
                if (teacherAssistants.getUserName() != null
                        && teacherAssistants.getPassword() != null
                        && teacherAssistants.getUserName().equals(userName.getText())
                        && teacherAssistants.getPassword().equals(password.getText())) {
                    model.setRegisteredTeacherAssistant(teacherAssistants);
                    navigation.navigateTo(rootPane, navigation.ENTER_COURSE_FXML);
                    found = true;
                }
            }
        }
        if (!found) {
            MyAlert.errorAlert("User Not Found!", "Error", "User name: " + userName.getText() + ", Password: " + password.getText());
        }
    }
}
