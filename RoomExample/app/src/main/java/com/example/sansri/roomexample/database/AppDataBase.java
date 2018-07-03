package com.example.sansri.roomexample.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.sansri.roomexample.database.dao.RepoDao;
import com.example.sansri.roomexample.database.entities.Repo;

@Database(entities = {Repo.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    private static final String DB_NAME = "appDb.db";
    private static volatile AppDataBase instance;
    private static final int CURRENT_VERSION = 1;
    private static final int NEXT_VERSION = 2;


    public  abstract  RepoDao getRepoDao();

    public static  synchronized AppDataBase getInstance(Context mContext) {
        if (instance == null) {
            return create(mContext);
        }
        return instance;
    }

    private static AppDataBase create(Context mContext) {

        return Room.databaseBuilder(mContext, AppDataBase.class, DB_NAME).allowMainThreadQueries().addMigrations(new Migration(CURRENT_VERSION, NEXT_VERSION) {
            @Override
            public void migrate(@NonNull SupportSQLiteDatabase database) {

            }
        }).build();
    }

}

