package com.tinkoff.android_homework.data.storage.mappers.operations

import com.tinkoff.android_homework.data.storage.entities.OperationDb
import com.tinkoff.android_homework.domain.main.entities.Operation
import com.tinkoff.android_homework.domain.main.entities.Operations
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
class OperationsDbToDomainMapper @Inject constructor() : (List<OperationDb>) -> Operations {

    override fun invoke(operations: List<OperationDb>): Operations {
        return Operations(
            operations = operations.map { operation ->
                Operation(operation.type, operation.name, operation.amount)
            }
        )
    }
}
