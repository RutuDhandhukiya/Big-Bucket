package com.example.bigbucket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgotPassword extends AppCompatActivity {

    private EditText etnewpassword, etconfirmpass;
    private Button btnotp, btnsubmite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        etnewpassword = findViewById(R.id.etnewpassword);
        etconfirmpass = findViewById(R.id.etconfirmpass);
        btnotp = findViewById(R.id.btnotp);
        btnsubmite = findViewById(R.id.btnsubmite);

        btnsubmite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent
                        = new Intent(ForgotPassword.this, ResetPassword.class);
                startActivity(intent);
            }
        });

    }
}