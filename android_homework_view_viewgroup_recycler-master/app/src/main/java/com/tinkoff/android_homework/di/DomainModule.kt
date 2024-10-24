package com.tinkoff.android_homework.di

import com.tinkoff.android_homework.data.network.repo.detail.DetailRepository
import com.tinkoff.android_homework.data.network.repo.detail.SubscribeDetailRepositoryImpl
import com.tinkoff.android_homework.data.network.repo.operations.OperationsRepository
import com.tinkoff.android_homework.data.network.repo.total.TotalRepository
import com.tinkoff.android_homework.domain.main.usecases.SubscribeDetailUseCase
import com.tinkoff.android_homework.domain.main.usecases.SubscribeDetailUseCaseImpl
import com.tinkoff.android_homework.domain.main.usecases.SubscribeOperationsUseCase
import com.tinkoff.android_homework.domain.main.usecases.SubscribeOperationsUseCaseImpl
import com.tinkoff.android_homework.domain.main.usecases.SubscribeTotalUseCase
import com.tinkoff.android_homework.domain.main.usecases.SubscribeTotalUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author d.shtaynmets
 */
@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Singleton
    @Provides
    fun provideSubscribeTotalUseCase(
        repository: TotalRepository,
    ): SubscribeTotalUseCase {
        return SubscribeTotalUseCaseImpl(repository)
    }

    @Singleton
    @Provides
    fun provideSubscribeOperationUseCase(
        repository: OperationsRepository,
    ): SubscribeOperationsUseCase {
        return SubscribeOperationsUseCaseImpl(repository)
    }

//    @Singleton
//    @Provides
//    fun provideDetailUseCase(
//        repository: DetailRepository,
//    ): SubscribeDetailUseCase {
//        return SubscribeDetailUseCaseImpl(repository)
//    }

    @Singleton
    @Provides
    fun provideSubscribeDetailUseCase(
        repository: SubscribeDetailRepositoryImpl,
    ):  SubscribeDetailUseCase {
        return SubscribeDetailUseCaseImpl(repository)
    }
}


