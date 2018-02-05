package button.panic.cl.panicbutton.model;

/**
 * Created by jorgefigueroa on 04-02-18.
 */

public class User {

    private String username;
    private String nameClient;
    private String lastNameClient;
    private String emailClient;
    private String password;


    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastNameClient() {
        return lastNameClient;
    }

    public void setLastNameClient(String lastNameClient) {
        this.lastNameClient = lastNameClient;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String nameClient, String lastNameClient, String emailClient, String password) {
        this.username = username;
        this.nameClient = nameClient;
        this.lastNameClient = lastNameClient;
        this.emailClient = emailClient;
        this.password = password;
    }
}
