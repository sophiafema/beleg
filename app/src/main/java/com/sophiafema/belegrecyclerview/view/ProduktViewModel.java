package com.sophiafema.belegrecyclerview.view;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.sophiafema.belegrecyclerview.data.Product;
import com.sophiafema.belegrecyclerview.data.ProductRepository;

import java.util.List;

public class ProduktViewModel extends AndroidViewModel {

    private ProductRepository mRepository;
    private LiveData<List<Product>> mAllProducts;

    public ProduktViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = new ProductRepository(application);
        this.mAllProducts = mRepository.getAllProducts();
    }
    public LiveData<List<Product>> getAllProducts()
    {
        return mAllProducts;
    }
    //insert
    public void insertProduct(Product product)
    {
        mRepository.insert(product);
    }
    //delete all products from database
    public void deleteAll()
    {
        mRepository.deleteAll();
    }
    //delete one item
    public void deleteProduct(Product p)
    {
        mRepository.deleteProduct(p);
    }

}
