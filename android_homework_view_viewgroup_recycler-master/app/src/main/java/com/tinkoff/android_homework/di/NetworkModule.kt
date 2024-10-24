package com.tinkoff.android_homework.di

import com.tinkoff.android_homework.data.network.repo.detail.DetailRepository
import com.tinkoff.android_homework.data.network.repo.detail.SubscribeDetailRepositoryImpl
import com.tinkoff.android_homework.data.network.repo.operations.OperationsRepository
import com.tinkoff.android_homework.data.network.repo.operations.OperationsRepositoryImpl
import com.tinkoff.android_homework.data.network.repo.total.TotalRepository
import com.tinkoff.android_homework.data.network.repo.total.TotalRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author d.shtaynmets
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {


    @Binds
    abstract fun bindTotalRepository(
        impl: TotalRepositoryImpl,
    ): TotalRepository

    @Binds
    abstract fun bindOperationsRepository(
        impl: OperationsRepositoryImpl,
    ): OperationsRepository

    @Binds
    abstract fun bindDetailRepository(
        impl: SubscribeDetailRepositoryImpl,
    ): DetailRepository

}
