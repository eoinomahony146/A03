package a03.a03;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.Start;
import java.io.IOException;

class MainTest {

    @Start
    public void start(Stage stage1) throws Exception{
        Stage stg = stage1;
        stage1.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage1.setTitle("Registration form");
        stage1.setScene(new Scene(root, 500, 500));
        stage1.show();
    }

    @DisplayName("Should change scene")
    @Test
    public void changeScene(String fxml) throws IOException {
        Main m = new Main();
        Stage stg = new Stage();
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
        m.changeScene("success.fxml");
    }
}