package button.panic.cl.panicbutton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import butterknife.ButterKnife;
import butterknife.InjectView;
import button.panic.cl.panicbutton.model.LoginBody;
import button.panic.cl.panicbutton.model.MyApiEndpointInterface;
import button.panic.cl.panicbutton.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PanicButton extends AppCompatActivity {
    @InjectView(R.id.username) EditText _username;
    @InjectView(R.id.password) EditText _password;
    @InjectView(R.id.loginButton) Button _loginButton;
    @InjectView(R.id.registerLink) TextView _registerLink;
    private static final String TAG = "LoginActivity";
    private MyApiEndpointInterface myApi;
    private Retrofit mRestAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panic_button);

        ButterKnife.inject(this);

        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();

            }
        });


        _registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PanicButton.this, Register.class));
            }
        });
    }

    private void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(PanicButton.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Autenticando...");
        progressDialog.show();

        String email = _username.getText().toString();
        String password = _password.getText().toString();

        // Crear conexión al servicio REST
        mRestAdapter = new Retrofit.Builder()
                .baseUrl(MyApiEndpointInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = mRestAdapter.create(MyApiEndpointInterface.class);

        Call<User> registerCall = myApi.login(new LoginBody(email, password));

        registerCall.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("pasa aqui", "llega aqui");
                response.message();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _username.getText().toString();
        String password = _password.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _username.setError("Ingrese un mail correcto");
            valid = false;
        } else {
            _username.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _password.setError("Debe contener entre 4 y 10 caracteres");
            valid = false;
        } else {
            _password.setError(null);
        }

        return valid;
    }
}
