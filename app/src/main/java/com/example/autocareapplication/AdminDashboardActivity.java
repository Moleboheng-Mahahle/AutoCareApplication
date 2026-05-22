package com.example.autocareapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class AdminDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_dashboard);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Bind the new centered buttons
        MaterialButton btnCustomer = findViewById(R.id.btnNavAddCustomer);
        MaterialButton btnVehicle = findViewById(R.id.btnNavAddVehicle);
        MaterialButton btnMechanic = findViewById(R.id.btnNavAddMechanic);

        // Set up clean, one-line routing intents
        btnCustomer.setOnClickListener(v -> startActivity(new Intent(AdminDashboardActivity.this, AddCustomerActivity.class)));
        btnVehicle.setOnClickListener(v -> startActivity(new Intent(AdminDashboardActivity.this, AddVehicleActivity.class)));
        btnMechanic.setOnClickListener(v -> startActivity(new Intent(AdminDashboardActivity.this, AddMechanicActivity.class)));
    }
}