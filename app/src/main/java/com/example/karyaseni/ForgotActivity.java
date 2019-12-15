package com.example.karyaseni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotActivity extends AppCompatActivity {
    TextInputLayout emailTxt;
    Button resetButton;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        resetButton = (Button) findViewById(R.id.forgotBtn);
        emailTxt = (TextInputLayout) findViewById(R.id.emailForgotTxt);
        firebaseAuth = FirebaseAuth.getInstance();
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailTxt.getEditText().getText().toString();
                firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Your reset link has been send!", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Your reset link Failed to send!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
