package com.example.cur3_ex4.db;


import android.content.Context;

import com.example.cur3_ex4.models.Repos;
import com.example.cur3_ex4.models.ReposRoomData;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
        entities = {ReposRoomData.class},
        version = 1,
        exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "MyDb.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    abstract ReposDao reposDao();
}
