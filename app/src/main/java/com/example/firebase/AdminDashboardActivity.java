package com.example.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class AdminDashboardActivity extends AppCompatActivity {

    private CardView cardViewAppointments, cardViewRegistrations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        // Initialize CardViews
        cardViewAppointments = findViewById(R.id.cardViewAppointments);
        cardViewRegistrations = findViewById(R.id.cardViewRegistrations);

        // Click listener for Wash Appointments
        cardViewAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reuse existing viewwashes activity to see appointments
                Intent intent = new Intent(AdminDashboardActivity.this, viewwashes.class);
                startActivity(intent);
            }
        });

        // Click listener for Mamafua Registrations - Using a PopupMenu
        cardViewRegistrations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegistrationsPopup(v);
            }
        });
    }

    private void showRegistrationsPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        // Inflating the menu resource we created
        popup.getMenuInflater().inflate(R.menu.admin_registrations_menu, popup.getMenu());

        // Handling menu item clicks
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.action_view_pending) {
                    Intent intent = new Intent(AdminDashboardActivity.this, ViewMamafuaRegistrationsActivity.class);
                    intent.putExtra("status", "pending");
                    startActivity(intent);
                    return true;
                } else if (id == R.id.action_view_approved) {
                    Intent intent = new Intent(AdminDashboardActivity.this, ViewMamafuaRegistrationsActivity.class);
                    intent.putExtra("status", "approved");
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        popup.show();
    }
}
