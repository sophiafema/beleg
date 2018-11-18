package com.sophiafema.belegrecyclerview.data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Product.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {
    public abstract ProductDao productDao();


    //Create the productDatabase as a singleton to prevent having multiple instances of the database opened at the same time, which would be a bad thing.
    private static ProductDatabase INSTANCE;

    public static ProductDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ProductDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ProductDatabase.class,
                            "product_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    /**
     * Product Callback to delete and populate database
     */

    public static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }

        ;


    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final ProductDao mDao;
        private Product[] products =
                {new Product("Brot", "200g", false),
                new Product("Tomaten", "2", false),
                new Product("Zwiebeln", "Päckchen", false)};

        public PopulateDbAsync(ProductDatabase instance) {
            mDao = instance.productDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            // Start the app with a clean database every time.
            // Not needed if you only populate the database
            // when it is first created
            //mDao.deleteAll();

            if(mDao.getAnyProduct().length<1) {
                for (int i = 0; i < products.length; i++) {
                    mDao.insertProduct(products[i]);
                }
            }
            return null;
        }
    }
}
