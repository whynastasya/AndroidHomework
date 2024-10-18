package com.tinkoff.android_homework.presentation.model.operations

/**
 * @author d.a.korotkov
 */
data class OperationItem(
    val operationType: OperationType,
    val operationTitle: String,
    val operationSum: Int
)
