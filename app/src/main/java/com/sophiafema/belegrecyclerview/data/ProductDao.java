package com.sophiafema.belegrecyclerview.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM product_table ORDER BY produkt_name ASC")
    LiveData<List<Product>> getAllProducts();

    @Query("SELECT * FROM product_table WHERE id =:productId")
    LiveData<Product> getProduct(int productId);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Long insertProduct(Product p);

    @Update
    void updateProduct(Product p);

    @Query ("DELETE FROM product_table")
    void deleteAll();

    @Delete
    void deleteProduct(Product p);

    @Query("SELECT * from product_table LIMIT 1")
    Product[] getAnyProduct();
}
