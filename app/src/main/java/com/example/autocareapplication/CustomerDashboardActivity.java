package com.example.autocareapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class CustomerDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_dashboard);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Bind the buttons
        MaterialButton btnMyVehicles = findViewById(R.id.btnNavMyVehicles);
        MaterialButton btnMyBookings = findViewById(R.id.btnNavMyBookings);
        MaterialButton btnMyProfile = findViewById(R.id.btnNavMyProfile);

        // Set up routing intents
        btnMyVehicles.setOnClickListener(v -> {
            // TODO: Create a ViewMyVehiclesActivity and link it here
            Toast.makeText(CustomerDashboardActivity.this, "Vehicle view coming soon", Toast.LENGTH_SHORT).show();
        });

        btnMyBookings.setOnClickListener(v -> startActivity(new Intent(CustomerDashboardActivity.this, ViewBookingsActivity.class)));

        btnMyProfile.setOnClickListener(v -> {
            // TODO: Create an UpdateProfileActivity and link it here
            Toast.makeText(CustomerDashboardActivity.this, "Profile update coming soon", Toast.LENGTH_SHORT).show();
        });
    }
}