package com.example.cur3_ex4.models;


import androidx.annotation.NonNull;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;



@Entity(tableName = "repos")
public class ReposRoomData {

    private String name;

    @PrimaryKey
    @NonNull
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }


    public ReposRoomData(@NonNull String id, String name) {
        this.id = id;
        this.name = name;
    }


    public static Repos convertToEntity(ReposRoomData item) {
        return new Repos(
                item.id,
                item.name);
    }

    public static ReposRoomData convertToRoomData(Repos item) {
        return new ReposRoomData(
                item.getId(),
                item.getName());
    }
}
