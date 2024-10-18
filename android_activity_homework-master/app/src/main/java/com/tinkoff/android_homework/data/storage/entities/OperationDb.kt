package com.tinkoff.android_homework.data.storage.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tinkoff.android_homework.data.storage.entities.OperationDb.Companion.OPERATION_TABLE_NAME
import com.tinkoff.android_homework.presentation.model.operations.OperationType

/**
 * @author d.shtaynmets
 */
@Entity(tableName = OPERATION_TABLE_NAME)
data class OperationDb(
    @PrimaryKey()
    val id: Long,
    val type: OperationType,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "amount")
    val amount: Int,
) {

    companion object {
        const val OPERATION_TABLE_NAME = "operation_table"
    }
}
