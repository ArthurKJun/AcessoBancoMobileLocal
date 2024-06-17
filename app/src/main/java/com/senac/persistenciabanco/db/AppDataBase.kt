package com.senac.persistenciabanco.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.senac.persistenciabanco.dao.ProductDao
import com.senac.persistenciabanco.entities.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase(){

    abstract val productDao : ProductDao

}