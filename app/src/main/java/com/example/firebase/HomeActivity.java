package com.example.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends newUserOption {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_home), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CardView cardScheduleWash = findViewById(R.id.cardScheduleWash);
        CardView cardViewWashes = findViewById(R.id.cardViewWashes);
        CardView cardRegisterMamafua = findViewById(R.id.cardRegisterMamafua);

        // Click listener for Scheduling a Wash
        cardScheduleWash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, dashboard.class);
                startActivity(intent);
            }
        });

        // Click listener for Viewing Scheduled Washes
        cardViewWashes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, viewwashes.class);
                startActivity(intent);
            }
        });

        // Click listener for Registering as a Mamafua
        cardRegisterMamafua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, RegisterMamafuaActivity.class);
                startActivity(intent);
            }
        });
    }
}
