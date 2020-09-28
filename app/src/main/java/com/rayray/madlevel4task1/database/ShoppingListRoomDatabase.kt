package com.rayray.madlevel4task1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rayray.madlevel4task1.model.Product
import com.rayray.madlevel4task1.dao.ProductDao

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ShoppingListRoomDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        private const val DATABASE_NAME = "SHOPPING_LIST_DATABASE"

        //@volatile = read from main memory no cache.
        @Volatile
        private var shoppingListRoomDatabaseInstance: ShoppingListRoomDatabase? = null

        fun getDatabase(context: Context): ShoppingListRoomDatabase? {
            if (shoppingListRoomDatabaseInstance == null) {
                synchronized(ShoppingListRoomDatabase::class.java) {
                    if (shoppingListRoomDatabaseInstance == null) {
                        shoppingListRoomDatabaseInstance =
                            Room.databaseBuilder(
                                context.applicationContext,
                                ShoppingListRoomDatabase::class.java,
                                DATABASE_NAME
                            ).build()
                    }
                }
            }
            return shoppingListRoomDatabaseInstance
        }

    }
}
