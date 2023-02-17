package com.example.myfirstapp;

import android.os.Bundle;
import android.util.Log; 
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myfirstapp.databinding.FragmentSecondBinding;

import java.util.Random;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Retrieving the value of the passed argument
        Integer count = SecondFragmentArgs.fromBundle(getArguments()).getMyArg();
        Log.i("SECONDFRAGMENT", "count " + count);
        // Get the string and format it with the count (use of the %d)
        String countText = getString(R.string.random_heading, count);
        // Set the textview header
        TextView headerView = view.getRootView().findViewById(R.id.textview_header);
        headerView.setText(countText);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        // Showing the random number between 0 and count
        Random random = new java.util.Random();
        Integer randomNumber = 0;
        if (count > 0) {
            randomNumber = random.nextInt(count + 1);
        }
        TextView randomView = view.getRootView().findViewById(R.id.textview_random);
        randomView.setText(randomNumber.toString());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}