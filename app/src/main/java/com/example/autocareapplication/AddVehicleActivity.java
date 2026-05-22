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

public class AddVehicleActivity extends AppCompatActivity {

    private TextInputEditText ownerIdInput, brandInput, modelInput, registrationInput, yearInput;
    private MaterialButton saveButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_vehicle);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Bind views
        ownerIdInput = findViewById(R.id.vehicleOwnerIdInput);
        brandInput = findViewById(R.id.vehicleBrandInput);
        modelInput = findViewById(R.id.vehicleModelInput);
        registrationInput = findViewById(R.id.vehicleRegistrationInput);
        yearInput = findViewById(R.id.vehicleYearInput);
        saveButton = findViewById(R.id.saveVehicleButton);
        backButton = findViewById(R.id.backToDashboardButton);

        // Handle Back Button
        backButton.setOnClickListener(v -> finish());

        // Handle Save Button
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ownerId = ownerIdInput.getText().toString().trim();
                String brand = brandInput.getText().toString().trim();
                String model = modelInput.getText().toString().trim();
                String registration = registrationInput.getText().toString().trim();
                String year = yearInput.getText().toString().trim();

                // Frontend Input Validation
                if (ownerId.isEmpty() || brand.isEmpty() || model.isEmpty() || registration.isEmpty() || year.isEmpty()) {
                    Toast.makeText(AddVehicleActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                /* * TEAM MATE HANDOFF POINT:
                 * Database insert logic for Vehicle goes here.
                 */

                Toast.makeText(AddVehicleActivity.this, "Vehicle Saved Successfully!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}