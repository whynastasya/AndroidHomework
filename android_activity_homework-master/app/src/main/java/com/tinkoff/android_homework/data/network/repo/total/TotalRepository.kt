package com.tinkoff.android_homework.data.network.repo.total

import com.tinkoff.android_homework.data.network.mappers.total.TotalApiToDbMapper
import com.tinkoff.android_homework.data.network.repo.utils.InternetChecker
import com.tinkoff.android_homework.data.network.services.TotalService
import com.tinkoff.android_homework.data.storage.dao.TotalDao
import com.tinkoff.android_homework.data.storage.mappers.total.TotalDbToDomainMapper
import com.tinkoff.android_homework.domain.main.entities.Total
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
interface TotalRepository {

    suspend fun subscribeTotal(): Flow<Total>

}

class TotalRepositoryImpl @Inject constructor(
    private val totalDao: TotalDao,
    private val totalService: TotalService,
    private val totalApiToDbMapper: TotalApiToDbMapper,
    private val totalDbToDomainMapper: TotalDbToDomainMapper,
    private val internetChecker: InternetChecker,
) : TotalRepository {

    override suspend fun subscribeTotal(): Flow<Total> {
        if (internetChecker.isInternetAvailable()) {
            val totalApi = totalService.getTotal()
            totalDao.insert(totalApiToDbMapper.invoke(totalApi))
        }
        return totalDao.getAll().map { totalDbToDomainMapper.invoke(it) }
    }
}
