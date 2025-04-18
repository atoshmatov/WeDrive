package uz.toshmatov.wedrive.app

import android.app.Application
import com.yariksoffice.lingver.Lingver
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import uz.toshmatov.wedrive.BuildConfig
import uz.toshmatov.wedrive.core.logger.Logger
import uz.toshmatov.wedrive.di.WeDriveModule.weDriveModule

class WeDriveApp : Application() {
    override fun onCreate() {
        super.onCreate()

        Logger.setup(BuildConfig.DEBUG)

        Lingver.init(this)

        startKoin {
            androidLogger()
            androidContext(this@WeDriveApp)
            modules(weDriveModule)
        }
    }
}