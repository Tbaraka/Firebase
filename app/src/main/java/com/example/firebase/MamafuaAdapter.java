package com.example.firebase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MamafuaAdapter extends RecyclerView.Adapter<MamafuaAdapter.MamafuaViewHolder> {

    private List<MamafuaRequest> mamafuaList;
    private OnApproveClickListener onApproveClickListener;

    public interface OnApproveClickListener {
        void onApproveClick(MamafuaRequest request);
    }

    public MamafuaAdapter(List<MamafuaRequest> mamafuaList, OnApproveClickListener listener) {
        this.mamafuaList = mamafuaList;
        this.onApproveClickListener = listener;
    }

    @NonNull
    @Override
    public MamafuaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mamafua_request, parent, false);
        return new MamafuaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MamafuaViewHolder holder, int position) {
        MamafuaRequest request = mamafuaList.get(position);
        holder.tvName.setText(request.getName());
        holder.tvContact.setText(request.getContact());
        holder.tvStatus.setText("Status: " + request.getStatus());

        if ("pending".equals(request.getStatus())) {
            holder.btnApprove.setVisibility(View.VISIBLE);
            holder.btnApprove.setOnClickListener(v -> {
                if (onApproveClickListener != null) {
                    onApproveClickListener.onApproveClick(request);
                }
            });
        } else {
            holder.btnApprove.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mamafuaList.size();
    }

    public static class MamafuaViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvContact, tvStatus;
        Button btnApprove;

        public MamafuaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvContact = itemView.findViewById(R.id.tvContact);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            btnApprove = itemView.findViewById(R.id.btnApprove);
        }
    }
}
