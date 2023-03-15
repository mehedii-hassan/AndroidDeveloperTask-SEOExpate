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
import android.widget.Toast;

import com.example.androiddevelopertask.R;
import com.example.androiddevelopertask.adapters.CommentAdapter;
import com.example.androiddevelopertask.adapters.PostAdapter;
import com.example.androiddevelopertask.databinding.FragmentPostDetailsPageBinding;
import com.example.androiddevelopertask.models.CommentModel;
import com.example.androiddevelopertask.models.CommentResponseModel;
import com.example.androiddevelopertask.models.PostResponseModel;
import com.example.androiddevelopertask.viewmodels.CommentViewModel;

import java.util.List;

public class PostDetailsPageFragment extends Fragment {

    private FragmentPostDetailsPageBinding binding;
    private CommentViewModel viewModel;

    private PostResponseModel model;

    public PostDetailsPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPostDetailsPageBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(CommentViewModel.class);

        CommentAdapter adapter = new CommentAdapter();
        binding.rvCommentsDF.setLayoutManager(new LinearLayoutManager(container.getContext()));
        binding.rvCommentsDF.setAdapter(adapter);

        Bundle bundle = getArguments();
        if (bundle != null) {
            model = bundle.getParcelable("model");
            Log.d("TAG", "modelTitle:  " + model.getTitle());
        }
        //set text -------------
        binding.tvPostTitle.setText(model.getTitle());
        binding.tvDetailsDF.setText(model.getBody());

        viewModel.loadCommentData(model.getId());
        viewModel.getPostResponseLiveDate().observe(requireActivity(), new Observer<List<CommentResponseModel>>() {
            @Override
            public void onChanged(List<CommentResponseModel> commentList) {
                adapter.summitNewCommentList(commentList);
                Log.d("TAG", "commentListSize " + commentList.size());
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        binding.ivEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = binding.etComment.getText().toString().trim();
                if (comment.isEmpty()) {
                    Toast.makeText(v.getContext(), "Please write your comment!", Toast.LENGTH_SHORT).show();
                } else {
                    CommentModel model1 = new CommentModel(comment);

                }
            }
        });
        binding.ivALDetailsFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.toPostPage);
            }
        });
    }
}