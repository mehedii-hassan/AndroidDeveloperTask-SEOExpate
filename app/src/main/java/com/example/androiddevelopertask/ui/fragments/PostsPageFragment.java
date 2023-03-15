package com.example.androiddevelopertask.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androiddevelopertask.R;
import com.example.androiddevelopertask.adapters.PostAdapter;
import com.example.androiddevelopertask.callbacks.PostItem;
import com.example.androiddevelopertask.databinding.FragmentPostsPageBinding;
import com.example.androiddevelopertask.models.PostResponseModel;
import com.example.androiddevelopertask.viewmodels.PostViewModel;

import java.util.List;

public class PostsPageFragment extends Fragment implements PostItem {

    private PostViewModel postViewModel;
    private FragmentPostsPageBinding binding;

    public PostsPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPostsPageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);
        postViewModel.loadPostData();

        PostAdapter adapter = new PostAdapter(this);
        binding.rvPostsFragment.setLayoutManager(new LinearLayoutManager(view.getContext()));
        binding.rvPostsFragment.setAdapter(adapter);
        postViewModel.getPostResponseLiveDate().observe(requireActivity(), new Observer<List<PostResponseModel>>() {
            @Override
            public void onChanged(List<PostResponseModel> postList) {
                if (postList.size() > 0) {
                    Log.d("TAG", "" + postList.size());
                    adapter.submitNewList(postList);
                }
            }
        });
    }


    @Override
    public void getPostId(PostResponseModel model) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("model",model);
        Navigation.findNavController(requireView()).navigate(R.id.postDetailsPageFragment,bundle);
    }
}