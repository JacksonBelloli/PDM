package com.example.academia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView inputUsername;
    private TextView inputPassword;
    private Button btnLogin;

    private static boolean doLogin(String username, String password) {

        if(username == null || password == null || username == "" || password == "") {
            return  false;
        }

        if(username.equals("Administrador") && password.equals("Administrador")) {
            return true;
        }
        if(username.equals("Adm") && password.equals("Adm123")) {
            return true;
        }
        if(username.equals("Administrator") && password.equals("Que3B1eng4ElT0r0")) {
            return true;
        }
        if(username.equals("Root") && password.equals("pr0m1uscu0")) {
            return true;
        }

        return false;
    }

    private static boolean isValidUsername(TextView textView) {
        String username = textView.getText().toString();

        if(username.equals("")) {
            textView.setError("Username cannot be blank");
        }

        if(username.contains(" ")) {
            textView.setError("The username must not contain spaces.");
            return false;
        }

        return true;
    }
    private static boolean isValidPassword(TextView textView) {
        String username = textView.getText().toString();

        if(username.equals("")) {
            textView.setError("Password cannot be blank");
        }

        if(username.contains(" ")) {
            textView.setError("The password must not contain spaces.");
            return false;
        }

        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputUsername = findViewById(R.id.inputUsername);
        inputPassword = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(!isValidUsername(inputUsername)) {
                    return;
                }
                if(!isValidPassword(inputPassword)) {
                    return;
                }
                String username = inputUsername.getText().toString();
                String password = inputPassword.getText().toString();



                if(doLogin(username, password)) {
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                    SharedPreferences.Editor editor = preferences.edit();

                    editor.putString("KEY_USERNAME", username.toString());
                    editor.putString("KEY_PASSWORD", password.toString());
                    editor.apply();

                    Intent it = new Intent(MainActivity.this, DashBoard.class);
                    it.putExtra("username", username.toString());
                    it.putExtra("password", password.toString());

                    startActivity(it);
                }
            }
        });


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String username = preferences.getString("KEY_USERNAME", null);
        String password = preferences.getString("KEY_PASSWORD", null);

        if(username != null && password != null) {
            inputUsername.setText(username);
            inputPassword.setText(password);
        }

    }
}