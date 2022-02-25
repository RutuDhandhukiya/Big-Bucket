package com.example.bigbucket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResetPassword extends AppCompatActivity {

    private EditText etnewpass, etnewresetpass;
    private Button btnsign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        etnewpass = findViewById(R.id.etnewpass);
        etnewresetpass = findViewById(R.id.etnewresetpass);
        btnsign = findViewById(R.id.btnsign);

        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent
                        = new Intent(ResetPassword.this, LoginPage.class);
                startActivity(intent);


            }
        });

    }
}