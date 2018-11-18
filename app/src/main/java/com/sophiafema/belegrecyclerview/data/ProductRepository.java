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

    public LiveData<List<Product>> getAllProducts()
    {
        return mAllProducts;
    }

    //insert
    public void insert(Product product)
    {
        new insertAsyncTask(mProductDao).execute(product);
    }

    private class insertAsyncTask extends AsyncTask<Product, Void, Void> {
        private ProductDao mAsyncTaskDao;
        public insertAsyncTask(ProductDao mproductDao) {
            this.mAsyncTaskDao = mproductDao;
        }

        @Override
        protected Void doInBackground(final Product... params) {
            mAsyncTaskDao.insertProduct(params[0]);
            return null;
        }
    }

    //delete all
    public void deleteAll()
    {
        new deleteAllAsyncTask(mProductDao).execute();
    }

    private class deleteAllAsyncTask extends AsyncTask<Void, Void, Void>{
        private ProductDao mAsyncTaskDao;
        public deleteAllAsyncTask(ProductDao mProductDao) {
            mAsyncTaskDao = mProductDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }

    //delete single item
    public void deleteProduct(Product p)
    {
        new deleteAsyncTask(mProductDao).execute(p);
    }

    private class deleteAsyncTask extends AsyncTask<Product, Void, Void>{
        private ProductDao mAsyncTaskDao;
        public deleteAsyncTask(ProductDao mProductDao) {
            mAsyncTaskDao = mProductDao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            mAsyncTaskDao.deleteProduct(products[0]);
            return null;
        }
    }
}
