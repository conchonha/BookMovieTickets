package com.conchonha.bookmovietickets.database.callback;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class CallbackRoomDatabase extends RoomDatabase.Callback {
    @Override
    public void onOpen(@NonNull SupportSQLiteDatabase db) {
        super.onOpen(db);
//        AppDatabase.DATABASE_INSTANCE.cinemaDao().insert(Arrays.asList(DumyData.listCinema))
//                .subscribeOn(Schedulers.io())
//                .subscribe(()->{
//                    Log.d("SangTB", "onCreate: insert cinemaDao");
//                }).dispose();
    }

}



