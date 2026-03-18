package com.example.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

private EditText emailtext, passwordtext;
private Button registbutton;
private ProgressBar registrProgressbar;
private FirebaseAuth Auth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Auth = FirebaseAuth.getInstance();
// initialising all views through id defined above
        emailtext = findViewById(R.id.email);
        passwordtext = findViewById(R.id.password);
        registbutton = findViewById(R.id.registerbtn);
        registrProgressbar = findViewById(R.id.progressbar);

        registbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registernewuser();
            }
        });
    }
    private void registernewuser(){
// show the visibility of progress bar to show loading
            registrProgressbar.setVisibility(View.VISIBLE);
        // Take the value of two edit texts in Strings
        String email, password;
        email = emailtext.getText().toString();
        password = passwordtext.getText().toString();

        // Validations for input email and password
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            return;

        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Enter password",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        // create new user or register new user
        Auth.createUserWithEmailAndPassword(email,
                password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Registration Successfull", Toast.LENGTH_SHORT).show();
                    // hide the progress bar
                    registrProgressbar.setVisibility(View.GONE);
                    Intent intent = new Intent(MainActivity.this,login.class);
                    startActivity(intent);
                }
                else{

                    // Registration failed
                    Toast.makeText(getApplicationContext(), "Failed Registration", Toast.LENGTH_SHORT).show();



                }



}