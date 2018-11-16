package com.sophiafema.belegrecyclerview.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Product.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {
    public abstract ProductDao productDao();


    //Create the productDatabase as a singleton to prevent having multiple instances of the database opened at the same time, which would be a bad thing.
    private static ProductDatabase INSTANCE;

    public static ProductDatabase getDatabase(final Context context)
    {
        if(INSTANCE == null)
        {
            synchronized (ProductDatabase.class)
            {
                if(INSTANCE == null)
                {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ProductDatabase.class,
                            "product_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                             .build();
                }
            }
        }
        return INSTANCE;
    }


}
