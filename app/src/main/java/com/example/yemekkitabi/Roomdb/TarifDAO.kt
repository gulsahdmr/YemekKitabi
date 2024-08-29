package com.example.yemekkitabi.Roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.yemekkitabi.Model.Tarif
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface TarifDAO {
    @Query("Select * from Tarif")
    fun getall(): Flowable<List<Tarif>>

    @Query("Select *from Tarif Where id = :id")
    fun findById(id : Int): Flowable<Tarif>

    @Insert
    fun insert(tarif: Tarif) : Completable

    @Delete
    fun delete(tarif:Tarif) : Completable




}