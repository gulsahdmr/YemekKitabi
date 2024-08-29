package com.example.yemekkitabi.Roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.yemekkitabi.Model.Tarif

@Database(entities = [Tarif::class], version = 1)
abstract class TarifDataBase : RoomDatabase() {
    abstract fun tarifdao(): TarifDAO
}