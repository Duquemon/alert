package button.panic.cl.panicbutton;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.victor.loading.newton.NewtonCradleLoading;

import button.panic.cl.panicbutton.model.MyApiEndpointInterface;
import button.panic.cl.panicbutton.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jorgefigueroa on 01-02-18.
 */

public class Register extends AppCompatActivity {
    EditText username, name, lastName, email, password;
    Button registerButton;
    TextView loginLink;
    private MyApiEndpointInterface myApi;
    private Retrofit mRestAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = (EditText) findViewById(R.id.username);
        name = (EditText) findViewById(R.id.name);
        lastName = (EditText) findViewById(R.id.lastName);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        // Crear conexión al servicio REST
        mRestAdapter = new Retrofit.Builder()
                .baseUrl(MyApiEndpointInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myApi = mRestAdapter.create(MyApiEndpointInterface.class);

        registerButton = (Button)findViewById(R.id.registerButton);
        loginLink = (TextView)findViewById(R.id.loginLink);

        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!isOnline()) {
                    showLoginError(getString(R.string.error_network));
                    return;
                }

                registerUser();

            }

        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Register.this, PanicButton.class));
            }
        });



    }
    private void registerUser() {

        String userId = username.getText().toString();
        String nameUser = name.getText().toString();
        String lastNameUser = lastName.getText().toString();
        String emailUser = email.getText().toString();
        String passwordUser = password.getText().toString();


        Call<User> registerCall = myApi.register(new User(userId, nameUser,lastNameUser, emailUser, passwordUser));

        registerCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                showLoginError(t.getMessage());
            }
        });

    }

    private boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

    private void showLoginError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
