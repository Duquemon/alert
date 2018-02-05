package button.panic.cl.panicbutton.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jorgefigueroa on 05-02-18.
 */

public class LoginBody {
    @SerializedName("email")
    private String email;
    private String password;

    public LoginBody(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
