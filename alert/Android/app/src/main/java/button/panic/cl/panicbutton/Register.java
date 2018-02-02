package button.panic.cl.panicbutton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jorgefigueroa on 01-02-18.
 */

public class Register extends AppCompatActivity {
    EditText username, name, lastName, email, password;
    Button registerButton;
    TextView loginLink;
    String URL = "http://192.168.1.41:8080/login/sign-up";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText)findViewById(R.id.username);
        name = (EditText)findViewById(R.id.name);
        lastName = (EditText)findViewById(R.id.lastName);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        registerButton = (Button)findViewById(R.id.registerButton);
        loginLink = (TextView)findViewById(R.id.loginLink);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JSONObject ob = new JSONObject();
                try {
                    ob.put("username", username.getText().toString());
                    ob.put("nameClient", name.getText().toString());
                    ob.put("lastNameClient", lastName.getText().toString());
                    ob.put("emailClient", email.getText().toString());
                    ob.put("password", password.getText().toString());
                } catch (JSONException e) {

                    e.printStackTrace();

                }

                JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, URL, ob,
                        new Response.Listener<JSONObject>(){

                            @Override
                            public void onResponse(JSONObject s) {
                                Log.d("SOMETAG", s.toString());
                                Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_LONG).show();
//                                if(s.equals("true"))
//                                    Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_LONG).show();
//                                else{
//                                    Toast.makeText(Register.this, "Can't Register", Toast.LENGTH_LONG).show();
//                                }
                            }
                        }, new Response.ErrorListener(){
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                Log.d("SOMETAG", volleyError.toString());
                                Toast.makeText(Register.this, "Some error occurred -> "+volleyError, Toast.LENGTH_LONG).show();;
                            }
                        }
                );
//                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, URL, ob,
//                        new Response.Listener<JsonObjectRequest>(){
//                            @Override
//                            public void onResponse(JsonObjectRequest s) {
//                                Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_LONG).show();
////                                if(s.equals("true"))
////                                    Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_LONG).show();
////                                else{
////                                    Toast.makeText(Register.this, "Can't Register", Toast.LENGTH_LONG).show();
////                                }
//                            }
//                        }, new Response.ErrorListener(){
//                            @Override
//                            public void onErrorResponse(VolleyError volleyError) {
//                                Toast.makeText(Register.this, "Some error occurred -> "+volleyError, Toast.LENGTH_LONG).show();;
//                            }
//                        }) {
//                    @Override
//                    protected Map<String, String> getParams() throws AuthFailureError {
//                        Map<String, String> parameters = new HashMap<String, String>();
//                        parameters.put("username", username.getText().toString());
//                        parameters.put("nameClient", name.getText().toString());
//                        parameters.put("lastNameClient", lastName.getText().toString());
//                        parameters.put("emailClient", email.getText().toString());
//                        parameters.put("password", password.getText().toString());
//                        return parameters;
//                    }
//                };

                        RequestQueue rQueue = Volley.newRequestQueue(Register.this);
                rQueue.add(req);
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });


    }

}
