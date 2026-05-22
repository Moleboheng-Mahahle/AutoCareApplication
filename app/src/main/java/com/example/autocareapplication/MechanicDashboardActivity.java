package com.example.autocareapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MechanicDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mechanic_dashboard);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Bind the buttons
        MaterialButton btnCreateBooking = findViewById(R.id.btnNavCreateBooking);
        MaterialButton btnUpdateStatus = findViewById(R.id.btnNavUpdateStatus);
        MaterialButton btnViewBookings = findViewById(R.id.btnNavViewBookingsMechanic);

        // Set up clean routing intents
        btnCreateBooking.setOnClickListener(v -> startActivity(new Intent(MechanicDashboardActivity.this, CreateBookingActivity.class)));
        btnUpdateStatus.setOnClickListener(v -> startActivity(new Intent(MechanicDashboardActivity.this, UpdateServiceStatusActivity.class)));
        btnViewBookings.setOnClickListener(v -> startActivity(new Intent(MechanicDashboardActivity.this, ViewBookingsActivity.class)));
    }
}