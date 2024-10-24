package com.tinkoff.android_homework.data.network.repo.detail

import com.tinkoff.android_homework.data.storage.mappers.detail.DetailDbToDomainMapper
import com.tinkoff.android_homework.data.network.mappers.detail.DetailApiToDbMapper
import com.tinkoff.android_homework.data.network.repo.utils.InternetChecker
import com.tinkoff.android_homework.data.network.services.DetailService
import com.tinkoff.android_homework.data.storage.dao.DetailDao
import com.tinkoff.android_homework.domain.main.entities.Detail
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
interface DetailRepository {

    suspend fun getDetail(id: Int): Detail

}

class SubscribeDetailRepositoryImpl @Inject constructor(
    private val detailService: DetailService,
    private val detailDao: DetailDao,
    private val detailApiToDbMapper: DetailApiToDbMapper,
    private val detailDbToDomainMapper: DetailDbToDomainMapper,
    private val internetChecker: InternetChecker,
) : DetailRepository {


    override suspend fun getDetail(id: Int): Detail {
        if (internetChecker.isInternetAvailable()) {
            val detailApi = detailService.getDetail(id)
            detailDao.insertAll(detailApiToDbMapper.invoke(detailApi))
        }

        return detailDbToDomainMapper.invoke(detailDao.getAll())
    }
}
