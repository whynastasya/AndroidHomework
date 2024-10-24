package com.tinkoff.android_homework.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tinkoff.android_homework.data.storage.entities.OperationDb

/**
 * @author d.shtaynmets
 */
@Dao
interface OperationDao {

    @Query("SELECT * FROM ${OperationDb.OPERATION_TABLE_NAME}")
    suspend fun getAll(): List<OperationDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg operations: OperationDb)
}
