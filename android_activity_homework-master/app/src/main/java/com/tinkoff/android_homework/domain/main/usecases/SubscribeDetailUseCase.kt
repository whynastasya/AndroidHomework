package com.tinkoff.android_homework.domain.main.usecases

import com.tinkoff.android_homework.data.network.repo.detail.DetailRepository
import com.tinkoff.android_homework.domain.main.entities.Detail
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
interface SubscribeDetailUseCase {

    suspend fun getDetail(id: Int): Detail
}

class SubscribeDetailUseCaseImpl @Inject constructor(
    private val detailRepository: DetailRepository
) : SubscribeDetailUseCase {

    override suspend fun getDetail(id: Int): Detail {
        return detailRepository.getDetail(id)
    }
}

