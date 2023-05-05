package br.com.car.config.retrofit

import br.com.car.adapters.http.CarHttpService
import br.com.car.config.circuitbreaker.CircuitBreakerConfiguration
import io.github.resilience4j.retrofit.CircuitBreakerCallAdapter
import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Configuration
class CarHttpConfiguration(
        private val circuitBreakerConfiguration: CircuitBreakerConfiguration
) {

    private companion object {
        const val BASE_URL = "http://localhost:1080"
    }

    private fun buildClient() = OkHttpClient.Builder().build()

    private fun buildRetrofit() = Retrofit.Builder()
            .addCallAdapterFactory(CircuitBreakerCallAdapter.of(circuitBreakerConfiguration.getCircuitBreaker()))
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(buildClient())
            .build()

    @Bean
    fun carHttpService(): CarHttpService = buildRetrofit().create(CarHttpService::class.java)
}