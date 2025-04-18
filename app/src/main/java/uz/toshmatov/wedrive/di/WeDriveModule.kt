package uz.toshmatov.wedrive.di

import org.koin.dsl.module
import uz.toshmatov.wedrive.di.AppModule.appModule
import uz.toshmatov.wedrive.di.NetworkModule.netWorkModule
import uz.toshmatov.wedrive.di.RPModule.repositoryModule
import uz.toshmatov.wedrive.di.VMModule.viewModelModule

object WeDriveModule {
    val weDriveModule = module {
        includes(
            appModule,
            repositoryModule,
            viewModelModule,
            netWorkModule
        )
    }
}