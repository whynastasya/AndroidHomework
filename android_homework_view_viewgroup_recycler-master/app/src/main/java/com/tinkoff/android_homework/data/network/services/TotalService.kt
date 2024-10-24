package com.tinkoff.android_homework.data.network.services

import com.tinkoff.android_homework.data.network.entities.total.TotalApi
import retrofit2.http.GET

/**
 * @author d.shtaynmets
 */
interface TotalService {

    @GET("android_for_begginers_back_end/main/total.json")
    suspend fun getTotal(): TotalApi
}
