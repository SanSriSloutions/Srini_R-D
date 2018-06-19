package com.example.sansri.roomexample.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Repo {
    @PrimaryKey
    @NonNull
    public final String id;
    public final String name;
    public final String url;

    public Repo(String id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;

    }
}
