package com.example.goagain;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.goagain.databinding.FragmentSecondBinding;
import com.example.goagain.db.User;
import com.example.goagain.db.UserViewModel;


public class SecondFragment extends Fragment {

    private UserViewModel model;

    EditText firstName;
    EditText lastName;
    EditText age;

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.firstName.findViewById(R.id.first_name);
        binding.lastName.findViewById(R.id.last_name);
        binding.age.findViewById(R.id.age);

        model = new ViewModelProvider(this).get(UserViewModel.class);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertDataToDatabase();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void insertDataToDatabase(){
            String firstname = binding.firstName.getText().toString();
            String lastname = binding.lastName.getText().toString();
            int userAge = Integer.parseInt(binding.age.getText().toString());

            if (inputCheck(firstname,lastname,binding.age.getText())){

                model.insert(new User(firstname, lastname, userAge));
                Toast.makeText(requireContext(), "it's done", Toast.LENGTH_SHORT).show();
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }else {
                Toast.makeText(requireContext(), "please fill out all fields", Toast.LENGTH_LONG).show();
            }
    }

    private boolean inputCheck(String firsname, String lastname, Editable age){
        return !(TextUtils.isEmpty(firsname) && TextUtils.isEmpty(lastname) && TextUtils.isEmpty(age));
    }

}