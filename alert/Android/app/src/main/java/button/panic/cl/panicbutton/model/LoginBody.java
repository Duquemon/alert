package button.panic.cl.panicbutton.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jorgefigueroa on 05-02-18.
 */

public class LoginBody {
    @SerializedName("emailClient")
    private String emailClient;
    private String password;

    public LoginBody(String emailClient, String password) {
        this.emailClient = emailClient;
        this.password = password;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
