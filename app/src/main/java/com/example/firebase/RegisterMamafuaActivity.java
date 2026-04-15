package com.example.firebase;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterMamafuaActivity extends AppCompatActivity {

    private TextInputEditText etName, etContact;
    private Button btnSubmit;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_mamafua);

        // Initialize views
        etName = findViewById(R.id.etMamafuaName);
        etContact = findViewById(R.id.etMamafuaContact);
        btnSubmit = findViewById(R.id.btnSubmitMamafua);

        // Initialize Firestore
        db = FirebaseFirestore.getInstance();

        btnSubmit.setOnClickListener(v -> submitRegistration());
    }

    private void submitRegistration() {
        String name = etName.getText().toString().trim();
        String contact = etContact.getText().toString().trim();

        // Validate that both fields are not empty
        if (TextUtils.isEmpty(name)) {
            etName.setError("Full Name is required");
            etName.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(contact)) {
            etContact.setError("Contact is required");
            etContact.requestFocus();
            return;
        }

        // Store the data in Firebase Firestore in a collection called "mamafua_requests"
        Map<String, Object> request = new HashMap<>();
        request.put("name", name);
        request.put("contact", contact);
        request.put("status", "pending"); // default value: "pending"

        btnSubmit.setEnabled(false); // Disable button to prevent multiple submissions

        db.collection("mamafua_requests")
                .add(request)
                .addOnSuccessListener(documentReference -> {
                    // Show a Toast message "Registration submitted successfully"
                    Toast.makeText(RegisterMamafuaActivity.this, "Registration submitted successfully", Toast.LENGTH_SHORT).show();
                    
                    // Clear the form fields
                    etName.setText("");
                    etContact.setText("");
                    btnSubmit.setEnabled(true);
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(RegisterMamafuaActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    btnSubmit.setEnabled(true);
                });
    }
}
