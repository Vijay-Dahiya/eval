package com.masai.silleval1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {
    private EditText mTvUserName;
    private EditText mTvUserNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTvUserName = findViewById(R.id.signinname);
        mTvUserNames = findViewById(R.id.signupname);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("username");
        mTvUserName.setText(userName);

        //setContentView(R.layout.activity_home);

        Intent inten = getIntent();
        String userNames = inten.getStringExtra("user");
        mTvUserNames.setText(userNames);
    }
}