package com.example.autocareapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.BookingViewHolder> {

    private List<Booking> bookingList;

    public BookingAdapter(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_booking, parent, false);
        return new BookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, int position) {
        Booking booking = bookingList.get(position);
        holder.idText.setText("Booking ID: #" + booking.getId());
        holder.serviceText.setText("Service: " + booking.getServiceType());
        holder.dateText.setText("Date: " + booking.getDate());
        holder.statusText.setText("Status: " + booking.getStatus());
    }

    @Override
    public int getItemCount() {
        return bookingList.size();
    }

    public static class BookingViewHolder extends RecyclerView.ViewHolder {
        TextView idText, serviceText, dateText, statusText;

        public BookingViewHolder(@NonNull View itemView) {
            super(itemView);
            idText = itemView.findViewById(R.id.textBookingId);
            serviceText = itemView.findViewById(R.id.textServiceType);
            dateText = itemView.findViewById(R.id.textDate);
            statusText = itemView.findViewById(R.id.textStatus);
        }
    }
}