package com.tinkoff.android_homework.data.storage.mappers.total

import com.tinkoff.android_homework.data.storage.entities.TotalDb
import com.tinkoff.android_homework.domain.main.entities.Total
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
class TotalDbToDomainMapper @Inject constructor() : (TotalDb) -> Total {

    override fun invoke(totalDb: TotalDb): Total {
        return Total(amount = totalDb.total)
    }

}
