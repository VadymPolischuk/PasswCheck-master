package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main extends Application {
    public static ArrayList<User> users;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        primaryStage.setTitle("Welcome");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        users = new ArrayList<>();
        //users.add();

        FileInputStream deserialize = new FileInputStream("C\\users.ser");
        ObjectInputStream ois = new ObjectInputStream(deserialize);
        users = (ArrayList<User>) ois.readObject();
        ois.close();
        deserialize.close();
        launch(args);
    }
}
