package com.example.chitchat;

import
        androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
FirebaseAuth auth;
    EditText emailBox, passwordBox, nameBox;
    Button loginbtn, signupbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth=FirebaseAuth.getInstance();

        emailBox=findViewById(R.id.emailBox);
        nameBox=findViewById(R.id.nameBox);
        passwordBox=findViewById(R.id.passwordBox);

        loginbtn=findViewById(R.id.loginbtn);
        signupbtn=findViewById(R.id.createbtn);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, pass, name;
                email=emailBox.getText().toString();
                pass=passwordBox.getText().toString();
                name=nameBox.getText().toString();

                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete( Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignupActivity.this, "Account is created", Toast.LENGTH_SHORT);
                        } else {
                            Toast.makeText(SignupActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}