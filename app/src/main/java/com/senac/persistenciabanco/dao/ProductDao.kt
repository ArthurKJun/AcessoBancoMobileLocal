package com.senac.persistenciabanco.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.senac.persistenciabanco.entities.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert
    fun insert(product: Product) : Long

    @Update
    fun update(product: Product)

    @Upsert //insere ou altera depende se recebe o id ou nao
    suspend fun upsert(product: Product) : Long //suspend diz que pode ser executado fora da tread principal

    @Query("select * from product p order by p.name")
    fun getAll() : Flow<List<Product>> //flow monitora o banco e traz as alterações

    @Query("select * from product p where p.id = :id")
    fun findById(id : Long) : Product? //interrogação poder ser que nao retorne o produto

    @Delete
    fun delete (product: Product)
}