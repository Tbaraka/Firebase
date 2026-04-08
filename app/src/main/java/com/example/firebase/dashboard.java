package com.example.firebase;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.FirebaseFirestore;

public class dashboard extends AppCompatActivity {
    private EditText fullNameForm, phoneNumberForm, locationForm, pickUpTimeForm, instructionsForm;
    private Button btnBookWash;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views with the new IDs from activity_dashboard.xml
        fullNameForm = findViewById(R.id.FullName);
        phoneNumberForm = findViewById(R.id.PhoneNumber);
        locationForm = findViewById(R.id.Location);
        pickUpTimeForm = findViewById(R.id.pickuptime);
        instructionsForm = findViewById(R.id.instructions);
        btnBookWash = findViewById(R.id.bookyourwash);

        db = FirebaseFirestore.getInstance();
        btnBookWash.setOnClickListener(v -> saveBooking());
    }

    private void saveBooking() {
        String fullName = fullNameForm.getText().toString().trim();
        String phoneNumber = phoneNumberForm.getText().toString().trim();
        String location = locationForm.getText().toString().trim();
        String pickUpTime = pickUpTimeForm.getText().toString().trim();
        String instructions = instructionsForm.getText().toString().trim();

        // Validation
        if (TextUtils.isEmpty(fullName)) {
            fullNameForm.setError("Full Name is required");
            fullNameForm.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(location)) {
            locationForm.setError("Location is required");
            locationForm.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(pickUpTime)) {
            pickUpTimeForm.setError("Pickup time is required");
            pickUpTimeForm.requestFocus();
            return;
        }

        // Using WashBooking class to map the data
        WashBooking booking = new WashBooking(
                fullName,
                phoneNumber,
                location,
                pickUpTime,
                instructions,
                "pending_wash"
        );

        db.collection("WashBookings")
                .add(booking)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(this, "Wash Booked Successfully", Toast.LENGTH_SHORT).show();
                    clearFields();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Error Booking Wash: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    private void clearFields() {
        fullNameForm.setText("");
        phoneNumberForm.setText("");
        locationForm.setText("");
        pickUpTimeForm.setText("");
        instructionsForm.setText("");
    }
}
