package com.example.goagain.db;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {

    private UserDao userDao;
    private LiveData<List<User>> userList;

    UserRepository(Application application){
        UserDb db = UserDb.getDatabase(application);
        userDao = db.userDao();
        userList = userDao.getUsers();
    }

    LiveData<List<User>> getUserList(){
        return userList;
    }

    public void insert(User user){
        new Thread(() -> userDao.insert(user)
        ).start();
    }






}
