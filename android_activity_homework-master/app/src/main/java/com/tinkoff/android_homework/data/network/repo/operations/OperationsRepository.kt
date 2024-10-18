package com.tinkoff.android_homework.data.network.repo.operations

import com.tinkoff.android_homework.data.network.mappers.operations.OperationApiToDbMapper
import com.tinkoff.android_homework.data.network.repo.utils.InternetChecker
import com.tinkoff.android_homework.data.network.services.OperationsService
import com.tinkoff.android_homework.data.storage.dao.OperationDao
import com.tinkoff.android_homework.data.storage.mappers.operations.OperationsDbToDomainMapper
import com.tinkoff.android_homework.domain.main.entities.Operations
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
interface OperationsRepository {

    suspend fun getOperations(): Operations

}

class OperationsRepositoryImpl @Inject constructor(
    private val operationsService: OperationsService,
    private val operationDao: OperationDao,
    private val operationsApiToDbMapper: OperationApiToDbMapper,
    private val operationsDbToDomainMapper: OperationsDbToDomainMapper,
    private val internetChecker: InternetChecker
) : OperationsRepository {

    override suspend fun getOperations(): Operations {
        if (internetChecker.isInternetAvailable()) {
            val operationsApi = operationsService.getOperations()
            operationDao.insertAll(*operationsApiToDbMapper.invoke(operationsApi).toTypedArray())
        }
        return operationsDbToDomainMapper.invoke(operationDao.getAll())
    }
}
