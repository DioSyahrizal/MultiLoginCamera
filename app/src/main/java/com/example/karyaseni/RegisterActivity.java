package com.example.karyaseni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    TextInputLayout emailTxt, passTxt;
    Button registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        emailTxt = (TextInputLayout) findViewById(R.id.txtEmailRegister);
        passTxt = (TextInputLayout) findViewById(R.id.txtPasswordRegister);
        registerBtn = (Button) findViewById(R.id.btnRegister);
        firebaseAuth = FirebaseAuth.getInstance();
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isiEmail = emailTxt.getEditText().getText().toString();
                String isiPass = passTxt.getEditText().getText().toString();

                firebaseAuth.createUserWithEmailAndPassword(isiEmail,isiPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("", "createUserWithEmail:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Authentication Success.",
                                    Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
