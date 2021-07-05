package com.masai.silleval1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {

    private EditText mEtUserName;
    private EditText mEtPassword;
    private TextView mBtnLogin;
    private TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initViews();
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUserNameValid = isUserNameValid();
                boolean isPasswordValid = isPasswordValid();
                if (isPasswordValid && isUserNameValid) {
                    Intent inten = new Intent(SignInActivity.this, HomeActivity.class);
                    inten.putExtra("user", mEtUserName.getText().toString());
                    startActivity(inten);
                    Log.d("STo","after startactivity");

                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intens = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intens);
                Log.d("STO","after startactivity");
            }
        });
    }

    private void initViews() {
        mEtUserName = findViewById(R.id.signinname);
        mEtPassword = findViewById(R.id.signinpswrd);
        mBtnLogin = findViewById(R.id.signin);
        signup = findViewById(R.id.signupin);
    }
    private boolean isPasswordValid() {
        if (mEtPassword.getText().toString().length() >= 6) {
            return true;
        } else {
            mEtPassword.setError("Password length is less than 6 characters");
            return false;
        }
    }
    private boolean isUserNameValid() {
        if (mEtUserName.getText().toString().trim().length() >= 4) {
            return true;
        } else {
            mEtUserName.setError("Username is not valid");
            return false;
        }
    }
}

