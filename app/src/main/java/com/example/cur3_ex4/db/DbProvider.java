package com.example.cur3_ex4.db;

import com.example.cur3_ex4.models.ReposRoomData;

import java.util.List;

public interface DbProvider<T, R> {
    void insert(T data);

    void update(T data);

    void delete(T data);

    R select();
}
