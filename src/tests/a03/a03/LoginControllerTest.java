package a03.a03;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.testfx.api.FxRobot;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

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

    @DisplayName("Should click login button")
    @Test
    void loginButtonClick(FxRobot robot) {
        robot.clickOn("#loginButton", new MouseButton[0]);
    }

    @DisplayName("Should click login button")
    @Test
    void cancelButtonClick(FxRobot robot) {
        robot.clickOn("#cancelButton", new MouseButton[0]);
    }

    @DisplayName("Should click login button")
    @Test
    void logoutButtonClick(FxRobot robot) throws IOException {

    }

    @ParameterizedTest(
            name = "#{index} - Testing password --> {0}"
    )
    @ValueSource(
            strings = {"p123@", "123456", ""}
    )

    void passwordLengthFail(String arg) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LoginController controller = new LoginController();
        Method method = LoginController.class.getDeclaredMethod("loginValidation");
        method.setAccessible(true);
        boolean output = (Boolean)method.invoke(controller, arg);
        Assertions.assertFalse(output);
    }
}