package com.example.firebase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Adapter class for displaying WashBooking items in a RecyclerView.
 */
public class washadapter extends RecyclerView.Adapter<washadapter.ViewHolder> {

    private List<WashBooking> list;

    public washadapter(List<WashBooking> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // onCreateViewHolder is called when the RecyclerView needs a new ViewHolder.
        // We use R.layout.view_washes_recycler to inflate the layout file for a single row.
        // Note: Use R.layout (for layout files) here, not R.id (for views within a layout).
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_washes_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // onBindViewHolder binds the data from your WashBooking object to the UI elements in the ViewHolder.
        WashBooking booking = list.get(position);
        
        holder.tvFullName.setText(booking.getFullName());
        holder.tvPhoneNumber.setText(booking.getPhoneNumber());
        holder.tvLocation.setText(booking.getLocation());
        holder.tvPickUpTime.setText(booking.getPickUpTime());
        holder.tvInstructions.setText(booking.getInstructions());
        holder.tvStatus.setText(booking.getStatus());
    }

    @Override
    public int getItemCount() {
        // Returns the total number of items in the list to be displayed.
        return list.size();
    }

    /**
     * ViewHolder class holds references to the views for each data item.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvFullName, tvPhoneNumber, tvLocation, tvPickUpTime, tvInstructions, tvStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize the TextViews by finding them in the inflated layout using their IDs.
            tvFullName = itemView.findViewById(R.id.tvFullName);
            tvPhoneNumber = itemView.findViewById(R.id.tvPhoneNumber);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvPickUpTime = itemView.findViewById(R.id.tvPickUpTime);
            tvInstructions = itemView.findViewById(R.id.tvInstructions);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }
    }
}
