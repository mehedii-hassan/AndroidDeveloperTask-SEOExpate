package com.example.androiddevelopertask.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddevelopertask.databinding.RvRowItemCommentBinding;
import com.example.androiddevelopertask.models.CommentResponseModel;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {


    List<CommentResponseModel> commentList;

    public CommentAdapter() {
        commentList = new ArrayList<>();
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RvRowItemCommentBinding binding = RvRowItemCommentBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CommentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {

        holder.binding.tvUserName.setText(commentList.get(position).getName());
        holder.binding.tvUserDetails.setText(commentList.get(position).getBody());
    }

    public void summitNewCommentList(List<CommentResponseModel> commentList) {
        this.commentList = commentList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {
        private RvRowItemCommentBinding binding;

        public CommentViewHolder(RvRowItemCommentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
