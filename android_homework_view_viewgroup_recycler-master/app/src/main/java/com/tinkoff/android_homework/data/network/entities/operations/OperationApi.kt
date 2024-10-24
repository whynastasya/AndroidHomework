package com.tinkoff.android_homework.data.network.entities.operations

import com.tinkoff.android_homework.presentation.model.operations.OperationType
import kotlinx.serialization.Serializable

/**
 * @author d.shtaynmets
 */
@Serializable
data class OperationApi(
    val id: Int,
    val type: OperationType,
    val name: String,
    val amount: Int,
)
