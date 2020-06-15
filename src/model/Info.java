package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ashkan mohseni
 */
public class Info {

    private String username;
    private String email;
    private String password;
    
    HashMap<String, String> userpass = new HashMap<>();

    public Info() {

    }

    public Info(String username, String email, String password) {
        setUsername(username);
        setEmail(email);
        setPassword(password);
    }

    public void setUsername(String username) {
        if (username.matches("^[A-Za-z0-9_-]*$")) {
             this.username = username;
        } else{
         this.username = "notValid";   
        }
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        if (email.matches("^(.+)@(.+)$")) {
        this.email = email;    
        } else{
            this.email = "notValid";
        } 
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        if (password.matches("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")) {
            this.password = password;
        } else{
            this.password = "notValid";
        }
        
    }

    public String getPassword() {
        return password;
    }
    
    public void setUserpass(HashMap<String, String> userpass) {
        this.userpass = userpass;
    }

    // To write the new user's info to the UserPass.txt
    public void printUserPass() throws IOException {
        if (username != "notValid" && password != "notValid" && email != "notValid") {
        File file = new File("src/model/UserPass.txt");
        FileWriter fw = new FileWriter(file, true);
        try (fw) {
            fw.write(username + " ");
            fw.write(password);
            fw.write("\n");
        }
        }
    }

    // To read the user's info and store it in the hashMap so we can check it later on
    public void ReadUserPass() throws FileNotFoundException {
        File file = new File("src/model/UserPass.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {
            String user = sc.next();
            String pss = sc.next();
            userpass.put(user, pss);
        }
    }

    public HashMap<String, String> getUserpass() throws IOException {
        if (username != "notValid" && password != "notValid" && email !="notValid") {
            userpass.put(username, password);
            ReadUserPass();
        }
        return userpass;
    }
    
}
