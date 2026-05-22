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

public class UpdateServiceStatusActivity extends AppCompatActivity {

    private TextInputEditText bookingIdInput, statusInput;
    private MaterialButton updateButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_service_status);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Bind views
        bookingIdInput = findViewById(R.id.updateBookingIdInput);
        statusInput = findViewById(R.id.updateStatusInput);
        updateButton = findViewById(R.id.updateStatusButton);
        backButton = findViewById(R.id.backToDashboardButton);

        // Handle Back Button
        backButton.setOnClickListener(v -> finish());

        // Handle Update Button
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookingId = bookingIdInput.getText().toString().trim();
                String newStatus = statusInput.getText().toString().trim();

                // Frontend Input Validation
                if (bookingId.isEmpty() || newStatus.isEmpty()) {
                    Toast.makeText(UpdateServiceStatusActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                /* * TEAM MATE HANDOFF POINT:
                 * Database UPDATE query for Service Status goes here.
                 * Example: UPDATE bookings SET status = 'newStatus' WHERE id = 'bookingId'
                 */

                Toast.makeText(UpdateServiceStatusActivity.this, "Status Updated Successfully!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}