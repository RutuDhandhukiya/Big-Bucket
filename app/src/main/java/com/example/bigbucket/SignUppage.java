package com.example.bigbucket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUppage extends AppCompatActivity
{

    private EditText etname, etemil, etpass, etrepass;
    private TextView tvacc,tvlogin;
    private Button btnsignup1;
    private ImageView imgbb3;
    private FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    String userID;
    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_uppage);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        tvacc = findViewById(R.id.tvacc);
        tvlogin = findViewById(R.id.tvlogin);

        etname = findViewById(R.id.etname);
        etemil = findViewById(R.id.etemail);
        etpass = findViewById(R.id.etpass1);
        btnsignup1 = findViewById(R.id.btnsignup1);

        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent
                        = new Intent(SignUppage.this, LoginPage.class);
                startActivity(intent);
            }
        });

        btnsignup1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                registerNewUser();
            }

            private void registerNewUser() {
                String name, email, password;
                name = etname.getText().toString();
                email = etemil.getText().toString();
                password = etpass.getText().toString();

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your Name!!",
                            Toast.LENGTH_LONG)
                            .show();
                    return;
                }

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
                mAuth
                        .createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),
                                            "Registration successful!",
                                            Toast.LENGTH_LONG)
                                            .show();
                                    userID = mAuth.getCurrentUser().getUid();
                                    DocumentReference documentReference = fStore.collection("Users").document(userID);
                                    Map<String, Object> user = new HashMap<>();
                                    user.put("name", name);
                                    user.put("email", email);
                                    user.put("password", password);

                                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            Log.d(TAG, "Success");
                                        }
                                    });

                                    Intent intent
                                            = new Intent(SignUppage.this,
                                            LoginPage.class);
                                    startActivity(intent);
                                } else {

                                    // Registration failed
                                    Toast.makeText(
                                            getApplicationContext(),
                                            "Registration failed!!"
                                                    + " Please try again later",
                                            Toast.LENGTH_LONG)
                                            .show();
                                }
                            }
                        });
            };
        });
    }
}


