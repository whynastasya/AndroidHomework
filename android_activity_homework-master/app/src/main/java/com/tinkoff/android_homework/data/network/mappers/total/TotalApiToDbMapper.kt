package com.tinkoff.android_homework.data.network.mappers.total

import com.tinkoff.android_homework.data.network.entities.total.TotalApi
import com.tinkoff.android_homework.data.storage.entities.TotalDb
import java.util.Random
import java.util.UUID
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
class TotalApiToDbMapper @Inject constructor(): (TotalApi) -> TotalDb {
    override fun invoke(totalApi: TotalApi): TotalDb {
        return TotalDb(
            id = totalApi.id.toLong(),
            total = totalApi.total,
        )
    }
}
