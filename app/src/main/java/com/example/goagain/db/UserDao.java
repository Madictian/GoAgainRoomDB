package com.example.goagain.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Query("DELETE FROM User_List")
    void delete();

    @Query("SELECT * FROM User_List ORDER BY id ASC")
    LiveData<List<User>> getUsers();



}
