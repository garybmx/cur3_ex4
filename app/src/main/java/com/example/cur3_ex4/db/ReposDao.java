package com.example.cur3_ex4.db;



import com.example.cur3_ex4.models.Repos;
import com.example.cur3_ex4.models.ReposRoomData;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ReposDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(ReposRoomData... reposes);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract long insertRepos(ReposRoomData repos);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract int updateRepos(ReposRoomData repos);

    @Delete
    void delete(ReposRoomData repos);


    @Query("SELECT * FROM repos")
    List<ReposRoomData> getAllRepos();


    @Query("SELECT * FROM repos WHERE name LIKE :names")
    List<ReposRoomData> getAllReposesWith(String names);

}
