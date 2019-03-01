package com.example.login;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    private TextInputLayout emailinput;
    private TextInputLayout fname;
    private TextInputLayout lname;
    private TextInputLayout password;


    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //uses texts inputs and assigns them
        emailinput = findViewById(R.id.email);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        password = findViewById(R.id.password);

    }

    //used to open the login page once register button is pressed
    public void openActivityMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //validates first name is greater than 1 character and field is not empty
    private boolean validatefname() {
        String nameInput = fname.getEditText().getText().toString().trim();

        if (nameInput.isEmpty()) {
            fname.setError("Field can't be empty");
            return false;
        } else if (nameInput.length() <= 1) {
            fname.setError("Enter Your First Name");
            return false;
        } else {
            fname.setError(null);
            return true;
        }
    }

    //validates last name is greater than 1 character and field is not empty
    private boolean validatelname() {
        String lnameInput = lname.getEditText().getText().toString().trim();

        if (lnameInput.isEmpty()) {
            lname.setError("Field can't be empty");
            return false;
        } else if (lnameInput.length() <= 1) {
            lname.setError("Enter Your Last Name");
            return false;
        } else {
            lname.setError(null);
            return true;
        }
    }

    //validates email is in correct format and field is not empty
    private boolean validateEmail() {
        String emailInput = emailinput.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            emailinput.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            emailinput.setError("Please enter a valid email address");
            return false;
        } else {
            emailinput.setError(null);
            return true;
        }
    }

    //validates password field is not empty and is strong
    private boolean validatePassword() {
        String passwordinput = password.getEditText().getText().toString().trim();

        if (passwordinput.isEmpty()) {
            password.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordinput).matches()) {
            password.setError("Password too weak");
            return false;
        } else {
            password.setError(null);
            return true;
        }
    }

    // validates all once register button is pressed
    public void confirmRegistration(View v) {
        if (!validateEmail() | !validatelname() |!validatefname() | !validatePassword()) {
            return;
        }

        button = (Button) findViewById(R.id.register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMainActivity();
            }
        });

    }
}

