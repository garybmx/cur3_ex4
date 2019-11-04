package com.example.cur3_ex4;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.cur3_ex4.models.Repos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CounterDatabase {
    List<Repos> myList = new ArrayList<>();

    private static CounterDatabase instance;

    private final Map<Integer, Repos> counters;

    private int nextId = 1;

    private CounterDatabase() {
        counters = new HashMap<>();
    }

    public static synchronized CounterDatabase getInstance() {
        if (instance == null) {
            instance = new CounterDatabase();
        }
        return instance;
    }

    public List<Repos> getAllCounters() {
        setList();
        return myList;
    }

    @Nullable public Repos getCounter(int id) {
        synchronized (counters) {
            return counters.get(id);
        }
    }

    public void saveCounter(@NonNull Repos repos) {
        synchronized (counters) {
            int id = nextId++;
            repos.setId(id);
            counters.put(id, repos);
        }
    }

    private void setList(){
        Repos r1 = new Repos();
        r1.setId(1);
        r1.setName("alo");
        Repos r2 = new Repos();
        r2.setId(2);
        r2.setName("halo");
        myList.add(r1);
        myList.add(r2);

    }
}
