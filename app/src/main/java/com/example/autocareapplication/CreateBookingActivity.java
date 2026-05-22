package com.example.autocareapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class CreateBookingActivity extends AppCompatActivity {

    private TextInputEditText vehicleIdInput, mechanicIdInput, serviceTypeInput, dateInput, statusInput;
    private MaterialButton saveButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_booking);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Bind views
        vehicleIdInput = findViewById(R.id.bookingVehicleIdInput);
        mechanicIdInput = findViewById(R.id.bookingMechanicIdInput);
        serviceTypeInput = findViewById(R.id.bookingServiceTypeInput);
        dateInput = findViewById(R.id.bookingDateInput);
        statusInput = findViewById(R.id.bookingStatusInput);
        saveButton = findViewById(R.id.saveBookingButton);
        backButton = findViewById(R.id.backToDashboardButton);

        // Handle Back Button
        backButton.setOnClickListener(v -> finish());

        // Handle Save Button
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vehicleId = vehicleIdInput.getText().toString().trim();
                String mechanicId = mechanicIdInput.getText().toString().trim();
                String serviceType = serviceTypeInput.getText().toString().trim();
                String date = dateInput.getText().toString().trim();
                String status = statusInput.getText().toString().trim();

                // Frontend Input Validation
                if (vehicleId.isEmpty() || mechanicId.isEmpty() || serviceType.isEmpty() || date.isEmpty() || status.isEmpty()) {
                    Toast.makeText(CreateBookingActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                /* * TEAM MATE HANDOFF POINT:
                 * Database insert logic for Service Bookings goes here.
                 */

                Toast.makeText(CreateBookingActivity.this, "Booking Created Successfully!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}