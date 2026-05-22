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

public class AddMechanicActivity extends AppCompatActivity {

    private TextInputEditText nameInput, specializationInput, experienceInput;
    private MaterialButton saveButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_mechanic);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Bind views
        nameInput = findViewById(R.id.mechanicNameInput);
        specializationInput = findViewById(R.id.mechanicSpecializationInput);
        experienceInput = findViewById(R.id.mechanicExperienceInput);
        saveButton = findViewById(R.id.saveMechanicButton);
        backButton = findViewById(R.id.backToDashboardButton);

        // Handle Back Button
        backButton.setOnClickListener(v -> finish());

        // Handle Save Button
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString().trim();
                String specialization = specializationInput.getText().toString().trim();
                String experience = experienceInput.getText().toString().trim();

                // Frontend Input Validation
                if (name.isEmpty() || specialization.isEmpty() || experience.isEmpty()) {
                    Toast.makeText(AddMechanicActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                /* * TEAM MATE HANDOFF POINT:
                 * Database insert logic for Mechanic goes here.
                 */

                Toast.makeText(AddMechanicActivity.this, "Mechanic Saved Successfully!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}