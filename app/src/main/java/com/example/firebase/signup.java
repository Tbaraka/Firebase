package com.example.firebase;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class signup extends AppCompatActivity {
    private EditText emailtext, passwordtext;
    private Button registbutton;
    private ProgressBar registrProgressbar;

    private FirebaseAuth Auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
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
        LoginAuth=Firebase

        registbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registernewuser();
            }

            private void registernewuser() {
                registrProgressbar.setVisibility(View.VISIBLE);
                String email, password;
                email = emailtext.getText().toString();
                password = passwordtext.getText().toString();
                // Validations for input email and password
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(signup.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){ Toast.makeText(this, "Enter password",Toast.LENGTH_SHORT).show();
                    return;
                }
                Auth.createUserWithEmailAndPassword(email,
                        password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Registration
                                    Succesful", Toast.LENGTH_SHORT).show();



                        }


        }



            }
}