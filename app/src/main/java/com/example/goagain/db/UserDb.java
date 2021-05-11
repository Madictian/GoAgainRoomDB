package com.example.goagain.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDb extends RoomDatabase {

    public abstract UserDao userDao();
    private static UserDb INSTANCE;

    public static UserDb getDatabase(Context context){
        if(INSTANCE == null){
            synchronized (UserDb.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), UserDb.class, "UserDatabase")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
