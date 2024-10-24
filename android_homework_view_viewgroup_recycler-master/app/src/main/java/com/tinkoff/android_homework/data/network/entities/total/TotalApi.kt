package com.tinkoff.android_homework.data.network.entities.total

import kotlinx.serialization.Serializable

/**
 * @author d.shtaynmets
 */
@Serializable
data class TotalApi(
    val id: Int,
    val total: Int
)
