package com.example.goagain.db;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private LiveData<List<User>> userList;

    public UserViewModel (Application application){
        super(application);
        userRepository = new UserRepository(application);
        userList = userRepository.getUserList();
    }
    public LiveData<List<User>> getUserList(){ return userList;}

    public void insert(User user){ userRepository.insert(user);}
}
