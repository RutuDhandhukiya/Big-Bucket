package com.example.bigbucket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class LoginPage extends AppCompatActivity
{

    private TextView tvaccount, tvsignup, tvfp;
    private EditText etuser, etpassword;
    private Button btnlogin1;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        mAuth = FirebaseAuth.getInstance();

        tvaccount = findViewById(R.id.tvaccount);
        tvsignup = findViewById(R.id.tvsignup);
        tvfp = findViewById(R.id.tvfp);
        etuser = findViewById(R.id.etuser);
        etpassword = findViewById(R.id.etpassword);
        btnlogin1 = findViewById(R.id.btnlogin1);

        btnlogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) 
            {
                loginUserAccount();
            }

        });

        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent
                        = new Intent(LoginPage.this, SignUppage.class);
                startActivity(intent);
            }
        });

        tvfp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent
                        = new Intent(LoginPage.this, ForgotPassword.class);
                startActivity(intent);
            }
        });

    }
    private void loginUserAccount()
    {
        String email, password;
        email = etuser.getText().toString();
        password = etpassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter email!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter password!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(
                                    @NonNull Task<AuthResult> task)
                            {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),
                                            "Login successful!!",
                                            Toast.LENGTH_LONG)
                                            .show();


                                    // if sign-in is successful
                                    // intent to home activity
                                    Intent intent
                                            = new Intent(LoginPage.this, navigation_drawer.class);
                                    startActivity(intent);
                                }
                                else {

                                    // sign-in failed
                                    Toast.makeText(LoginPage.this, "Login Error" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user != null) {
            startActivity(new Intent(LoginPage.this, navigation_drawer.class));
        }
    }
}