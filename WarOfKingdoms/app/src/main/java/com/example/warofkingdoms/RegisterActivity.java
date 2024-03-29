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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    TextView txtLogin;
    Button btn_registre;
    Button abtus_btn;
    EditText name, email, password;
    FirebaseFirestore mFirestore;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        mFirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        name = findViewById(R.id.username);
        email = findViewById(R.id.correo);
        password = findViewById(R.id.regpassword);
        btn_registre = findViewById(R.id.btn_register);
        abtus_btn = findViewById(R.id.abtus_btn);
        txtLogin = findViewById(R.id.txtLogin);


        abtus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutus();

            }
        });

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        
    
        btn_registre.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String nameUser = name.getText().toString().trim();
                String emailUser = email.getText().toString().trim();
                String passUser = password.getText().toString().trim();

                if (nameUser.isEmpty() && emailUser.isEmpty() && passUser.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Fill the gaps with your information", Toast.LENGTH_LONG).show();
                }else{
                    registerUser(nameUser, emailUser, passUser);


            }
        }

        });
    }

    private void openAboutus() {
        Intent intent = new Intent(this, abtus.class);
        startActivity(intent);
    }

    private void registerUser(String nameUser, String emailUser, String passUser) {
        mAuth.createUserWithEmailAndPassword(emailUser, passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String id = mAuth.getCurrentUser().getUid();
                Map<String, Object> map = new HashMap<>();
                map.put("id", id);
                map.put("name", nameUser);
                map.put("email", emailUser);
                map.put("password", passUser);

                mFirestore.collection("user").document(id).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        finish();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        Toast.makeText(RegisterActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this, "Error in saving", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();

            }
        });
    }
    
}