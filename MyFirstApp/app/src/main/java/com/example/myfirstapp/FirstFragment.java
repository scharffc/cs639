package com.example.myfirstapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    //private FragmentFirstBinding binding;
    TextView showCountTextView;
    Button toastButton;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Commented from default code
        //binding = FragmentFirstBinding.inflate(inflater, container, false);
        //return binding.getRoot();

        // Inflating the fragment_first layout into a Java object
        // Notice that a layout is called with R.layout
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);

        // Getting the textview that displays count from the fragmentFirstLayout
        // This variable is declared as an instance variable to be accessible from anywhere in the class
        // Notice that a component is called with R.id
        showCountTextView = fragmentFirstLayout.findViewById(R.id.textview_first);

        // Getting the toast button from the fragmentFirstLayout
        // This variable is declared as an instance variable to be accessible from anywhere in the class
        toastButton = fragmentFirstLayout.findViewById(R.id.toast_button);

        return fragmentFirstLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Now that the view exists we can interact with it!

        // When we click on the count button, 1 is added to the value of the current counter and displayed on the screen
        view.findViewById(R.id.count_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Example of a log to appear in the LogCat
                Log.i("FIRSTFRAGMENT", "I am here");
                countMe(view);
            }
        });

        // When we click on the toast button, a toast appears on the screen
        view.findViewById(R.id.toast_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast myToast = Toast.makeText(getActivity(), "Hello toast!", Toast.LENGTH_LONG);
                Log.i("FIRSTFRAGMENT", "myToast " + myToast);
                // Do not forget to show the toast!
                myToast.show();
            }
        });

        // When we click on the random button, ...
        view.findViewById(R.id.random_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Getting the current value of count from showCountTextView
                int currentCount = Integer.parseInt(showCountTextView.getText().toString());
                Log.i("FIRSTFRAGMENT", "currentCount " + currentCount);

                // Create an action with currentCount as the argument to actionFirstFragmentToSecondFragment()
                // See the navigation graph
                FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount);

                // Commented from default code
                //NavHostFragment.findNavController(FirstFragment.this)
                //        .navigate(R.id.action_FirstFragment_to_SecondFragment);

                // Find the nav controller and navigate with the created action
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(action);
            }
        });

    }

    private void countMe(View view) {
        String countString = showCountTextView.getText().toString();
        Integer count = Integer.parseInt(countString);
        count++;
        showCountTextView.setText(count.toString());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
       // binding = null;
    }

}