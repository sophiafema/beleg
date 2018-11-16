package com.sophiafema.belegrecyclerview.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class ProductRepository {

    private ProductDao mProductDao;
    private LiveData<List<Product>> mAllProducts;

    public ProductRepository(Application application)
    {
        ProductDatabase db = ProductDatabase.getDatabase(application);
        this.mProductDao = db.productDao();
        this.mAllProducts = mProductDao.getAllProducts();
    }

    LiveData<List<Product>> getAllProducts()
    {
        return mAllProducts;
    }

    public void insert(Product product)
    {
        new insertAsyncTask(mProductDao).execute(product);
    }

    private class insertAsyncTask extends AsyncTask<Product, Void, Void> {
        private ProductDao mAsyncTeskDao;
        public insertAsyncTask(ProductDao mproductDao) {
            this.mAsyncTeskDao = mproductDao;
        }

        @Override
        protected Void doInBackground(final Product... params) {
            mAsyncTeskDao.insertProduct(params[0]);
            return null;
        }
    }
}
