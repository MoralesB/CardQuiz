package com.example.login;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    private Button button;
    private Button button2;
    private TextInputLayout email;
    private TextInputLayout pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityRegistration();
            }
        });

    }
    public void openActivitySignIn(){
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
    }

    public void openActivityRegistration(){
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }


    private boolean validateEmail () {
        String emailInput = email.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            email.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            email.setError("Please enter a valid email address");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }

    private boolean validatePassword () {
        String passwordInput = pass.getEditText().getText().toString().trim();

        if (passwordInput.isEmpty()) {
            pass.setError("Field can't be empty");
            return false;
        } else {
            pass.setError(null);
            return true;
        }
    }


    public void confirmInput (View v){
        if (!validateEmail() | !validatePassword()) {
            return;
        }

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySignIn();
            }
        });

    }


}
