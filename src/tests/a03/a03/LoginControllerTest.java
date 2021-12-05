package a03.a03;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({ApplicationExtension.class})
class LoginControllerTest {
    LoginControllerTest() {
    }

    @Start
    public void start(Stage stage1) throws Exception{
        Stage stg = stage1;
        stage1.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage1.setTitle("Registration form");
        stage1.setScene(new Scene(root, 500, 500));
        stage1.show();
    }

    @DisplayName("Should Click SignUp Button And Display Register Form")
    @Test
    void loginButtonClick(FxRobot robot) {
        robot.clickOn("#loginButton", new MouseButton[0]);
    }

}