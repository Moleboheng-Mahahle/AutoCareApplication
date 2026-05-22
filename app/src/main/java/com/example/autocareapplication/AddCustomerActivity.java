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

public class AddCustomerActivity extends AppCompatActivity {

    private TextInputEditText nameInput, surnameInput, phoneInput, emailInput;
    private MaterialButton saveButton, backButton; // Added backButton here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_customer);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Bind views
        nameInput = findViewById(R.id.customerNameInput);
        surnameInput = findViewById(R.id.customerSurnameInput);
        phoneInput = findViewById(R.id.customerPhoneInput);
        emailInput = findViewById(R.id.customerEmailInput);
        saveButton = findViewById(R.id.saveCustomerButton);

        // Bind the Back Button
        backButton = findViewById(R.id.backToDashboardButton);

        // Handle Back Button Click
        backButton.setOnClickListener(v -> finish());

        // Handle Save Button Click
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString().trim();
                String surname = surnameInput.getText().toString().trim();
                String phone = phoneInput.getText().toString().trim();
                String email = emailInput.getText().toString().trim();

                // Frontend Input Validation
                if (name.isEmpty() || surname.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                    Toast.makeText(AddCustomerActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                /* * TEAM MATE HANDOFF POINT:
                 * Database insert logic for Customer goes here.
                 */

                Toast.makeText(AddCustomerActivity.this, "Customer Saved Successfully!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}