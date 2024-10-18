package com.tinkoff.android_homework.data.network.entities.details

import com.tinkoff.android_homework.presentation.model.operations.OperationType
import kotlinx.serialization.Serializable

/**
 * @author d.shtaynmets
 */
@Serializable
data class DetailApi(
    val type: OperationType,
    val amount: Int,
    val comment: String,
    val positions: List<String>
)
