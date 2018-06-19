package com.example.sansri.roomexample.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.sansri.roomexample.database.entities.Repo;

import java.util.List;

@Dao
public interface RepoDao {

    @Query("select * from repo")
    List<Repo> getAllRepos();

    @Insert
    void insert(Repo... repos);

    @Update
    void update(Repo... repos);

    @Delete
    void delete(Repo... repos);
}
