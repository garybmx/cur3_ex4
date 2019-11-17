package com.example.cur3_ex4.db;

import android.os.Build;

import com.example.cur3_ex4.models.Repos;
import com.example.cur3_ex4.models.ReposRoomData;

import java.util.List;
import java.util.stream.Collectors;

import androidx.annotation.RequiresApi;

public class RoomDbImpl implements DbProvider<ReposRoomData, List<Repos>> {

    private AppDatabase db;

    public RoomDbImpl(AppDatabase db) {
        this.db = db;
    }

    @Override
    public void insert(ReposRoomData data) {
        db.reposDao().insertRepos(data);
    }




    @Override
    public void update(ReposRoomData data) {
        db.runInTransaction(() -> {
            db.reposDao().updateRepos(data);
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<Repos> select() {
        return db.reposDao().getAllRepos().stream()
                .map(item -> ReposRoomData.convertToEntity(item))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(ReposRoomData data) {
        db.runInTransaction(() -> {
            db.reposDao().delete(data);
        });
    }
}

