package button.panic.cl.panicbutton.model;

import button.panic.cl.panicbutton.Register;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by jorgefigueroa on 04-02-18.
 */

public interface MyApiEndpointInterface {
    public static final String BASE_URL = "http://192.168.1.8:8080/";

    @POST("login/sign-up")
    Call<User> register(@Body User user);

    @POST("login")
    Call<User> login(@Body LoginBody loginBody);


}
