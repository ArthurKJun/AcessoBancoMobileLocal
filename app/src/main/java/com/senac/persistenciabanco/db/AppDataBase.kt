package com.senac.persistenciabanco.db

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.senac.persistenciabanco.dao.ProductDao
import com.senac.persistenciabanco.entities.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract val productDao: ProductDao

    //companion é para instanciar apenas 1 vez o banco nao fazer varios acessos
    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null
        fun getDatabase(context : Context): AppDataBase = INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context,
                AppDataBase::class.java,
                "product-db"
            ).build()
            INSTANCE = instance
            instance
        }
    }

}