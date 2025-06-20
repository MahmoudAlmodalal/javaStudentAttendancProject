package com.example.test_javafx.controllers;

import com.example.test_javafx.Navigation;
import com.example.test_javafx.models.DataModel;
import com.example.test_javafx.models.MyAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class EditSystemMangerController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField name;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private TextField phoneNumber1;
    @FXML
    private TextField phoneNumber2;
    @FXML
    private TextField address;
    @FXML
    private TextField userName;
    @FXML
    private TextField password;
    private static final Navigation navigation = new Navigation();
    private static final DataModel model = new DataModel();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //set TextFiled to accept Numbers Only
        phoneNumber1.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("\\d*")) {
                phoneNumber1.setText(newValue.replaceAll("\\D", ""));
            }
        });
        phoneNumber2.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("\\d*")) {
                phoneNumber2.setText(newValue.replaceAll("\\D", ""));
            }
        });
    }
    public void onRadioButtonToggle(ActionEvent actionEvent) {
        ((actionEvent.getSource() == male) ? female : male).setSelected(false);
        ((actionEvent.getSource() == male) ? male : female).setSelected(true);
    }
    public void onEditSystemManger() {
        if (isValid()) {
            model.getSystemManger().setName(name.getText());
            model.getSystemManger().setPhoneNumber(phoneNumber1.getText(), phoneNumber2.getText());
            model.getSystemManger().setAddress(address.getText());
            model.getSystemManger().setUserName(userName.getText());
            model.getSystemManger().setPassword(password.getText());
            MyAlert.informationAlert("The system manger has been updated successfully", "Done", null);
        }
        else {
            MyAlert.errorAlert("All fields must be entered!", "Error", null);
        }
    }
    public void onBack() {
        navigation.navigateTo(rootPane, navigation.SYSTEM_MANGER_FXML);
    }
    private boolean isValid() {
        return !name.getText().isEmpty()
                && (!phoneNumber1.getText().isEmpty() || !phoneNumber2.getText().isEmpty())
                && !address.getText().isEmpty()
                && !userName.getText().isEmpty()
                && !password.getText().isEmpty();
    }
}
