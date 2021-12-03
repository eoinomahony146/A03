package a03.a03;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
//import javafx.scene.control.TextInputControl;

import java.io.IOException;

public class LoginController {
    @FXML
    private Button cancelButton;

    @FXML
    private Label login_message;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;


    public void setLoginButton(ActionEvent event) {
        login_message.setText("You tried to login");
    }

    public void userLogin(ActionEvent event) throws IOException {
        loginValidation();
    }

    public void setCancelButton(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void loginValidation() throws IOException {
        Main m = new Main();
        if (!email.getText().matches("^^[\\\\w!#$%&'*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&'*+/=?`{|}~^-]+" +
                ")*@(?:[a-zA-Z0-9-]+\\\\.)+[\\\\a-zA-Z]{2,6}") &&
                password.getText().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])$")
                && password.getText().length() >= 7)
                login_message.setText("Success");
        else {
            if (email.getText().isBlank() && password.getText().isBlank())
                login_message.setText("Please enter your email and password");
            else {
                if (!email.getText().matches("^[\\\\w!#$%&'*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&'*+/=?`{|}~^-]+" +
                        ")*@(?:[a-zA-Z0-9-]+\\\\.)+[\\\\a-zA-Z]{2,6}") && !password.getText().isBlank())
                    login_message.setText("Please enter your email");
                else if (password.getText().isBlank() && email.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$"))
                    login_message.setText("Please enter your password");
                else {
                    if (password.getText().length() < 7)
                        login_message.setText("Password must be at least 6 characters");
                        if (!password.getText().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])$"))
                            login_message.setText("Please enter password with at least 1 digit, 1 upper and lower case" +
                                    "and 1 special character");
                }
            }
        }
    }
}