package com.example.autocareapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    // Declare your view variables
    private TextInputEditText usernameEditText;
    private TextInputEditText passwordEditText;
    private MaterialButton loginButton;
    private TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Handle edge-to-edge screen padding safely
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Bind the variables to the XML layout
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        errorTextView = findViewById(R.id.errorTextView);

        // 2. Set up the click listener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hide error message initially on every click
                errorTextView.setVisibility(View.GONE);

                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Basic Input Validation
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
                    return;
                }

                /* * TEAM MATE HANDOFF POINT:
                 * Replace these hardcoded checks with SQLite verification.
                 */
                if (username.equals("admin") && password.equals("1234")) {
                    startActivity(new Intent(LoginActivity.this, AdminDashboardActivity.class)); // [cite: 89]
                    finish();

                } else if (username.equals("mechanic") && password.equals("1234")) {
                    startActivity(new Intent(LoginActivity.this, MechanicDashboardActivity.class)); // [cite: 90]
                    finish();

                } else if (username.equals("customer") && password.equals("1234")) {
                    startActivity(new Intent(LoginActivity.this, CustomerDashboardActivity.class)); // [cite: 91]
                    finish();

                } else {
                    // Invalid credentials
                    errorTextView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}