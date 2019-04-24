package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;

import static sample.Main.users;

public class RegistrationController implements Serializable
{
    @FXML
    TextField regLogin;

    @FXML
    TextField regPassword;

    public void registration() throws IOException {
        String loginNew = regLogin.getText();
        String passwordNew = regPassword.getText();


        // check if login exists
            for (User user:users)
            {
                if (user.login.equals(loginNew))
                {
                    System.out.println("This login is already taken!");
                    return;
                }
            }
        System.out.println("User is new");

        // check if password valid
        int errCode = Password.isValid(passwordNew);

        if (errCode > 0)
        {
            System.out.println(ErrorsInfo.getMessage(errCode));
            return;
        }

        User user = new User(loginNew, new Passwords());

        users.add(user);
        System.out.println("Total users: " + users.size());
        String line = "C\\users.ser";
        try {

            FileOutputStream serialize = new FileOutputStream(line);
            ObjectOutputStream obs = new ObjectOutputStream(serialize);
            obs.writeObject(users);
            obs.flush();
            obs.close();
            serialize.close();
            System.out.println("Users have been serialized");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}