package com.tinkoff.android_homework.presentation.mappers.operations

import com.tinkoff.android_homework.domain.main.entities.Operation
import com.tinkoff.android_homework.presentation.model.operations.OperationItem
import com.tinkoff.android_homework.presentation.model.operations.OperationType
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
class OperationToUiItemMapper @Inject constructor() : (Operation) -> OperationItem {

    override operator fun invoke(operation: Operation): OperationItem {
        return OperationItem(
            operationType = operation.type,
            operationTitle = operation.name,
            operationSum = operation.amount
        )
    }

}
