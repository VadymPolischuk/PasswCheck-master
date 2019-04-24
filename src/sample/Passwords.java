package sample;

import java.io.Serializable;
import java.util.HashMap;

import static sample.Main.users;

public class Passwords implements Serializable {
    public HashMap<Integer, Password> getPasswords()
    {
        return passwords;
    }

    private HashMap<Integer, Password> passwords;

    public Passwords()
    {
        passwords = new HashMap<>();
    }

    /**
     *
     * @param password - New user password
     * @return true if password succesfully added
     */
    public boolean addPassword(String password)
    {
        // todo Check if password is valid (Password.isValid)
        if(Password.isValid(password) == 0)
        {
            System.out.println("Password is OK");
        }
        // todo create new Password
        Password password1 = new Password(password);
        password1.setActive(true);

        // todo make all previous passwords inactive
        for (int i = 0; i <users.size()-1 ; i++) {
            passwords.get(i).setActive(false);
        }





        // todo add to current list



        return true;
    }

    public boolean checkPassword(String password)
    {
        //todo check if this password equals to active
        passwords.get(passwords.size()).isActive();

        return true;
    }
}
