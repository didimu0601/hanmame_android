package com.hanname.hbapp.data.repository

import com.hanname.hbapp.data.repository.remote.ServiceRemoteData
import dagger.Binds
import dagger.Module

@Module
abstract class ServiceRepositoryModule {
    @Binds
    abstract fun prvideRemoteDataSource(remoteService: ServiceRemoteData): ServiceData
}