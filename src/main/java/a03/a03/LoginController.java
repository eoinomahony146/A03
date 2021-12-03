package a03.a03;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import java.io.IOException;

public class LoginController {
    @FXML
    private Label login_message;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    public void closeButton(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    public void userLogin(ActionEvent event) throws IOException {
        loginValidation();
    }

    public void loginValidation() throws IOException {
        Main m = new Main();
        if (password.getText().isBlank() || email.getText().isBlank())
            login_message.setText("Please enter your email and password");
        else {
            if (!email.getText().matches("[a-zA-Z0-9-+=$%^&*_]+@[a-zA-Z0-9-+=$%^&*_]+\\.com"))
                login_message.setText("Email format is not correct");
            else {
                if (password.getText().length() <= 7)
                    login_message.setText("Password must be at least 7 characters");
                else {
                    if (!password.getText().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+-._=])(?=\\S+$).{7,}$"))
                        login_message.setText("Please enter password with at least 1 digit, 1 upper and lower case " +
                                "and 1 special character");
                    else {
                        m.changeScene("success.fxml");
                    }
                }
            }
        }
    }
}