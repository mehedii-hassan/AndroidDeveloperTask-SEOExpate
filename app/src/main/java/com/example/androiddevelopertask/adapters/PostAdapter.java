package com.example.androiddevelopertask.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddevelopertask.R;
import com.example.androiddevelopertask.databinding.RvRowItemDesignBinding;
import com.example.androiddevelopertask.models.PostResponseModel;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<PostResponseModel> postList;

    public PostAdapter() {
        postList = new ArrayList<>();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RvRowItemDesignBinding binding = RvRowItemDesignBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        holder.binding.tvTitle.setText(postList.get(position).getTitle());
        holder.binding.tvDetails.setText(postList.get(position).getBody());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.postDetailsPageFragment);
            }
        });
    }

    public void submitNewList(List<PostResponseModel> postList) {

        this.postList = postList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        private RvRowItemDesignBinding binding;

        public PostViewHolder(RvRowItemDesignBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
