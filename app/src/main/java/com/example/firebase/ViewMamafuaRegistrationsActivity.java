package com.example.firebase;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class ViewMamafuaRegistrationsActivity extends AppCompatActivity {

    private RecyclerView rvMamafua;
    private MamafuaAdapter adapter;
    private List<MamafuaRequest> mamafuaList;
    private FirebaseFirestore db;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mamafua_registrations);

        tvTitle = findViewById(R.id.tvTitle);
        rvMamafua = findViewById(R.id.rvMamafua);
        rvMamafua.setLayoutManager(new LinearLayoutManager(this));

        mamafuaList = new ArrayList<>();
        adapter = new MamafuaAdapter(mamafuaList, request -> approveMamafua(request));
        rvMamafua.setAdapter(adapter);

        db = FirebaseFirestore.getInstance();

        String statusFilter = getIntent().getStringExtra("status");
        if (statusFilter != null) {
            tvTitle.setText(statusFilter.substring(0, 1).toUpperCase() + statusFilter.substring(1) + " Registrations");
            loadRegistrations(statusFilter);
        } else {
            loadRegistrations(null);
        }
    }

    private void loadRegistrations(String status) {
        com.google.firebase.firestore.Query query = db.collection("mamafua_requests");
        
        if (status != null) {
            query = query.whereEqualTo("status", status);
        }

        query.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                mamafuaList.clear();
                for (QueryDocumentSnapshot document : task.getResult()) {
                    MamafuaRequest request = document.toObject(MamafuaRequest.class);
                    request.setId(document.getId());
                    mamafuaList.add(request);
                }
                adapter.notifyDataSetChanged();
                if (mamafuaList.isEmpty()) {
                    Toast.makeText(this, "No registrations found", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Error getting documents: " + task.getException(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void approveMamafua(MamafuaRequest request) {
        db.collection("mamafua_requests").document(request.getId())
                .update("status", "approved")
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(this, "Mamafua approved successfully", Toast.LENGTH_SHORT).show();
                    // Refresh the list
                    String statusFilter = getIntent().getStringExtra("status");
                    loadRegistrations(statusFilter);
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Error approving: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }
}
