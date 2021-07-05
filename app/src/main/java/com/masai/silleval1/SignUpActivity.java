package com.masai.silleval1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.masai.silleval1.R.id.signups;

public class SignUpActivity extends AppCompatActivity {
    private EditText mEtUserName;
    private EditText mEtEmail;
    private EditText mEtPassword;
    private TextView mBtnLogin;
    private TextView signin;
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        initViews();
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUserNameValid = isUserNameValid();
                boolean isPasswordValid = isPasswordValid();
                boolean isEmailValid = isEmailValid();
                if (isEmailValid && isPasswordValid && isUserNameValid) {
                    Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                    intent.putExtra("username",mEtUserName.getText().toString());
                    startActivity(intent);

                }
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
            }
        });


    }

    private void initViews() {
        mEtUserName = findViewById(R.id.signupname);
        mEtEmail = findViewById(R.id.signupemail);
        mEtPassword = findViewById(R.id.signuppswrd);
        mBtnLogin = findViewById(R.id.signups);
        signin = findViewById(R.id.singnupsignin);

    }
    private boolean isEmailValid() {
        if (mEtEmail.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            mEtEmail.setError("Invalid email");
            return false;
        }
    }
    private boolean isPasswordValid() {
        if (mEtPassword.getText().toString().length() >= 6) {
            return true;
        } else {
            mEtPassword.setError("Password is weak");
            return false;
        }
    }
    private boolean isUserNameValid() {
        if (mEtUserName.getText().toString().trim().length() >= 4) {
            return true;
        } else {
            mEtUserName.setError("Minimum 4 characters needed");
            return false;
        }
    }
}