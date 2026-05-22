package com.example.autocareapplication;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.List;

public class ViewBookingsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookingAdapter adapter;
    private List<Booking> dummyBookingList;
    private MaterialButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_bookings);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Setup Back Button
        backButton = findViewById(R.id.backToDashboardButton);
        backButton.setOnClickListener(v -> finish());

        // Setup RecyclerView
        recyclerView = findViewById(R.id.bookingsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /* * TEAM MATE HANDOFF POINT:
         * Swap this dummy data loop with a SQLite Cursor that fetches
         * real bookings from the database and adds them to the list.
         */
        dummyBookingList = new ArrayList<>();
        dummyBookingList.add(new Booking("101", "Minor Service", "2026-06-01", "Pending"));
        dummyBookingList.add(new Booking("102", "Brake Pad Replacement", "2026-06-03", "In Progress"));
        dummyBookingList.add(new Booking("103", "Major Service", "2026-06-05", "Completed"));
        dummyBookingList.add(new Booking("104", "Engine Diagnostics", "2026-06-10", "Pending"));

        // Attach Adapter to RecyclerView
        adapter = new BookingAdapter(dummyBookingList);
        recyclerView.setAdapter(adapter);
    }
}