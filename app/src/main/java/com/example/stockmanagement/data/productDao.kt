package com.example.stockmanagement.data

import Product
import androidx.room.*

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product)

    @Update
    suspend fun updateProduct(product: Product)

    @Query("SELECT * FROM product_table")
    suspend fun getAllProducts(): List<Product>

    @Query("SELECT * FROM product_table WHERE qrCode = :qr")
    suspend fun getProductByQR(qr: String): Product?

    @Query("UPDATE product_table SET quantity = quantity + :addQty WHERE qrCode = :qr")
    suspend fun updateStock(qr: String, addQty: Int)

    @Query("DELETE FROM product_table")
    suspend fun clearAll()
}
