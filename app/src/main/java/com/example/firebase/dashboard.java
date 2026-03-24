package com.example.firebase;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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
    private EditText ItemNameform, Descriptionform, Locationform, Contactform;
    private Button btnSaveform;
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

        ItemNameform = findViewById(R.id.ItemNamelost);
        Descriptionform = findViewById(R.id.Descriptionlost);
        Locationform = findViewById(R.id.Locationlost);
        Contactform = findViewById(R.id.Contactlost);
        btnSaveform = findViewById(R.id.btn_save_lost);

        db = FirebaseFirestore.getInstance();
        btnSaveform.setOnClickListener(v -> saveitem());
    }

    private void saveitem() {
        String itemname = ItemNameform.getText().toString().trim();
        String description = Descriptionform.getText().toString().trim();
        String location = Locationform.getText().toString().trim();
        String contact = Contactform.getText().toString().trim();

        if (TextUtils.isEmpty(itemname)) {
            ItemNameform.setError("Item name is required");
            ItemNameform.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(description)) {
            Descriptionform.setError("Description is required");
            Descriptionform.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(location)) {
            Locationform.setError("Location is required");
            Locationform.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(contact)) {
            Contactform.setError("Contact is required");
            Contactform.requestFocus();
            return;
        }

        LostItem item = new LostItem(
                itemname,
                description,
                location,
                contact,
                "lost"
        );

        db.collection("LostItems")
                .add(item)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(this, "Item Saved Successfully", Toast.LENGTH_SHORT).show();
                    clearFields();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Error Saving Item: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    private void clearFields() {
        ItemNameform.setText("");
        Descriptionform.setText("");
        Locationform.setText("");
        Contactform.setText("");
    }
}
