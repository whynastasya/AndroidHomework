package com.tinkoff.android_homework.data.storage.mappers.detail

import com.tinkoff.android_homework.data.storage.entities.DetailDb
import com.tinkoff.android_homework.domain.main.entities.Detail
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
class DetailDbToDomainMapper @Inject constructor() : (DetailDb) -> Detail {

    override fun invoke(detailDb: DetailDb): Detail {
        return Detail(
            type = detailDb.type,
            comment = detailDb.comment,
            positions = detailDb.positions
        )
    }
}
