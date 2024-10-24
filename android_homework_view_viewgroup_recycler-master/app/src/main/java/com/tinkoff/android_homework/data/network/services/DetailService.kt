package com.tinkoff.android_homework.data.network.services

import com.tinkoff.android_homework.data.network.entities.details.DetailApi
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author d.shtaynmets
 */
interface DetailService {

    @GET("android_for_begginers_back_end/main/detail/{id}.json")
    suspend fun getDetail(
        @Path("id") id: Int
    ): DetailApi
}
