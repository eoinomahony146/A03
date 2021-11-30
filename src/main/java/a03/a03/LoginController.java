package a03.a03;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class LoginController {
    @FXML
    private Button cancelButton;

    @FXML
    private Label login_fail;

    public void setLoginButton(ActionEvent event) {
        login_fail.setText("You tried to login");
    }

    public void setCancelButton(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}