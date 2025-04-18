package uz.toshmatov.wedrive.di

import org.koin.dsl.module
import uz.toshmatov.wedrive.ui.WeDriveActivity

object AppModule {
    val appModule = module {
        single { WeDriveActivity::class.java }
    }
}