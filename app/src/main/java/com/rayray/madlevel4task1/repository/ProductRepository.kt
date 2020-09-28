package com.rayray.madlevel4task1.repository

import android.content.Context
import com.rayray.madlevel4task1.dao.ProductDao
import com.rayray.madlevel4task1.database.ShoppingListRoomDatabase
import com.rayray.madlevel4task1.model.Product

//suspend = cant run outside coroutine, wont be called from the main ui, prevent screen freezes
//Benefit: no need to create instance of db or productDao. just use product repo
class ProductRepository(context: Context) {

    private val productDao: ProductDao

    init {
        val database = ShoppingListRoomDatabase.getDatabase(context)
        productDao = database!!.productDao()
    }

    suspend fun getAllProducts(): List<Product>{
        return productDao.getAllProducts()
    }

    suspend fun insertProduct(product: Product){
        productDao.insertProduct(product)
    }

    suspend fun deleteProduct(product: Product){
        productDao.deleteProduct(product)
    }

    suspend fun deleteAllProducts(){
        productDao.deleteAllProducts()
    }
}