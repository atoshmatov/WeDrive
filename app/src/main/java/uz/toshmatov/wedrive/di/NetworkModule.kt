package uz.toshmatov.wedrive.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import uz.toshmatov.wedrive.core.logger.logDebug
import uz.toshmatov.wedrive.core.logger.logInfo
import uz.toshmatov.wedrive.data.NetworkConstants
import uz.toshmatov.wedrive.data.apiservice.PromoCodeApiService
import uz.toshmatov.wedrive.data.apiservice.UserCardApiService
import uz.toshmatov.wedrive.data.apiservice.UserWalletApiService
import uz.toshmatov.wedrive.data.apiservice.impl.PromoCodeApiServiceImpl
import uz.toshmatov.wedrive.data.apiservice.impl.UserCardApiServiceImpl
import uz.toshmatov.wedrive.data.apiservice.impl.UserWalletApiServiceImpl

object NetworkModule {
    val netWorkModule = module {
        single {
            HttpClient {
                defaultRequest {
                    url(NetworkConstants.BASE_URL)
                }

                install(ContentNegotiation) {
                    json(
                        json = Json {
                            prettyPrint = true
                            isLenient = true
                            ignoreUnknownKeys = true
                        },
                        contentType = ContentType.Any
                    )
                }

                install(HttpTimeout) {
                    requestTimeoutMillis = 10000
                }

                install(Logging) {
                    logger = object : Logger {
                        override fun log(message: String) {
                            logInfo { "Logger Ktor -->, $message" }
                        }
                    }
                    level = LogLevel.NONE
                }

                install(ResponseObserver) {
                    onResponse { response ->
                        logDebug { "HTTP status:, ${response.status.value}" }
                    }
                }
                install(DefaultRequest) {
                    header(
                        HttpHeaders.ContentType,
                        ContentType.Application.Json,
                    )
                }
            }
        }

        factory<UserCardApiService> { UserCardApiServiceImpl(get()) }
        factory<UserWalletApiService> { UserWalletApiServiceImpl(get()) }
        factory<PromoCodeApiService> { PromoCodeApiServiceImpl(get()) }
    }
}