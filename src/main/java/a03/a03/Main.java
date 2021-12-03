package a03.a03;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

    public class Main extends Application {

        private static Stage stg;

        @Override
        public void start(Stage stage1) throws Exception{
            stg = stage1;
            stage1.setResizable(false);
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            stage1.setTitle("Registration form");
            stage1.setScene(new Scene(root, 500, 500));
            stage1.show();
        }

        public void changeScene(String fxml) throws IOException {
            Parent pane = FXMLLoader.load(getClass().getResource(fxml));
            stg.getScene().setRoot(pane);
        }

        public static void main(String[] args) {
            launch(args);
        }
    }