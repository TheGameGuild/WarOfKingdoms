package com.example.warofkingdoms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    Button btnlogin;
    EditText logemail, logpassword;
    FirebaseAuth mAuth;
    TextView txtSignup;

    TextView txtForgotPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        logemail = findViewById(R.id.logemail);
        logpassword = findViewById(R.id.logpassword);
        btnlogin = findViewById(R.id.btn_login);
        txtSignup = findViewById(R.id.txtsignup);
        txtForgotPassword = findViewById(R.id.txtForgotPassword);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailUser = logemail.getText().toString().trim();
                String passUser = logpassword.getText().toString().trim();

                if (emailUser.isEmpty() && passUser.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                } else {
                    loginUser(emailUser, passUser);
                }
            }
        });

        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }



    private void loginUser(String emailUser, String passUser) {
        mAuth.signInWithEmailAndPassword(emailUser, passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {


            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    finish();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    Toast.makeText(LoginActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();

                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, "Error trying to login", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
