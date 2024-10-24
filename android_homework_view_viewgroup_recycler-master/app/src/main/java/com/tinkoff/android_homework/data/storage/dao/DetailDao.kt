package com.tinkoff.android_homework.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tinkoff.android_homework.data.storage.entities.DetailDb

/**
 * @author d.shtaynmets
 */
@Dao
interface DetailDao {

    @Query("SELECT * FROM ${DetailDb.DETAILS_TABLE_NAME}")
    suspend fun getAll(): DetailDb

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg operations: DetailDb)
}
